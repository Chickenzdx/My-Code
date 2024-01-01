import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
/*In this Last Swing I want to make an air conditioner with JSlider and JTextBox
Since the actual temperature of air conditioning is equal to the temperature that will be reached in the room,
JDialog is used to stop users killing themselves by setting the temperature below 20 degrees or above 40 degrees.
JMenuBar Switches between the air conditioner temperature screen and the air conditioner function screen
 */
//Just copy and paste from SwingSwingSwing
public class LastSwing {
    public static void main(String[] args) {
        FrameMaker thisFrame = new FrameMaker();
    }
}

class FrameMaker implements ActionListener, ChangeListener, ItemListener,
        MouseListener {
    JFrame myFrame = new JFrame("User Input");
    JPanel[] sectors = new JPanel[4];
    JLabel[] titles = new JLabel[2];
    JLabel[] output = new JLabel[2];
    JLabel[] allOutput = new JLabel[2];
    JButton dataButton = new JButton("Get all data");
    // JSlider syntax: min, max, initial
    JSlider mySlider = new JSlider(0,100,0);
    // Setting up an array of JCheckBox(es)
    JCheckBox[] boxes = new JCheckBox[3];
    //Set up JMenuBar
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Menu");
    JMenuItem[] menuItems = new JMenuItem[2];

    public FrameMaker() {
        myFrame.setPreferredSize(new Dimension(1300,600));
        myFrame.setMinimumSize(new Dimension(1300,600));
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLayout(new GridLayout(1, 3));

        //Menu bar set up
        menuItems[0] = new JMenuItem("temperature");
        menuItems[1] = new JMenuItem("function");
        for (int i = 0; i < menuItems.length; i++) {
            menu.add(menuItems[i]);
            menuItems[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Handle Menu Item click
                    if (e.getActionCommand().equals("temperature")) {
                        sectors[0].setVisible(true);
                        sectors[1].setVisible(false);
                    } else if (e.getActionCommand().equals("function")) {
                        sectors[0].setVisible(false);
                        sectors[1].setVisible(true);
                    }
                }
            });
        }
        menuBar.add(menu);
        myFrame.setJMenuBar(menuBar);


// setting up my main JPanel panels, just copy and paste from SwingSwingSwing
        for (int i=0;i<2;i++) {
            sectors[i] = new JPanel();
            sectors[i].setLayout(new GridLayout(3,1));
            sectors[i].setBorder(new EmptyBorder(10, 10, 10, 10));
        }
        sectors[0].setBackground(Color.RED);
        sectors[1].setBackground(Color.ORANGE);
// setting up & formatting panel titles, just copy and paste from SwingSwingSwing
        for (int i=0;i<titles.length;i++) {
            titles[i] = new JLabel();
            titles[i].setFont(new Font("Futura", Font.BOLD, 30));
        }
        titles[0].setText("Temperature");
        titles[1].setText("Function");
        for (int i=0;i<titles.length;i++) {
            sectors[i].add(titles[i]);
        }
// setting up JSlider and adding to a JPanel, just copy and paste from SwingSwingSwing
        mySlider.setPaintTrack(true);
        mySlider.setPaintTicks(true);
        mySlider.setPaintLabels(true);
        mySlider.setMajorTickSpacing(20);
        mySlider.setMinorTickSpacing(5);
        mySlider.setFont(new Font("Futura", Font.PLAIN, 10));
        mySlider.addChangeListener(this);
        sectors[0].add(mySlider);
// setting up some check boxes (inside a JPanel within a JPanel), just copy and paste from SwingSwingSwing
        JPanel boxPanel = new JPanel();
        sectors[1].add(boxPanel);
        boxPanel.setBackground(Color.WHITE);
        boxPanel.setLayout(new GridLayout(1,2));
        boxes[0] = new JCheckBox("Sleep");
        boxes[1] = new JCheckBox("Moist");
        boxes[2] = new JCheckBox("Quite");
        for (int i=0;i<3;i++) {
            boxes[i].addItemListener(this);
            boxes[i].setFont(new Font("Futura", Font.PLAIN, 20));
            boxPanel.add(boxes[i]);
        }
// setting up & formatting output information, just copy and paste from SwingSwingSwing
        output[0] = new JLabel("Slider value: " + mySlider.getValue());
        output[1] = new JLabel("");
        for (int i=0;i<output.length;i++) {
            output[i].setFont(new Font("Futura", Font.BOLD, 20));
            sectors[i].add(output[i]);
        }
