/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tworageautorep_t;

import diagnosticreport.DiagnosticReportController;
import diagnosticreport.DiagnosticReportModel;
import diagnosticreport.DiagnosticReportView;
import invoice.InvoiceController;
import invoice.InvoiceModel;
import invoice.InvoiceView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.LoginController;
import login.LoginModel;
import login.LoginView;
import mainmenu.MainMenuController;
import mainmenu.MainMenuView;
import networking.EmailController;
import networking.EmailModel;
import networking.EmailView;
import records.RecordsController;
import records.RecordsModel;
import records.RecordsView;
import registervehicle.RegisterVehicleController;
import registervehicle.RegisterVehicleModel;
import registervehicle.RegisterVehicleView;
import tracking.TrackingController;
import tracking.TrackingModel;
import tracking.TrackingView;
import updatetrack.UpdateTrackController;
import updatetrack.UpdateTrackModel;
import updatetrack.UpdateTrackView;

/**
 *
 * @author Matthew Rodriguez
 */
public class TwoRageAutoRep_T extends Application
{
    //stage
    Stage mainStage;
    
    //views
    LoginView loginView = new LoginView();
    MainMenuView mainMenuView = new MainMenuView();
    InvoiceView invoiceView = new InvoiceView();
    UpdateTrackView updateTrackView = new UpdateTrackView();
    RecordsView recordsView = new RecordsView();
    RegisterVehicleView registerVehicleView = new RegisterVehicleView();
    DiagnosticReportView diagnosticReportView = new DiagnosticReportView();
    TrackingView trackingView = new TrackingView();
    EmailView emailView = new EmailView();
    
    //models
    LoginModel loginModel = new LoginModel();
    InvoiceModel invoiceModel = new InvoiceModel();
    UpdateTrackModel updateTrackModel= new UpdateTrackModel();
    RecordsModel recordsModel = new RecordsModel();
    RegisterVehicleModel registerVehicleModel = new RegisterVehicleModel();
    DiagnosticReportModel diagnosticReportModel = new DiagnosticReportModel();
    TrackingModel trackingModel = new TrackingModel();
    EmailModel emailModel = new EmailModel();
    
    //scenes
    Scene loginScene = new Scene(loginView, 900, 550);
    Scene mainmenuScene = new Scene(mainMenuView, 900, 550);
    Scene mainmenuScene2 = new Scene(mainMenuView.getMainMenuEmployeeForm(), 900, 550);
    Scene invoiceScene = new Scene(invoiceView, 900, 550);
    Scene updateTrackScene = new Scene(updateTrackView, 900, 550);
    Scene recordsScene = new Scene(recordsView, 900, 550);
    Scene diagnosticReportScene = new Scene(diagnosticReportView, 900, 550);
    Scene registerVehicleScene = new Scene(registerVehicleView, 900, 550);
    Scene trackingScene = new Scene(trackingView, 900, 550);
    Scene emailScene = new Scene (emailView, 900, 550);
    
    //controllers
    LoginController lc;
    MainMenuController mmc;
    MainController mc;
    InvoiceController ic;
    UpdateTrackController utc;
    RecordsController rc;
    DiagnosticReportController drc;
    TrackingController tc;
    RegisterVehicleController rvc;
    EmailController ec;
    
    @Override
    public void start(Stage primaryStage)
    {
        // set the stage
        mainStage = primaryStage;
        
        //set Controllers
        lc = new LoginController(mainStage,loginView,loginModel,mainmenuScene,mainmenuScene2);
        mmc = new MainMenuController(mainStage, mainMenuView, diagnosticReportScene, trackingScene, registerVehicleScene, loginScene, invoiceScene, updateTrackScene, recordsScene);
        ic = new InvoiceController(mainStage, invoiceView, invoiceModel, mainmenuScene2);
        utc = new UpdateTrackController(mainStage, updateTrackView, updateTrackModel, mainmenuScene2);
        rc = new RecordsController(mainStage, recordsView, recordsModel, mainmenuScene2, emailScene);
        drc = new DiagnosticReportController(mainStage,diagnosticReportView,diagnosticReportModel,mainmenuScene);
        tc = new TrackingController(mainStage, trackingView, mainmenuScene, trackingModel);
        rvc = new RegisterVehicleController(mainStage, registerVehicleView, mainmenuScene, registerVehicleModel);
        ec = new EmailController(mainStage, emailView, emailModel, recordsScene);
        mc = new MainController(lc, mmc, drc, tc, rvc, ic, utc, rc, ec);
        
        //show intial scene
        mainStage.setTitle("TwoRage AutoRep-T");
        mainStage.setScene(loginScene);
        mainStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
