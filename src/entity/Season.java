package entity;

import core.ComboItem;

import java.time.LocalDate;
import java.util.Date;

public class Season {
    private int seasonId;
    private int hotelId;
    private LocalDate seasonStartDate;
    private LocalDate seasonEndDate;

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public LocalDate getSeasonStartDate() {
        return seasonStartDate;
    }

    public void setSeasonStartDate(LocalDate seasonStartDate) {
        this.seasonStartDate = seasonStartDate;
    }

    public LocalDate getSeasonEndDate() {
        return seasonEndDate;
    }

    public void setSeasonEndDate(LocalDate seasonEndDate) {
        this.seasonEndDate = seasonEndDate;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonId=" + seasonId +
                ", hotelId=" + hotelId +
                ", seasonStartDate=" + seasonStartDate +
                ", seasonFinishDate=" + seasonEndDate +
                '}';
    }
    public ComboItem getComboItem() {
        return new ComboItem(this.getSeasonId(),this.getSeasonStartDate() + " - " + this.getSeasonEndDate());
    }
}
