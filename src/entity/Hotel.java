package entity;

public class Hotel {
    private int id;
    private String hotelName;
    private String hotelAddress;
    private String hotelMail;
    private String hotelPhone;
    private String hotelStar;
    private boolean hotelCarpark;
    private boolean hotelWifi;
    private boolean hotelPool;
    private boolean hotelFitness;
    private boolean hotelConcierge;
    private boolean hotelSpa;
    private boolean hotelRoomservice;
    public Hotel(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelMail() {
        return hotelMail;
    }

    public void setHotelMail(String hotelMail) {
        this.hotelMail = hotelMail;
    }

    public String getHotelPhone() {
        return hotelPhone;
    }

    public void setHotelPhone(String hotelPhone) {
        this.hotelPhone = hotelPhone;
    }

    public String getHotelStar() {
        return hotelStar;
    }

    public void setHotelStar(String hotelStar) {
        this.hotelStar = hotelStar;
    }

    public boolean isHotelCarpark() {
        return hotelCarpark;
    }

    public void setHotelCarpark(boolean hotelCarpark) {
        this.hotelCarpark = hotelCarpark;
    }

    public boolean isHotelWifi() {
        return hotelWifi;
    }

    public void setHotelWifi(boolean hotelWifi) {
        this.hotelWifi = hotelWifi;
    }

    public boolean isHotelPool() {
        return hotelPool;
    }

    public void setHotelPool(boolean hotelPool) {
        this.hotelPool = hotelPool;
    }

    public boolean isHotelFitness() {
        return hotelFitness;
    }

    public void setHotelFitness(boolean hotelFitness) {
        this.hotelFitness = hotelFitness;
    }

    public boolean isHotelConcierge() {
        return hotelConcierge;
    }

    public void setHotelConcierge(boolean hotelConcierge) {
        this.hotelConcierge = hotelConcierge;
    }

    public boolean isHotelSpa() {
        return hotelSpa;
    }

    public void setHotelSpa(boolean hotelSpa) {
        this.hotelSpa = hotelSpa;
    }

    public boolean isHotelRoomservice() {
        return hotelRoomservice;
    }

    public void setHotelRoomservice(boolean hotelRoomservice) {
        this.hotelRoomservice = hotelRoomservice;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", hotelName='" + hotelName + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
                ", hotelMail='" + hotelMail + '\'' +
                ", hotelPhone='" + hotelPhone + '\'' +
                ", hotelStar='" + hotelStar + '\'' +
                ", hotelCarpark=" + hotelCarpark +
                ", hotelWifi=" + hotelWifi +
                ", hotelPool=" + hotelPool +
                ", hotelFitness=" + hotelFitness +
                ", hotelConcierge=" + hotelConcierge +
                ", hotelSpa=" + hotelSpa +
                ", hotelRoomservice=" + hotelRoomservice +
                '}';
    }


}
