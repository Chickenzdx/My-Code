import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Extra:I added a picture to help the user determine the correct answer
public class WeekNine {
    public static void main(String[] args) {
        JFrame myFrame = new JFrame("My Wife");
        myFrame.setPreferredSize(new Dimension(1000, 500));
        myFrame.setMinimumSize(new Dimension(1000, 500));
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLayout(null);

        // Create two panels for the left and right sides
        JPanel panelLeft = new JPanel();
        JPanel panelRight = new JPanel();
        panelLeft.setBounds(6, 0, 500, 500);
        panelRight.setBounds(506, 0, 500, 500);
        panelLeft.setBackground(Color.WHITE);
        panelRight.setBackground(Color.BLUE);
        panelLeft.setLayout(null);
        panelRight.setLayout(null);
        myFrame.add(panelLeft);
        myFrame.add(panelRight);

        // button and text field setup
        JTextField userInput = new JTextField();
        userInput.setBounds(10, 10, 200, 50);
        JButton button1 = new JButton("Submit");
        button1.setBounds(10, 60, 200, 50);
        panelLeft.add(userInput);
        panelLeft.add(button1);

        JLabel theLabel = new JLabel("Who is this person?");
        theLabel.setBounds(10, 100, 200, 50);
        panelLeft.add(theLabel);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button1) {
                    String input = userInput.getText();

                    // Check the answer
                    if (input.equalsIgnoreCase("Kate's wife")) {
                        theLabel.setText("Correct answer!");
                        theLabel.setForeground(Color.BLUE);
                    } else {
                        theLabel.setText("Wrong answer, Please re-enter");
                        theLabel.setForeground(Color.RED);
                    }
                }
            }
        });

        // Image setup on the right panel

        ImageIcon imageIcon = new ImageIcon("MyWife.jpeg");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(10, 150, 250, 200);
        panelRight.add(imageLabel);

        myFrame.setVisible(true);
    }
}