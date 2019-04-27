/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package records;
import database.Database;
import java.sql.ResultSet;
import java.sql.Statement;
import utilities.DRString;
import utilities.DiagnosticReport;
import utilities.Invoice;
import utilities.RecordString;
/**
 *
 * @author Matthew Rodriguez
 */
public class RecordsModel
{
    Database trDatabase = new Database();
    
    public boolean DRDataExistsFromID(int ID)
    {
        boolean exists = false;
        try
        {
            trDatabase.Connect();
            Statement sql = trDatabase.GetStatement();
            ResultSet rs = sql.executeQuery("select * from diagnosticreport where diagnosticreport.formID = " + ID + ";");
            if (rs.next() == true)
            {
                exists = true;
            }
            else
            {
                exists = false;
            }
            rs.close();
            trDatabase.CloseConnection();
        }
        catch (Exception e)
        {
            System.out.println("Exception at IncoiceDataExistsFromID (RecordsModel): " + e.getMessage());
        }
        return exists;
    }
    
    public boolean InvoiceDataExistsFromID(int ID)
    {
        boolean exists = false;
        try
        {
            trDatabase.Connect();
            Statement sql = trDatabase.GetStatement();
            ResultSet rs = sql.executeQuery("select * from invoice where invoice.invoiceID = " + ID + ";");
            if (rs.next() == true)
            {
                exists = true;
            }
            else
            {
                exists = false;
            }
            rs.close();
            trDatabase.CloseConnection();
        }
        catch (Exception e)
        {
            System.out.println("Exception at IncoiceDataExistsFromID (RecordsModel): " + e.getMessage());
        }
        return exists;
    }
    
    public DiagnosticReport SelectDiagnostcDataFromID(int ID)
    {
        DiagnosticReport diagRecord = new DiagnosticReport();
        try
        {
            trDatabase.Connect();
            Statement sql = trDatabase.GetStatement();
            ResultSet rs = sql.executeQuery("select * from diagnosticreport where diagnosticreport.formID = " + ID + ";");
            rs.next();
            diagRecord.SetFormID(ID);
            diagRecord.SetDfcID(rs.getInt("dfcID"));
            diagRecord.SetDfvID(rs.getInt("dfvID"));
            diagRecord.SetSymptomID(rs.getInt("symptomID"));
            diagRecord.SetSComments(rs.getString("sComments"));
            rs.close();
            trDatabase.CloseConnection();
        }
        catch (Exception e)
        {
            System.out.println("Exception at SelectDiagnosticDataFromID (RecordsModel): " + e.getMessage());
        }
        return diagRecord;
    }
    
    public Invoice SelectInvoiceDataFromID(int ID)
    {
        Invoice refRecords = new Invoice();
        try
        {
        trDatabase.Connect();
        Statement sql = trDatabase.GetStatement();
        ResultSet rs = sql.executeQuery("select * from invoice where invoice.invoiceID = " + ID + ";");
        rs.next();
        refRecords.setEmpID(rs.getInt("empID"));
        refRecords.setCustID(rs.getInt("custID"));
        refRecords.setCarID(rs.getInt("carID"));
        refRecords.setDiagnosticID(rs.getInt("diagnosticID"));
        refRecords.setsID(rs.getInt("sID"));
        refRecords.setLaborOnly(rs.getDouble("laborOnly"));
        refRecords.setRecievedDate(rs.getString("receivedDate"));
        refRecords.setSerialVIN(rs.getString("serialVin"));
        refRecords.setOrderNum(rs.getString("orderNum"));
        rs.close();
        trDatabase.CloseConnection();  
        if(refRecords.getRecievedDate() == null)
        {
             refRecords.setRecievedDate("N/A");
        }
        if(refRecords.getSerialVIN() == null)
        {
             refRecords.setSerialVIN("N/A");
        }
        if(refRecords.getOrderNum() == null)
        {
             refRecords.setOrderNum("N/A");
        }
        }
        catch (Exception e)
        {
            System.out.println("Exception at SelectInvoiceDataFromID (RecordsModel): " + e.getMessage());
        }
        
        return refRecords;
    }
    
