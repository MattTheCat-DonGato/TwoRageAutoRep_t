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
public class ActiveEmployee extends Employee
{
    private ActiveEmployee() {}
    
    private static ActiveEmployee singletonEmployee = null;
    
    public static ActiveEmployee GetSingletonEmployee()
    {
        if (singletonEmployee == null) 
        {
            singletonEmployee = new ActiveEmployee();
        }
        return singletonEmployee;
    }
    
    public void SetActiveEmployee(Employee current)
    {
        SeteID(current.GeteID());
        SeteFirstName(current.GeteFirstName());
        SeteMiddleName(current.GeteMiddleName());
        SeteLastName(current.GeteLastName());
        SeteAddress(current.GeteAddress());
        SeteCity(current.GeteCity());
        SeteState(current.GeteState());
        SeteZip(current.GeteZip());
        SeteEmailContact(current.GeteEmailContact());
        SetePhoneContact(current.GetePhoneContact());
        SeteHashPassword(current.GeteHashPassword());
    }
    
    public void PrintActiveEmployee()
    {
        System.out.println("Active Customer info:");
        System.out.println("Id: " + GeteID());
        System.out.println("First Name: " + GeteFirstName());
        System.out.println("Middle Name: " + GeteMiddleName());
        System.out.println("Last Name: " + GeteLastName());
        System.out.println("Address: " + GeteAddress());
        System.out.println("City: " + GeteCity());
        System.out.println("State: " + GeteState());
        System.out.println("Zip: " + GeteZip());
        System.out.println("Email Contact: " + GeteEmailContact());
        System.out.println("Phone Contact: " + GetePhoneContact());
        System.out.println("Hash Password: " + GeteHashPassword());
    }
}
