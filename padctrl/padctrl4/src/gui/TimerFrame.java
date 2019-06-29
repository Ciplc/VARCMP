package gui;
/*
Written by Henry G for VAR pad 6/28/2019
Frame which counts down time given by input and also counts up time after the fact
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class TimerFrame extends Template {

    //Declaring labels
    private JLabel timeDownLabel = new JLabel(" T- ",SwingConstants.LEFT);
    private JLabel timeUpLabel = new JLabel(" T+ ",SwingConstants.LEFT);
    
    //Declaring buttons
    private JButton proceedButton = new JButton("PROCEED WITH THE COUNT");
    private JButton holdButton = new JButton("HOLD");
    
    //Declaring panels
    private JPanel timerControlPanel = new JPanel(new BorderLayout());
    private JPanel timerDisplayPanel = new JPanel(new BorderLayout());
    
    public static void main(String[] args) {
        new TimerFrame();
    }

    public TimerFrame() {
        
        //Formatting frame
        this.setTitle("Timer");
        this.setBounds(100,50,650,400);
        this.setLayout(new BorderLayout());
        
        //Formatting labels
        timeDownLabel.setFont(TIMER_FONT);
        timeUpLabel.setFont(TIMER_FONT);
        timeDownLabel.setForeground(Color.WHITE);  
        timeUpLabel.setForeground(Color.WHITE);  
        
        //Formatting buttons
        proceedButton.setFont(BUTTON_FONT);
        holdButton.setFont(BUTTON_FONT);
        holdButton.setForeground(Color.RED);
        
        //Formatting panel
        timerControlPanel.setBackground(BACKGROUND_COLOR);
        timerDisplayPanel.setBackground(BACKGROUND_COLOR);
        
        //Adding actionlistener to buttons
        holdButton.addActionListener(this);
        proceedButton.addActionListener(this);
        
        //Adding to timerControlPanel
        timerControlPanel.add(proceedButton,BorderLayout.WEST);
        timerControlPanel.add(holdButton,BorderLayout.EAST);
        
        //Adding to timerDisplayPanel
        timerDisplayPanel.add(timeDownLabel,BorderLayout.WEST);
        timerDisplayPanel.add(new TestPane(),BorderLayout.EAST);
        
        //Adding to buttonPanel
        buttonPanel.add(timerControlPanel,BorderLayout.WEST);
        
        //Removing buttonPanel
        this.remove(buttonPanel);
        
        //Adding to frame
        this.add(timerDisplayPanel,BorderLayout.CENTER);
        this.add(buttonPanel,BorderLayout.SOUTH);
        
        this.setVisible(true);
    }

    // Creates a JPanel to add the timer stuff too, add a button for holding in here
    public class TestPane extends JPanel {
        
        //Constant
        private final Color BACKGROUND_COLOR = new Color(95,95,95);
        private final Font TIMER_FONT = new Font("Trebuchet MS",Font.BOLD,60);
        
        // Declare timer obj and set the start time and duration, make duration variable to UI
        private Timer timer;
        private long startTime = -1;
        private long duration = 50000;
        private JLabel label = new JLabel("");

        // Constructor for the Panel
        public TestPane() {
            setLayout(new GridBagLayout());

            //Formats panel
            this.setBackground(BACKGROUND_COLOR);
            
            // This timer works by setting the system time to a var then tracking time since it set that time then
            // Subtracting it from the start sys time to get the current time
            timer = new Timer(10, new ActionListener() { // Set timer method to obj and
                @Override                                        // and override the actionPerformed
                public void actionPerformed(ActionEvent e) {
                    if (startTime < 0) {                         // if start time is less than 0 set the start time to
                        startTime = System.currentTimeMillis();  // the current sys time in MS
                    }
                    long now = System.currentTimeMillis();       // The current sys time
                    long clockTime = now - startTime;            // The time on the clock
                    if (clockTime >= duration) {                 // If clock time passes duration stop the timer
                        clockTime = duration;
                        timer.stop();
                    }

                    SimpleDateFormat df = new SimpleDateFormat("mm:ss");    // Format the output in Min:Sec
                    label.setText(df.format(duration - clockTime));             // Set the label to current time
                    label.setFont(TIMER_FONT);
                    label.setForeground(Color.WHITE);
                }
            });
            timer.setInitialDelay(0);                            // Set the delay on the timer
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (!timer.isRunning()) {                    // If the timer is not running start it
                        startTime = -1;
                        timer.start();
                    }
                }
            });
            label = new JLabel("CLICK TO START");       // Setup initial label
            label.setFont(TIMER_FONT);
            label.setForeground(Color.WHITE);
            add(label);
        }
    }
}