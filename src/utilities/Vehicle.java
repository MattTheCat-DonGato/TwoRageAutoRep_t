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
public class Vehicle
{
    // data
    private int vID;
    private String vYear;
    private String vMake;
    private String vModel;
    private String vColor;
    private String vLicensePlate;
    private String vOdometer;
    
    //Constructor
    public Vehicle(){} //Empty
    
    public Vehicle(int vID, String vYear, String vMake, String vModel, String vColor, String vLicensePlate,
            String vOdometer)
    {
        this.vID = vID;
        this.vYear = vYear;
        this.vMake = vMake;
        this.vModel = vModel;
        this.vLicensePlate = vLicensePlate;
        this.vOdometer = vOdometer;
    }
    
    //getters and setters

    /**
     * @return the vID
     */
    public int getvID()
    {
        return vID;
    }

    /**
     * @param vID the vID to set
     */
    public void setvID(int vID)
    {
        this.vID = vID;
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
}