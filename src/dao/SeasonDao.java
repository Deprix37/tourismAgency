package dao;

import core.Db;
import entity.Hotel;
import entity.Pencion;
import entity.Season;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SeasonDao {
    private Connection con;

    public SeasonDao(){
        this.con = Db.getInstance();
    }

    public Season getById(int id){
        Season obj = null;
        String query = "SELECT * FROM public.season WHERE season_id = ?";
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

    public Season match(ResultSet rs) throws SQLException{
        Season obj = new Season();
        obj.setSeasonId(rs.getInt("season_id"));
        obj.setHotelId(rs.getInt("hotel_id"));
        obj.setSeasonStartDate(rs.getString("season_startdate"));
        obj.setSeasonEndDate(rs.getString("season_enddate"));
        return obj;
    }
    public boolean saveSeason(Hotel hotel, String startDate, String endDate){
        String query = "INSERT INTO public.season" +
                "(hotel_id, season_startdate, season_enddate)" +
                "VALUES ( ?, ?, ?)";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1,hotel.getId());
            pr.setDate(2, Date.valueOf(startDate));
            pr.setDate(3,Date.valueOf(endDate));

            return pr.executeUpdate() != -1;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return true;
    }
    public ArrayList<Season> findAll(){
        ArrayList<Season> seasonsList = new ArrayList<>();
        String sql = "SELECT * FROM public.season";
        try {
            ResultSet rs = this.con.createStatement().executeQuery(sql);
            while (rs.next()){
                seasonsList.add(this.match(rs));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return seasonsList;
    }
}
