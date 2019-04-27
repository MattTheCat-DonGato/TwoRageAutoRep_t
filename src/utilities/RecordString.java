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
public class RecordString
{
    private String cFName;
    private String cMName;
    private String cLName;
    private String cAddress;
    private String cCity;
    private String cState;
    private String cZip;
    private String cPhoneContact;
    private String eFirstName;
    private String eMiddleName;
    private String eLastName;
    private String vYear;
    private String vMake;
    private String vModel;
    private String vColor;
    private String vLicensePlate;
    private String vOdometer;
    private String diagName;
    private String serviceName;
    private double laborOnly;
    private String recievedDate;
    private String serialVIN;
    private String orderNum;

    // Empty constructor
    public RecordString() {}
    
    // Partial Constructor (used in SelectInfoFromSeveralIDs() function)
    public RecordString(String cFName, String cMName, String cLName, String cAddress, String cCity, String cState, 
            String cZip, String cPhoneContact, String eFirstName, String eMiddleName, String eLastName, String vYear,
            String vMake, String vModel, String vColor, String vLicensePlate, String vOdometer, String diagName, 
            String serviceName) 
    {
        this.cFName = cFName;
        this.cMName = cMName;
        this.cLName = cLName;
        this.cAddress = cAddress;
        this.cCity = cCity;
        this.cState = cState;
        this.cZip = cZip;
        this.cPhoneContact = cPhoneContact;
        this.eFirstName = eFirstName;
        this.eMiddleName = eMiddleName;
        this.eLastName = eLastName;
        this.vYear = vYear;
        this.vMake = vMake;
        this.vModel = vModel;
        this.vColor = vColor;
        this.vLicensePlate = vLicensePlate;
        this.vOdometer = vOdometer;
        this.diagName = diagName;
        this.serviceName = serviceName;
    }

    // Full Constructor (used to display the whole record)
    public RecordString(String cFName, String cMName, String cLName, String cAddress, String cCity, String cState, 
            String cZip, String cPhoneContact, String eFirstName, String eMiddleName, String eLastName, String vYear,
            String vMake, String vModel, String vColor, String vLicensePlate, String vOdometer, String diagName, String serviceName, 
            double laborOnly, String recievedDate, String serialVIN, String orderNum)
    {
        this.cFName = cFName;
        this.cMName = cMName;
        this.cLName = cLName;
        this.cAddress = cAddress;
        this.cCity = cCity;
        this.cState = cState;
        this.cZip = cZip;
        this.cPhoneContact = cPhoneContact;
        this.eFirstName = eFirstName;
        this.eMiddleName = eMiddleName;
        this.eLastName = eLastName;
        this.vYear = vYear;
        this.vMake = vMake;
        this.vModel = vModel;
        this.vColor = vColor;
        this.vLicensePlate = vLicensePlate;
        this.vOdometer = vOdometer;
        this.diagName = diagName;
        this.serviceName = serviceName;
        this.laborOnly = laborOnly;
        this.recievedDate = recievedDate;
        this.serialVIN = serialVIN;
        this.orderNum = orderNum;
    }

    /**
     * @return the cFName
     */
    public String getcFName()
    {
        return cFName;
    }

    /**
     * @param cFName the cFName to set
     */
    public void setcFName(String cFName)
    {
        this.cFName = cFName;
    }

    /**
     * @return the cMName
     */
    public String getcMName()
    {
        return cMName;
    }

    /**
     * @param cMName the cMName to set
     */
    public void setcMName(String cMName)
    {
        this.cMName = cMName;
    }

    /**
     * @return the cLName
     */
    public String getcLName()
    {
        return cLName;
    }

    /**
     * @param cLName the cLName to set
     */
    public void setcLName(String cLName)
    {
        this.cLName = cLName;
    }

    /**
     * @return the cAddress
     */
    public String getcAddress()
    {
        return cAddress;
    }

    /**
     * @param cAddress the cAddress to set
     */
    public void setcAddress(String cAddress)
    {
        this.cAddress = cAddress;
    }

    /**
     * @return the cCity
     */
    public String getcCity()
    {
        return cCity;
    }

    /**
     * @param cCity the cCity to set
     */
    public void setcCity(String cCity)
    {
        this.cCity = cCity;
    }

    /**
     * @return the cState
     */
    public String getcState()
    {
        return cState;
    }

    /**
     * @param cState the cState to set
     */
    public void setcState(String cState)
    {
        this.cState = cState;
    }

