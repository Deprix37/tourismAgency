package view;

import business.UserManager;
import entity.User;

import javax.swing.*;

public class UserView extends Layout{
    private JPanel container;
    private JLabel lbl_user;
    private JLabel lbl_user_name;
    private JTextField fld_user_name;
    private JPasswordField lbl_user_pass;
    private JComboBox cmb_role;
    private JButton btn_save;
    private User user;
    private UserManager userManager;
    public UserView(User user){
        this.add(container);
        this.guiInitilaze(300,300);
        this.user = user;
    }
}
