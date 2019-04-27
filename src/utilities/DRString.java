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
public class DRString
{
    private String cFirstName;
    private String cMiddleName;
    private String cLastName;
    private String vYear;
    private String vMake;
    private String vModel;
    private String vLicensePlate;
    private String vOdometer;
    private String diagName;
    private String sComments;
 
    // empty constructor
    public DRString() {}

    // main constructor
    public DRString(String cFirstName, String cMiddleName, String cLastName, String vYear, String vMake, String vModel, String vLicensePlate, String vOdometer, String diagName, String sComments)
    {
        this.cFirstName = cFirstName;
        this.cMiddleName = cMiddleName;
        this.cLastName = cLastName;
        this.vYear = vYear;
        this.vMake = vMake;
        this.vModel = vModel;
        this.vLicensePlate = vLicensePlate;
        this.vOdometer = vOdometer;
        this.diagName = diagName;
        this.sComments = sComments;
    }

    /**
     * @return the cFirstName
     */
    public String getcFirstName()
    {
        return cFirstName;
    }

    /**
     * @param cFirstName the cFirstName to set
     */
    public void setcFirstName(String cFirstName)
    {
        this.cFirstName = cFirstName;
    }

    /**
     * @return the cMiddleName
     */
    public String getcMiddleName()
    {
        return cMiddleName;
    }

    /**
     * @param cMiddleName the cMiddleName to set
     */
    public void setcMiddleName(String cMiddleName)
    {
        this.cMiddleName = cMiddleName;
    }

    /**
     * @return the cLastName
     */
    public String getcLastName()
    {
        return cLastName;
    }

    /**
     * @param cLastName the cLastName to set
     */
    public void setcLastName(String cLastName)
    {
        this.cLastName = cLastName;
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
     * @return the sComments
     */
    public String getsComments()
    {
        return sComments;
    }

    /**
     * @param sComments the sComments to set
     */
    public void setsComments(String sComments)
    {
        this.sComments = sComments;
    }
}