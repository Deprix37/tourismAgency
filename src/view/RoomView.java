package view;

import business.HotelManager;
import business.RoomManager;
import entity.Hotel;
import entity.Room;

import javax.swing.*;
import java.util.ArrayList;

public class RoomView extends Layout {
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JRadioButton radioButton5;
    private JPanel container;
    private JButton btn_roomSave;
    private Hotel hotel;
    private RoomManager roomManager;
    private HotelManager hotelManager;
    private Room room;

    public RoomView(Room room) {
        this.room = room;
        this.add(container);
        this.roomManager = new RoomManager();
        this.hotelManager = new HotelManager();
        this.guiInitilaze(650,400);



    }







}
