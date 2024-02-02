package view;

import business.HotelManager;
import business.UserManager;
import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


public class EmployeeView extends Layout {
    private User user;
    private UserManager userManager;
    private HotelManager hotelManager;
    private JPanel container;
    private JTabbedPane tabbedPane1;
    private JTable tablo_hotel;
    private DefaultTableModel tmdl_hotel = new DefaultTableModel();
    private JButton çıkışYapButton;
    private JButton otelEkleButton;
    private JLabel lbl_welcome;
    private JPanel pnl_hotel;
    private JTable table2;
    private JTable table3;
    Object[] col_hotel;




    public  EmployeeView(User loggedInUser) {
        this.hotelManager = new HotelManager();
        this.add(container);
        this.guiInitilaze(1300, 550);
        this.user = loggedInUser;
        lbl_welcome.setText("Hoş Geldiniz: " + this.user.getUsername());
        loadHotelAddView();
        loadHotelTable(null);


    }





    public void loadHotelAddView(){
        otelEkleButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                HotelAddView hotelAddView = new HotelAddView(null);
                hotelAddView.addWindowListener(new WindowAdapter() { //yeni açılan pencereyi izler
                    @Override
                    public void windowClosed(WindowEvent e) {
                        loadHotelTable(null); //kapandıktan sonra tabloyu günceller
                    }
                });
            }

        });

    }

    public void loadHotelTable( ArrayList<Object[]> hotelList) {
        col_hotel = new Object[]{"ID", "Name", "Address", "Mail","Phone","Star","CarPark","Wifi","Pool","Fitness","Concierge","Spa,","RoomService"};
        if (hotelList==null){
            hotelList = this.hotelManager.getForTable(col_hotel.length, this.hotelManager.findAll());
        }
        System.out.println("loadhotel"+hotelList.size());
        createTable(this.tmdl_hotel, this.tablo_hotel, col_hotel, hotelList);
    }
}

