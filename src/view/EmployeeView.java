package view;

import business.HotelManager;
import business.PencionManager;
import business.UserManager;
import core.Helper;
import entity.Hotel;
import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;


public class EmployeeView extends Layout {
    private User user;
    private UserManager userManager;
    private HotelManager hotelManager;
    private PencionManager pencionManager;
    private JPanel container;
    private JTabbedPane tabbedPane1;
    private JTable tablo_hotel;
    private DefaultTableModel tmdl_hotel = new DefaultTableModel();
    private JButton çıkışYapButton;
    private JButton otelEkleButton;
    private JLabel lbl_welcome;
    private JPanel pnl_hotel;
    private JTable table3;
    private JTable tbl_pancion;
    private JScrollPane getSpn_pancion;
    private JScrollPane spn_pancion;
    Object[] col_hotel;
    private JPopupMenu hotelMenu;
    Object[] col_pancion;
    private DefaultTableModel tmdl_pancion = new DefaultTableModel();




    public EmployeeView(User loggedInUser) {

        this.hotelManager = new HotelManager();
        this.pencionManager = new PencionManager(null);
        this.add(container);
        this.guiInitilaze(1300, 550);
        this.user = loggedInUser;
        lbl_welcome.setText("Hoş Geldiniz: " + this.user.getUsername());
        loadHotelAddView();
        loadHotelTable(null);
        loadPancionTable(null);


    }


    public void loadHotelAddView() {
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
        tableRowSelect(tablo_hotel);
        this.tablo_hotel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selectedRow = tablo_hotel.rowAtPoint(e.getPoint());
                tablo_hotel.setRowSelectionInterval(selectedRow, selectedRow);
            }
        });
        this.hotelMenu = new JPopupMenu();
        this.hotelMenu.add("Pansiyon Tipi Ekle").addActionListener(e -> {
            int selectedId = getTableSelectedRow(tablo_hotel, 0);
            PencionView pensionView = new PencionView(hotelManager.getById(selectedId));

            //PencionView otelPensionView = new PencionView(HotelManager.getById(selectedId));



        });

            this.hotelMenu.add("Sezon Ekle");


            this.tablo_hotel.setComponentPopupMenu(hotelMenu);
        loadPancionTable(null);



    }

    public void loadHotelTable(ArrayList<Object[]> hotelList) {
        col_hotel = new Object[]{"ID", "Name", "Address", "Mail", "Phone", "Star", "CarPark", "Wifi", "Pool", "Fitness", "Concierge", "Spa,", "RoomService"};
        if (hotelList == null) {
            hotelList = this.hotelManager.getForTable(col_hotel.length, this.hotelManager.findAll());
        }
        System.out.println("loadhotel" + hotelList.size());
        createTable(this.tmdl_hotel, this.tablo_hotel, col_hotel, hotelList);

    }

    public void loadPancionTable(ArrayList<Object[]> pancionList) {
        col_pancion = new Object[]{"pencion_id", "hotel_id", "pencion_type"};
        System.out.println("1");
        if (pancionList == null) {
            System.out.println("2");
            pancionList = this.pencionManager.getForTable(col_pancion.length, this.pencionManager.findAll());
            System.out.println("3");
        }
        System.out.println("4");
        //System.out.println("loadhotel" + pancionList.size());
        createTable(this.tmdl_pancion, this.tbl_pancion, col_pancion, pancionList);


    }
}

