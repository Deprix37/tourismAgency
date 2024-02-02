package view;

import business.HotelManager;
import business.UserManager;
import core.Helper;
import entity.Hotel;
import entity.User;

import javax.swing.*;

public class HotelAddView extends Layout{
    private JPanel container;
    private JTextField fld_otelName;
    private JComboBox cmb_otelStar;
    private JRadioButton rbtn_carpark;
    private JRadioButton rbtn_wifi;
    private JRadioButton rbtn_pool;
    private JRadioButton rbtn_fitness;
    private JRadioButton rbtn_concierge;
    private JRadioButton rbtn_spa;
    private JRadioButton rbtn_roomservice;
    private JButton btn_oteladd;
    private JTextField fld_otelMail;
    private JTextField fld_otelPhone;
    private JTextField fld_otelAdres;
    private HotelManager hotelManager;
    private Hotel hotel;
    private User user;
    private UserManager userManager;
    public HotelAddView(Hotel hotel){
        //this.hotel = hotel;
        this.hotelManager= new HotelManager();
        this.add(container);
        this.guiInitilaze(700,700);
        loadHotelAddCompenent();
        this.hotel = (hotel != null) ? hotel : new Hotel();


    }


    public void loadHotelAddCompenent(){
        btn_oteladd.addActionListener(e -> {
            JTextField[] checkFieldList = {this.fld_otelName,this.fld_otelMail,this.fld_otelPhone,this.fld_otelAdres};
            if (Helper.isFieldListEmpty(checkFieldList)){
                Helper.showMsg("fill");
            }else {
                boolean result = true;
                //Hotel hotelNew = new Hotel();
                hotel.setHotelName(fld_otelName.getText());
                hotel.setHotelMail(fld_otelMail.getText());
                hotel.setHotelPhone(fld_otelPhone.getText());
                hotel.setHotelAddress(fld_otelAdres.getText());
                hotel.setHotelStar(String.valueOf(cmb_otelStar.getSelectedItem()));
                hotel.setHotelCarpark(rbtn_wifi.isSelected());
                hotel.setHotelPool(rbtn_pool.isSelected());
                hotel.setHotelFitness(rbtn_fitness.isSelected());
                hotel.setHotelConcierge(rbtn_concierge.isSelected());
                hotel.setHotelSpa(rbtn_spa.isSelected());
                hotel.setHotelRoomservice(rbtn_roomservice.isSelected());
                if (this.hotel.getId()==0){
                    result = this.hotelManager.save(hotel);
                }else {

                }

                if (result){
                    Helper.showMsg("done");


                }else {
                    Helper.showMsg("error");
                }

            }
        });
    }



}


