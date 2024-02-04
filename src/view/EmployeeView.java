package view;

import business.*;
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
    private SeasonManager seasonManager;
    private RoomManager roomManager;
    private JPanel container;
    private JTabbedPane tabbedPane1;
    private JTable tablo_hotel;
    private DefaultTableModel tmdl_hotel = new DefaultTableModel();
    private JButton çıkışYapButton;
    private JButton otelEkleButton;
    private JLabel lbl_welcome;
    private JPanel pnl_hotel;
    private JTable tablo_sezon;
    private JTable tbl_pancion;
    private JScrollPane getSpn_pancion;
    private JScrollPane spn_pancion;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton odaAraButton;
    private JButton odaEkleButton;
    private JButton resetButton;
    private JTable tablo_room;
    Object[] col_hotel;
    private JPopupMenu hotelMenu;
    Object[] col_pancion;
    Object[] col_season;
    Object[] col_room;
    private DefaultTableModel tmdl_pancion = new DefaultTableModel();
    private DefaultTableModel tmdl_season = new DefaultTableModel();
    private DefaultTableModel tmdl_room = new DefaultTableModel();




    public EmployeeView(User loggedInUser) {
        this.seasonManager = new SeasonManager(null);
        this.hotelManager = new HotelManager();
        this.pencionManager = new PencionManager(null);
        this.roomManager = new RoomManager();
        this.add(container);
        this.guiInitilaze(1300, 550);
        this.user = loggedInUser;
        lbl_welcome.setText("Hoş Geldiniz: " + this.user.getUsername());

        loadHotelAddView();
        loadHotelTable(null);


        loadPancionTable(null);
        loadSeasonTable(null);

        loadRoomTable(null);
        loadRoomCompanent();



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


            pensionView.addWindowListener((new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {

                    loadPancionTable(null);
                }

            }));

        });

        this.hotelMenu.add("Sezon Ekle").addActionListener(e -> {
            int selectedId = getTableSelectedRow(tablo_hotel, 0);
            SeasonView seasonView = new SeasonView(hotelManager.getById(selectedId));
            seasonView.addWindowListener((new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadSeasonTable(null);
                }
            }));
            loadSeasonTable(null);
        });
        this.tablo_hotel.setComponentPopupMenu(hotelMenu);
        loadPancionTable(null);
        loadSeasonTable(null);
    }

    public void loadHotelTable(ArrayList<Object[]> hotelList) {
        col_hotel = new Object[]{"ID", "Name", "Address", "Mail", "Phone", "Star", "CarPark", "Wifi", "Pool", "Fitness", "Concierge", "Spa,", "RoomService"};
        if (hotelList == null) {
            hotelList = this.hotelManager.getForTable(col_hotel.length, this.hotelManager.findAll());
        }
        createTable(this.tmdl_hotel, this.tablo_hotel, col_hotel, hotelList);

    }

    public void loadPancionTable(ArrayList<Object[]> pancionList) {
        col_pancion = new Object[]{"pencion_id", "hotel_id", "pencion_type"};

        if (pancionList == null) {

            pancionList = this.pencionManager.getForTable(col_pancion.length, this.pencionManager.findAll());

        }

        //System.out.println("loadhotel" + pancionList.size());
        createTable(this.tmdl_pancion, this.tbl_pancion, col_pancion, pancionList);


    }

    public void loadSeasonTable(ArrayList<Object[]> seasonList) {
        col_season = new Object[]{"season_id", "hotel_id", "season_startDate" , "season_EndDate"};

        if (seasonList == null) {

            seasonList = this.seasonManager.getForTable(col_season.length, this.seasonManager.findAll());

        }

        //System.out.println("loadhotel" + pancionList.size());
        createTable(this.tmdl_season, this.tablo_sezon, col_season, seasonList);


    }

   public void loadRoomTable(ArrayList<Object[]> roomList) {
        col_room = new Object[]{"ID", "Otel Adı", "Pansiyon" , "Oda Tipi", "Stok", "Yetişkin Fiyat","Çocuk Fiyat", "Yatak Kapasitesi", "m2", "Tv","Minibar","Konsol","Kasa","Projeksiyon"};

        if (roomList == null) {

            roomList = this.roomManager.getForTable(col_room.length, this.roomManager.findAll());

        }

        //System.out.println("loadhotel" + pancionList.size());
        createTable(this.tmdl_room, this.tablo_room, col_room, roomList);


    }
    public void loadRoomCompanent(){
        odaEkleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RoomView roomView = new RoomView(null);
                roomView.addWindowListener(new WindowAdapter() { //yeni açılan pencereyi izler
                    @Override
                    public void windowClosed(WindowEvent e) {
                        loadHotelTable(null); //kapandıktan sonra tabloyu günceller
                        loadRoomTable(null);
                    }
                });
            }

        });
    }
}

