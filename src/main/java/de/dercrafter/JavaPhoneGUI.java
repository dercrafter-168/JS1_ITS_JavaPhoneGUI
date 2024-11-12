package de.dercrafter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * JavaPhoneGUI is a graphical user interface that simulates a phone keypad and display using Java's Swing framework.
 * This application provides a simple layout with a numeric keypad, a display area, and call control buttons,
 * allowing users to input numbers and simulate connecting and disconnecting calls.
 *
 * <p>The main features include:
 * <ul>
 * <li>A numeric keypad (0-9) along with hashtag (#) and asterisk (*) buttons.</li>
 * <li>A display area to show the phone's status (e.g., "ready", "connected") and the current number being dialed.</li>
 * <li>A call button that toggles between "Hook off" and "Hook on" to simulate picking up and hanging up a call.</li>
 * </ul>
 * <p>
 * The layout is structured with multiple panels:
 * <ul>
 * <li>A main phone panel (`PhonePanel`) that organizes the display, keypad, and call button.</li>
 * <li>A `keyPanel` organized in a 4x3 grid layout, holding the phone's numeric and symbol buttons.</li>
 * <li>A `displayPanel` to show the phone's current status and user input.</li>
 * </ul>
 * <p>
 * This class also implements the ActionListener interface to handle button clicks and update the display,
 * state, and call button text dynamically.
 *
 * <p>License: MIT
 *
 * @author Mike Mayer aka dercrafter-168
 * @version 1.0.0.0
 * @since jdk -23
 */
public class JavaPhoneGUI extends JFrame implements ActionListener {

    private static final Logger logger = LoggerFactory.getLogger(JavaPhoneGUI.class);

    /**
     * The Key 1.
     */
    JButton key1 = new JButton("1");
    /**
     * The Key 2.
     */
    JButton key2 = new JButton("2");
    /**
     * The Key 3.
     */
    JButton key3 = new JButton("3");
    /**
     * The Key 4.
     */
    JButton key4 = new JButton("4");
    /**
     * The Key 5.
     */
    JButton key5 = new JButton("5");
    /**
     * The Key 6.
     */
    JButton key6 = new JButton("6");
    /**
     * The Key 7.
     */
    JButton key7 = new JButton("7");
    /**
     * The Key 8.
     */
    JButton key8 = new JButton("8");
    /**
     * The Key 9.
     */
    JButton key9 = new JButton("9");
    /**
     * The Key hashtag.
     */
    JButton keyHashtag = new JButton("#");
    /**
     * The Key 0.
     */
    JButton key0 = new JButton("0");
    /**
     * The Key star.
     */
    JButton keyStern = new JButton("*");
    /**
     * The Call button.
     */
    JButton call_button = new JButton("Hook off");

    /**
     * The Display.
     */
    JTextField display = new JTextField();
    /**
     * The State.
     */
    JLabel state = new JLabel("ready");
    /**
     * The Key panel.
     */
    JPanel keyPanel = new JPanel();
    /**
     * The Display panel.
     */
    JPanel displayPanel = new JPanel();
    /**
     * The Key display panel.
     */
    JPanel keyDisplayPanel = new JPanel();
    JPanel PhonePanel  = new JPanel();

    /**
     * Constructs the JavaPhoneGUI class, which sets up the graphical user interface for a phone-like application.
     * This GUI includes a display panel for showing the current state and input, a keypad panel for numerical input,
     * and a button for initiating calls.
     * <p>
     * The layout includes:
     * <ul>
     * <li>A main phone panel (`PhonePanel`) using a BorderLayout, with a central `keyDisplayPanel` for organizing
     * components such as the keypad, display, and call button.</li>
     * <li>A display panel (`displayPanel`) with a grid layout, showing the state and current input display.</li>
     * <li>A key panel (`keyPanel`) arranged in a 4x3 grid, holding buttons for digits (0-9), as well as the
     * hashtag (#) and asterisk (*) keys.</li>
     * </ul>
     * <p>
     * Each button on the keypad and the call button is linked to an ActionListener to handle button clicks.
     * <p>
     * The method also applies padding and spacing between components for improved layout, sets the default size
     * and visibility of the window, and centers it on the screen.
     */
    JavaPhoneGUI() {
        setLayout(new BorderLayout(20, 20));
        displayPanel.setLayout(new GridLayout(1, 2, 20, 20));
        keyPanel.setLayout(new GridLayout(4, 3, 20, 20));
        keyDisplayPanel.setLayout(new BorderLayout(20, 20));
        PhonePanel.setLayout(new BorderLayout(200, 200));

        logger.info("set the layouts");

        //add buttons
        key1.addActionListener(this);
        key2.addActionListener(this);
        key3.addActionListener(this);
        key4.addActionListener(this);
        key5.addActionListener(this);
        key6.addActionListener(this);
        key7.addActionListener(this);
        key8.addActionListener(this);
        key9.addActionListener(this);
        keyHashtag.addActionListener(this);
        key0.addActionListener(this);
        keyStern.addActionListener(this);
        call_button.addActionListener(this);

        logger.info("buttons added");

        //move buttons to the keypanel
        keyPanel.add(key1);
        keyPanel.add(key2);
        keyPanel.add(key3);

        keyPanel.add(key4);
        keyPanel.add(key5);
        keyPanel.add(key6);

        keyPanel.add(key7);
        keyPanel.add(key8);
        keyPanel.add(key9);

        keyPanel.add(keyHashtag);
        keyPanel.add(key0);
        keyPanel.add(keyStern);

        logger.info("buttons to the keypanel moved");

        //create the main panel
        displayPanel.add(state);
        displayPanel.add(display);
        keyDisplayPanel.add(displayPanel, BorderLayout.NORTH);
        keyDisplayPanel.add(call_button, BorderLayout.WEST);
        keyDisplayPanel.add(keyPanel, BorderLayout.CENTER);
        PhonePanel.add(keyDisplayPanel, BorderLayout.CENTER);
        PhonePanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        add(PhonePanel, BorderLayout.CENTER);

        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Main method
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        new JavaPhoneGUI();
    }

    /**
     * Handles the actions performed when buttons on the phone GUI are pressed.
     * This method checks the source of the action event and updates the display,
     * call button text, and state of the phone accordingly.
     *
     * <ul>
     * <li>If the "Hook off" command is received, and there is text in the display,
     * it sets the state to "connected" and changes the call button text to "Hook on".</li>
     *
     * <li>If the "Hook on" command is received, and there is text in the display,
     * it clears the display, sets the state to "ready", and changes the call button
     * text back to "Hook off".</li>
     *
     * <li>If any other button is pressed (number or symbol), it appends the button's
     * text to the display, allowing the user to compose a number.</li>
     * </ul>
     *
     * @param e The ActionEvent triggered by the button press.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //hook of
        String num = e.getActionCommand();
        if (e.getActionCommand().equalsIgnoreCase("Hook off")) {
            if (!this.display.getText().isEmpty()) {
                this.state.setText("connected");
                this.call_button.setText("Hook on");
                logger.info("connected to the current phone number");
            }
            return;
        }

        //hook on
        if(e.getActionCommand().equalsIgnoreCase("Hook on")) {
            if (!this.display.getText().isEmpty()) {
                this.call_button.setText("Hook off");
                this.state.setText("ready");
                this.display.setText("");
                logger.info("disconnected to the current phone number");
            }
            return;
        }

        //user input
        @Deprecated
        //this.display.setText(this.display.getText().concat(num));
        String tmp = this.display.getText();
        this.display.setText(tmp+num);

        logger.info("updated the number_display");
    }
}
