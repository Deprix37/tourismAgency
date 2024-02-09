package entity;

import java.time.LocalDate;
import java.util.Date;

public class Reservation {
    private int ID;
    private int reservationRoomId;
    private LocalDate reservationStartDate;
    private LocalDate reservationEndDate;
    private int reservationTotalPrice;
    private int reservationGuesNumber;
    private String reservationGuestName;
    private String reservationGuestId;
    private String reservationMail;
    private String reservationPhone;

    public Reservation(){

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getReservationRoomId() {
        return reservationRoomId;
    }

    public void setReservationRoomId(int reservationRoomId) {
        this.reservationRoomId = reservationRoomId;
    }

    public LocalDate getReservationStartDate() {
        return reservationStartDate;
    }

    public void setReservationStartDate(LocalDate reservationStartDate) {
        this.reservationStartDate = reservationStartDate;
    }

    public LocalDate getReservationEndDate() {
        return reservationEndDate;
    }

    public void setReservationEndDate(LocalDate reservationEndDate) {
        this.reservationEndDate = reservationEndDate;
    }

    public int getReservationTotalPrice() {
        return reservationTotalPrice;
    }

    public void setReservationTotalPrice(int reservationTotalPrice) {
        this.reservationTotalPrice = reservationTotalPrice;
    }

    public int getReservationGuesNumber() {
        return reservationGuesNumber;
    }

    public void setReservationGuesNumber(int reservationGuesNumber) {
        this.reservationGuesNumber = reservationGuesNumber;
    }

    public String getReservationGuestName() {
        return reservationGuestName;
    }

    public void setReservationGuestName(String reservationGuestName) {
        this.reservationGuestName = reservationGuestName;
    }

    public String getReservationGuestId() {
        return reservationGuestId;
    }

    public void setReservationGuestId(String reservationGuestId) {
        this.reservationGuestId = reservationGuestId;
    }

    public String getReservationMail() {
        return reservationMail;
    }

    public void setReservationMail(String reservationMail) {
        this.reservationMail = reservationMail;
    }

    public String getReservationPhone() {
        return reservationPhone;
    }

    public void setReservationPhone(String reservationPhone) {
        this.reservationPhone = reservationPhone;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "ID=" + ID +
                ", reservationRoomId=" + reservationRoomId +
                ", reservationStartDate=" + reservationStartDate +
                ", reservationEndDate=" + reservationEndDate +
                ", reservationTotalPrice=" + reservationTotalPrice +
                ", reservationGuesNumber=" + reservationGuesNumber +
                ", reservationGuestName=" + reservationGuestName +
                ", reservationGuestId=" + reservationGuestId +
                ", reservationMail='" + reservationMail + '\'' +
                ", reservationPhone=" + reservationPhone +
                '}';
    }
}
