/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Matthew Rodriguez
 */
public class RegisterCustomerForm extends GridPane
{
    //labels
    private Label titleLabel = new Label("Customer\n Registration");
    private Label firstNameLabel = new Label("Enter First Name");
    private Label lastNameLabel = new Label("Enter Last Name");
    private Label middleNameLabel = new Label("Enter Middle Name (Optional)");
    private Label addressLabel = new Label ("Enter Address");
    private Label cityLabel = new Label("Enter City Name");
    private Label stateLabel = new Label("Enter State Name");
    private Label zipCodeLabel = new Label("Enter Zip Code");
    private Label phoneNumberLabel = new Label("Enter Phone Number");
    private Label emailLabel = new Label("Enter Email Address");
    private Label passwordLabel = new Label("Enter Account Password");
    
    //textfields
    private TextField firstNameTF = new TextField();
    private TextField lastNameTF = new TextField();
    private TextField middleNameTF = new TextField();
    private TextField addressTF = new TextField();
    private TextField cityTF = new TextField();
    private TextField stateTF = new TextField();
    private TextField zipCodeTF = new TextField();
    private TextField phoneNumberTF = new TextField();
    private TextField emailTF = new TextField();
    private PasswordField passwordTF = new PasswordField();
    
    //buttons
    private Button registerButton = new Button("Register");
    private Button returnButton = new Button("Back");
    
    //boxes
    VBox labelTFVBox = new VBox(10);
    VBox labelTFVBox2 = new VBox(10);
    VBox buttonVBox = new VBox(30);
    HBox groupedBoxes = new HBox(20);
    
    public RegisterCustomerForm()
    {
        this.setVgap(15);
        //change fonts of labels
        titleLabel.setFont(Font.font("Book Antiqua", FontWeight.BOLD, FontPosture.ITALIC, 40));
        firstNameLabel.setFont(Font.font("Book Antiqua", FontWeight.BOLD, FontPosture.REGULAR, 12));
        lastNameLabel.setFont(Font.font("Book Antiqua", FontWeight.BOLD, FontPosture.REGULAR, 12));
        middleNameLabel.setFont(Font.font("Book Antiqua", FontWeight.BOLD, FontPosture.REGULAR, 12));
        addressLabel.setFont(Font.font("Book Antiqua", FontWeight.BOLD, FontPosture.REGULAR, 12));
        cityLabel.setFont(Font.font("Book Antiqua", FontWeight.BOLD, FontPosture.REGULAR, 12));
        stateLabel.setFont(Font.font("Book Antiqua", FontWeight.BOLD, FontPosture.REGULAR, 12));
        zipCodeLabel.setFont(Font.font("Book Antiqua", FontWeight.BOLD, FontPosture.REGULAR, 12));
        phoneNumberLabel.setFont(Font.font("Book Antiqua", FontWeight.BOLD, FontPosture.REGULAR, 12));
        emailLabel.setFont(Font.font("Book Antiqua", FontWeight.BOLD, FontPosture.REGULAR, 12));
        passwordLabel.setFont(Font.font("Book Antiqua", FontWeight.BOLD, FontPosture.REGULAR, 12));
        
        labelTFVBox.getChildren().addAll(firstNameLabel,firstNameTF, lastNameLabel, lastNameTF,
                                         middleNameLabel,middleNameTF,addressLabel,addressTF,cityLabel,cityTF
                                         );
        labelTFVBox2.getChildren().addAll(stateLabel,stateTF,zipCodeLabel,zipCodeTF,phoneNumberLabel,phoneNumberTF,
                                         emailLabel,emailTF,passwordLabel,passwordTF);
        
        buttonVBox.getChildren().addAll(registerButton,returnButton);
        
        groupedBoxes.getChildren().addAll(labelTFVBox,labelTFVBox2);
                
        // Set the spacing between objects
        this.setHgap(40);
        
        //Set button Sizes
        registerButton.setPrefSize(200, 50);
        returnButton.setPrefSize(200, 50);
        
        this.add(titleLabel,0,0);
        this.add(groupedBoxes,1,0);
        this.add(buttonVBox,2,0);
        this.setAlignment(Pos.CENTER);
    }

    /**
     * @return the titleLabel
     */
    public Label GetTitleLabel()
    {
        return titleLabel;
    }

    /**
     * @param titleLabel the titleLabel to set
     */
    public void SetTitleLabel(Label titleLabel)
    {
        this.titleLabel = titleLabel;
    }

    /**
     * @return the firstNameLabel
     */
    public Label GetFirstNameLabel()
    {
        return firstNameLabel;
    }

    /**
     * @param firstNameLabel the firstNameLabel to set
     */
    public void SetFirstNameLabel(Label firstNameLabel)
    {
        this.firstNameLabel = firstNameLabel;
    }

    /**
     * @return the lastNameLabel
     */
    public Label GetLastNameLabel()
    {
        return lastNameLabel;
    }

    /**
     * @param lastNameLabel the lastNameLabel to set
     */
    public void SetLastNameLabel(Label lastNameLabel)
    {
        this.lastNameLabel = lastNameLabel;
    }

    /**
     * @return the middleNameLabel
     */
    public Label GetMiddleNameLabel()
    {
        return middleNameLabel;
    }

    /**
     * @param middleNameLabel the middleNameLabel to set
     */
    public void SetMiddleNameLabel(Label middleNameLabel)
    {
        this.middleNameLabel = middleNameLabel;
    }

    /**
     * @return the addressLabel
     */
    public Label GetAddressLabel()
    {
        return addressLabel;
    }

