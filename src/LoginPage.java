//Login window

import java.awt.*;
import java.awt.event.*;

public class LoginPage
{
    Frame frame;
    Button login_button,register_button;
    char mask='*';

    //The frame is initialized in the default constructor
    LoginPage()
    {
        //Creating a frame
        frame=new Frame();
        
        //setting the size the the frame
        frame.setSize(300,200);
        
        //setting the title of the frame
        frame.setTitle("Login Window");
    
        frame.setLayout(null);
        
        //setVisible is set to true to make sure the frame is visible after the program is executed
        frame.setVisible(true);

        //set the location of the frame on the screen to the center.
        frame.setLocationRelativeTo(null);

        //handling window events 
        frame.addWindowListener(new WindowAdapter()
        {
            //Overloading the method for closing the window
            public void windowClosing(WindowEvent e)
            {
                frame.dispose();
            }
        });

        //Initializing Componenets and setting the position of the components - Labels,TextFields,Buttons
        Label userid_label=new Label("UserID");
        userid_label.setBounds(20,40,80,30);
        TextField userid_field=new TextField();
        userid_field.setBounds(20,80,80,30);
        
        Label psswrd_label=new Label("Password");
        psswrd_label.setBounds(120,40,80,30);
        TextField psswrd_field=new TextField();
        psswrd_field.setBounds(120,80,80,30);
        psswrd_field.setEchoChar(mask);
        
        login_button=new Button("Login");
        login_button.setBounds(20,120,80,30);
        login_button.addActionListener(new ActionListener() //Handling action event - login button. Using the annoymous inner class method
        {
            //when pressed, the program retrieve data stored in the database and compare it to the input data in the textfield
            public void actionPerformed(ActionEvent e)
            {
                //Storing data from textfields in String variables
                String user_id=userid_field.getText();
                String password=psswrd_field.getText();
                
                UserDB user=new UserDB(user_id,password);
                
                //Verification - comparing the input values in the textfield to the data in the database
                if(user_id.equals(user.retrieveUserID()) && password.equals(user.retrieveUserPassword(user_id)))
                {
                    //Creating an instance which invoke the contructor -  the frame of WelcomePage window
                    WelcomePage welcome=new WelcomePage();
                    frame.dispose();
                }
                else
                {
                    //Resetting the textfields
                    userid_field.setText("");
                    psswrd_field.setText("");

                    Warning warning=new Warning();
                    warning.invalidUserMessage();
                }
            }
        });
        
        register_button=new Button("Register");
        register_button.setBounds(120,120,80,30);
        register_button.addActionListener(new ActionListener() //Handling action event - resgister button. Using the annoymous inner class method
        {
            public void actionPerformed(ActionEvent e)
            {
                //Creating an instance of RegisterPage class to invoke the constructor - to invoke RegisterPage window
                RegisterPage registerpage=new RegisterPage();
            }
        });

        //adding the components to the frame
        frame.add(userid_label);
        frame.add(psswrd_label);
        frame.add(userid_field);
        frame.add(psswrd_field);
        frame.add(login_button);
        frame.add(register_button);  
    }

    //Main method is invoking the Login window itself.
    public static void main(String args[])
    {
        LoginPage login=new LoginPage();
    }
}