package view;

import business.UserManager;
import core.Helper;
import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Objects;

public class AdminView extends Layout{
    private User user;

    private JPanel container;
    private JLabel lbl_welcome;
    private JTable tbl_user;
    private JButton btn_logout;
    private JComboBox cmb_user_search;
    private JButton btn_search;
    private JTextField fld_userName;
    private JPasswordField fld_pass;
    private JComboBox cmb_role;
    private JButton btn_save;
    private DefaultTableModel tmdl_user = new DefaultTableModel();
    private UserManager userManager;
    private JPopupMenu userMenu;


    public AdminView(User loggedInUser){
        this.userManager = new UserManager();
        this.add(container);
        this.guiInitilaze(700,500);
        this.user = loggedInUser;
        if (loggedInUser == null){
            dispose();
        }


        //Tabloya colonları ekleme
        this.lbl_welcome.setText("Hoşgeldiniz " + this.user.getUsername());
        Object[] col_user = {"Kullanıcı ID" , "Kullanıcı Adı" ,"Parola", "Kullanıcı Rolü"};
        ArrayList<User> userList = this.userManager.findAll();
        this.tmdl_user.setColumnIdentifiers(col_user);
        for (User user : userList) {
            Object[] obj = new Object[]{user.getId(), user.getUsername(), user.getPassword(),user.getRole()};
            this.tmdl_user.addRow(obj);
        }




        //DATABASE VERİLERİ TABLOYA ÇEKME
        this.tbl_user.setModel(this.tmdl_user);
        this.tbl_user.getTableHeader().setReorderingAllowed(false); //kolon yerleri değişmemesi için
        this.tbl_user.setEnabled(false); //tablo düzenlenmemesii için

       //tıklanan satırın seçilmesi
        this.tbl_user.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                int selected_row = tbl_user.rowAtPoint(e.getPoint());
                tbl_user.setRowSelectionInterval(selected_row, selected_row);
            }
        });

        //sağ tık yapıldığında menu açılmasını sağlar
        this.userMenu = new JPopupMenu();
        userMenu.add("Yeni").addActionListener(e -> {
           UserView userView = new UserView(null);
        });
        userMenu.add("Güncelle");
        userMenu.add("Sil");

        this.tbl_user.setComponentPopupMenu(userMenu);


        btn_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField[] checkFieldList = {fld_userName,fld_pass};
                String role = (String) cmb_role.getSelectedItem();
                if (Helper.isFieldListEmpty(checkFieldList) || role.equals("")){
                    Helper.showMsg("fill");
                }else {

                }if (user == null){


                }

            }
        });
    }



}
