//register window

import java.awt.*;
import java.awt.event.*;

class RegisterPage extends UserDB
{
    String fname,lname,userID,emailID,psswrd; 
    Frame frame;
    TextField fname_field,lname_field,userid_field,email_field,psswrd_field;
    char mask='*';
    
    RegisterPage()
    {
        super(first_name, last_name, user_id, email_id, password);

        //Frame settings
        frame=new Frame();
        frame.setTitle("Register Window");
        frame.setSize(350,400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() //Window event handling - closing the window
        {
            public void windowClosing(WindowEvent e)
            {
                frame.dispose();
            }
        });
        
        //Initializing,setting and adding of the components
        Label fname_label=new Label("Firstname");
        fname_label.setBounds(20,40,80,30);
        frame.add(fname_label);
        fname_field=new TextField();
        fname_field.setBounds(100,40,80,30);
        frame.add(fname_field);
        
        Label lname_label=new Label("Lastname");
        lname_label.setBounds(20,80,80,30);
        frame.add(lname_label);
        lname_field=new TextField();
        lname_field.setBounds(100,80,80,30);
        frame.add(lname_field);
        
        Label userid_label=new Label("User ID");
        userid_label.setBounds(20,120,80,30);
        frame.add(userid_label);
        userid_field=new TextField();
        userid_field.setBounds(100,120,80,30);
        frame.add(userid_field);
        
        Label email_label=new Label("Email ID");
        email_label.setBounds(20,160,80,30);
        frame.add(email_label);
        email_field=new TextField();
        email_field.setBounds(100,160,180,30);
        frame.add(email_field);
        
        Label psswrd_label=new Label("Password");
        psswrd_label.setBounds(20,200,80,30);
        frame.add(psswrd_label);
        psswrd_field=new TextField();
        psswrd_field.setBounds(100,200,180,30);
        psswrd_field.setEchoChar(mask);
        frame.add(psswrd_field);
        
        Button register_button=new Button("Register");
        register_button.setBounds(20,240,80,30);
        register_button.addActionListener(new ActionListener() //Register the user to the database
        {
            //When pressed, the input data is passed in the parameterized constructor of the UserDB class
            public void actionPerformed(ActionEvent e)
            {
                //saving Strings in the textfield into the String variable
                fname=fname_field.getText();
                lname=lname_field.getText();
                userID=userid_field.getText();
                emailID=email_field.getText();
                psswrd=psswrd_field.getText();
                
                //Input data is passed as a parameter in the constructor of the UserDB class
                UserDB user=new UserDB(fname,lname,userID,emailID,psswrd);
                //Inserting the input string into the database
                user.insertUserInfo();
                
                //Once registration is complete, rest the textField
                fname_field.setText("");
                lname_field.setText("");
                userid_field.setText("");
                email_field.setText("");
                psswrd_field.setText(""); 
            }
        });
        frame.add(register_button);

        Button exit_button=new Button("Exit");
        exit_button.setBounds(100,240,80,30);
        exit_button.addActionListener(new ActionListener()
        {
            //closing the frame with the use of exit button
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
            }
        }
        );
        frame.add(exit_button);
    }
}