package view;

import business.UserManager;
import entity.User;

import javax.swing.*;


public class EmployeeView extends Layout {
    private User user;
    private UserManager userManager;
    private JPanel container;
    private JPanel pnp_top;
    private JPanel pnp_bottom;

    public  EmployeeView(User loggedInUser) {
        this.userManager = new UserManager();
        this.add(container);
        this.guiInitilaze(700, 500);
        this.user = loggedInUser;

    }
}

