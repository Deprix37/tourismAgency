package view;

import business.HotelManager;
import business.PencionManager;
import entity.Hotel;
import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PencionView extends Layout {
    private JPanel container;
    private JComboBox cmb_pencion;
    private JButton btn_pencionSave;
    private JLabel lbl_otelid;
    private Hotel hotel;
    private HotelManager hotelManager;
    private PencionManager pencionManager;


    public PencionView(Hotel hotel) {

        this.pencionManager = new PencionManager(hotel);
        this.hotelManager = new HotelManager();
        this.hotel = hotel;
        this.add(container);
        this.guiInitilaze(400, 350);
        lbl_otelid.setText("Otel ID:" + this.hotel.getId());
        //this.lbl_otelid.setText(String.valueOf(this.hotel.getId()));

        btn_pencionSave.addActionListener(e -> {

          this.cmb_pencion.getSelectedItem().toString();
            pencionManager.savePencion(hotel,String.valueOf(cmb_pencion.getSelectedItem()));
            dispose();


        });
    }



}

