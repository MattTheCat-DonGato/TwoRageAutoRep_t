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
public class Invoice
{
    //data
    private int invoiceID;
    private int empID;
    private int custID;
    private int carID;
    private int diagnosticID;
    private int sID;
    private double laborOnly;
    private String recievedDate;
    private String serialVIN;
    private String orderNum;
    
    //constructor
    public Invoice() {} // empty

    public Invoice(int invoiceID, int empID, int custID, int carID, int diagnosticID, int sID, double laborOnly, String recievedDate, String serialVin, String orderNum)
    {
        this.invoiceID = invoiceID;
        this.empID = empID;
        this.custID = custID;
        this.carID = carID;
        this.diagnosticID = diagnosticID;
        this.sID = sID;
        this.laborOnly = laborOnly;
        this.recievedDate = recievedDate;
        this.serialVIN = serialVin;
        this.orderNum = orderNum;
    }

    /**
     * @return the invoiceID
     */
    public int getInvoiceID()
    {
        return invoiceID;
    }

    /**
     * @param invoiceID the invoiceID to set
     */
    public void setInvoiceID(int invoiceID)
    {
        this.invoiceID = invoiceID;
    }

    /**
     * @return the empID
     */
    public int getEmpID()
    {
        return empID;
    }

    /**
     * @param empID the empID to set
     */
    public void setEmpID(int empID)
    {
        this.empID = empID;
    }

    /**
     * @return the custID
     */
    public int getCustID()
    {
        return custID;
    }

    /**
     * @param custID the custID to set
     */
    public void setCustID(int custID)
    {
        this.custID = custID;
    }

    /**
     * @return the carID
     */
    public int getCarID()
    {
        return carID;
    }

    /**
     * @param carID the carID to set
     */
    public void setCarID(int carID)
    {
        this.carID = carID;
    }

    /**
     * @return the diagnosticID
     */
    public int getDiagnosticID()
    {
        return diagnosticID;
    }

    /**
     * @param diagnosticID the diagnosticID to set
     */
    public void setDiagnosticID(int diagnosticID)
    {
        this.diagnosticID = diagnosticID;
    }

    /**
     * @return the sID
     */
    public int getsID()
    {
        return sID;
    }

    /**
     * @param sID the sID to set
     */
    public void setsID(int sID)
    {
        this.sID = sID;
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