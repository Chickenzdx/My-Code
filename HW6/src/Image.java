import javax.swing.*;
import java.awt.*;

public class Image {
    public static void main(String[] args) {
        JFrame myFrame = new JFrame("Madeline");
        myFrame.setPreferredSize(new Dimension(1000, 1000));
        myFrame.setMinimumSize(new Dimension(1000, 1000)); //
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon firstImage = new ImageIcon("/Users/zhouduanxi/WechatIMG3454.jpeg");
        JLabel firstLabel = new JLabel(firstImage);
        firstLabel.setVerticalAlignment(JLabel.TOP);
        firstLabel.setHorizontalAlignment(JLabel.RIGHT);
        myFrame.add(firstLabel);
        myFrame.setVisible(true);
    }
}