/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utilities.Customer;
import utilities.TRError;

/**
 *
 * @author Matthew Rodriguez
 */
public class LoginController
{
    //stage ref
    Stage mainStage;
    
    //views
    private LoginView loginView;
    
    //scenes
    Scene mainMenuScene;
    Scene mainMenuScene2;
    
    //model
    private LoginModel loginModel;
    
    public LoginController(Stage mainStage, LoginView loginView, LoginModel loginModel, Scene mainMenuScene, Scene mainMenuScene2)
    {
        this.mainStage = mainStage;
        this.mainMenuScene = mainMenuScene;
        this.mainMenuScene2 = mainMenuScene2;
        this.loginView = loginView;
        this.loginModel = loginModel;
    }
    
    public void attachHandlers()
    {
        //Actions for when you are in the Welcome Form - COMPLETE
        loginView.GetWelcomeForm().getCustomerBtn().setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event)
            {
                loginView.SetLoginCustomerForm();
            }
        });
        loginView.GetWelcomeForm().getEmployeeBtn().setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event)
            {
                loginView.SetLoginEmployeeForm();
            }
        });
        loginView.GetWelcomeForm().getExitBtn().setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event)
            {
                Platform.exit();
            }
        });
        
        //Actions when in the Login Customer Form.
        loginView.GetLoginCustomerForm().getLoginButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
               String email = loginView.GetLoginCustomerForm().getEmailTF().getText();
               String pass = loginView.GetLoginCustomerForm().getPasswordTF().getText();
               boolean isVerified = loginModel.VerifyCustomerLogin(email, pass);
               if(isVerified == true)
               {
                   mainStage.setScene(mainMenuScene);
                   loginView.GetLoginCustomerForm().ClearTF();
               }
               else
               {
                   TRError.TRError("ERROR", "Login Error", "Information not recorded within the database. Please re-enter your information or sign up.");
               }
            }
        });
        loginView.GetLoginCustomerForm().getRegisterButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                loginView.SetRegisterCustomerForm();
            }
        });
        loginView.GetLoginCustomerForm().getReturnButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                loginView.SetWelcomeForm();
            }
        });
        
        //Actions when in the Register Customer Form
        loginView.GetRegisterCustomerForm().GetRegisterButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
               String fName = loginView.GetRegisterCustomerForm().GetFirstNameTF().getText();
               String mName = loginView.GetRegisterCustomerForm().GetMiddleNameTF().getText();
               String lName = loginView.GetRegisterCustomerForm().GetLastNameTF().getText();
               String address = loginView.GetRegisterCustomerForm().GetAddressTF().getText();
               String city = loginView.GetRegisterCustomerForm().GetCityTF().getText();
               String state = loginView.GetRegisterCustomerForm().GetStateTF().getText();
               String zip = loginView.GetRegisterCustomerForm().GetZipCodeTF().getText();
               String emailContact = loginView.GetRegisterCustomerForm().GetEmailTF().getText();
               String phoneContact = loginView.GetRegisterCustomerForm().GetPhoneNumberTF().getText();
               String password = loginView.GetRegisterCustomerForm().GetPasswordTF().getText();
               
               if(fName.trim().length() == 0)
               {
                   TRError.TRError("Error", "First Name Field Empty", "Please fill in the field");
               }
               else
               {
                   if(lName.trim().length() == 0)
                   {
                       TRError.TRError("Error", "Last Name Field Empty", "Please fill in the field");
                   }
                   else
                   {
                       if(address.trim().length() == 0)
                       {
                           TRError.TRError("Error", "Address Field Empty", "Please fill in the field");
                       }
                       else
                       {
                           if(city.trim().length() == 0)
                           {
                               TRError.TRError("Error", "City Field Empty", "Please fill in the field");
                           }
                           else
                           {
                               if(state.trim().length() == 0)
                               {
                                   TRError.TRError("Error", "State Field Empty", "Please fill in the field");
                               }
                               else
                               {
                                   if(zip.trim().length() == 0)
                                   {
                                       TRError.TRError("Error", "Zip Field Empty", "Please fill in the field");
                                   }
                                   else
                                   {
                                       if(zip.length() != 5)
                                       {
                                           TRError.TRError("Error", "Zip Code Invalid", "Zip Codes must be 5 digits long. Please re-enter the zip code.");
                                       }
                                       else
                                       {
                                           boolean isAllNumbers = false;
                                           int testZip = 0;
                                           try
                                           {
                                               testZip = Integer.parseInt(zip);
                                               isAllNumbers = true;
                                           }
                                           catch (Exception e)
                                           {
                                               isAllNumbers = false;
                                           }
                                           if(!isAllNumbers)
                                           {
                                                TRError.TRError("Error", "Zip Code Invalid", "Zip Codes must be 5 digits long. Please re-enter the zip code.");
                                           }
                                           else
                                           {
                                               if(emailContact.trim().length() == 0)
                                               {
                                                   TRError.TRError("Error", "Email Address Field Empty", "Please fill in the field.");
                                               }
                                               else
                                               {
                                                   if(emailContact.endsWith("@gmail.com") || emailContact.endsWith("@yahoo.com") || emailContact.endsWith("@hotmail.com") || emailContact.endsWith("@aol.com"))
                                                   {
                                                       if(phoneContact.trim().length() == 0)
                                                       {
                                                           TRError.TRError("Error", "Phone Contact Field Empty", "Please fill in the field with a ten digit number.");
                                                       }
                                                       else
                                                       {
                                                           if(phoneContact.length() != 10)
                                                           {
                                                               TRError.TRError("Error", "Invalid Phone Number Length", "Please fill in the field with a ten digit number.");
                                                           }
                                                           else
                                                           {
                                                               if(password.trim().length() == 0)
                                                               {
                                                                   TRError.TRError("Error", "Password Field Empty", "Please fill in the field.");
                                                               }
                                                               else
                                                               {
                                                                   if(mName.isEmpty())
                                                                   {
                                                                       mName = "";
                                                                   }
                                                                   
                                                                    boolean isRegistered = false;
                                                                    Customer newCustomer = new Customer(0, fName, mName, lName, address, city, state, zip, emailContact, phoneContact, password);
                                                                    Customer newCustomer2 = new Customer(0, fName, mName, lName, address, city, state, zip, emailContact, phoneContact, password);
                                                                    isRegistered = loginModel.IsCustomerRegistered(newCustomer);
                                                                       
                                                                    if(isRegistered)
                                                                    {
                                                                        TRError.TRError("Error", "Email Address is already used", "Please enter a different email address.");
                                                                    }
                                                                    else
                                                                    {
                                                                        loginModel.RegisterCustomerToDatabase(newCustomer2);
                                                                        TRError.TRError("INFORMATION", "Information Entered Into Database", "Please write down your email and password and keep it safe: " + "\n" + "Email: " + newCustomer.GetcEmailContact() + "\n" + "Password: " + newCustomer.GetcHashPassword() + "\n" + "You may now login into the application. Retruning to Customer Login Screen.");
                                                                        loginView.GetRegisterCustomerForm().ClearTF();
                                                                        loginView.SetLoginCustomerForm();
                                                                    }
                                                                }
                                                           }
                                                       }
                                                   }
                                                   else
                                                   {
                                                       TRError.TRError("Error", "Invalid Email Domain", "Please enter a valid email address.");
                                                   }
                                               }
                                           }
                                       }
                                   }
                               }
                           }
                       }
                   }
               }
            }
        });
        loginView.GetRegisterCustomerForm().GetReturnButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                loginView.SetLoginCustomerForm();
            }
        });
        
        //Actions when in the Login Employee Form
        loginView.GetLoginEmployeeForm().getLoginButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
               String email = loginView.GetLoginEmployeeForm().getEmailTF().getText();
               String pass = loginView.GetLoginEmployeeForm().getPasswordTF().getText();
               boolean isVerified = loginModel.VerifyEmployeeLogin(email, pass);
               if(isVerified == true)
               {
                   mainStage.setScene(mainMenuScene2);
                   loginView.GetLoginEmployeeForm().ClearTF();
               }
               else
               {
                   TRError.TRError("ERROR", "Login Error", "Information not recorded within the database. Please re-enter your information.");
               }
            }
        });
        loginView.GetLoginEmployeeForm().getReturnButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                loginView.SetWelcomeForm();
            }
        });
    }
    /**
     * @return the loginView
     */
    public LoginView GetLoginView()
    {
        return loginView;
    }

    /**
     * @param loginView the loginView to set
     */
    public void SetLoginView(LoginView loginView)
    {
        this.loginView = loginView;
    }
     /**
     * @return the loginModel
     */
    public LoginModel GetLoginModel()
    {
        return loginModel;
    }

    /**
     * @param loginModel the loginModel to set
     */
    public void SetLoginModel(LoginModel loginModel)
    {
        this.loginModel = loginModel;
    }
}
