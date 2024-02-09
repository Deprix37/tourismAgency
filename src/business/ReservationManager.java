package business;

import core.Helper;
import dao.ReservationDao;
import dao.RoomDao;
import entity.Pencion;
import entity.Reservation;
import entity.Room;
import entity.User;

import java.util.ArrayList;


public class ReservationManager {

    private final ReservationDao reservationDao;
    private final RoomDao roomDao;
    public ReservationManager(){
        reservationDao = new ReservationDao();
        roomDao = new RoomDao();

    }
    public ArrayList<Object[]> getForTable(int size, ArrayList<Reservation> reservations) {
        ArrayList<Object[]> reservationList = new ArrayList<>();
        for (Reservation obj : reservations) {
            Object[] rowObject = new Object[size];
            int i = 0;

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
    public boolean save(Reservation reservation){
        if (reservation.getID() !=0 ){
            Helper.showMsg("error");

        }
        return this.reservationDao.save(reservation);
    }
    public Reservation getById(int id){
        return this.reservationDao.getById(id);
    }
    public boolean update(Reservation reservation){
        if (this.getById(reservation.getID())== null){
            Helper.showMsg("notFound");
        }
        return this.reservationDao.update(reservation);
    }
    public boolean delete(int id){
        if (this.getById(id) == null){
            Helper.showMsg(id + " ID kayıtlı rezervasyon bulunamadı");
            return false;
        }
        return this.reservationDao.delete(id);
    }


}
