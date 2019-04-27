/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Matthew Rodriguez
 */
public class WelcomeForm extends GridPane
{
    // Welcome menu labels and others
    private Label title = new Label("TwoRage AutoRep-T");

    // Welcome menu TextFields and TextAreas
    
    //Welcome menu buttons
    private Button employeeBtn = new Button("Employee Login");
    private Button customerBtn = new Button("Customer Login");
    private Button exitBtn = new Button("Exit Program");
    
    //Image
    private Image welcomeImage = new Image("images/logo_design_new_version_small.jpg");
    private ImageView welcomeIV = new ImageView(welcomeImage);
    
    //cosntructor
    public WelcomeForm()
    {
        //show logo
        welcomeIV.setFitHeight(300);
        welcomeIV.setFitWidth(400);
        
        //format title label 
        title.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        
        //vbox variables
        VBox buttonbox = new VBox(50);

        //set sizes of buttons
        employeeBtn.setPrefSize(200, 50);
        customerBtn.setPrefSize(200, 50);
        exitBtn.setPrefSize(200, 50);

        //add everything
        buttonbox.getChildren().addAll(employeeBtn, customerBtn, exitBtn);

        //outputting all GUIS here
        this.add(welcomeIV, 0, 0);
        this.setHgap(30);
        this.add(buttonbox, 1, 0);

        this.setAlignment(Pos.CENTER);
    }

    /**
     * @return the employeeBtn
     */
    public Button getEmployeeBtn()
    {
        return employeeBtn;
    }

    /**
     * @param employeeBtn the employeeBtn to set
     */
    public void setEmployeeBtn(Button employeeBtn)
    {
        this.employeeBtn = employeeBtn;
    }

    /**
     * @return the customerBtn
     */
    public Button getCustomerBtn()
    {
        return customerBtn;
    }

    /**
     * @param customerBtn the customerBtn to set
     */
    public void setCustomerBtn(Button customerBtn)
    {
        this.customerBtn = customerBtn;
    }

    /**
     * @return the exitBtn
     */
    public Button getExitBtn()
    {
        return exitBtn;
    }

    /**
     * @param exitBtn the exitBtn to set
     */
    public void setExitBtn(Button exitBtn)
    {
        this.exitBtn = exitBtn;
    }
}