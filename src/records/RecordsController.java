/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package records;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import records.RecordsModel;
import records.RecordsView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utilities.DRString;
import utilities.DiagnosticReport;
import utilities.Invoice;
import utilities.RecordString;
import utilities.TRError;

/**
 *
 * @author Matthew Rodriguez
 */
public class RecordsController
{
    //stage
    Stage mainStage;
    
    //views
    private RecordsView recordsView;
    
    //scene
    Scene mainMenuScene2;
    Scene emailScene;
    
    //models
    private RecordsModel recordsModel;
    
    public RecordsController(Stage mainStage, RecordsView recordsView, RecordsModel recordsModel, Scene mainMenuScene2, Scene emailScene)
    {
        this.mainStage = mainStage;
        this.recordsView = recordsView;
        this.recordsModel = recordsModel;
        this.mainMenuScene2 = mainMenuScene2;
        this.emailScene = emailScene;
    }
    
    public void attachHandlers()
    {
        recordsView.GetRecordsForm().GetSearchDiagnosticFormButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                
               String stringID = recordsView.GetRecordsForm().GetcIDTF().getText();
               int ID = 0;
               int dfcID, dfvID, symptomID;
               String sComments = "";
               boolean isInt = false;
               try
               {
                   ID = Integer.parseInt(stringID);
                   isInt = true;
               }
               catch (Exception e)
               {
                   isInt = false;
               }
               
               if(isInt)
               {
                   boolean exists = false;
                   exists = recordsModel.DRDataExistsFromID(ID);
                   if (exists)
                   {
                      final long startTime = System.currentTimeMillis();
                      DiagnosticReport diagReport = recordsModel.SelectDiagnostcDataFromID(ID);
                      dfcID = diagReport.GetDfcID();
                      dfvID = diagReport.GetDfvID();
                      symptomID = diagReport.GetSymptomID();
                      sComments = diagReport.GetSComments();
                      DRString record = recordsModel.SelectDiagnosticInfoFromDatabase(dfcID, dfvID, symptomID);
                      record.setsComments(sComments);
                      String info = recordsModel.DisplayDiagnosticReportRecordToTextArea(record);
                      recordsView.GetRecordsForm().GetInfoScreen().setText(info);
                      final long endTime = System.currentTimeMillis();
                      System.out.println("Total Execution Time in ms. (Diagnostic Record): " + (endTime - startTime)); 
                   }
                   else
                   {
                       TRError.TRError("ERROR", "Record Does Not Exist", "Try Entering a Different ID Number.");
                   }
               }
               else
               {
                   TRError.TRError("ERROR", "Field Entry is Not an ID Number", "Enter a number then press Search Invoice Forms On ID.");
               }
            }
        });
        
        /* Perform a SQL query of the invoice record based on the ID number entered.
        
        If found, perform a SQL query based on the ID's gathered from the previous query to get the 
        contents of each column in the result set then pass them into a RecordString object to be displayed 
        in the Text Area.
        
        If not found, display error message.
        
        Display Error message if input is not an integer.        
        */
        recordsView.GetRecordsForm().GetSearchInvoiceFormButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {  
               String stringID = recordsView.GetRecordsForm().GetcIDTF().getText();
               int ID = 0;
               int empID, custID, carID, diagnosticID, sID;
               double laborOnly = 0;
               String recievedDate = "";
               String serialVIN = "";
               String orderNum = "";
               boolean isInt = false;
               try
               {
                   ID = Integer.parseInt(stringID);
                   isInt = true;
               }
               catch (Exception e)
               {
                   isInt = false;
               }
               
               if(isInt)
               {
                   boolean exists = false;
                   exists = recordsModel.InvoiceDataExistsFromID(ID);
                   if (exists)
                   {
                      final long startTime = System.currentTimeMillis();
                      Invoice invoice = recordsModel.SelectInvoiceDataFromID(ID);
                      empID = invoice.getEmpID();
                      custID = invoice.getCustID();
                      carID = invoice.getCarID();
                      diagnosticID = invoice.getDiagnosticID();
                      sID = invoice.getsID();
                      laborOnly = invoice.getLaborOnly();
                      recievedDate = invoice.getRecievedDate();
                      serialVIN = invoice.getSerialVIN();
                      orderNum = invoice.getOrderNum();                   
                      RecordString record = recordsModel.SelectInvoiceInfoFromSeveralIDs(empID, custID, carID, diagnosticID, sID);
                      record.setLaborOnly(laborOnly);
                      record.setRecievedDate(recievedDate);
                      record.setSerialVIN(serialVIN);
                      record.setOrderNum(orderNum);
                      
                      String info = recordsModel.DisplayInvoiceRecordToTextArea(record);
                      recordsView.GetRecordsForm().GetInfoScreen().setText(info);
                      final long endTime = System.currentTimeMillis();
                      System.out.println("Total Execution Time in ms. (Invoice Record): " + (endTime - startTime));
                   }
                   else
                   {
                       TRError.TRError("ERROR", "Record Does Not Exist", "Try Entering a Different ID Number.");
                   }
               }
               else
               {
                   TRError.TRError("ERROR", "Field Entry is Not an ID Number", "Enter a number then press Search Invoice Forms On ID.");
               }
            }
        });
        
        //Move to the Employee Main Menu Scene
        recordsView.GetRecordsForm().GetSendPDFByEmailButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                recordsView.GetRecordsForm().GetInfoScreen().clear();
                mainStage.setScene(emailScene);
            }
        });
        
        //Move to the Employee Main Menu Scene
        recordsView.GetRecordsForm().GetReturnButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                recordsView.GetRecordsForm().GetInfoScreen().clear();
                mainStage.setScene(mainMenuScene2);
            }
        });
    }
}
