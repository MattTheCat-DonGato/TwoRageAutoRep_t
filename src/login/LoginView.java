/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Matthew Rodriguez
 */
public class LoginView extends BorderPane
{
    //background
    private Image backgroundImg = new Image("images/background1.png");
    private BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
    private Background background = new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.NO_REPEAT, 
                                                    BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize));
    //forms
    private WelcomeForm welcomeForm = new WelcomeForm();
    private LoginCustomerForm loginCustomerForm = new LoginCustomerForm();
    private LoginEmployeeForm loginEmployeeForm = new LoginEmployeeForm();
    private RegisterCustomerForm registerCustomerForm = new RegisterCustomerForm();
    //private RegisterEmployeeForm registerEmployeeForm = new RegisterEmployeeForm();
    
   //constructor
    public LoginView()
    {
        this.setBackground(background);
        this.setCenter(welcomeForm); 
    }

    /**
     * @return the welcomeForm
     */
    public WelcomeForm GetWelcomeForm()
    {
        return welcomeForm;
    }

    /**
     * @param welcomeForm the welcomeForm to set
     */
    public void SetWelcomeForm(WelcomeForm welcomeForm)
    {
        this.welcomeForm = welcomeForm;
    }
    
    /**
     * @return the loginCustomerForm
     */
    public LoginCustomerForm GetLoginCustomerForm()
    {
        return loginCustomerForm;
    }

    /**
     * @param loginCustomerForm the loginCustomerForm to set
     */
    public void SetLoginCustomerForm(LoginCustomerForm loginCustomerForm)
    {
        this.loginCustomerForm = loginCustomerForm;
    }

    /**
     * @return the loginEmployeeForm
     */
    public LoginEmployeeForm GetLoginEmployeeForm()
    {
        return loginEmployeeForm;
    }

    /**
     * @param loginEmployeeForm the loginEmployeeForm to set
     */
    public void SetLoginEmployeeForm(LoginEmployeeForm loginEmployeeForm)
    {
        this.loginEmployeeForm = loginEmployeeForm;
    }
    
    /**
     * @return the registerCustomerForm
     */
    public RegisterCustomerForm GetRegisterCustomerForm()
    {
        return registerCustomerForm;
    }

    /**
     * @param registerCustomerForm the registerCustomerForm to set
     */
    public void SetRegisterCustomerForm(RegisterCustomerForm registerCustomerForm)
    {
        this.registerCustomerForm = registerCustomerForm;
    } 
    
    //functions
    public void SetWelcomeForm()
    {
        this.getChildren().clear();
        this.setCenter(welcomeForm);
    }
    
    public void SetLoginCustomerForm()
    {
        this.getChildren().clear();
        this.setCenter(loginCustomerForm);
    }
    
    public void SetLoginEmployeeForm()
    {
        this.getChildren().clear();
        this.setCenter(loginEmployeeForm);
    }

    public void SetRegisterCustomerForm()
    {
        this.getChildren().clear();
        this.setCenter(registerCustomerForm);
    }
}