    /**
     * @param addressLabel the addressLabel to set
     */
    public void SetAddressLabel(Label addressLabel)
    {
        this.addressLabel = addressLabel;
    }

    /**
     * @return the cityLabel
     */
    public Label GetCityLabel()
    {
        return cityLabel;
    }

    /**
     * @param cityLabel the cityLabel to set
     */
    public void SetCityLabel(Label cityLabel)
    {
        this.cityLabel = cityLabel;
    }

    /**
     * @return the stateLabel
     */
    public Label GetStateLabel()
    {
        return stateLabel;
    }

    /**
     * @param stateLabel the stateLabel to set
     */
    public void SetStateLabel(Label stateLabel)
    {
        this.stateLabel = stateLabel;
    }

    /**
     * @return the zipCodeLabel
     */
    public Label GetZipCodeLabel()
    {
        return zipCodeLabel;
    }

    /**
     * @param zipCodeLabel the zipCodeLabel to set
     */
    public void SetZipCodeLabel(Label zipCodeLabel)
    {
        this.zipCodeLabel = zipCodeLabel;
    }

    /**
     * @return the phoneNumberLabel
     */
    public Label GetPhoneNumberLabel()
    {
        return phoneNumberLabel;
    }

    /**
     * @param phoneNumberLabel the phoneNumberLabel to set
     */
    public void SetPhoneNumberLabel(Label phoneNumberLabel)
    {
        this.phoneNumberLabel = phoneNumberLabel;
    }

    /**
     * @return the emailLabel
     */
    public Label GetEmailLabel()
    {
        return emailLabel;
    }

    /**
     * @param emailLabel the emailLabel to set
     */
    public void SetEmailLabel(Label emailLabel)
    {
        this.emailLabel = emailLabel;
    }

    /**
     * @return the passwordLabel
     */
    public Label GetPasswordLabel()
    {
        return passwordLabel;
    }

    /**
     * @param passwordLabel the passwordLabel to set
     */
    public void SetPasswordLabel(Label passwordLabel)
    {
        this.passwordLabel = passwordLabel;
    }

    /**
     * @return the firstNameTF
     */
    public TextField GetFirstNameTF()
    {
        return firstNameTF;
    }

    /**
     * @param firstNameTF the firstNameTF to set
     */
    public void SetFirstNameTF(TextField firstNameTF)
    {
        this.firstNameTF = firstNameTF;
    }

    /**
     * @return the lastNameTF
     */
    public TextField GetLastNameTF()
    {
        return lastNameTF;
    }

    /**
     * @param lastNameTF the lastNameTF to set
     */
    public void SetLastNameTF(TextField lastNameTF)
    {
        this.lastNameTF = lastNameTF;
    }

    /**
     * @return the middleNameTF
     */
    public TextField GetMiddleNameTF()
    {
        return middleNameTF;
    }

    /**
     * @param middleNameTF the middleNameTF to set
     */
    public void SetMiddleNameTF(TextField middleNameTF)
    {
        this.middleNameTF = middleNameTF;
    }

    /**
     * @return the addressTF
     */
    public TextField GetAddressTF()
    {
        return addressTF;
    }

    /**
     * @param addressTF the addressTF to set
     */
    public void SetAddressTF(TextField addressTF)
    {
        this.addressTF = addressTF;
    }

    /**
     * @return the cityTF
     */
    public TextField GetCityTF()
    {
        return cityTF;
    }

    /**
     * @param cityTF the cityTF to set
     */
    public void SetCityTF(TextField cityTF)
    {
        this.cityTF = cityTF;
    }

    /**
     * @return the stateTF
     */
    public TextField GetStateTF()
    {
        return stateTF;
    }

    /**
     * @param stateTF the stateTF to set
     */
    public void SetStateTF(TextField stateTF)
    {
        this.stateTF = stateTF;
    }

    /**
     * @return the zipCodeTF
     */
    public TextField GetZipCodeTF()
    {
        return zipCodeTF;
    }

    /**
     * @param zipCodeTF the zipCodeTF to set
     */
    public void SetZipCodeTF(TextField zipCodeTF)
    {
        this.zipCodeTF = zipCodeTF;
    }

    /**
     * @return the phoneNumberTF
     */
    public TextField GetPhoneNumberTF()
    {
        return phoneNumberTF;
    }

    /**
     * @param phoneNumberTF the phoneNumberTF to set
     */
    public void SetPhoneNumberTF(TextField phoneNumberTF)
    {
        this.phoneNumberTF = phoneNumberTF;
    }

    /**
     * @return the emailTF
     */
    public TextField GetEmailTF()
    {
        return emailTF;
    }

    /**
     * @param emailTF the emailTF to set
     */
    public void SetEmailTF(TextField emailTF)
    {
        this.emailTF = emailTF;
    }

    /**
     * @return the passwordTF
     */
    public PasswordField GetPasswordTF()
    {
        return passwordTF;
    }

    /**
     * @param passwordTF the passwordTF to set
     */
    public void SetPasswordTF(PasswordField passwordTF)
    {
        this.passwordTF = passwordTF;
    }

    /**
     * @return the loginButton
     */
    public Button GetRegisterButton()
    {
        return registerButton;
    }

    /**
     * @param registerButton the loginButton to set
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
        firstNameTF.clear();
        lastNameTF.clear();
        middleNameTF.clear();
        addressTF.clear();
        cityTF.clear();
        stateTF.clear();
        zipCodeTF.clear();
        phoneNumberTF.clear();
        emailTF.clear();
        passwordTF.clear();
    }
}