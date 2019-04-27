/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnosticreport;

import javafx.scene.layout.BorderPane;

/**
 *
 * @author Matthew Rodriguez
 */
public class DiagnosticReportView extends BorderPane
{
    private DiagnosticReportForm diagnosticReportForm = new DiagnosticReportForm();
    
    public DiagnosticReportView()
    {
        this.getChildren().clear();
        this.setCenter(diagnosticReportForm);
    }

    /**
     * @return the diagnosticReportForm
     */
    public DiagnosticReportForm GetDiagnosticReportForm()
    {
        return diagnosticReportForm;
    }

    /**
     * @param diagnosticReportForm the diagnosticReportForm to set
     */
    public void SetDiagnosticReportForm(DiagnosticReportForm diagnosticReportForm)
    {
        this.diagnosticReportForm = diagnosticReportForm;
    }
    
    public void SetDiagnosticReportForm()
    {
        this.getChildren().clear();
        this.setCenter(diagnosticReportForm);
    }
}
