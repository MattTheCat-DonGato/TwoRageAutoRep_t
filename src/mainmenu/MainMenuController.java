package mainmenu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Matthew Rodriguez
 */
public class MainMenuController
{
    //stage ref
    Stage mainStage;
    
    //scenes
    Scene loginScene;
    Scene invoiceScene;
    Scene updateTrackScene;
    Scene recordsScene;
    Scene reportDiagnosticScene;
    Scene trackingScene;
    Scene registerVehicleScene;
    
    //views
    private MainMenuView mainMenuView;
    
    public MainMenuController(Stage mainStage, MainMenuView mainMenuView, Scene reportDiagnosticScene, 
            Scene trackingScene, Scene registerVehicleScene, Scene loginScene, Scene invoiceScene,
            Scene updateTrackScene, Scene recordsScene)
    {
        this.mainStage = mainStage;
        this.mainMenuView = mainMenuView;
        this.loginScene = loginScene;
        this.reportDiagnosticScene = reportDiagnosticScene;
        this.trackingScene = trackingScene;
        this.registerVehicleScene = registerVehicleScene;
        this.invoiceScene = invoiceScene;
        this.updateTrackScene = updateTrackScene;
        this.recordsScene = recordsScene;
    }
    
    public void attachHandlers()
    {
        mainMenuView.getMainMenuCustomerForm().getSubmitDiagnosticFormButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
               mainStage.setScene(reportDiagnosticScene);
            }
        });
        
        mainMenuView.getMainMenuCustomerForm().getRegisterVehicleButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
               mainStage.setScene(registerVehicleScene);
            }
        });
        
        mainMenuView.getMainMenuCustomerForm().getVehicleTrackerButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                mainStage.setScene(trackingScene);
            }
        });
        
        mainMenuView.getMainMenuCustomerForm().getLogoutButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                mainStage.setScene(loginScene);
            }
        });
        
        mainMenuView.getMainMenuEmployeeForm().getCreateInvoiceButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                mainStage.setScene(invoiceScene);
            }
        });
        
        mainMenuView.getMainMenuEmployeeForm().getUpdateVehicleButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                mainStage.setScene(updateTrackScene);
            }
        });
        
        mainMenuView.getMainMenuEmployeeForm().getRecordsRoomButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
               mainStage.setScene(recordsScene);
            }
        });
       
        mainMenuView.getMainMenuEmployeeForm().getLogoutButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                mainStage.setScene(loginScene);
            }
        });
    }
}
