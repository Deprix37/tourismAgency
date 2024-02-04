package entity;

public class Room {
    private int room_id;
    private int hotel_id;
    private int pencion_id;
    private int season_id;
    private String room_type;
    private int room_stock;
    private int room_adult_price;
    private int room_child_price;
    private int room_bed_capacity;
    private int room_squar_meter;
    private boolean room_tv;
    private boolean room_minibar;
    private boolean room_konsol;
    private boolean room_kasa;
    private boolean room_projeksiyon;
    private Hotel hotel;
    private Season season;
    private Pencion pencion;
    public enum RoomType{
        Single,
        Double,
        JuniorSuite,
        Suite
    }

    public Room() {
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public int getPencion_id() {
        return pencion_id;
    }

    public void setPencion_id(int pencion_id) {
        this.pencion_id = pencion_id;
    }

    public int getSeason_id() {
        return season_id;
    }

    public void setSeason_id(int season_id) {
        this.season_id = season_id;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public int getRoom_stock() {
        return room_stock;
    }

    public void setRoom_stock(int room_stock) {
        this.room_stock = room_stock;
    }

    public int getRoom_adult_price() {
        return room_adult_price;
    }

    public void setRoom_adult_price(int room_adult_price) {
        this.room_adult_price = room_adult_price;
    }

    public int getRoom_child_price() {
        return room_child_price;
    }

    public void setRoom_child_price(int room_child_price) {
        this.room_child_price = room_child_price;
    }

    public int getRoom_bed_capacity() {
        return room_bed_capacity;
    }

    public void setRoom_bed_capacity(int room_bed_capacity) {
        this.room_bed_capacity = room_bed_capacity;
    }

    public int getRoom_squar_meter() {
        return room_squar_meter;
    }

    public void setRoom_squar_meter(int room_squar_meter) {
        this.room_squar_meter = room_squar_meter;
    }

    public boolean isRoom_tv() {
        return room_tv;
    }

    public void setRoom_tv(boolean room_tv) {
        this.room_tv = room_tv;
    }

    public boolean isRoom_minibar() {
        return room_minibar;
    }

    public void setRoom_minibar(boolean room_minibar) {
        this.room_minibar = room_minibar;
    }

    public boolean isRoom_konsol() {
        return room_konsol;
    }

    public void setRoom_konsol(boolean room_konsol) {
        this.room_konsol = room_konsol;
    }

    public boolean isRoom_kasa() {
        return room_kasa;
    }

    public void setRoom_kasa(boolean room_kasa) {
        this.room_kasa = room_kasa;
    }

    public boolean isRoom_projeksiyon() {
        return room_projeksiyon;
    }

    public void setRoom_projeksiyon(boolean room_projeksiyon) {
        this.room_projeksiyon = room_projeksiyon;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Pencion getPencion() {
        return pencion;
    }

    public void setPencion(Pencion pencion) {
        this.pencion = pencion;
    }

    @Override
    public String toString() {
        return "Room{" +
                "room_id=" + room_id +
                ", hotel_id=" + hotel_id +
                ", pencion_id=" + pencion_id +
                ", season_id=" + season_id +
                ", room_type='" + room_type + '\'' +
                ", room_stock=" + room_stock +
                ", room_adult_price=" + room_adult_price +
                ", room_child_price=" + room_child_price +
                ", room_bed_capacity=" + room_bed_capacity +
                ", room_squar_meter=" + room_squar_meter +
                ", room_tv=" + room_tv +
                ", room_minibar=" + room_minibar +
                ", room_konsol=" + room_konsol +
                ", room_kasa=" + room_kasa +
                ", room_projeksiyon=" + room_projeksiyon +
                '}';
    }
}