    /**
     * @return the cZip
     */
    public String getcZip()
    {
        return cZip;
    }

    /**
     * @param cZip the cZip to set
     */
    public void setcZip(String cZip)
    {
        this.cZip = cZip;
    }

    /**
     * @return the cPhoneContact
     */
    public String getcPhoneContact()
    {
        return cPhoneContact;
    }

    /**
     * @param cPhoneContact the cPhoneContact to set
     */
    public void setcPhoneContact(String cPhoneContact)
    {
        this.cPhoneContact = cPhoneContact;
    }

    /**
     * @return the eFirstName
     */
    public String geteFirstName()
    {
        return eFirstName;
    }

    /**
     * @param eFirstName the eFirstName to set
     */
    public void seteFirstName(String eFirstName)
    {
        this.eFirstName = eFirstName;
    }

    /**
     * @return the eMiddleName
     */
    public String geteMiddleName()
    {
        return eMiddleName;
    }

    /**
     * @param eMiddleName the eMiddleName to set
     */
    public void seteMiddleName(String eMiddleName)
    {
        this.eMiddleName = eMiddleName;
    }

    /**
     * @return the eLastName
     */
    public String geteLastName()
    {
        return eLastName;
    }

    /**
     * @param eLastName the eLastName to set
     */
    public void seteLastName(String eLastName)
    {
        this.eLastName = eLastName;
    }
    
    /**
     * @return the vYear
     */
    public String getvYear()
    {
        return vYear;
    }

    /**
     * @param vYear the vYear to set
     */
    public void setvYear(String vYear)
    {
        this.vYear = vYear;
    }

    /**
     * @return the vMake
     */
    public String getvMake()
    {
        return vMake;
    }

    /**
     * @param vMake the vMake to set
     */
    public void setvMake(String vMake)
    {
        this.vMake = vMake;
    }

    /**
     * @return the vModel
     */
    public String getvModel()
    {
        return vModel;
    }

    /**
     * @param vModel the vModel to set
     */
    public void setvModel(String vModel)
    {
        this.vModel = vModel;
    }

    /**
     * @return the vColor
     */
    public String getvColor()
    {
        return vColor;
    }

    /**
     * @param vColor the vColor to set
     */
    public void setvColor(String vColor)
    {
        this.vColor = vColor;
    }

    /**
     * @return the vLicensePlate
     */
    public String getvLicensePlate()
    {
        return vLicensePlate;
    }

    /**
     * @param vLicensePlate the vLicensePlate to set
     */
    public void setvLicensePlate(String vLicensePlate)
    {
        this.vLicensePlate = vLicensePlate;
    }

    /**
     * @return the vOdometer
     */
    public String getvOdometer()
    {
        return vOdometer;
    }

    /**
     * @param vOdometer the vOdometer to set
     */
    public void setvOdometer(String vOdometer)
    {
        this.vOdometer = vOdometer;
    }

    /**
     * @return the diagName
     */
    public String getDiagName()
    {
        return diagName;
    }

    /**
     * @param diagName the diagName to set
     */
    public void setDiagName(String diagName)
    {
        this.diagName = diagName;
    }

    /**
     * @return the serviceName
     */
    public String getServiceName()
    {
        return serviceName;
    }

    /**
     * @param serviceName the serviceName to set
     */
    public void setServiceName(String serviceName)
    {
        this.serviceName = serviceName;
    }

    /**
     * @return the laborOnly
     */
    public double getLaborOnly()
    {
        return laborOnly;
    }

    /**
     * @param laborOnly the laborOnly to set
     */
    public void setLaborOnly(double laborOnly)
    {
        this.laborOnly = laborOnly;
    }

    /**
     * @return the recievedDate
     */
    public String getRecievedDate()
    {
        return recievedDate;
    }

    /**
     * @param recievedDate the recievedDate to set
     */
    public void setRecievedDate(String recievedDate)
    {
        this.recievedDate = recievedDate;
    }

    /**
     * @return the serialVIN
     */
    public String getSerialVIN()
    {
        return serialVIN;
    }

    /**
     * @param serialVIN the serialVIN to set
     */
    public void setSerialVIN(String serialVIN)
    {
        this.serialVIN = serialVIN;
    }

    /**
     * @return the orderNum
     */
    public String getOrderNum()
    {
        return orderNum;
    }

    /**
     * @param orderNum the orderNum to set
     */
    public void setOrderNum(String orderNum)
    {
        this.orderNum = orderNum;
    }   

    
}