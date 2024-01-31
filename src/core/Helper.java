package core;

import javax.swing.*;
import java.awt.*;

public class Helper {
    public static void setTheme() {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {

                    UIManager.setLookAndFeel(info.getClassName());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
        }
    }

    //girilen dosya boş mu dolu mu kontrol eden function
    public static boolean isFieldEmpty(JTextField field){
        return field.getText().trim().isEmpty();
    }

    //Boş mu kontrolümü tüm dosyalar için liste haline getiren function
    public static boolean isFieldListEmpty(JTextField[] fieldList){
        for (JTextField field : fieldList){
            if (isFieldEmpty(field)) return true;
        }
        return false;
    }
    public static void showMsg(String str) {
        optionPaneTR();
        String msg;
        String title;
        switch (str) {
            case "fill":
                msg = "Lütfen tüm alanları doldurunuz !";
                title = "Hata!";
                break;
            case "done":
                msg = "İşlem Başarılı !";
                title = "Sonuç";
                break;
            case "succes":
                msg = "Giriş Başarılı";
                title ="Başarılı";
                break;
            case "userNotFound":
                msg = "Kullanıcı adı veya şifre hatalı";
                title ="Bilgiler hatalı";
                break;
            case "notFound":
                msg =  " Kayıt Bulunamadı !";
                title = "Bulunamadı";
                break;
            case "error":
                msg = "Hatalı işlem yaptınız !";
                title = "Hata";
                break;
            default:
                msg = str;
                title = "Mesaj";
        }
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);

    }

    private static void optionPaneTR() {
        UIManager.put("OptionPane.okButtonText", "Tamam");
        UIManager.put("OptionPane.yesButtonText", "Evet");
        UIManager.put("OptionPane.noButtonText", "Hayır");
    }


    // pencereyi ekranda ortalamak için fonction
    public static int getLocationPoint(String type, Dimension size){
        switch (type){
            case "x":
                return (Toolkit.getDefaultToolkit().getScreenSize().width-size.width)/2; //Yatay eksende ekranı ortalamak

            case "y":
                return (Toolkit.getDefaultToolkit().getScreenSize().height-size.height)/2; //dikey eksanda ekranı ortalma
            default:
            return 0;
        }

    }
}
