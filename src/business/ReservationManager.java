package business;

import dao.ReservationDao;
import entity.Reservation;
import entity.Room;

import java.util.ArrayList;


public class ReservationManager {
    private final ReservationDao reservationDao;
    public ReservationManager(){
        reservationDao = new ReservationDao();
    }
    public ArrayList<Object[]> getForTable(int size, ArrayList<Reservation> reservations) {
        ArrayList<Object[]> reservationList = new ArrayList<>();
        for (Reservation obj : reservations) {
            Object[] rowObject = new Object[size];
            int i = 0;
            //col_room = new Object[]{"ID", "Otel Adı", "Pansiyon" , "Oda Tipi", "Stok", "Yetişkin Fiyat","Çocuk Fiyat", "Yatak Kapasitesi", "m2", "Tv","Minibar","Konsol","Kasa","Projeksiyon"}
            rowObject[i++] = obj.getID();
            rowObject[i++] = obj.getReservationRoomId();
            rowObject[i++] = obj.getReservationStartDate();
            rowObject[i++] = obj.getReservationEndDate();
            rowObject[i++] = obj.getReservationTotalPrice();
            rowObject[i++] = obj.getReservationGuesNumber();
            rowObject[i++] = obj.getReservationGuestName();
            rowObject[i++] = obj.getReservationGuestId();
            rowObject[i++] = obj.getReservationMail();
            rowObject[i++] = obj.getReservationPhone();

            reservationList.add(rowObject);
            //rowObject[i++] = obj.getSeason().getSeasonEndDate();
            //rowObject[i++] = obj.getHotel().getHotelAddress();
            //rowObject[i++] = obj.getRoom_type();
        }
        return reservationList;
    }
    public ArrayList<Reservation> findAll(){
        return this.reservationDao.findAll();
    }
}
