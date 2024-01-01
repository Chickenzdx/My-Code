import javax.swing.*;
import java.awt.*;

public class Shape extends JPanel {
    public Shape() {
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.RED);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int ovalWidth = 200;
        int ovalHeight = 300;

        g.setColor(Color.GREEN);
        g.fillOval(centerX - ovalWidth / 2, centerY - ovalHeight / 2, ovalWidth, ovalHeight);

        int rectWidth = 50;
        int rectHeight = 50;
        int gap = 10;

        for (int i = 0; i < 5; i++) {
            int rectX = centerX + ovalWidth / 2 + i * (rectWidth + gap);
            int rectY = centerY - ovalHeight / 2;
            g.setColor(Color.BLUE);
            g.fillRect(rectX, rectY, rectWidth, rectHeight);
        }
    }

    public static void main(String[] args) {
        JFrame myFrame = new JFrame("Ellipses and Rectangles");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.add(new Shape());
        myFrame.setPreferredSize(new Dimension(900, 600));
        myFrame.pack();
        myFrame.setVisible(true);
    }
}