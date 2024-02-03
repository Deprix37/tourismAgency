package business;

import core.Helper;
import dao.PencionDao;
import entity.Hotel;
import entity.Pencion;

import java.util.ArrayList;

public class PencionManager {
    private final PencionDao pencionDao;
    private Hotel hotel;
    public PencionManager(Hotel hotel) {
        this.hotel = hotel;
        this.pencionDao = new PencionDao();
    }
    public boolean savePencion(Hotel hotel, String val){
        if (hotel.getId() !=0 ){
            Helper.showMsg("error");

        }
        return this.pencionDao.savePencion(hotel,val);
    }


    public ArrayList<Object[]> getForTable(int size, ArrayList<Pencion> pencions){
        System.out.println("2.1");
        ArrayList<Object[]> pencionList = new ArrayList<>();
        for (Pencion obj : pencions){
            System.out.println("2.3");
            int i = 0;
            Object[] rowObject = new Object[size];
            rowObject[i++] = obj.getPencionId();
            rowObject[i++] = obj.getHotelId();
            rowObject[i++] = obj.getPencionType();

            pencionList.add(rowObject);
        }
        return pencionList;
    }
    public ArrayList<Pencion> findAll(){
        return this.pencionDao.findAll();
    }
    public Pencion getById(int id){
        return this.pencionDao.getById(id);
    }
}
