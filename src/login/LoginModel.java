/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import database.Database;
import java.sql.ResultSet;
import java.sql.Statement;
import utilities.ActiveCustomer;
import utilities.ActiveEmployee;
import utilities.Customer;
import utilities.Employee;
import utilities.TRError;

/**
 *
 * @author Matthew Rodriguez
 */
public class LoginModel
{
    Database trDatabase = new Database();
    private Employee currentEmployee;
    private ActiveEmployee activeEmployee;
    private Customer currentCustomer;
    private ActiveCustomer activeCustomer;
    
     /**
     * @return the currentEmployee
     */
    public Employee GetCurrentEmployee()
    {
        return currentEmployee;
    }

    /**
     * @param currentEmployee the currentEmployee to set
     */
    public void SetCurrentEmployee(Employee currentEmployee)
    {
        this.currentEmployee = currentEmployee;
    }
    
    /**
     * @return the currentCustomer
     */
    public Customer GetCurrentCustomer()
    {
        return currentCustomer;
    }

    /**
     * @param currentCustomer the currentCustomer to set
     */
    public void SetCurrentCustomer(Customer currentCustomer)
    {
        this.currentCustomer = currentCustomer;
    }
    
    public boolean VerifyEmployeeLogin(String email, String pass)
    {
        boolean isValid = false;
        try
        {
            trDatabase.Connect();
            Statement sql = trDatabase.GetStatement();
            ResultSet rs = sql.executeQuery("select * from employee where eEmailContact = " + "'" + email + "'" + "and eHashPassword = " + "'" + pass + "'" + ";");
            if (rs.next() == true)
            {
                isValid = true;
                int eID = rs.getInt("employeeID");
                String eFirstName = rs.getString("eFirstName");
                String eMiddleName = rs.getString("eMiddleName");
                String eLastName = rs.getString("eLastName");
                String eAddress = rs.getString("eAddress");
                String eCity = rs.getString("eCity");
                String eState = rs.getString("eState");
                String eZip = rs.getString("eZip");
                String eEmailContact = rs.getString("eEmailContact");
                String ePhoneContact = rs.getString("ePhoneContact");
                String eHashPassword = rs.getString("eHashPassword");
                Employee tempEmployee = new Employee(eID,eFirstName,eMiddleName,eLastName,eAddress,eCity,eState,eZip,eEmailContact,ePhoneContact,eHashPassword);
                activeEmployee = ActiveEmployee.GetSingletonEmployee();
                activeEmployee.SetActiveEmployee(tempEmployee);
                rs.close();          
            }
            else
            {
                isValid = false;
            }
              trDatabase.CloseConnection();
        }
        catch (Exception e)
        {
            System.out.println("Exception at VerifyEmployeeLogin Function: " + e.getMessage()); 
        }
        return isValid;
    }
    
     public boolean VerifyCustomerLogin(String email, String pass)
    {
        boolean isValid = false;
        try
        {
            trDatabase.Connect();
            Statement sql = trDatabase.GetStatement();
            ResultSet rs = sql.executeQuery("select * from customer where cEmailContact = " + "'" + email + "'" + "and cHashPassword = " + "'" + pass + "'" + ";");
            if (rs.next() == true)
            {
                System.out.println("Record Found");
                isValid = true;
                int cID = rs.getInt("cID");
                String cFirstName = rs.getString("cFirstName");
                String cMiddleName = rs.getString("cMiddleName");
                String cLastName = rs.getString("cLastName");
                String cAddress = rs.getString("cAddress");
                String cCity = rs.getString("cCity");
                String cState = rs.getString("cState");
                String cZip = rs.getString("cZip");
                String cEmailContact = rs.getString("cEmailContact");
                String cPhoneContact = rs.getString("cPhoneContact");
                String cHashPassword = rs.getString("cHashPassword");
                Customer tempCustomer = new Customer(cID,cFirstName,cMiddleName,cLastName,cAddress,cCity,cState,cZip,cEmailContact,cPhoneContact,cHashPassword);
                activeCustomer = ActiveCustomer.GetSingletonCustomer();
                activeCustomer.SetActiveCustomer(tempCustomer);
                rs.close();             
            }
            else
            {
                isValid = false;
            }
              trDatabase.CloseConnection();
        }
        catch (Exception e)
        {
            System.out.println("Exception at VerifyCustomerLogin Function: " + e.getMessage()); 
        }
        return isValid;
    }
     
     public boolean IsCustomerRegistered(Customer newCustomer)
     {
         boolean isRegistered = false;
         String email = newCustomer.GetcEmailContact();
         try
         {
              trDatabase.CloseConnection();
              Statement sql = trDatabase.GetStatement();
              ResultSet rs = sql.executeQuery("select * from customer where cEmailContact = " + "'" + email + "';");
              if(rs.next() == true)
              {
                  isRegistered  = true;
              }
              else
              {
                  isRegistered = false;
              }
              rs.close();
              trDatabase.CloseConnection();
         }
         catch (Exception e)
         {
             System.out.println("Exception at IsCustomerRegistered Function: " + e.getMessage());
         }        
         return isRegistered;
     }
     
     public void RegisterCustomerToDatabase(Customer newCustomer)
     {
         try
         {
            int ID = newCustomer.GetcID();
            String fName = newCustomer.GetcFirstName();
            String mName = newCustomer.GetcMiddleName();
            String lName = newCustomer.GetcLastName();
            String address = newCustomer.GetcAddress();
            String city = newCustomer.GetcCity();
            String state = newCustomer.GetcState();
            String zip = newCustomer.GetcZip();
            String emailContact = newCustomer.GetcEmailContact();
            String phoneContact = newCustomer.GetcPhoneContact();
            String password = newCustomer.GetcHashPassword();
            
            trDatabase.Connect();
            Statement statement = trDatabase.GetStatement();
            String sql = "insert into customer values (" + ID + ", '"+ fName + "', '" + lName + "', '" + mName + "', '" + address + "', '" + city + "', '" + state + "', '" + zip + "', '" + emailContact + "', '" + phoneContact + "', '" + password + "');";
            statement.executeUpdate(sql);
            TRError.TRError("INFORMATION", "Customer Record Insert Success", "Customer Record has been successfully added to the database.");
            trDatabase.CloseConnection();
         }
         catch (Exception e)
         {
             System.out.println("Exception at RegisterCustomerToDatabase: " + e.getMessage());
         }                
     }
}