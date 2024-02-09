package view;

import business.ReservationManager;
import core.Helper;
import entity.Reservation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationUpdateView extends Layout {
    private JPanel container;
    private JTextField fld_guestname;
    private JTextField fld_guestmail;
    private JButton güncelleButton;
    private Reservation reservation;
    private ReservationManager reservationManager;

    public ReservationUpdateView(Reservation reservation) {
        this.reservationManager = new ReservationManager();
        this.add(container);
        this.guiInitilaze(700, 500);
        this.reservation = reservation;
        this.fld_guestname.setText(this.reservation.getReservationGuestName());
        this.fld_guestmail.setText(this.reservation.getReservationMail());
        güncelleButton.addActionListener(e -> {
            boolean result = false;
            this.reservation.setReservationGuestName(this.fld_guestname.getText());
            this.reservation.setReservationMail(this.fld_guestmail.getText());
            result = this.reservationManager.update(this.reservation);
           if (result){
               Helper.showMsg("done");
               dispose();
           }else{
               Helper.showMsg("error");
           }
        });
    }


}
