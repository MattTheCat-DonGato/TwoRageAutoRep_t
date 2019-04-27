/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tworageautorep_t;

import diagnosticreport.DiagnosticReportController;
import login.LoginController;
import mainmenu.MainMenuController;
import invoice.InvoiceController;
import networking.EmailController;
import records.RecordsController;
import registervehicle.RegisterVehicleController;
import tracking.TrackingController;
import updatetrack.UpdateTrackController;
/**
 *
 * @author Matthew Rodriguez
 */
public class MainController
{
    LoginController loginController;
    MainMenuController mainMenuController;
    InvoiceController invoiceController;
    UpdateTrackController updateTrackController;
    RecordsController recordsController;
    DiagnosticReportController diagnosticReportController;
    TrackingController trackingController;
    RegisterVehicleController registerVehicleController;
    EmailController emailController;
    
    public MainController(LoginController loginController, MainMenuController mainMenuController, 
         DiagnosticReportController diagnosticReportController, TrackingController trackingController, 
         RegisterVehicleController registerVehicleController, InvoiceController invoiceController,
    UpdateTrackController updateTrackController, RecordsController recordsController, 
    EmailController emailController)
    {
        //set controllers
        this.loginController = loginController;
        this.mainMenuController = mainMenuController;
        this.diagnosticReportController = diagnosticReportController;
        this.trackingController = trackingController;
        this.registerVehicleController = registerVehicleController;
        this.invoiceController = invoiceController;
        this.updateTrackController = updateTrackController;
        this.recordsController = recordsController;
        this.emailController = emailController;
        
        //AttachHandlers
        AttachHandlers();
    }
    
    public void AttachHandlers()
    {
        //set attach handlers from controllers
        loginController.attachHandlers();
        mainMenuController.attachHandlers();
        diagnosticReportController.attachHandlers();
        trackingController.attachHandlers();
        registerVehicleController.attachHandlers();
        invoiceController.attachHandlers();
        updateTrackController.attachHandlers();
        recordsController.attachHandlers();
        emailController.attachHandlers();
    }
}
