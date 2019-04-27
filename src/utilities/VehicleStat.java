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
public class VehicleStat
{
    private String vYear;
    private String vMake;
    private String vModel;
    private String vLicensePlate;
    private String sStatus;
    
    public VehicleStat() {}
    
    public VehicleStat(String vYear, String vMake, String vModel, String vLicensePlate, String sStatus)
    {
        this.vYear = vYear;
        this.vMake = vMake;
        this.vModel = vModel;
        this.vLicensePlate = vLicensePlate;
        this.sStatus = sStatus;
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
     * @return the sStatus
     */
    public String getsStatus()
    {
        return sStatus;
    }

    /**
     * @param sStatus the sStatus to set
     */
    public void setsStatus(String sStatus)
    {
        this.sStatus = sStatus;
    }
    
    
}
