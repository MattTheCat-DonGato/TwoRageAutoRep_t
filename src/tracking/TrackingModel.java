package tracking;

import database.Database;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import utilities.ActiveCustomer;
import utilities.TRError;
import utilities.VehicleStat;

/**
 *
 * @author Matthew Rodriguez
 */
public class TrackingModel
{
    Database trDatabase = new Database();
    private ArrayList<VehicleStat> vehicles = new ArrayList<>();
    ActiveCustomer activeCustomer = ActiveCustomer.GetSingletonCustomer();
    
    /**
     * @return the vehicles
     */
    public ArrayList<VehicleStat> GetVehicles()
    {
        return vehicles;
    }

    /**
     * @param vehicles the vehicles to set
     */
    public void SetVehicles(ArrayList<VehicleStat> vehicles)
    {
        this.vehicles = vehicles;
    }
    
    public boolean GetVehicleStatuses()
    {
        final long startTime = System.currentTimeMillis();
        boolean recordsFound = false;
        GetVehicles().clear();
        String vYear = "";
        String vMake = "";
        String vModel = "";
        String vLicensePlate = "";
        String sStatus = ""; 
        try
        {
            trDatabase.Connect();
            Statement sql = trDatabase.GetStatement();
            ResultSet rs = sql.executeQuery("select vehicle.vYear, vehicle.vMake, vehicle.vModel, vehicle.vLicensePlate, status.statusName from vehiclestatus inner join vehicleownership inner join customer inner join vehicle inner join status where customer.cID = " + activeCustomer.GetcID() + " and (vehicle.vID = vehicleownership.vID && vehiclestatus.vstatusID = vehicle.vID && vehicleownership.cID = customer.cID  && status.statusID = vehiclestatus.statusID);");  
                while(rs.next())
                {
                    recordsFound = true;                
                    vYear = rs.getString("vYear");
                    vMake = rs.getString("vMake");
                    vModel = rs.getString("vModel");
                    vLicensePlate = rs.getString("vLicensePlate");
                    sStatus = rs.getString("statusName");
                     VehicleStat vehicleStat = new VehicleStat(vYear, vMake, vModel, vLicensePlate, sStatus);
                    vehicles.add(vehicleStat);
                }
       
            rs.close();
            trDatabase.CloseConnection();
        }
        catch (Exception e)
        {
            System.out.println("Execption at Get Vehicle Statuses (TrackingModel): " + e.getMessage());
        }
        final long endTime = System.currentTimeMillis();
        System.out.println("Total Execution time For GetVehicleStatuses: " + (endTime - startTime));
        return recordsFound;
    }
    
    public String DisplayInvoiceRecordToTextArea(VehicleStat vehicle)
    {
        String info = "Vehicle: " + vehicle.getvYear() + " " + vehicle.getvMake() + " " + vehicle.getvModel() + "\n"
                + "License Plate: " + vehicle.getvLicensePlate() + "\n"
                + "Current Status: " + vehicle.getsStatus() + "\n";
        return info;
    }

}