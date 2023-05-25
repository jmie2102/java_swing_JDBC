import java.awt.*;
import java.awt.event.*;

class WelcomePage 
{
    Frame frame;
    Button logout_button;

    WelcomePage()
    {   
        //frame settings
        frame=new Frame();
        frame.setTitle("Home Page");
        frame.setSize(300,200);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                frame.dispose();
            }
        });

        Label welcome_message=new Label("Welcome back!");
        welcome_message.setAlignment(Label.CENTER);
        frame.add(welcome_message);

        logout_button=new Button("Logout");
        logout_button.addActionListener(new ActionListener() //when pressed, will logout and go back to login window
        {
            public void actionPerformed(ActionEvent e)
            {
                LoginPage login=new LoginPage();
                frame.dispose();
            }
        });
        frame.add(logout_button,BorderLayout.SOUTH);
    }
}