// setting up button, just copy and paste from SwingSwingSwing
        sectors[2] = new JPanel();
        sectors[2].setLayout(new BorderLayout());
        sectors[2].setBackground(Color.MAGENTA);
        sectors[2].setBorder(new EmptyBorder(10, 10, 10, 10));
        dataButton.addActionListener(this);
        dataButton.setFont(new Font("Futura", Font.PLAIN, 20));
        dataButton.addMouseListener(this);
        sectors[2].add(dataButton, BorderLayout.CENTER);
// setting up main output panel, just copy and paste from SwingSwingSwing
        for (int i=0;i<2;i++) {
            allOutput[i] = new JLabel();
            allOutput[i].setForeground(Color.WHITE);
        }
        sectors[3] = new JPanel();
        sectors[3].setBackground(Color.BLUE);
        sectors[3].setBorder(new EmptyBorder(10, 10, 10, 10));
        sectors[3].setLayout(new GridLayout(4,1));
        for (int i=0;i<2;i++) {
            allOutput[i].setFont(new Font("Futura", Font.BOLD, 20));
            sectors[3].add(allOutput[i]);
        }
// adding panels to frame, just copy and paste from SwingSwingSwing

        for (int i=0;i<sectors.length;i++) {
            myFrame.add(sectors[i]);
        }
        sectors[1].setVisible(false);
        myFrame.setVisible(true);
    }
    /*Here I made a big change, I saw my classmates in class use JSlider to adjust the light and shade, so I wanted to
    Try some color gradients, and it's also fit the theme of air conditioning
    So I need to search for the relevant code on the search engine. It wasn't hard to do, but I didn't know the right keywords
    I was do some search and I got some keywords like "color palette" and "animation"
    Thinking that the color palette in the painting software is a sliding JSlider and letting the colors gradually change, so there is a starting point
    After more searching, I have found more keywords such as Java RGB color interpolation code and many others keywords
    So I found a reliable method such as https://blog.51cto.com/u_16213335/7024380
    I didn't search in English because I didn't find reliable information in English...Maybe because my terrible English, I write wrong keywords
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        int value = mySlider.getValue();
        output[0].setText("Slider value: " + value);
        //Create a start color and end color
        Color blueColor = new Color(0, 0, 255);
        Color redColor = new Color(255, 0, 0);
        //Use linear interpolation algorithm to calculate the intermediate color
        int r = (int) (redColor.getRed() * (1.0 - value / 100.0) + blueColor.getRed() * (value / 100.0));
        int g = (int) (redColor.getGreen() * (1.0 - value / 100.0) + blueColor.getGreen() * (value / 100.0));
        int b = (int) (redColor.getBlue() * (1.0 - value / 100.0) + blueColor.getBlue() * (value / 100.0));

        Color color = new Color(r, g, b);
        sectors[0].setBackground(color);
    }
    //Just copy and paste from SwingSwingSwing
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource()==boxes[0] || e.getSource()==boxes[1] ||
                e.getSource()==boxes[2]) {
            output[1].setFont(new Font("Futura", Font.BOLD, 12));
            output[1].setText("");
            if (boxes[0].isSelected()) {
                output[1].setText(output[1].getText() + "Sleep is selected. ");
            }
            if (boxes[1].isSelected()) {
                output[1].setText(output[1].getText() + "Moist is selected. ");
            }
            if (boxes[2].isSelected()) {
                output[1].setText(output[1].getText() + "Quiet is selected. ");
            }
        }
    }
    //Just copy and paste from SwingSwingSwing
    @Override
    public void actionPerformed(ActionEvent e) {
        allOutput[0].setText("Slider value: " + mySlider.getValue());
        allOutput[1].setText("");
        if (boxes[0].isSelected()) {
            allOutput[1].setText(allOutput[1].getText() + "Sleep! ");
        }
        if (boxes[1].isSelected()) {
            allOutput[1].setText(allOutput[1].getText() + "Moist! ");
        }
        if (boxes[2].isSelected()) {
            allOutput[1].setText(allOutput[1].getText() + "Quiet!");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }
    //JDialog
    @Override
    public void mouseReleased(MouseEvent e) {
        if (sectors[0].isVisible()) {
            int value = mySlider.getValue();
            if (value < 20 || value > 40) {
                JDialog myDialog = new JDialog();
                myDialog.setBounds(10, 10, 300, 100);

                JLabel dialogMessage = new JLabel("Invalid data!");
                myDialog.add(dialogMessage);
                myDialog.setVisible(true);
            }
        }
    }
    //Just copy and paste from SwingSwingSwing
    @Override
    public void mouseEntered(MouseEvent e) {
        Component c = e.getComponent();
        if (c==dataButton) {
            dataButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}

