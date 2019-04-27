/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmenu;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
public class MainMenuEmployeeForm extends GridPane
{
    private Image backgroundImg = new Image("images/backgroundEmployee.png");
    private BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
    private Background background = new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.NO_REPEAT, 
                                                    BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize));
    //Boxes
    private VBox buttonBox = new VBox(15);
    
    //Buttons
    private Button createInvoiceButton = new Button("Create Invoice");
    private Button updateVehicleButton = new Button("Update Vehicle Progress");
    private Button recordsRoomButton = new Button("Records Room");
    private Button logoutButton = new Button("Logout");
    
    public MainMenuEmployeeForm()
    {
        this.setBackground(background);
        
        createInvoiceButton.setPrefSize(200, 50);
        updateVehicleButton.setPrefSize(200, 50);
        recordsRoomButton.setPrefSize(200, 50);
        logoutButton.setPrefSize(200, 50);
        
        buttonBox.getChildren().addAll(createInvoiceButton,updateVehicleButton,recordsRoomButton,logoutButton);

        this.addRow(0,buttonBox);
        this.setAlignment(Pos.CENTER);
    }

    /**
     * @return the createInvoiceForm
     */
    public Button getCreateInvoiceButton()
    {
        return createInvoiceButton;
    }

    /**
     * @param createInvoiceButton the createInvoiceForm to set
     */
    public void setCreateInvoiceButton(Button createInvoiceButton)
    {
        this.createInvoiceButton = createInvoiceButton;
    }

    /**
     * @return the updateVehicleButton
     */
    public Button getUpdateVehicleButton()
    {
        return updateVehicleButton;
    }

    /**
     * @param updateVehicleButton the updateVehicleButton to set
     */
    public void setManageEmployeesButton(Button updateVehicleButton)
    {
        this.updateVehicleButton = updateVehicleButton;
    }

    /**
     * @return the recordsRoomButton
     */
    public Button getRecordsRoomButton()
    {
        return recordsRoomButton;
    }

    /**
     * @param recordsRoomButton the recordsRoomButton to set
     */
    public void setRecordsRoomButton(Button recordsRoomButton)
    {
        this.recordsRoomButton = recordsRoomButton;
    }

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