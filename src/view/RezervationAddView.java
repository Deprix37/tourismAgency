package view;

import business.ReservationManager;
import business.RoomManager;
import entity.Reservation;
import entity.Room;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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
    private JTextField fld_totalGuest;
    private JTextField fld_guestName;
    private JTextField fld_guestID;
    private JTextField fld_guestMail;
    private JTextField fld_guestPhone;
    private JButton btn_rezervationSave;
    private JRadioButton radio_konsol;
    private JRadioButton radio_projeksiyon;
    private JRadioButton radio_kasa;
    private Reservation reservation;
    private ReservationManager reservationManager;
    private RoomManager roomManager;
    private EmployeeView employeeView;
    private Room room;
    public RezervationAddView(Reservation reservation, Room selectedRoom, String start_date, String endDate, int adultNumber, int childNumber) {
        //this.pencionManager = new PencionManager(hotel);
    this.room = selectedRoom;
    if (reservation == null){
        this.reservation = new Reservation();
    }else {
        this.reservation = reservation;
    }


    this.reservationManager = new ReservationManager();
    this.roomManager = new RoomManager();
    this.fld_rezervationOtelName.setText(this.room.getHotel().getHotelName());
    this.fld_roomType.setText(this.room.getRoom_type());
    this.fld_pansiyonType.setText(this.room.getPencion().getPencionType());
    this.fld_rezervationAdress.setText(this.room.getHotel().getHotelAddress());
    this.fld_startDate.setText(start_date);
    this.fld_endDate.setText(endDate);
    this.fld_RezervationStar.setText(this.room.getHotel().getHotelStar());
    this.radio_concierge.setSelected(this.room.getHotel().isHotelConcierge());
    this.radio_otopark.setSelected(this.room.getHotel().isHotelCarpark());
    this.radio_wifi.setSelected(this.room.getHotel().isHotelWifi());
    this.radio_spa.setSelected(this.room.getHotel().isHotelSpa());
    this.radio_pool.setSelected(this.room.getHotel().isHotelPool());
    this.radio_roomService.setSelected(this.room.getHotel().isHotelRoomservice());
    this.radio_fitness.setSelected(this.room.getHotel().isHotelFitness());
    this.fld_bedCapacity.setText(String.valueOf(room.getRoom_bed_capacity()));
    this.fld_meter.setText(String.valueOf(room.getRoom_squar_meter()));
    this.radio_tv.setSelected(this.room.isRoom_tv());
    this.radio_konsol.setSelected(this.room.isRoom_konsol());
    this.radio_projeksiyon.setSelected(this.room.isRoom_projeksiyon());
    this.radio_minibar.setSelected(this.room.isRoom_minibar());
    this.radio_kasa.setSelected(this.room.isRoom_kasa());
    int totalGuest = adultNumber + childNumber;
    this.fld_totalGuest.setText(String.valueOf(totalGuest));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start_datee = LocalDate.parse(start_date, formatter);
        LocalDate endDatee = LocalDate.parse(endDate, formatter);

        long days =  ChronoUnit.DAYS.between(start_datee, endDatee);

        int totalPrice = (int) (days *  ((adultNumber * this.room.getRoom_adult_price()) + (childNumber * this.room.getRoom_child_price())));
        this.fld_totalPrice.setText(String.valueOf(totalPrice));






        this.add(container);
        this.guiInitilaze(1000, 700);
    }


}

