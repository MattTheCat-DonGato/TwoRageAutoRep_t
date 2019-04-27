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
public class Customer
{
    private int cID;
    private String cFirstName;
    private String cMiddleName;
    private String cLastName;
    private String cAddress;
    private String cCity;
    private String cState;
    private String cZip;
    private String cEmailContact;
    private String cPhoneContact;
    private String cHashPassword;
    
    public Customer(){} //empty constructor

    public Customer(int cID, String cFirstName, String cMiddleName, String cLastName, String cAddress, String cCity, String cState, String cZip, String cEmailContact, String cPhoneContact, String cHashPassword)
    {
        this.cID = cID;
        this.cFirstName = cFirstName;
        this.cMiddleName = cMiddleName;
        this.cLastName = cLastName;
        this.cAddress = cAddress;
        this.cCity = cCity;
        this.cState = cState;
        this.cZip = cZip;
        this.cEmailContact = cEmailContact;
        this.cPhoneContact = cPhoneContact;
        this.cHashPassword = cHashPassword;
    }

    /**
     * @return the cID
     */
    public int GetcID()
    {
        return cID;
    }

    /**
     * @param cID the cID to set
     */
    public void SetcID(int cID)
    {
        this.cID = cID;
    }

    /**
     * @return the cFirstName
     */
    public String GetcFirstName()
    {
        return cFirstName;
    }

    /**
     * @param cFirstName the cFirstName to set
     */
    public void SetcFirstName(String cFirstName)
    {
        this.cFirstName = cFirstName;
    }

    /**
     * @return the cMiddleName
     */
    public String GetcMiddleName()
    {
        return cMiddleName;
    }

    /**
     * @param cMiddleName the cMiddleName to set
     */
    public void SetcMiddleName(String cMiddleName)
    {
        this.cMiddleName = cMiddleName;
    }

    /**
     * @return the cLastName
     */
    public String GetcLastName()
    {
        return cLastName;
    }

    /**
     * @param cLastName the cLastName to set
     */
    public void SetcLastName(String cLastName)
    {
        this.cLastName = cLastName;
    }

    /**
     * @return the cAddress
     */
    public String GetcAddress()
    {
        return cAddress;
    }

    /**
     * @param cAddress the cAddress to set
     */
    public void SetcAddress(String cAddress)
    {
        this.cAddress = cAddress;
    }

    /**
     * @return the cCity
     */
    public String GetcCity()
    {
        return cCity;
    }

    /**
     * @param cCity the cCity to set
     */
    public void SetcCity(String cCity)
    {
        this.cCity = cCity;
    }

    /**
     * @return the cState
     */
    public String GetcState()
    {
        return cState;
    }

    /**
     * @param cState the cState to set
     */
    public void SetcState(String cState)
    {
        this.cState = cState;
    }

    /**
     * @return the cZip
     */
    public String GetcZip()
    {
        return cZip;
    }

    /**
     * @param cZip the cZip to set
     */
    public void SetcZip(String cZip)
    {
        this.cZip = cZip;
    }

    /**
     * @return the cEmailContact
     */
    public String GetcEmailContact()
    {
        return cEmailContact;
    }

    /**
     * @param cEmailContact the cEmailContact to set
     */
    public void SetcEmailContact(String cEmailContact)
    {
        this.cEmailContact = cEmailContact;
    }

    /**
     * @return the cPhoneContact
     */
    public String GetcPhoneContact()
    {
        return cPhoneContact;
    }

    /**
     * @param cPhoneContact the cPhoneContact to set
     */
    public void SetcPhoneContact(String cPhoneContact)
    {
        this.cPhoneContact = cPhoneContact;
    }

    /**
     * @return the cHashPassword
     */
    public String GetcHashPassword()
    {
        return cHashPassword;
    }

    /**
     * @param cHashPassword the cHashPassword to set
     */
    public void SetcHashPassword(String cHashPassword)
    {
        this.cHashPassword = cHashPassword;
    }
    
    
}