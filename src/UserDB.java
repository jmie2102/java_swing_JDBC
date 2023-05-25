import java.sql.*;
import java.util.*;

class UserDB 
{
    static String first_name=null,last_name=null,user_id=null,email_id=null,password=null;
    
    static Connection conn=null;
    static Statement statement=null;
    static PreparedStatement pstatement=null;
    static ResultSet rs=null;
    static ResultSet rs_id=null;

    //Driver and url of Oracle databse
    String driver="oracle.jdbc.driver.OracleDriver";
    String url="jdbc:oracle:thin:@localhost:1521:xe";

    String passed_id,passed_password;
    
    //Constructor used in the LoginPage window for the passed input data
    UserDB(String ID,String pass)
    {
        passed_id=ID;
        passed_password=pass;
    }
    
    //Constructor used in the RegisterPage window for inserting into the input data from textfield to the database
    UserDB(String fname,String lname,String userID,String emailID,String psswrd)
    {
        first_name=fname;
        last_name=lname;
        user_id=userID;
        email_id=emailID;
        password=psswrd;
    }
    
    //Used to insert all of the user information into the database
    public void insertUserInfo() 
    {
        try
        {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,"admin","admin");

            //PrepareStatment allows multiple parameters to be passed to the insert query with the help of setString()
            pstatement=conn.prepareStatement("insert into usertable values(?,?,?,?,?)");
            pstatement.setString(1,user_id); //(index,data)
            pstatement.setString(2,first_name);
            pstatement.setString(3,last_name);
            pstatement.setString(4,email_id);
            pstatement.setString(5,password);

            int i=pstatement.executeUpdate();
            
            Success success=new Success();
            success.successMessage();
            
            System.out.println("User successfully registered");
            System.out.println(i+" records inserted");

            conn.close();
        }
        catch(Exception e)
        {
            Warning warning=new Warning();
            warning.nullFieldMessage();
            e.printStackTrace();
        }
    }    

    //retrieve the user id for UserID verification
    public String retrieveUserID()
    {   
        String temp_id=null;

        try
        {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,"admin","admin");
            statement=conn.createStatement();
            rs=statement.executeQuery("select USER_ID from usertable");

            ArrayList<String> retrieved_id=new ArrayList<String>();
            
            //Identificication
            while(rs.next())
            {   
                //saving the user_id within the database to the ArrayList for identification
                retrieved_id.add(rs.getString("USER_ID"));
                int i=0;
                
                //comparing the input data and the data stored in the database
                if(passed_id.equals(retrieved_id.get(i)))
                {
                    temp_id=retrieved_id.get(i);
                    System.out.println("ID Found");
                }
                else
                {
                    retrieved_id.remove(0);
                    temp_id=null;
                }    
            }
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return temp_id;
    }

    //retrieve the password from the database for password verification
    public String retrieveUserPassword(String MatchedUserID)
    {   
        String temp_password=null;
        try
        {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,"admin","admin");
            pstatement=conn.prepareStatement("select PASSWORD from usertable where user_id = ?");
            pstatement.setString(1,MatchedUserID);
            rs=pstatement.executeQuery();

            
            ArrayList<String> retrieved_password=new ArrayList<String>();
            
            //Identificication
            while(rs.next())
            {   
                retrieved_password.add(rs.getString("PASSWORD"));
                int i=0;

                if(passed_password.equals(retrieved_password.get(i)))
                {
                    temp_password=retrieved_password.get(i);
                    System.out.println("Password matched");
                }
                else
                {
                    retrieved_password.remove(0);
                    temp_password=null;
                }
            }
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return temp_password;
    }
}