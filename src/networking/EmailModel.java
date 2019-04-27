/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking;

import database.Database;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Matthew Rodriguez
 */
public class EmailModel
{
    Database trDatabase = new Database();
    
    public String SelectCustomerEmailAddress(int ID)
    {
        String emailContact = "";
        try
        {
            trDatabase.Connect();
            Statement sql = trDatabase.GetStatement();
            ResultSet rs = sql.executeQuery("select cEmailContact from customer where cID = " + ID +";");
            while (rs.next())
            {
                 emailContact = rs.getString("cEmailContact");
            }
            rs.close();
            trDatabase.CloseConnection();
        }
        catch (Exception e)
        {
              System.out.println("Exception at SelectCustomerEmailAddress (EmailModel): " + e.getMessage());    
        }
        return emailContact;
    }
}
