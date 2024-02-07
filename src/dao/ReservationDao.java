package dao;

import core.Db;
import entity.Reservation;
import entity.Room;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReservationDao {
    private final Connection con;
    public ReservationDao() {
        this.con = Db.getInstance();
    }
    public ArrayList<Reservation> findAll(){
        ArrayList<Reservation> reservationList = new ArrayList<>();
        String sql = "SELECT * FROM public.reservation";
        try {
            ResultSet rs = this.con.createStatement().executeQuery(sql);
            while (rs.next()){
                reservationList.add(this.match(rs));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return reservationList;
    }
    public Reservation match(ResultSet rs) throws SQLException {
        Reservation obj = new Reservation();
        obj.setID(rs.getInt("ID"));
        obj.setReservationRoomId(rs.getInt("reservation_room_id"));
        obj.setReservationStartDate(rs.getDate("reservation_start_date").toLocalDate());
        obj.setReservationEndDate(rs.getDate("reservation_end_date").toLocalDate());
        obj.setReservationTotalPrice(rs.getInt("reservation_total_price"));
        obj.setReservationGuesNumber(rs.getInt("reservation_guest_number"));
        obj.setReservationGuestId(rs.getInt("reservation_guest_id"));
        obj.setReservationMail(rs.getString("reservation_mail"));
        obj.setReservationPhone(rs.getInt("reservation_phone"));

        return obj;
    }
}
