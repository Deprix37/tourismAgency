import core.Db;
import core.Helper;
import entity.User;
import view.EmployeeView;
import view.LoginView;

import java.sql.Connection;
import java.sql.DriverManager;

public class App {
    public static void main(String[] args) {
        Helper.setTheme();
        LoginView loginView = new LoginView();
        //EmployeeView employeeView = new EmployeeView(new User());

    }
}
