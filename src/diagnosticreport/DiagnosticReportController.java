/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnosticreport;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utilities.TRError;


/**
 *
 * @author Matthew Rodriguez
 */
public class DiagnosticReportController
{
    //stage ref
    Stage mainStage;
    
    //views
    private DiagnosticReportView diagnosticReportView = new DiagnosticReportView();
    
    //models
    private DiagnosticReportModel diagnosticReportModel = new DiagnosticReportModel();
    
    //scenes
    Scene mainMenuScene;
    
    public DiagnosticReportController(Stage mainStage, DiagnosticReportView diagnosticReportView, 
            DiagnosticReportModel diagnosticReportModel, Scene mainMenuScene)
    {
        this.mainStage = mainStage;
        this.diagnosticReportView = diagnosticReportView;
        this.diagnosticReportModel = diagnosticReportModel;
        this.mainMenuScene = mainMenuScene;
    }
    
    public void attachHandlers()
    {
        diagnosticReportView.GetDiagnosticReportForm().GetDisplayVehicles().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                diagnosticReportView.GetDiagnosticReportForm().FillVehicleComboBoxBasedOnCurrentCustomer();
                diagnosticReportView.SetDiagnosticReportForm();
            }
        });
        
        diagnosticReportView.GetDiagnosticReportForm().GetSubmitButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
               if(diagnosticReportView.GetDiagnosticReportForm().GetVehicleCB().getSelectionModel().isEmpty())
               {
                   TRError.TRError("ERROR", "No Vehicle Selected", "Please select a vehicle from the box. If there are no vehicles registered under your account, you may do so in the Register Vehicle Screen.");
               }
               else
               {
                   if(diagnosticReportView.GetDiagnosticReportForm().GetDiagnosticCB().getSelectionModel().isEmpty())
                   {
                       TRError.TRError("ERROR", "No Symptom Selected", "Please select a symptom from the dropdown box.");
                   }
                   else
                   {
                       String vehicleItem = diagnosticReportView.GetDiagnosticReportForm().GetVehicleCB().getSelectionModel().getSelectedItem().toString();
                       String symptomItem = diagnosticReportView.GetDiagnosticReportForm().GetVehicleCB().getSelectionModel().getSelectedItem().toString();
                       String vIDString = vehicleItem.substring(0, 1);
                       String sympIDString = symptomItem.substring(0, 1);
                       int vID = Integer.parseInt(vIDString);
                       int sympID = Integer.parseInt(sympIDString);
                       String comments = diagnosticReportView.GetDiagnosticReportForm().GetCommentsTextArea().getText();
                       if (comments.trim().length() == 0)
                       {
                           comments = "";
                       }
                       diagnosticReportModel.InsertReportToDatabase(vID, sympID, comments);
                       diagnosticReportView.GetDiagnosticReportForm().GetVehicleCB().getSelectionModel().clearSelection();
                       diagnosticReportView.GetDiagnosticReportForm().GetVehicleCB().getItems().clear();
                       diagnosticReportView.GetDiagnosticReportForm().GetDiagnosticCB().getSelectionModel().clearSelection();
                       diagnosticReportView.GetDiagnosticReportForm().GetCommentsTextArea().clear();
                   }
               }
            }
        });
        
        diagnosticReportView.GetDiagnosticReportForm().GetReturnButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                // clear selections of vehicle and symptom comboboxes, empty vehicle boxes, and return to main menu
                diagnosticReportView.GetDiagnosticReportForm().GetVehicleCB().getSelectionModel().clearSelection();
                diagnosticReportView.GetDiagnosticReportForm().GetVehicleCB().getItems().clear();
                diagnosticReportView.GetDiagnosticReportForm().GetDiagnosticCB().getSelectionModel().clearSelection();
                diagnosticReportView.GetDiagnosticReportForm().GetCommentsTextArea().clear();
                mainStage.setScene(mainMenuScene);
            }
        });
    }
}
