package business;

import core.Helper;
import dao.RoomDao;
import entity.Hotel;
import entity.Pencion;
import entity.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomManager {
    private final RoomDao roomDao;
    private Hotel hotel;
    private Room room;

    public RoomManager() {
        this.roomDao = new RoomDao();

    }
    public ArrayList<Object[]> getForTable(int size, ArrayList<Room> rooms) {
        ArrayList<Object[]> roomList = new ArrayList<>();
        for (Room obj : rooms) {
            Object[] rowObject = new Object[size];
            int i = 0;
            //col_room = new Object[]{"ID", "Otel Adı", "Pansiyon" , "Oda Tipi", "Stok", "Yetişkin Fiyat","Çocuk Fiyat", "Yatak Kapasitesi", "m2", "Tv","Minibar","Konsol","Kasa","Projeksiyon"}
            rowObject[i++] = obj.getRoom_id();
            rowObject[i++] = obj.getHotel().getHotelName();
            rowObject[i++] = obj.getPencion().getPencionType();
            rowObject[i++] = obj.getRoom_type();
            rowObject[i++] = obj.getRoom_stock();
            rowObject[i++] = obj.getRoom_adult_price();
            rowObject[i++] = obj.getRoom_child_price();
            rowObject[i++] = obj.getRoom_bed_capacity();
            rowObject[i++] = obj.getRoom_squar_meter();
            rowObject[i++] = obj.isRoom_tv();
            rowObject[i++] = obj.isRoom_minibar();
            rowObject[i++] = obj.isRoom_konsol();
            rowObject[i++] = obj.isRoom_kasa();
            rowObject[i++] = obj.isRoom_projeksiyon();
            roomList.add(rowObject);
            //rowObject[i++] = obj.getSeason().getSeasonEndDate();
            //rowObject[i++] = obj.getHotel().getHotelAddress();
            //rowObject[i++] = obj.getRoom_type();
        }
        return roomList;
    }
    public ArrayList<Room> findAll(){
        return this.roomDao.findAll();
    }
    public boolean save(Room room){
        if (room.getRoom_id() !=0 ){
            Helper.showMsg("error");

        }
        return this.roomDao.saveRoom(room);
    }
    public ArrayList<Room> findByRoomFilter(String hotelName, String hotelAddress, String startDate, String enddate, String childNumber, String adultNumber) {
    return roomDao.findByRoomFilter(hotelName,hotelAddress,startDate,enddate,childNumber,adultNumber);
}
    public Room getById(int id){
        return this.roomDao.getById(id);
    }
}

