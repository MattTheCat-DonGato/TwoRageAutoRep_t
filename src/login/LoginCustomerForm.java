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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
public class LoginCustomerForm extends GridPane
{
    //boxes
    private HBox buttonBox = new HBox(5);
    private VBox formBox = new VBox(10);
    
    //labels
    private Label emailLabel = new Label("Enter Customer Email:");
    private Label passwordLabel = new Label("Enter Customer Password:");
    
    //textfields
    private TextField emailTF = new TextField();
    private PasswordField passwordTF = new PasswordField();
    
    //buttons
    private Button loginButton = new Button("Login");
    private Button registerButton = new Button("New User? Register Here!");
    private Button returnButton = new Button("Back");
    
    //login images
    private Image loginImage = new Image("images/logo_design_small_version.png");
    private ImageView loginIV = new ImageView(loginImage);
    
    public LoginCustomerForm()
        {
        //set the size of Image
        //loginIV.setFitHeight(300);
        //loginIV.setFitWidth(300);
        
        //change label
       // emailLabel.setStyle("-fx-background-color: white");
       // passwordLabel.setStyle("-fx-background-color: white");
        emailLabel.setFont(Font.font("Book Antiqua", FontWeight.BOLD, FontPosture.REGULAR, 16));
        passwordLabel.setFont(Font.font("Book Antiqua", FontWeight.BOLD, FontPosture.REGULAR, 16));
        
        //add to button box
        buttonBox.getChildren().addAll(loginButton, registerButton, returnButton);
        
        //add to form box
        formBox.getChildren().addAll(emailLabel, emailTF, passwordLabel, passwordTF, buttonBox);
        
        //add all fields to the VBox
      //  this.add(loginIV, 0, 0);
        this.add(formBox, 0, 1);
       
        this.setAlignment(Pos.CENTER);
        }

    /**
     * @return the emailLabel
     */
    public Label getEmailLabel()
    {
        return emailLabel;
    }

    /**
     * @param emailLabel the emailLabel to set
     */
    public void setEmailLabel(Label emailLabel)
    {
        this.emailLabel = emailLabel;
    }

    /**
     * @return the passwordLabel
     */
    public Label getPasswordLabel()
    {
        return passwordLabel;
    }

    /**
     * @param passwordLabel the passwordLabel to set
     */
    public void setPasswordLabel(Label passwordLabel)
    {
        this.passwordLabel = passwordLabel;
    }

    /**
     * @return the emailTF
     */
    public TextField getEmailTF()
    {
        return emailTF;
    }

    /**
     * @param emailTF the emailTF to set
     */
    public void setEmailTF(TextField emailTF)
    {
        this.emailTF = emailTF;
    }

    /**
     * @return the passwordTF
     */
    public PasswordField getPasswordTF()
    {
        return passwordTF;
    }

    /**
     * @param passwordTF the passwordTF to set
     */
    public void setPasswordTF(PasswordField passwordTF)
    {
        this.passwordTF = passwordTF;
    }

    /**
     * @return the loginButton
     */
    public Button getLoginButton()
    {
        return loginButton;
    }

    /**
     * @param loginButton the loginButton to set
     */
    public void setLoginButton(Button loginButton)
    {
        this.loginButton = loginButton;
    }

    /**
     * @return the registerButton
     */
    public Button getRegisterButton()
    {
        return registerButton;
    }

    /**
     * @param registerButton the registerButton to set
     */
    public void setRegisterButton(Button registerButton)
    {
        this.registerButton = registerButton;
    }

    /**
     * @return the returnButton
     */
    public Button getReturnButton()
    {
        return returnButton;
    }

    /**
     * @param returnButton the returnButton to set
     */
    public void setReturnButton(Button returnButton)
    {
        this.returnButton = returnButton;
    }
    
    public void ClearTF()
    {
        emailTF.clear();
        passwordTF.clear();
    }
}
