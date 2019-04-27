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
public class Symptom
{
    private int diagID;
    private String diagName;
    private String diagDescription;
    
    public Symptom() {}

    public Symptom(int diagID, String diagName, String diagDescription)
    {
        this.diagID = diagID;
        this.diagName = diagName;
        this.diagDescription = diagDescription;
    }

    /**
     * @return the diagID
     */
    public int getDiagID()
    {
        return diagID;
    }

    /**
     * @param diagID the diagID to set
     */
    public void setDiagID(int diagID)
    {
        this.diagID = diagID;
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
     * @return the diagDescription
     */
    public String getDiagDescription()
    {
        return diagDescription;
    }

    /**
     * @param diagDescription the diagDescription to set
     */
    public void setDiagDescription(String diagDescription)
    {
        this.diagDescription = diagDescription;
    }
    
    
}
