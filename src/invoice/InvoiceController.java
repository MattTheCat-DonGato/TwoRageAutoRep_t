/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoice;

import database.Database;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utilities.TRError;

/**
 *
 * @author Matthew Rodriguez
 */
public class InvoiceController
{
    private Database trDatabase;
    //stage
    Stage mainStage;
    
    //views
    private InvoiceView invoiceView;
    
    //scene
    Scene mainMenuScene2;
    
    //models
    private InvoiceModel invoiceModel;
    
    public InvoiceController(Stage mainStage, InvoiceView invoiceView, InvoiceModel invoiceModel, Scene mainMenuScene2)
    {
        this.mainStage = mainStage;
        this.invoiceView = invoiceView;
        this.invoiceModel = invoiceModel;
        this.mainMenuScene2 = mainMenuScene2;
    }
    
    public void attachHandlers()
    {
        invoiceView.GetInvoiceForm().GetSelectCustomerButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                //Check if the customer is selected if not selected throw error else refresh the vehicle combobox based on selected customer
                if(invoiceView.GetInvoiceForm().GetCustomerCB().getSelectionModel().isEmpty())
                {
                    TRError.TRError("ERROR", "Customer not selected", "Please select a customer before pressing the Display Customer Vehicles button.");
                }
                else
                {
                    invoiceView.GetInvoiceForm().FillVehicleComboBoxBasedOnSelectedCustomer();
                    invoiceView.SetInvoiceForm();
                }
                
            }
        });
        invoiceView.GetInvoiceForm().GetCreateInvoiceButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                //Check if the customer is selected
                if(invoiceView.GetInvoiceForm().GetCustomerCB().getSelectionModel().isEmpty())
                {
                    TRError.TRError("ERROR", "Customer not selected", "Please select a customer before pressing the Create Invoice Button.");
                }
                else
                {
                    //check if the vehicle is selected
                    if (invoiceView.GetInvoiceForm().GetVehicleCB().getSelectionModel().isEmpty())
                    {
                        TRError.TRError("ERROR", "Vehicle not selected", "Please select a vehicle before pressing the Create Invoice Button.");
                    }
                    else
                    {
                        //check if the symptom is selected
                        if(invoiceView.GetInvoiceForm().GetDiagnosticCB().getSelectionModel().isEmpty())
                        {
                            TRError.TRError("ERROR", "Symptom not selected", "Please select a symptom before pressing the Create Invoice Button.");
                        }
                        else
                        {
                            //check if the service is selected
                            if(invoiceView.GetInvoiceForm().GetServiceCB().getSelectionModel().isEmpty())
                            {
                                TRError.TRError("ERROR", "Service not selected", "Please select a service before pressing the Create Invoice Button.");
                            }
                            else
                            {
                                String recievedDate = invoiceView.GetInvoiceForm().GetRecievedDateTF().getText();
                                String serialNum = invoiceView.GetInvoiceForm().GetSerialNumTF().getText();
                                String orderNum = invoiceView.GetInvoiceForm().GetOrderNumberTF().getText();
                                String pdfName = invoiceView.GetInvoiceForm().GetPdfNameTF().getText();
                                String slaborOnly = invoiceView.GetInvoiceForm().GetLaborOnlyTF().getText();
                                
                                if(recievedDate.trim().length() == 0)
                                {
                                    TRError.TRError("ERROR", "No Date Recieved entered", "Please enter the date the vehicle was recieved before pressing the Create Invoice Button.");
                                }
                                else
                                {
                                    if(serialNum.trim().length() == 0)
                                    {
                                        TRError.TRError("ERROR", "No Serial Number entered", "Please enter the serial number before pressing the Create Invoice Button.");
                                    }
                                    else
                                    {
                                        if(orderNum.trim().length() == 0)
                                        {
                                            TRError.TRError("ERROR", "No Order Number entered", "Please enter the order number before pressing the Create Invoice Button.");
                                        }
                                        else
                                        {
                                            if(pdfName.trim().length() == 0)
                                            {
                                                TRError.TRError("ERROR", "No PDF Name entered", "Please enter the PDF Name before pressing the Create Invoice Button.");
                                            }
                                            else
                                            {
                                                if(slaborOnly.trim().length() == 0)
                                                {
                                                    TRError.TRError("ERROR", "No Labor entered", "Please enter the labor charge before pressing the Create Invoice Button.");
                                                }
                                                else
                                                {
                                                    double laborOnly = 0;
                                                    boolean isDouble = false;
                                                    try
                                                    {
                                                        laborOnly = Double.parseDouble(slaborOnly);
                                                        isDouble = true;
                                                    }
                                                    catch (Exception e)
                                                    {
                                                        isDouble = false;        
                                                    }
                                                    
                                                    if(isDouble == false)
                                                    {
                                                         TRError.TRError("ERROR", "Invalid Input", "Enter a numerical value before pressing the Create Invoice Button.");
                                                    }
                                                    else
                                                    {
                                                        // get all items parse first number into substring then to int for Insert Query then substring the name for PDF Creation
                                                        String CustomerItem = invoiceView.GetInvoiceForm().GetCustomerCB().getSelectionModel().getSelectedItem().toString();
                                                        String VehicleItem = invoiceView.GetInvoiceForm().GetVehicleCB().getSelectionModel().getSelectedItem().toString();
                                                        String SymptomItem = invoiceView.GetInvoiceForm().GetDiagnosticCB().getSelectionModel().getSelectedItem().toString();
                                                        String ServiceItem = invoiceView.GetInvoiceForm().GetServiceCB().getSelectionModel().getSelectedItem().toString();
                                                        int cID, vID, sympID, servID;
                                                        String scID = CustomerItem.substring(0, 1);
                                                        cID = Integer.parseInt(scID);
                                                        String cName = CustomerItem.substring(2, CustomerItem.length());
                                                        String svID = VehicleItem.substring(0, 1);
                                                        vID = Integer.parseInt(svID);
                                                        String vName = VehicleItem.substring(2, VehicleItem.length());
                                                        String ssympID = SymptomItem.substring(0, 1);
                                                        sympID = Integer.parseInt(ssympID);
                                                        //String sympName = SymptomItem.substring(2, SymptomItem.length());
                                                        String sservID = ServiceItem.substring(0, 1);
                                                        servID = Integer.parseInt(sservID);
                                                        String servName = ServiceItem.substring(2, ServiceItem.length());
                                                        String cAddress = invoiceModel.GetCustomerAddressString(cID);
                                                        String cCity = invoiceModel.GetCustomerCityString(cID);
                                                        String cState = invoiceModel.GetCustomerStateString(cID);
                                                        String cZip = invoiceModel.GetCustomerZipString(cID);
                                                        String cPhone = invoiceModel.GetCustomerPhoneNumberString(cID);
                                                        String vLicensePlate = invoiceModel.GetVehicleLicensePlateString(vID);
                                                        String vOdometer = invoiceModel.GetVehicleOdometerString(vID);
                                                        
                                                        if (!pdfName.endsWith(".pdf"))
                                                        {
                                                            pdfName += ".pdf";
                                                        }
                                                        
                                                        //Create PDF Invoice File
                                                        invoiceModel.CreatePDFInvoice(cName, vName, servName, slaborOnly, 
                                                                cAddress, cCity, cState, cZip, cPhone, recievedDate, 
                                                                orderNum, serialNum, vLicensePlate, vOdometer, pdfName);
                                                        
                                                        //Insert Invoice Record to Database
                                                        invoiceModel.InsertInvoiceRecordToDatabase(cID, vID, sympID, 
                                                                servID, laborOnly, recievedDate, serialNum, orderNum);
                                                        
                                                        //clear all selections from comboboxes and textfields
                                                        invoiceView.GetInvoiceForm().GetCustomerCB().getSelectionModel().clearSelection();
                                                        invoiceView.GetInvoiceForm().GetVehicleCB().getSelectionModel().clearSelection();
                                                        invoiceView.GetInvoiceForm().GetVehicleCB().getItems().clear(); // clear the items from the vehicle combobox
                                                        invoiceView.GetInvoiceForm().GetDiagnosticCB().getSelectionModel().clearSelection();
                                                        invoiceView.GetInvoiceForm().GetServiceCB().getSelectionModel().clearSelection();
                                                        invoiceView.GetInvoiceForm().ClearTF();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }   
                }
            }
        });
        invoiceView.GetInvoiceForm().GetReturnButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                // clear selections, empty vehicle box items, and return to Employee Main Menu 
                invoiceView.GetInvoiceForm().GetCustomerCB().getSelectionModel().clearSelection();
                invoiceView.GetInvoiceForm().GetVehicleCB().getItems().clear();
                invoiceView.GetInvoiceForm().GetDiagnosticCB().getSelectionModel().clearSelection();
                invoiceView.GetInvoiceForm().GetServiceCB().getSelectionModel().clearSelection();
                mainStage.setScene(mainMenuScene2);
            }
        });
    }
}