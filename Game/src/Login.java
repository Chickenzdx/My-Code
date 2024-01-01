/*import com.sxt.GameWin;*/
import com.sxt.GameWin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
/*I'm going to make a little game about kill cockroaches in the house

        I want to make a login screen:

        1. Create a window method

        2. Create a text box to enter the username and password

        3. Use regular expressions(regex) to check if the password is up to standard (I want to review the regular expressions, and I want users to create more complex passwords)

        4. Create a login button

        5. Click the login button to verify the username and password is correct. If there is an error, prompt to re-enter.

        The first level:
        1. Move the role up, down, left and right, and use the keyListener

        2. Firing bullets: The timer can be used to firing and movement of bullets.

        3. Enemy generation and movement: Generate cockroaches by timer and set their movement path.

        4. Determine win conditions: Check if all enemies are defeated.

        5. Determine the failure condition: Check whether the character collides with the enemy.

        The second level:
        1. Create a second window

        2. Move the character and the monster: similar to the first level.

        3. Monster firing bullets: similar to the first level of bullet firing.

        4. Win condition: The monster is defeated.

        5. Judge failure condition: Character collides with monster.

        Game end screen:
        1. End of game screen after failure: Use JDialog to indicate the end of the game and ask if player（user）want to restart.

        2. The game end screen after victory: Jump to the game completion screen and ask if user want to play again.

        Switch levels:
        Use JMenuBar to switch to the menu item of the second level*/

//Register and Login the game
public class Login {
    public static void main(String[] args) {
        JFrame myFrame = new JFrame("Login");
        myFrame.setPreferredSize(new Dimension(500, 500));
        myFrame.setMinimumSize(new Dimension(500, 500));
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLayout(null);

        JLabel label1 = new JLabel("UserName:");
        label1.setBounds(10, 10, 100, 50);
        JTextField userName = new JTextField();
        userName.setBounds(110, 10, 200, 50);

        JLabel label2 = new JLabel("Set Password:");
        label2.setBounds(10, 60, 100, 50);
        //JPasswordField, password invisible
        JPasswordField password = new JPasswordField();
        password.setBounds(110, 60, 200, 50);

        JButton button1 = new JButton("Submit");
        button1.setBounds(110, 110, 200, 50);

        JLabel theLabel = new JLabel();
        theLabel.setBounds(10, 160, 300, 50);
        myFrame.add(theLabel);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button1) {
                    String name = userName.getText();
                    //change it to String
                    char[] pin = password.getPassword();
                    String pinString = new String(pin);
                    // Check the answer using the validatePassword method
                    if (myPassword(pinString)) {

                        // Call a method to switch to the game panel here
                        // Create and display the game window
                       GameWin anim = new GameWin();
                        anim.setVisible(true);
                        myFrame.dispose();
                    } else {
                        theLabel.setText("Wrong answer, Please re-enter");
                        theLabel.setForeground(Color.RED);
                    }
                }
            }
        });

        myFrame.add(label1);
        myFrame.add(userName);
        myFrame.add(label2);
        myFrame.add(password);
        myFrame.add(button1);
        myFrame.setVisible(true);
    }

    // Return method for password validation
    //I used regular expressions to validate a complex password format
    private static boolean myPassword(String password) {
        String passwordRegex = "[a-zA-Z]{4}\\d{4}.";
        //[a-zA-Z]{4} means 4 Letter (Either uppercase or lowercase is fine)
        //\\d{4} means 4 number (Any number is fine)
        //.means except \n whatever you what, such as !
        //[abc] only abc
        //[^abc] except abc
        return Pattern.matches(passwordRegex, password);
    }
}