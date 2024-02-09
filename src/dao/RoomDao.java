package dao;

import business.HotelManager;
import core.Db;
import entity.Hotel;
import entity.Pencion;
import entity.Room;
import entity.User;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class RoomDao {
    private final Connection con;
    private final HotelDao hotelDao;
    private final SeasonDao seasonDao;
    private final  PencionDao pencionDao;

    public RoomDao() {
        this.hotelDao = new HotelDao();
        this.seasonDao = new SeasonDao();
        this.pencionDao = new PencionDao();
        this.con = Db.getInstance();
    }
    //Veri erişim işlemlerini gerçekleştiren katmandır.
    //Veritabanına erişim, veri çekme, ekleme, güncelleme ve silme işlemlerini yönetir.
    public boolean saveRoom(Room room) {
        String query = "INSERT INTO public.room" +
                "(" +
                "hotel_id," +
                "pencion_id," +
                "season_id," +
                "room_type," +
                "room_stock," +
                "room_adult_price," +
                "room_child_price," +
                "room_bed_capacity," +
                "room_squar_meter," +
                "room_tv," +
                "room_minibar," +
                "room_konsol," +
                "room_kasa," +
                "room_projeksiyon" +
                ")" +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1,room.getHotel_id());
            pr.setInt(2,room.getPencion_id());
            pr.setInt(3,room.getSeason_id());
            pr.setString(4,room.getRoom_type());
            pr.setInt(5,room.getRoom_stock());
            pr.setInt(6,room.getRoom_adult_price());
            pr.setInt(7,room.getRoom_child_price());
            pr.setInt(8,room.getRoom_bed_capacity());
            pr.setInt(9,room.getRoom_squar_meter());
            pr.setBoolean(10,room.isRoom_tv());
            pr.setBoolean(11,room.isRoom_minibar());
            pr.setBoolean(12,room.isRoom_konsol());
            pr.setBoolean(13,room.isRoom_kasa());
            pr.setBoolean(14, room.isRoom_projeksiyon());
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public Room match(ResultSet rs) throws SQLException {
        Room obj = new Room();
        obj.setRoom_id(rs.getInt("room_id"));
        obj.setHotel_id(rs.getInt("hotel_id"));
        obj.setPencion_id(rs.getInt("pencion_id"));
        obj.setSeason_id(rs.getInt("season_id"));
        obj.setRoom_type(rs.getString("room_type"));
        obj.setRoom_stock(rs.getInt("room_stock"));
        obj.setRoom_adult_price(rs.getInt("room_adult_price"));
        obj.setRoom_child_price(rs.getInt("room_child_price"));
        obj.setRoom_bed_capacity(rs.getInt("room_bed_capacity"));
        obj.setRoom_squar_meter(rs.getInt("room_squar_meter"));
        obj.setRoom_tv(rs.getBoolean("room_tv"));
        obj.setRoom_minibar(rs.getBoolean("room_minibar"));
        obj.setRoom_konsol(rs.getBoolean("room_konsol"));
        obj.setRoom_kasa(rs.getBoolean("room_kasa"));
        obj.setRoom_projeksiyon(rs.getBoolean("room_projeksiyon"));
        obj.setHotel(this.hotelDao.getById(rs.getInt("hotel_id")));
        obj.setPencion(this.pencionDao.getById(rs.getInt("pencion_id")));
        obj.setSeason(this.seasonDao.getById(rs.getInt("season_id")));
        return obj;
    }
    public ArrayList<Room> findAll(){
        ArrayList<Room> roomList = new ArrayList<>();
        String sql = "SELECT * FROM public.room";
        try {
            ResultSet rs = this.con.createStatement().executeQuery(sql);
            while (rs.next()){
                roomList.add(this.match(rs));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return roomList;
    }
    public ArrayList<Room> findByRoomFilter(String hotelName, String hotelAddress, String startDate, String endDate,String childNumber, String adultNumber) {
        ArrayList<Room> roomList = new ArrayList<>();
        if (childNumber.equals("")){
             childNumber = "0";
        }
        if (adultNumber.equals("")){
            adultNumber ="0";
        }

        try {
            String query = "SELECT * FROM public.room r" +
                    " LEFT JOIN public.hotel h ON r.hotel_id = h.hotel_id" +
                    " LEFT JOIN public.season s ON r.hotel_id = s.hotel_id" +
                    " WHERE (h.hotel_name IS NULL OR LOWER(h.hotel_name) LIKE LOWER(?))" +
                    " AND r.room_stock > 0 AND (h.hotel_address IS NULL OR LOWER(h.hotel_address) LIKE LOWER(?))" +
                    "AND (" + childNumber + "+" + adultNumber+ ") <= r.room_bed_capacity";

            // startDate ve endDate dolu ise ekleyelim
            if (!startDate.isEmpty()) {
                query += " AND (s.season_startdate IS NULL OR s.season_startdate < ?)";
            }

            if (!endDate.isEmpty()) {
                query += " AND (s.season_enddate IS NULL OR s.season_enddate > ?)";
            }

            PreparedStatement preparedStatement = this.con.prepareStatement(query);
            preparedStatement.setString(1, "%" + hotelName + "%");
            preparedStatement.setString(2, "%" + hotelAddress + "%");


            // startDate ve endDate'ı uygun bir tarih formatına çevirip set edin
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedStartDate = startDate.isEmpty() ? null : dateFormat.parse(startDate);
            java.util.Date parsedEndDate = endDate.isEmpty() ? null : dateFormat.parse(endDate);

            int parameterIndex = 3; // Query'de başlangıç indeksi

            if (parsedStartDate != null) {
                preparedStatement.setDate(parameterIndex++, new java.sql.Date(parsedStartDate.getTime()));
            }

            if (parsedEndDate != null) {
                preparedStatement.setDate(parameterIndex++, new java.sql.Date(parsedEndDate.getTime()));
            }

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                roomList.add(match(rs));
            }
            System.out.println(query);
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }

        return roomList;
    }

    public Room getById(int id){
        Room obj = null;
        String query = "SELECT * FROM public.room WHERE room_id = ?";
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
    public boolean updateStok(Room room){
        String query = "UPDATE public.room SET " +
                "room_stock= ? " +
                "WHERE room_id = ? ";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1,room.getRoom_stock());
            pr.setInt(2,room.getRoom_id());

            return pr.executeUpdate() != -1;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return true;
    }


}
