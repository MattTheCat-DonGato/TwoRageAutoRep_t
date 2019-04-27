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
public class Service
{
    private int serviceID;
    private String serviceName;
    private String serviceDescription;
    private double serviceCost;
    
    public Service() {}

    public Service(int serviceID, String serviceName, String serviceDescription, double serviceCost)
    {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.serviceCost = serviceCost;
    }

    /**
     * @return the serviceID
     */
    public int getServiceID()
    {
        return serviceID;
    }

    /**
     * @param serviceID the serviceID to set
     */
    public void setServiceID(int serviceID)
    {
        this.serviceID = serviceID;
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
     * @return the serviceDescription
     */
    public String getServiceDescription()
    {
        return serviceDescription;
    }

    /**
     * @param serviceDescription the serviceDescription to set
     */
    public void setServiceDescription(String serviceDescription)
    {
        this.serviceDescription = serviceDescription;
    }

    /**
     * @return the serviceCost
     */
    public double getServiceCost()
    {
        return serviceCost;
    }

    /**
     * @param serviceCost the serviceCost to set
     */
    public void setServiceCost(double serviceCost)
    {
        this.serviceCost = serviceCost;
    }
    
}