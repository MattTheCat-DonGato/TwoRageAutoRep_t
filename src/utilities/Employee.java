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
public class Employee
{
    private int eID;
    private String eFirstName;
    private String eMiddleName;
    private String eLastName;
    private String eAddress;
    private String eCity;
    private String eState;
    private String eZip;
    private String eEmailContact;
    private String ePhoneContact;
    private String eHashPassword;
    
    public Employee() {}

    public Employee(int eID, String eFirstName, String eMiddleName, String eLastName, String eAddress, String eCity, String eState, String eZip, String eEmailContact, String ePhoneContact, String eHashPassword)
    {
        this.eID = eID;
        this.eFirstName = eFirstName;
        this.eMiddleName = eMiddleName;
        this.eLastName = eLastName;
        this.eAddress = eAddress;
        this.eCity = eCity;
        this.eState = eState;
        this.eZip = eZip;
        this.eEmailContact = eEmailContact;
        this.ePhoneContact = ePhoneContact;
        this.eHashPassword = eHashPassword;
    }

    /**
     * @return the eID
     */
    public int GeteID()
    {
        return eID;
    }

    /**
     * @param eID the eID to set
     */
    public void SeteID(int eID)
    {
        this.eID = eID;
    }

    /**
     * @return the eFirstName
     */
    public String GeteFirstName()
    {
        return eFirstName;
    }

    /**
     * @param eFirstName the eFirstName to set
     */
    public void SeteFirstName(String eFirstName)
    {
        this.eFirstName = eFirstName;
    }

    /**
     * @return the eMiddleName
     */
    public String GeteMiddleName()
    {
        return eMiddleName;
    }

    /**
     * @param eMiddleName the eMiddleName to set
     */
    public void SeteMiddleName(String eMiddleName)
    {
        this.eMiddleName = eMiddleName;
    }

    /**
     * @return the eLastName
     */
    public String GeteLastName()
    {
        return eLastName;
    }

    /**
     * @param eLastName the eLastName to set
     */
    public void SeteLastName(String eLastName)
    {
        this.eLastName = eLastName;
    }

    /**
     * @return the eAddress
     */
    public String GeteAddress()
    {
        return eAddress;
    }

    /**
     * @param eAddress the eAddress to set
     */
    public void SeteAddress(String eAddress)
    {
        this.eAddress = eAddress;
    }

    /**
     * @return the eCity
     */
    public String GeteCity()
    {
        return eCity;
    }

    /**
     * @param eCity the eCity to set
     */
    public void SeteCity(String eCity)
    {
        this.eCity = eCity;
    }

    /**
     * @return the eState
     */
    public String GeteState()
    {
        return eState;
    }

    /**
     * @param eState the eState to set
     */
    public void SeteState(String eState)
    {
        this.eState = eState;
    }

    /**
     * @return the eZip
     */
    public String GeteZip()
    {
        return eZip;
    }

    /**
     * @param eZip the eZip to set
     */
    public void SeteZip(String eZip)
    {
        this.eZip = eZip;
    }

    /**
     * @return the eEmailContact
     */
    public String GeteEmailContact()
    {
        return eEmailContact;
    }

    /**
     * @param eEmailContact the eEmailContact to set
     */
    public void SeteEmailContact(String eEmailContact)
    {
        this.eEmailContact = eEmailContact;
    }

    /**
     * @return the ePhoneContact
     */
    public String GetePhoneContact()
    {
        return ePhoneContact;
    }

    /**
     * @param ePhoneContact the ePhoneContact to set
     */
    public void SetePhoneContact(String ePhoneContact)
    {
        this.ePhoneContact = ePhoneContact;
    }

    /**
     * @return the eHashPassword
     */
    public String GeteHashPassword()
    {
        return eHashPassword;
    }

    /**
     * @param eHashPassword the eHashPassword to set
     */
    public void SeteHashPassword(String eHashPassword)
    {
        this.eHashPassword = eHashPassword;
    }
}