package view;

import entity.User;

import javax.swing.*;

public class AdminView extends Layout{
    private User user;

    private JPanel container;
    private JLabel lbl_welcome;
    private JTable tbl_user;
    private JButton btn_logout;
    private JComboBox cmb_user_search;
    private JButton btn_search;

    public AdminView(User user){
        this.add(container);
        this.guiInitilaze(700,500);
        this.user = user;
        if (user == null){
            dispose();
        }
        this.lbl_welcome.setText("Hoşgeldiniz " + this.user.getUsername());
        //sd

    }
}
