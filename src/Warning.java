//Warning messages window
import java.awt.*;
import java.awt.event.*;

class Warning
{
    Frame frame;
    static Label null_message,invalid_message;
    Button exit_button;

    Font warningFont=new Font("Serif",Font.PLAIN,16);
    
    //warning message for null entry in the register window
    public void nullFieldMessage()
    {
        null_message=new Label("Please fill all the information!");   
        null_message.setFont(warningFont);
        null_message.setAlignment(Label.CENTER); 
        frame.add(null_message);
    }

    //warning message for invalid/null entry in the login window
    public void invalidUserMessage()
    {
        invalid_message=new Label("Invalid user");
        invalid_message.setFont(warningFont);
        invalid_message.setAlignment(Label.CENTER);
        frame.add(invalid_message);
    }
    
    Warning()
    {
        //frame settings
        frame=new Frame();
        frame.setTitle("Warning!");
        frame.setSize(350,100);
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
        
        exit_button=new Button("Exit");
        exit_button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
            }
        });
        frame.add(exit_button,BorderLayout.SOUTH);
    }
}