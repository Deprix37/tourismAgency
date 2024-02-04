package business;

import core.Helper;
import dao.HotelDao;
import dao.UserDao;
import entity.Hotel;
import entity.Room;
import entity.User;

import java.util.ArrayList;

public class HotelManager {
    private final HotelDao hotelDao;


    public HotelManager() {
        this.hotelDao = new HotelDao();
    }
    public ArrayList<Object[]> getForTable(int size, ArrayList<Hotel> hotels){
        ArrayList<Object[]> hotelList = new ArrayList<>();
        for (Hotel obj : hotels){
            int i = 0;
            Object[] rowObject = new Object[size];
            rowObject[i++] = obj.getId();
            rowObject[i++] = obj.getHotelName();
            rowObject[i++] = obj.getHotelAddress();
            rowObject[i++] = obj.getHotelMail();
            rowObject[i++] = obj.getHotelPhone();
            rowObject[i++] = obj.getHotelStar();
            rowObject[i++] = obj.isHotelCarpark();
            rowObject[i++] = obj.isHotelWifi();
            rowObject[i++] = obj.isHotelPool();
            rowObject[i++] = obj.isHotelFitness();
            rowObject[i++] = obj.isHotelConcierge();
            rowObject[i++] = obj.isHotelSpa();
            rowObject[i++] = obj.isHotelRoomservice();

            hotelList.add(rowObject);
        }
        return hotelList;
    }
    public boolean save(Hotel hotel){
        if (hotel.getId() !=0 ){
            Helper.showMsg("error");

        }
        return this.hotelDao.save(hotel);
    }
    public ArrayList<Hotel> findAll(){
        return this.hotelDao.findAll();
    }
    public Hotel getById(int id){
        return this.hotelDao.getById(id);
    }







}
