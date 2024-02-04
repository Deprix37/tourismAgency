package view;

import business.HotelManager;
import business.SeasonManager;
import core.Helper;
import entity.Hotel;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class SeasonView extends Layout{
    private JPanel container;
    private JFormattedTextField fld_endDate;
    private JButton btn_seasonSave;
    private JFormattedTextField fld_startDate;
    private JLabel lbl_otelD;
    private SeasonManager seasonManager;
    private HotelManager hotelManager;
    private Hotel hotel;

    public SeasonView(Hotel hotel){
        this.seasonManager = new SeasonManager(null);
        //this.pencionManager = new PencionManager(hotel);
        this.hotelManager = new HotelManager();
        this.hotel = hotel;
        this.add(container);
        this.guiInitilaze(400, 350);
        lbl_otelD.setText("OTEL ID : " + hotel.getId());
        btn_seasonSave.addActionListener(e -> {

                LocalDate convertedSeaonStartDate = LocalDate.parse(LocalDate.parse(this.fld_startDate.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                LocalDate convertedSeaonEndDate = LocalDate.parse(LocalDate.parse(this.fld_endDate.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                seasonManager.saveSeason(hotel,convertedSeaonStartDate,convertedSeaonEndDate);
                dispose();


        });
    }

    private void createUIComponents() throws ParseException {

        this.fld_startDate = new JFormattedTextField(new MaskFormatter("##/##/####"));
        this.fld_endDate = new JFormattedTextField(new MaskFormatter("##/##/####"));
    }
}
