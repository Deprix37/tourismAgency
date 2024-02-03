package business;

import core.Helper;
import dao.SeasonDao;
import entity.Hotel;
import entity.Pencion;
import entity.Season;

import java.sql.Date;
import java.util.ArrayList;


public class SeasonManager {
    private final SeasonDao seasonDao;
    private Hotel hotel;

    public SeasonManager(Hotel hotel) {
        this.seasonDao = new SeasonDao();
        this.hotel = hotel;
    }
    public boolean saveSeason(Hotel hotel, String startDate, String endDate){
        if (hotel.getId() !=0 ){
            Helper.showMsg("done");

        }
        return this.seasonDao.saveSeason(hotel,  startDate, endDate);
    }
    public ArrayList<Object[]> getForTable(int size, ArrayList<Season> seasons){
        ArrayList<Object[]> seasonList = new ArrayList<>();
        for (Season obj : seasons){
            int i = 0;
            Object[] rowObject = new Object[size];
            rowObject[i++] = obj.getSeasonId();
            rowObject[i++] = obj.getHotelId();
            rowObject[i++] = obj.getSeasonStartDate();
            rowObject[i++] = obj.getSeasonEndDate();

            seasonList.add(rowObject);
        }
        return seasonList;
    }
    public ArrayList<Season> findAll(){
        return this.seasonDao.findAll();
    }
    public Season getById(int id){
        return this.seasonDao.getById(id);
    }
}
