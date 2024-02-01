package view;

import business.UserManager;
import core.Helper;
import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;

public class AdminView extends Layout{
    private User user;

    private JPanel container;
    private JLabel lbl_welcome;
    private JTable tbl_user;
    private JButton btn_logout;
    private JComboBox<User.Role> cmb_user_search;
    private JButton btn_search;
    private JTextField fld_userName;
    private JPasswordField fld_pass;
    private JComboBox<User.Role> cmb_role;
    private JButton btn_save;
    private DefaultTableModel tmdl_user = new DefaultTableModel();
    private UserManager userManager;
    private JPopupMenu userMenu;
    private Object[] col_user ;


    public AdminView(User loggedInUser) {
        this.userManager = new UserManager();
        this.add(container);
        this.guiInitilaze(700, 500);
        this.user = loggedInUser;

        if (loggedInUser == null) {
            dispose();
        }
        loadUserTable(null);
        loadUserComponent();



    }

    private void loadUserComponent(){
        btn_save.addActionListener(e -> {
            JTextField[] checkFieldList = {this.fld_userName,this.fld_pass};
            if (Helper.isFieldListEmpty(checkFieldList)){
                Helper.showMsg("fill");
            }else {
                boolean result ;
                User userNew = new User();
                userNew.setUsername(fld_userName.getText());
                userNew.setPassword(fld_pass.getText());
                userNew.setRole(String.valueOf(cmb_role.getSelectedItem()));
                result = this.userManager.save(userNew);
                if (result){
                    Helper.showMsg("done");
                    loadUserTable(null);

                }else {
                    Helper.showMsg("error");
                }

            }
        });
        //tıklanan satırın seçilmesi
        tableRowSelect(tbl_user);



        //sağ tık yapıldığında menu açılmasını sağlar
        this.userMenu = new JPopupMenu();
        userMenu.add("Yeni").addActionListener(e -> {
            UserView userView = new UserView(null);
            userView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadUserTable(null);
                }
            });

        });

        //SEÇİLİ OLAN USERID Yİ DATABASEDEN ALIP BURAYA GÖNDERME
        userMenu.add("Güncelle").addActionListener(e -> {
            int selectUserId = Integer.parseInt(tbl_user.getValueAt(tbl_user.getSelectedRow() , 0).toString());

            UserView userView = new UserView(this.userManager.getById(selectUserId));
            userView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadUserTable(null);
                }
            });

        });
        userMenu.add("Kullanıcı Sil").addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int selectedId = Integer.parseInt(tbl_user.getValueAt(tbl_user.getSelectedRow() , 0).toString());
                if (this.userManager.delete(selectedId)) {
                    Helper.showMsg("done");
                    loadUserTable(null);
                } else {
                    Helper.showMsg("error");
                }
            }
        });
        this.tbl_user.setComponentPopupMenu(userMenu);
        this.cmb_user_search.setModel(new DefaultComboBoxModel<>(User.Role.values()));

        this.cmb_role.setModel(new DefaultComboBoxModel<>(User.Role.values()));

        btn_search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userSearchRole =String.valueOf(cmb_user_search.getSelectedItem());
                ArrayList<User> searchedUserList = userManager.findByRole(userSearchRole);
                ArrayList<Object[]> searchedUserRowList= userManager.getForTable(col_user.length,searchedUserList);
                loadUserTable(searchedUserRowList);
            }
        });
    }
    public void loadUserTable( ArrayList<Object[]> userList) {
        col_user = new Object[]{"ID", "Kullanıcı Adı", "Parola", "Rol"};
        if (userList==null){
            userList = this.userManager.getForTable(col_user.length, this.userManager.findAll());
        }
        System.out.println("loaduser"+userList.size());
        createTable(this.tmdl_user, this.tbl_user, col_user, userList);
    }


}
