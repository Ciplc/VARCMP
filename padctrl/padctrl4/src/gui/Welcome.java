/*
4/15/2019
Class for the welcome frame of Pad Control application
 */
package padctrlgui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Welcome extends JFrame implements ActionListener
{
    //Constants
    
    private final Color BACKGROUND_COLOR = new Color(0,200,0);
    private final Font DEFAULT_FONT = new Font("Calibri",Font.PLAIN,20);

    //Object declaration
    
    private JLabel welcomeLabel;
    private JLabel descriptionLabel;
    private JLabel imageLabel;
    private JButton loginButton;
    private JButton exitButton;
    private JPanel descriptionPanel;
    private JPanel buttonPanel;
    
    //Constructor
    
    public Welcome()
    {
        //Formatting frame
        
        super("Welcome");
        this.setBounds(100,50,900,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBackground(BACKGROUND_COLOR);
        this.setLayout(new BorderLayout());
        
        //Formatting and constructing welcomeLabel
        
        welcomeLabel = new JLabel("");
        welcomeLabel.setFont(DEFAULT_FONT);
        welcomeLabel.setForeground(Color.WHITE);
        
        //Formatting and constructing descriptionLabel
        
        descriptionLabel = new JLabel("");
        descriptionLabel.setFont(DEFAULT_FONT);
        descriptionLabel.setForeground(Color.WHITE);
        
        //Constructing imageLabel
        
        imageLabel = new JLabel();
        
        //Constructing buttons
        
        loginButton = new JButton("Login");
        exitButton = new JButton("Exit Application");
        loginButton.addActionListener(this);
        exitButton.addActionListener(this);
        
        //Constructing and formatting descriptionPanel
        
        descriptionPanel = new JPanel(new BorderLayout());
        descriptionPanel.setBackground(BACKGROUND_COLOR);
        
        descriptionPanel.add(welcomeLabel,BorderLayout.NORTH);
        descriptionPanel.add(descriptionLabel,BorderLayout.CENTER);
        
        //Constructing and formatting buttonPanel
        
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(BACKGROUND_COLOR);
        
        //Add to frame
        
        
    }
    
    public static void main(String[] args) 
    {
        
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
    }
    
}