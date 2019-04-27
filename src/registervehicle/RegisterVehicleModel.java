package registervehicle;

import database.Database;
import java.sql.ResultSet;
import java.sql.Statement;
import utilities.ActiveCustomer;
import utilities.TRError;
import utilities.Vehicle;

/**
 *
 * @author Matthew Rodriguez
 */
public class RegisterVehicleModel
{
      Database trDatabase = new Database();
      ActiveCustomer activeCustomer = ActiveCustomer.GetSingletonCustomer();

      public void InsertVehicleToDatabase(Vehicle newVehicle)
      {
          int vID = newVehicle.getvID();
          String year = newVehicle.getvYear();
          String make = newVehicle.getvMake();
          String model = newVehicle.getvModel();
          String color = newVehicle.getvYear();
          String licensePlate = newVehicle.getvLicensePlate();
          String odometer = newVehicle.getvOdometer();
          
          try
          {
              trDatabase.Connect();
              Statement statement = trDatabase.GetStatement();
              String sql = "insert into vehicle values (" + vID + ", '" + year + "', '" + make + "', '" + model + "', '" + color + "', '" + licensePlate + "', '" + odometer + "');";
              statement.executeUpdate(sql);
              TRError.TRError("INFORMATION", "Vehicle Inserted to Database", "Your vehicle has been successfully registered to the Database.");
              trDatabase.CloseConnection();
          }
          catch (Exception e)
          {
              System.out.println("Exception at InsertVehicleToDatabase (RegisterVehicleModel): " + e.getMessage());
          }
      }
      
      public int GetRecentVehicleIDInsertedToDatabase()
      {
          int vID = 0;
          try
          {             
              trDatabase.Connect();
              Statement sql = trDatabase.GetStatement();
              ResultSet rs = sql.executeQuery("select * from vehicle order by vID DESC");
              rs.next();
              vID = rs.getInt("vID");
              rs.close();
              trDatabase.CloseConnection();
          }
          catch (Exception e)
          {
              System.out.println("Exception at GetMostRecentVehicleIDRegistered (RegisterVehicleModel): " + e.getMessage());
          }
          return vID;
      }
      
      public void InsertIntoVehicleOwnerShipTable(int vID)
      {
          try
          {             
              trDatabase.Connect();
              Statement statement = trDatabase.GetStatement();
              String sql = "insert into vehicleownership values (" + activeCustomer.GetcID() + ", " + vID + ");";
              statement.executeUpdate(sql);
              TRError.TRError("INFORMATION", "Vehicle Assigned under your Account", "Clearing text fields.");
              trDatabase.CloseConnection();
          }
          catch (Exception e)
          {
              System.out.println("Exception at InsertIntoVehicleOwnerShipTable (RegisterVehicleModel): " + e.getMessage());
          }
      }
      
      public void InsertIntoVehicleStatusTable(int vID)
      {
          try
          {             
              trDatabase.Connect();
              Statement statement = trDatabase.GetStatement();
              String sql = "insert into vehiclestatus values (" + activeCustomer.GetcID() + ", " + vID + ", 1);";
              statement.executeUpdate(sql);
              trDatabase.CloseConnection();
          }
          catch (Exception e)
          {
              System.out.println("Exception at InsertIntoVehicleStatusTable (RegisterVehicleModel): " + e.getMessage());
          }
      }
   }