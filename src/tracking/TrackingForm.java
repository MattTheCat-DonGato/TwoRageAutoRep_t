/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracking;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
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
public class TrackingForm extends GridPane
{
    private Image backgroundImg = new Image("images/backgroundStatus.png");
    private BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
    private Background background = new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.NO_REPEAT, 
                                                    BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize));
    
    private VBox buttonVBox = new VBox(15);
    
    private Button pullButton = new Button("Pull Records from Database");
    private Button nextButton = new Button("Next Vehicle");
    private Button lastButton = new Button("Last Vehicle");
    private Button returnButton = new Button ("Return to Main Menu");
    
    private TextArea vehicleStatusInfo = new TextArea();
    
    public TrackingForm()
    {
        this.getChildren().clear();
        this.setBackground(background);
        this.setVgap(20); 
        this.buttonVBox.getChildren().addAll(pullButton,nextButton,lastButton,returnButton);
        vehicleStatusInfo.setEditable(false);
        this.add(vehicleStatusInfo, 0, 0);
        this.add(buttonVBox, 0, 1);
        this.setAlignment(Pos.CENTER);
    }

    /**
     * @return the nextButton
     */
    public Button GetNextButton()
    {
        return nextButton;
    }

    /**
     * @param nextButton the nextButton to set
     */
    public void SetNextButton(Button nextButton)
    {
        this.nextButton = nextButton;
    }

    /**
     * @return the lastButton
     */
    public Button GetLastButton()
    {
        return lastButton;
    }

    /**
     * @param lastButton the lastButton to set
     */
    public void SetLastButton(Button lastButton)
    {
        this.lastButton = lastButton;
    }

    /**
     * @return the returnButton
     */
    public Button GetReturnButton()
    {
        return returnButton;
    }

    /**
     * @param returnButton the returnButton to set
     */
    public void SetReturnButton(Button returnButton)
    {
        this.returnButton = returnButton;
    }

    /**
     * @return the vehicleStatusInfo
     */
    public TextArea GetVehicleStatusInfo()
    {
        return vehicleStatusInfo;
    }

    /**
     * @param vehicleStatusInfo the vehicleStatusInfo to set
     */
    public void SetVehicleStatusInfo(TextArea vehicleStatusInfo)
    {
        this.vehicleStatusInfo = vehicleStatusInfo;
    }

    /**
     * @return the pullButton
     */
    public Button GetPullButton()
    {
        return pullButton;
    }

    /**
     * @param pullButton the pullButton to set
     */
    public void SetPullButton(Button pullButton)
    {
        this.pullButton = pullButton;
    }     
}