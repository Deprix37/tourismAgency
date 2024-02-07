package view;

import business.HotelManager;
import business.PencionManager;
import business.RoomManager;
import business.SeasonManager;
import core.ComboItem;
import core.Helper;
import entity.Hotel;
import entity.Pencion;
import entity.Room;
import entity.Season;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RoomView extends Layout {

    private JTextField fld_stok;
    private JTextField fld_bedCapacity;
    private JTextField fld_meter;
    private JRadioButton rbtn_tv;
    private JRadioButton rbtn_minibar;
    private JRadioButton rbtn_konsol;
    private JRadioButton rbtn_kasa;
    private JRadioButton rbtn_projeksiyon;
    private JPanel container;
    private JButton btn_roomSave;
    private JComboBox cmb_pencion;
    private JComboBox cmb_season;
    private JComboBox cmb_roomType;
    private JComboBox cmb_hotel;
    private JTextField fld_AdultPrice;
    private JTextField fld_childPrice;
    private Hotel hotel;
    private RoomManager roomManager;
    private HotelManager hotelManager;
    private SeasonManager seasonManager;
    private PencionManager pencionManager;
    private Room room;
    private Season season;


    public RoomView(Room room) {

        this.room = room;
        this.add(container);
        this.roomManager = new RoomManager();
        this.hotelManager = new HotelManager();
        this.seasonManager = new SeasonManager(null);
        this.pencionManager = new PencionManager(null);

        this.guiInitilaze(650, 400);
        this.cmb_roomType.setModel(new DefaultComboBoxModel<>(Room.RoomType.values()));


        for (Hotel hotel : this.hotelManager.findAll()) {
            cmb_hotel.addItem(hotel.getComboItem());
        }

        for (Season season : this.seasonManager.findAll()) {
            cmb_season.addItem(season.getComboItem());
        }

        for (Pencion pencion : this.pencionManager.findAll()) {
            cmb_pencion.addItem(pencion.getComboItem());
        }

        btn_roomSave.addActionListener(e -> {
            JTextField[] checkFieldList = {fld_AdultPrice,fld_childPrice,fld_meter,fld_stok,fld_bedCapacity};
            if (Helper.isFieldListEmpty(checkFieldList)){
                Helper.showMsg("fill");

            } else

            {
                boolean result;
                Room roomNew = new Room();

                ComboItem selectedHotel = (ComboItem) cmb_hotel.getSelectedItem();


                roomNew.setHotel_id(selectedHotel.getKey());
                ComboItem selectedPension = (ComboItem) cmb_pencion.getSelectedItem();
                roomNew.setPencion_id(selectedPension.getKey());


                ComboItem selectedSeason = (ComboItem) cmb_season.getSelectedItem();
                roomNew.setSeason_id(selectedSeason.getKey());


                roomNew.setRoom_type(cmb_roomType.getModel().getSelectedItem().toString());
                roomNew.setRoom_adult_price(Integer.parseInt(fld_AdultPrice.getText()));
                roomNew.setRoom_child_price(Integer.parseInt(fld_childPrice.getText()));
                roomNew.setRoom_bed_capacity(Integer.parseInt(fld_bedCapacity.getText()));
                roomNew.setRoom_squar_meter(Integer.parseInt(fld_meter.getText()));
                roomNew.setRoom_stock(Integer.parseInt(fld_stok.getText()));
                roomNew.setRoom_tv(rbtn_tv.getModel().isSelected());
                roomNew.setRoom_minibar(rbtn_minibar.getModel().isSelected());
                roomNew.setRoom_konsol(rbtn_konsol.getModel().isSelected());
                roomNew.setRoom_kasa(rbtn_kasa.getModel().isSelected());
                roomNew.setRoom_projeksiyon(rbtn_projeksiyon.getModel().isSelected());



                if (roomNew.getRoom_id()==0) {
                    Helper.showMsg("done");
                    result = roomManager.save(roomNew);
                    dispose();
                } else {
                    Helper.showMsg("error");
                }
            }

        });


        }


}
