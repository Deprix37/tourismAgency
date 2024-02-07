package view;

import entity.Room;

import javax.swing.*;

public class RezervationAddView extends Layout{

    private JPanel container;
    private JTextField fld_rezervationOtelName;
    private JTextField fld_rezervationAdress;
    private JTextField fld_RezervationStar;
    private JRadioButton radio_otopark;
    private JRadioButton radio_concierge;
    private JRadioButton radio_wifi;
    private JRadioButton radio_spa;
    private JRadioButton radio_pool;
    private JRadioButton radio_roomService;
    private JRadioButton radio_fitness;
    private JTextField fld_roomType;
    private JTextField fld_pansiyonType;
    private JTextField fld_startDate;
    private JTextField fld_endDate;
    private JTextField fld_totalPrice;
    private JTextField fld_bedCapacity;
    private JTextField fld_meter;
    private JRadioButton radio_tv;
    private JRadioButton radio_minibar;
    private JTextField textField1;
    private JTextField fld_guestName;
    private JTextField fld_guestID;
    private JTextField fld_guestMail;
    private JTextField fld_guestPhone;
    private JButton btn_rezervationSave;
    private Room room;
    public RezervationAddView() {
        //this.pencionManager = new PencionManager(hotel);


        this.add(container);
        this.guiInitilaze(1000, 700);
    }


}

