package dao;

import core.Db;
import entity.Reservation;
import entity.Room;
import entity.User;

import java.sql.*;
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
        obj.setID(rs.getInt("id"));
        obj.setReservationRoomId(rs.getInt("reservation_room_id"));
        obj.setReservationStartDate(rs.getDate("reservation_start_date").toLocalDate());
        obj.setReservationEndDate(rs.getDate("reservation_end_date").toLocalDate());
        obj.setReservationTotalPrice(rs.getInt("reservation_total_price"));
        obj.setReservationGuesNumber(rs.getInt("reservation_guest_number"));
        obj.setReservationGuestName(rs.getString("reservation_guest_name"));
        obj.setReservationGuestId(rs.getString("reservation_guest_id"));
        obj.setReservationMail(rs.getString("reservation_mail"));
        obj.setReservationPhone(rs.getString("reservation_phone"));

        return obj;
    }
    public boolean save(Reservation reservation) {
        String query = "INSERT INTO public.reservation" +
                "(" +
                "reservation_room_id," +
                "reservation_start_date," +
                "reservation_end_date," +
                "reservation_total_price," +
                "reservation_guest_number," +
                "reservation_guest_name," +
                "reservation_guest_id," +
                "reservation_mail," +
                "reservation_phone" +
                ")" +
                "VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1,reservation.getReservationRoomId());
            pr.setDate(2, Date.valueOf(reservation.getReservationStartDate()));
            pr.setDate(3, Date.valueOf(reservation.getReservationEndDate()));
            pr.setInt(4,reservation.getReservationTotalPrice());
            pr.setInt(5,reservation.getReservationGuesNumber());
            pr.setString(6,reservation.getReservationGuestName());
            pr.setString(7,reservation.getReservationGuestId());
            pr.setString(8,reservation.getReservationMail());
            pr.setString(9,reservation.getReservationPhone());
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public boolean update(Reservation reservation) {
        String query = "UPDATE public.reservation SET " +

                "reservation_room_id = ? ," +
                "reservation_start_date = ? ," +
                "reservation_end_date = ? , " +
                "reservation_total_price = ? , " +
                "reservation_guest_number = ? ," +
                "reservation_guest_name = ? , " +
                "reservation_guest_id = ? , " +
                "reservation_mail = ? , " +
                "reservation_phone = ?   " +
                "WHERE id = ? ";



        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1,reservation.getReservationRoomId());
            pr.setDate(2, Date.valueOf(reservation.getReservationStartDate()));
            pr.setDate(3, Date.valueOf(reservation.getReservationEndDate()));
            pr.setInt(4,reservation.getReservationTotalPrice());
            pr.setInt(5,reservation.getReservationGuesNumber());
            pr.setString(6,reservation.getReservationGuestName());
            pr.setString(7,reservation.getReservationGuestId());
            pr.setString(8,reservation.getReservationMail());
            pr.setString(9,reservation.getReservationPhone());
            pr.setInt(10,reservation.getID());
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public Reservation getById(int id){
        Reservation obj = null;
        String query = "SELECT * FROM public.reservation WHERE id = ?";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                obj = this.match(rs);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return obj;
    }
    public boolean delete(int id){
        String query = "DELETE FROM public.reservation WHERE id = ?";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1,id);
            return pr.executeUpdate() !=-1;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;

    }
   /* public boolean update(Reservation reservation){
        String query = "UPDATE public.reservation SET " +
                "resevartion_guest_name= ? , " +
                "reservation_guest_mail = ?  " +
                "WHERE ID = ? ";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1,reservation.getReservationGuestName());
            pr.setString(2,reservation.getReservationMail());
            pr.setInt(3,reservation.getID());
            return pr.executeUpdate() != -1;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return true;
    }*/


}
