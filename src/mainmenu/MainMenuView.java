/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmenu;

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
public class MainMenuView extends BorderPane
{
    //background
    private Image backgroundImg = new Image("images/backgroundCustomer.png");
    private BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
    private Background background = new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.NO_REPEAT, 
                                                    BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize));
    //forms
    private MainMenuCustomerForm mainMenuCustomerForm = new MainMenuCustomerForm();
    private MainMenuEmployeeForm mainMenuEmployeeForm = new MainMenuEmployeeForm();
    
    //constructor
    public MainMenuView()
    {
        this.setBackground(background);
        this.setCenter(mainMenuCustomerForm);
    }
    
    /**
     * @return the mainMenuCustomerForm
     */
    public MainMenuCustomerForm getMainMenuCustomerForm()
    {
        return mainMenuCustomerForm;
    }

    /**
     * @param mainMenuCustomerForm the mainMenuCustomerForm to set
     */
    public void setMainMenuCustomerForm(MainMenuCustomerForm mainMenuCustomerForm)
    {
        this.mainMenuCustomerForm = mainMenuCustomerForm;
    }

    /**
     * @return the mainMenuEmployeeForm
     */
    public MainMenuEmployeeForm getMainMenuEmployeeForm()
    {
        this.setBackground(background);
        return mainMenuEmployeeForm;
    }

    /**
     * @param mainMenuEmployeeForm the mainMenuEmployeeForm to set
     */
    public void setMainMenuEmployeeForm(MainMenuEmployeeForm mainMenuEmployeeForm)
    {
        
        this.mainMenuEmployeeForm = mainMenuEmployeeForm;
    }
    
    //functions
    public void SetMainMenuCustomerForm()
    {
        this.getChildren().clear();
        this.setCenter(mainMenuCustomerForm);
    }
    
    public void SetMainMenuEmployeeCustomerForm()
    {
        this.getChildren().clear();
        this.setCenter(mainMenuEmployeeForm);
    }
}
