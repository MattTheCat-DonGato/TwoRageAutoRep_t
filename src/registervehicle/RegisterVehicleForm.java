/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registervehicle;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Matthew Rodriguez
 */
public class RegisterVehicleForm extends GridPane
{
    private Image backgroundImg = new Image("images/backgroundVehicleRegistration.png");
    private BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
    private Background background = new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.NO_REPEAT, 
                                                    BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize));
    
    //Labels
    private Label vYearLabel = new Label ("Enter Vehicle Year:");
    private Label vMakeLabel = new Label("Enter Vehicle Make:");
    private Label vModelLabel = new Label("Enter Vehicle Model:");
    private Label vColorLabel = new Label("Enter Vehicle Color:");
    private Label vLicensePlateLabel = new Label("Enter License Plate:");
    private Label vOdometerLabel = new Label("Enter Odometer Value:");
    
    //textfields
    private TextField vYearTF = new TextField();
    private TextField vMakeTF = new TextField();
    private TextField vModelTF = new TextField();
    private TextField vColorTF = new TextField();
    private TextField vLicensePlateTF = new TextField();
    private TextField vOdometerTF = new TextField();
    
    //buttons
    private Button registerButton = new Button("Register");
    private Button returnButton = new Button("Back");
  
    //boxes
    VBox labelTFVBox = new VBox(10);
    VBox labelTFVBox2 = new VBox(10);
    VBox buttonVBox = new VBox(30);
    HBox groupedBoxes = new HBox(20);
    
    public RegisterVehicleForm()
    {
        this.getChildren().clear();
        this.setBackground(background);
        this.setHgap(20);
        labelTFVBox.getChildren().addAll(vYearLabel, vYearTF, vMakeLabel, vMakeTF, vModelLabel, vModelTF);
        labelTFVBox2.getChildren().addAll(vColorLabel,vColorTF,vLicensePlateLabel,vLicensePlateTF,vOdometerLabel,vOdometerTF);
        buttonVBox.getChildren().addAll(registerButton,returnButton);
        groupedBoxes.getChildren().addAll(labelTFVBox,labelTFVBox2,buttonVBox);
        
        this.add(groupedBoxes, 0, 0);
        this.setAlignment(Pos.CENTER);
    }

    /**
     * @return the vYearTF
     */
    public TextField GetvYearTF()
    {
        return vYearTF;
    }

    /**
     * @param vYearTF the vYearTF to set
     */
    public void SetvYearTF(TextField vYearTF)
    {
        this.vYearTF = vYearTF;
    }

    /**
     * @return the vMakeTF
     */
    public TextField GetvMakeTF()
    {
        return vMakeTF;
    }

    /**
     * @param vMakeTF the vMakeTF to set
     */
    public void SetvMakeTF(TextField vMakeTF)
    {
        this.vMakeTF = vMakeTF;
    }

    /**
     * @return the vModelTF
     */
    public TextField GetvModelTF()
    {
        return vModelTF;
    }

    /**
     * @param vModelTF the vModelTF to set
     */
    public void SetvModelTF(TextField vModelTF)
    {
        this.vModelTF = vModelTF;
    }

    /**
     * @return the vColorTF
     */
    public TextField GetvColorTF()
    {
        return vColorTF;
    }

    /**
     * @param vColorTF the vColorTF to set
     */
    public void SetvColorTF(TextField vColorTF)
    {
        this.vColorTF = vColorTF;
    }

    /**
     * @return the vLicensePlateTF
     */
    public TextField GetvLicensePlateTF()
    {
        return vLicensePlateTF;
    }

    /**
     * @param vLicensePlateTF the vLicensePlateTF to set
     */
    public void SetvLicensePlateTF(TextField vLicensePlateTF)
    {
        this.vLicensePlateTF = vLicensePlateTF;
    }

    /**
     * @return the vOdometerTF
     */
    public TextField GetvOdometerTF()
    {
        return vOdometerTF;
    }

    /**
     * @param vOdometerTF the vOdometerTF to set
     */
    public void SetvOdometerTF(TextField vOdometerTF)
    {
        this.vOdometerTF = vOdometerTF;
    }

    /**
     * @return the registerButton
     */
    public Button GetRegisterButton()
    {
        return registerButton;
    }

    /**
     * @param registerButton the registerButton to set
     */
    public void SetRegisterButton(Button registerButton)
    {
        this.registerButton = registerButton;
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
    
    public void ClearTF()
    {
        vYearTF.clear();
        vMakeTF.clear();
        vModelTF.clear();
        vColorTF.clear();
        vLicensePlateTF.clear();
        vOdometerTF.clear();
    }
}