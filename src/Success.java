//Success message window
import java.awt.*;
import java.awt.event.*;

class Success
{
    Frame frame;
    Button complete_button;
    Label success_message;

    Font successFont=new Font("Serif",Font.PLAIN,16);

    public void successMessage()
    {
        success_message=new Label("Registration completed");
        success_message.setFont(successFont);
        success_message.setAlignment(Label.CENTER);
        frame.add(success_message);
    }
    
    Success()
    {
        //frame settings
        frame=new Frame();
        frame.setTitle("Success!");
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
        
        complete_button=new Button("Complete");
        complete_button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
            }
        });
        frame.add(complete_button,BorderLayout.SOUTH);
    }

}