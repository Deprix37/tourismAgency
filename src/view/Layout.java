package view;

import core.Helper;

import javax.swing.*;

public class Layout extends JFrame {
    //Gui oluştuğunda çağırılcak metod
    public void guiInitilaze(int width, int height){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Turizm Acentası");
        this.setSize(width,height);

        this.setLocation(Helper.getLocationPoint("x",this.getSize()),Helper.getLocationPoint("y",this.getSize())); // Screen mid koordinant
        this.setVisible(true);
    }
}
