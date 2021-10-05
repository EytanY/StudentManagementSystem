import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class main2 {
    public static void main(String[] args) {
        ImageIcon img = new ImageIcon("C:\\Users\\etan1\\OneDrive\\שולחן העבודה\\אישי\\תמונות\\img\\pasport.jpg");
        img = resizeImage(img);
        JOptionPane.showMessageDialog(null, "message", "Display image:", JOptionPane.INFORMATION_MESSAGE, img);
    }

    public static ImageIcon resizeImage(ImageIcon img) {
        Image imgImage = img.getImage();
        Image newImgImage = imgImage.getScaledInstance(120, 150, java.awt.Image.SCALE_DEFAULT);
        return new ImageIcon(newImgImage);
    }
}
