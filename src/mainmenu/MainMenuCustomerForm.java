/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmenu;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
/**
 *
 * @author Matthew Rodriguez
 */
public class MainMenuCustomerForm extends GridPane
{
    private Image backgroundImg = new Image("images/backgroundCustomer.png");
    private BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
    private Background background = new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.NO_REPEAT, 
                                                    BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize));
    //Boxes
    private VBox buttonBox = new VBox(15);
    
    //Labels
    private Label customerTitle = new Label("Customer Main Menu");
    
    //Buttons
    private Button submitDiagnosticFormButton = new Button("Submit Diagnostic Form");
    private Button registerVehicleButton = new Button("Register Vehicle");
    private Button vehicleTrackerButton = new Button("Track Vehicle Progress");
    //private Button accountManagementButton = new Button("Account Management");
    private Button logoutButton = new Button("Logout");
    
    public MainMenuCustomerForm()
    {
        this.setVgap(25);
        
       // customerTitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 40));
        
        submitDiagnosticFormButton.setPrefSize(200, 50);
        registerVehicleButton.setPrefSize(200, 50);
        vehicleTrackerButton.setPrefSize(200, 50);
        //accountManagementButton.setPrefSize(200, 50);
        logoutButton.setPrefSize(200, 50);
        
        buttonBox.getChildren().addAll(submitDiagnosticFormButton,registerVehicleButton,vehicleTrackerButton,logoutButton);
        
        this.add(buttonBox, 0, 0);
        this.setAlignment(Pos.CENTER);
    }

    /**
     * @return the submitDiagnosticFormButton
     */
    public Button getSubmitDiagnosticFormButton()
    {
        return submitDiagnosticFormButton;
    }

    /**
     * @param submitDiagnosticFormButton the submitDiagnosticFormButton to set
     */
    public void setSubmitDiagnosticFormButton(Button submitDiagnosticFormButton)
    {
        this.submitDiagnosticFormButton = submitDiagnosticFormButton;
    }

    /**
     * @return the registerVehicleButton
     */
    public Button getRegisterVehicleButton()
    {
        return registerVehicleButton;
    }

    /**
     * @param registerVehicleButton the registerVehicleButton to set
     */
    public void setRegisterVehicleButton(Button registerVehicleButton)
    {
        this.registerVehicleButton = registerVehicleButton;
    }

    /**
     * @return the vehicleTrackerButton
     */
    public Button getVehicleTrackerButton()
    {
        return vehicleTrackerButton;
    }

    /**
     * @param vehicleTrackerButton the vehicleTrackerButton to set
     */
    public void setVehicleTrackerButton(Button vehicleTrackerButton)
    {
        this.vehicleTrackerButton = vehicleTrackerButton;
    }

    /*
    /**
     * @return the accountManagementButton
     *
    public Button getAccountManagementButton()
    {
        return accountManagementButton;
    }

    /**
     * @param accountManagementButton the accountManagementButton to set
     
    public void setAccountManagementButton(Button accountManagementButton)
    {
        this.accountManagementButton = accountManagementButton;
    }
    */
    
    /**
     * @return the logoutButton
     */
    public Button getLogoutButton()
    {
        return logoutButton;
    } 

    /**
     * @param logoutButton the logoutButton to set
     */
    public void setLogoutButton(Button logoutButton)
    {
        this.logoutButton = logoutButton;
    }   
}