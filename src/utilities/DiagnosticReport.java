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
public class DiagnosticReport
{
    // data
    private int formID;
    private int dfcID;
    private int dfvID;
    private int symptomID;
    private String sComments;
    
    // constructor
    public DiagnosticReport() {} // empty

    public DiagnosticReport(int formID, int dfcID, int dfvID, int symptomID, String sComments)
    {
        this.formID = formID;
        this.dfcID = dfcID;
        this.dfvID = dfvID;
        this.symptomID = symptomID;
        this.sComments = sComments;
    }

    /**
     * @return the formID
     */
    public int GetFormID()
    {
        return formID;
    }

    /**
     * @param formID the formID to set
     */
    public void SetFormID(int formID)
    {
        this.formID = formID;
    }

    /**
     * @return the dfcID
     */
    public int GetDfcID()
    {
        return dfcID;
    }

    /**
     * @param dfcID the dfcID to set
     */
    public void SetDfcID(int dfcID)
    {
        this.dfcID = dfcID;
    }

    /**
     * @return the dfvID
     */
    public int GetDfvID()
    {
        return dfvID;
    }

    /**
     * @param dfvID the dfvID to set
     */
    public void SetDfvID(int dfvID)
    {
        this.dfvID = dfvID;
    }

    /**
     * @return the symptomID
     */
    public int GetSymptomID()
    {
        return symptomID;
    }

    /**
     * @param symptomID the symptomID to set
     */
    public void SetSymptomID(int symptomID)
    {
        this.symptomID = symptomID;
    }

    /**
     * @return the sComments
     */
    public String GetSComments()
    {
        return sComments;
    }

    /**
     * @param sComments the sComments to set
     */
    public void SetSComments(String sComments)
    {
        this.sComments = sComments;
    } 
}
