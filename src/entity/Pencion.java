package entity;

import core.ComboItem;

public class Pencion {
    private int pencionId;
    private int hotelId;
    private String pencionType;
    public Pencion(){

    }

    public int getPencionId() {
        return pencionId;
    }

    public void setPencionId(int pencionId) {
        this.pencionId = pencionId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getPencionType() {
        return pencionType;
    }

    public void setPencionType(String pencionType) {
        this.pencionType = pencionType;
    }

    @Override
    public String toString() {
        return "Pencion{" +
                "pencionId=" + pencionId +
                ", hotelId=" + hotelId +
                ", pencionType='" + pencionType + '\'' +
                '}';
    }
    public ComboItem getComboItem() {
        return new ComboItem(this.getPencionId(),this.getPencionType());
    }
}
