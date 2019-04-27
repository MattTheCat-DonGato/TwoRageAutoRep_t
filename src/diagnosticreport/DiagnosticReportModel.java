/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnosticreport;

import database.Database;
import java.sql.Statement;
import utilities.ActiveCustomer;
import utilities.TRError;

/**
 *
 * @author Matthew Rodriguez
 */
public class DiagnosticReportModel
{
    Database trDatabase = new Database();
    ActiveCustomer activeCustomer = ActiveCustomer.GetSingletonCustomer();
    
    public void InsertReportToDatabase(int vID, int sympID, String comments)
    {
        try
        {
            trDatabase.Connect();
            Statement statement = trDatabase.GetStatement();
            String sql = "insert into diagnosticreport values (0," + activeCustomer.GetcID() + ", " + vID + ", " + sympID + ", '" + comments + "');";
            statement.executeUpdate(sql);
            TRError.TRError("INFORMATION", "Diagnostic Report Record Insert Success", "Diagnostic Report Record has been successfully added to the database.");
            trDatabase.CloseConnection();
        }
        catch (Exception e)
        {
            System.out.println("Exception at InsertReportToDataBase Function: " + e.getMessage());
        }
    }
}
