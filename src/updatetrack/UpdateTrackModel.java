/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package updatetrack;

import database.Database;
import java.sql.Statement;
import utilities.ActiveEmployee;
import utilities.TRError;

/**
 *
 * @author Matthew Rodriguez
 */
public class UpdateTrackModel
{
    Database trDatabase = new Database();
     
    public void UpdateSelectedVehicle(int cID, int vID, int sID)
    {
        try
        {
            trDatabase.Connect();
            Statement statement = trDatabase.GetStatement();
            String sql = "update vehiclestatus set statusID = " + sID + " where cstatusID = " + cID + " and vstatusID = " + vID + ";";
            statement.executeUpdate(sql);
            TRError.TRError("INFORMATION", "Status Updated", "Vehicle Status Record has been successfully updated in the database.");
            trDatabase.CloseConnection();
        }
        catch (Exception e)
        {
            System.out.println("Exception at UpdateSelectedVehicle (Update Track Model): " + e.getMessage());
        }         
    }
}
