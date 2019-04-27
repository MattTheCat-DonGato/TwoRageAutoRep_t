/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author Matthew Rodriguez
 */
public class ActiveCustomer extends Customer
{
    private ActiveCustomer() {} //private constructor
    
    private static ActiveCustomer singletonCustomer = null; // private singleton instance of customer
    
    // If singleton is null creates a new instance of the singleton user for login and other functionalities
    public static ActiveCustomer GetSingletonCustomer()
    {
        if (singletonCustomer == null) 
        {
            singletonCustomer = new ActiveCustomer();
        }
        return singletonCustomer;
    }
    
    //Set the values for the logged in customer for that session
    public void SetActiveCustomer(Customer current)
    {
        SetcID(current.GetcID());
        SetcFirstName(current.GetcFirstName());
        SetcMiddleName(current.GetcMiddleName());
        SetcLastName(current.GetcLastName());
        SetcAddress(current.GetcAddress());
        SetcCity(current.GetcCity());
        SetcState(current.GetcState());
        SetcZip(current.GetcZip());
        SetcEmailContact(current.GetcEmailContact());
        SetcPhoneContact(current.GetcPhoneContact());
        SetcHashPassword(current.GetcHashPassword());
    }
}