    /* Extract the data from the inner joins of customer, employee, vehicle, service, and symptom tables 
    and store them into a result set object. Place the data into a RecordString object then pass it back to the controller. 
    */
    public RecordString SelectInvoiceInfoFromSeveralIDs(int empID, int custID, int carID, int diagnosticID, int sID)
    {
        RecordString partialRec = new RecordString();
        try
        {
            trDatabase.Connect();
            Statement sql = trDatabase.GetStatement();
            ResultSet rs = sql.executeQuery("select customer.cFirstName, customer.cMiddleName, customer.cLastName, customer.cAddress, customer.cCity, customer.cState, customer.cZip, customer.cPhoneContact, vehicle.vYear, vehicle.vMake, vehicle.vModel, vehicle.vColor, vehicle.vLicensePlate, vehicle.vOdometer, employee.eFirstName, employee.eMiddleName, employee.eLastName, symptom.diagName, service.serviceName from customer inner join vehicle inner join employee inner join symptom inner join service where customer.cID = " + custID + " and employee.employeeID = " + empID + " and vehicle.vID = " + carID + " and symptom.diagID = " + diagnosticID + " and service.serviceID = " + sID + ";");
            rs.next();
            partialRec.setcFName(rs.getString("cFirstName"));
            partialRec.setcMName(rs.getString("cMiddleName"));
            partialRec.setcLName(rs.getString("cLastName"));
            partialRec.setcAddress(rs.getString("cAddress"));
            partialRec.setcCity(rs.getString("cCity"));
            partialRec.setcState(rs.getString("cState"));
            partialRec.setcZip(rs.getString("cZip"));
            partialRec.setcPhoneContact(rs.getString("cPhoneContact"));
            partialRec.seteFirstName(rs.getString("eFirstName"));
            partialRec.seteMiddleName(rs.getString("eMiddleName"));
            partialRec.seteLastName(rs.getString("eLastName"));
            partialRec.setvYear(rs.getString("vYear"));
            partialRec.setvMake(rs.getString("vMake"));
            partialRec.setvModel(rs.getString("vModel"));
            partialRec.setvColor(rs.getString("vColor"));
            partialRec.setvLicensePlate(rs.getString("vLicensePlate"));
            partialRec.setvOdometer(rs.getString("vOdometer"));
            partialRec.setDiagName(rs.getString("diagName"));
            partialRec.setServiceName(rs.getString("serviceName"));
            rs.close();
            trDatabase.CloseConnection();
        }
        catch(Exception e)
        {
              System.out.println("Exception at SelectInvoiceDataFromID (RecordsModel): " + e.getMessage());      
        }
        return partialRec;
    }
    
    public DRString SelectDiagnosticInfoFromDatabase(int dfcID, int dfvID, int symptomID)
    {
        DRString record = new DRString();
        try
        {
            trDatabase.Connect();
            Statement sql = trDatabase.GetStatement();
            ResultSet rs = sql.executeQuery("select cFirstName, cMiddleName, cLastName, vYear, vMake, vModel, vLicensePlate, vOdometer, diagName from customer inner join vehicle inner join symptom where customer.cID = " + dfcID + " and vehicle.vID = " + dfvID + " and symptom.diagID = " + symptomID + ";");
            rs.next();
            record.setcFirstName(rs.getString("cFirstName"));
            record.setcMiddleName(rs.getString("cMiddleName"));
            record.setcLastName(rs.getString("cLastName"));
            record.setvYear(rs.getString("vYear"));
            record.setvMake(rs.getString("vMake"));
            record.setvModel(rs.getString("vModel"));
            record.setvLicensePlate(rs.getString("vLicensePlate"));
            record.setvOdometer(rs.getString("vOdometer"));
            record.setDiagName(rs.getString("diagName"));
            record.setsComments("");
            rs.close();
            trDatabase.CloseConnection();
        }
        catch (Exception e)
        {
               System.out.println("Exception at SelectDiagnosticDataFromID (RecordsModel): " + e.getMessage());     
        }
        return record;
    }
    
    public String DisplayInvoiceRecordToTextArea(RecordString record)
    {
        String info = "Name: " + record.getcFName() + " " + record.getcMName() + " " + record.getcLName() + "\n"
                + "Address: " + record.getcAddress() + "\n"
                + "City, State, Zip: " + record.getcCity() + ", " + record.getcState() + " " + record.getcZip() + "\n"
                + "Phone: " + record.getcPhoneContact() + "\n"
                + "Recieved Date: " + record.getRecievedDate() + "\n"
                + "Customer Order Number: " + record.getOrderNum() + "\n"
                + "Year, Make, Model: " + record.getvYear() + " " + record.getvMake() + " " + record.getvModel() + "\n"
                + "License Plate: " + record.getvLicensePlate() + "\n"
                + "Odometer: " + record.getvOdometer() + "\n"
                + "Main Symptom of Vehicle: " + record.getDiagName() + "\n"
                + "Main Service Applied: " + record.getServiceName() + "\n"
                + "Worked on by: " + record.geteFirstName() + " " + record.geteMiddleName() + " " + record.geteLastName();
        return info;
    }
    
    public String DisplayDiagnosticReportRecordToTextArea(DRString record)
    {
        String info = "Name: " + record.getcFirstName() + " " + record.getcMiddleName() + " " + record.getcLastName() + "\n"
                + "Year, Make, Model: " + record.getvYear() + " " + record.getvMake() + " " + record.getvModel() + "\n"
                + "License Plate: " + record.getvLicensePlate() + "\n"
                + "Odometer: " + record.getvOdometer() + "\n"
                + "Main Symptom of Vehicle: " + record.getDiagName() + "\n\n"
                + "**************************************************\n"
                + "Comments: " + record.getsComments() + "\n";
        return info;
    }
    
    
}
