package dao;

import core.Db;
import entity.Hotel;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HotelDao {

    private final Connection con;
    public HotelDao() {
        this.con = Db.getInstance();
    }
    public ArrayList<Hotel> findAll(){
        ArrayList<Hotel> hotelList = new ArrayList<>();
        String sql = "SELECT * FROM public.hotel";
        try {
            ResultSet rs = this.con.createStatement().executeQuery(sql);
            while (rs.next()){
                hotelList.add(this.match(rs));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return hotelList;
    }


    public Hotel match(ResultSet rs) throws SQLException{
        Hotel obj = new Hotel();
        obj.setId(rs.getInt("hotel_id"));
        obj.setHotelName(rs.getString("hotel_name"));
        obj.setHotelAddress(rs.getString("hotel_address"));
        obj.setHotelMail(rs.getString("hotel_mail"));
        obj.setHotelPhone(rs.getString("hotel_phone"));
        obj.setHotelStar(rs.getString("hotel_star"));
        obj.setHotelCarpark(rs.getBoolean("hotel_carpark"));
        obj.setHotelWifi(rs.getBoolean("hotel_wifi"));
        obj.setHotelPool(rs.getBoolean("hotel_pool"));
        obj.setHotelFitness(rs.getBoolean("hotel_fitness"));
        obj.setHotelConcierge(rs.getBoolean("hotel_concierge"));
        obj.setHotelSpa(rs.getBoolean("hotel_spa"));
        obj.setHotelRoomservice(rs.getBoolean("hotel_roomservice"));

        return obj;
    }
    public boolean save(Hotel hotel){
        String query = "INSERT INTO public.hotel" +
                "("+
                "hotel_name,"+
                "hotel_mail,"+
                "hotel_phone,"+
                "hotel_address,"+
                "hotel_star,"+
                "hotel_carpark,"+
                "hotel_wifi,"+
                "hotel_pool,"+
                "hotel_fitness,"+
                "hotel_concierge,"+
                "hotel_spa,"+
                "hotel_roomservice"+
                ")"+
                " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, hotel.getHotelName());
            pr.setString(2, hotel.getHotelMail());
            pr.setString(3,hotel.getHotelPhone());
            pr.setString(4,hotel.getHotelAddress());
            pr.setString(5,hotel.getHotelStar());
            pr.setBoolean(6, hotel.isHotelCarpark());
            pr.setBoolean(7, hotel.isHotelWifi());
            pr.setBoolean(8, hotel.isHotelPool());
            pr.setBoolean(9, hotel.isHotelFitness());
            pr.setBoolean(10, hotel.isHotelConcierge());
            pr.setBoolean(11, hotel.isHotelSpa());
            pr.setBoolean(12, hotel.isHotelRoomservice());

            return pr.executeUpdate() != -1;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return true;
    }
    public Hotel getById(int id){
        Hotel obj = null;
        String query = "SELECT * FROM public.hotel WHERE hotel_id = ?";
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
   /* public boolean savePencion(Hotel hotel, String val){
        String query = "INSERT INTO public.pencion(" +
                " hotel_id, pencion_type)" +
                " VALUES ( ?, ?)";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1,hotel.getId());
            pr.setString(2,val);

            return pr.executeUpdate() != -1;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return true;
    }*/


}
