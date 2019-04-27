/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnosticreport;

import database.Database;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import utilities.ActiveCustomer;

/**
 *
 * @author Matthew Rodriguez
 */
public class DiagnosticReportForm extends GridPane
{

    private Image backgroundImg = new Image("images/backgroundDiagnosticReport.png");
    private BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
    private Background background = new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize));

    private VBox buttonVBox = new VBox(15);
    private VBox vehicleContentVBox = new VBox(15);
    private VBox symptomContentVBox = new VBox(15);
    private HBox contentHBox = new HBox(15);
    private VBox commentVBox = new VBox(15);
    
    private Button displayVehicles = new Button("Refresh Vehicle Box");
    private Button submitButton = new Button("Submit Form");
    private Button returnButton = new Button("Return to Main Menu");

    private Label vehicleLabel = new Label("Select Vehicle:");
    private Label symptomLabel = new Label("Select Symptom:");
    private Label commentsLabel = new Label("Comments:");

    private ObservableList<String> differentSymptoms
            = FXCollections.observableArrayList();

    private ObservableList<String> differentVehicle
            = FXCollections.observableArrayList();

    private ComboBox diagnosticCB = new ComboBox(differentSymptoms);
    private ComboBox vehicleCB = new ComboBox(differentVehicle);
    private TextArea commentsTextArea = new TextArea();
    
    Database trDatabase = new Database();
    private ActiveCustomer activeCustomer = ActiveCustomer.GetSingletonCustomer();

    public DiagnosticReportForm()
    {
        this.setBackground(background);
        this.setVgap(15);
        
        buttonVBox.getChildren().addAll(displayVehicles,submitButton, returnButton);
        vehicleContentVBox.getChildren().addAll(vehicleLabel, vehicleCB);
        symptomContentVBox.getChildren().addAll(symptomLabel, diagnosticCB);
        contentHBox.getChildren().addAll(vehicleContentVBox, symptomContentVBox, buttonVBox);
        commentVBox.getChildren().addAll(commentsLabel, commentsTextArea);
        
        FillSymptomComboBox();

        this.add(contentHBox, 0, 0);
        this.add(commentVBox, 0, 1);
        this.setAlignment(Pos.CENTER);
    }

     /**
     * @return the displayVehicles
     */
    public Button GetDisplayVehicles()
    {
        return displayVehicles;
    }

    /**
     * @param displayVehicles the displayVehicles to set
     */
    public void SetDisplayVehicles(Button displayVehicles)
    {
        this.displayVehicles = displayVehicles;
    }
    
    /**
     * @return the submitButton
     */
    public Button GetSubmitButton()
    {
        return submitButton;
    }

    /**
     * @param submitButton the submitButton to set
     */
    public void SetSubmitButton(Button submitButton)
    {
        this.submitButton = submitButton;
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
     * @return the diagnosticCB
     */
    public ComboBox GetDiagnosticCB()
    {
        return diagnosticCB;
    }

    /**
     * @param diagnosticCB the diagnosticCB to set
     */
    public void SetDiagnosticCB(ComboBox diagnosticCB)
    {
        this.diagnosticCB = diagnosticCB;
    }

    /**
     * @return the vehicleCB
     */
    public ComboBox GetVehicleCB()
    {
        return vehicleCB;
    }

    /**
     * @param vehicleCB the vehicleCB to set
     */
    public void SetVehicleCB(ComboBox vehicleCB)
    {
        this.vehicleCB = vehicleCB;
    }

    /**
     * @return the commentsTextArea
     */
    public TextArea GetCommentsTextArea()
    {
        return commentsTextArea;
    }

    /**
     * @param commentsTextArea the commentsTextArea to set
     */
    public void SetCommentsTextArea(TextArea commentsTextArea)
    {
        this.commentsTextArea = commentsTextArea;
    }

    /**
     * @return the differentSymptoms
     */
    public ObservableList<String> GetDifferentSymptoms()
    {
        return differentSymptoms;
    }

    /**
     * @param differentSymptoms the differentSymptoms to set
     */
    public void SetDifferentSymptoms(ObservableList<String> differentSymptoms)
    {
        this.differentSymptoms = differentSymptoms;
    }

    /**
     * @return the differentVehicle
     */
    public ObservableList<String> GetDifferentVehicle()
    {
        return differentVehicle;
    }

    /**
     * @param differentVehicle the differentVehicle to set
     */
    public void SetDifferentVehicle(ObservableList<String> differentVehicle)
    {
        this.differentVehicle = differentVehicle;
    }
    
    public void FillVehicleComboBoxBasedOnCurrentCustomer()
    {
        try
        {
            trDatabase.Connect();
            GetDifferentVehicle().clear();
            Statement sql = trDatabase.GetStatement();
            ResultSet rs = sql.executeQuery("select vehicle.vID, vehicle.vYear, vehicle.vMake, vehicle.vModel from vehiclestatus inner join customer inner join vehicle inner join status where vehiclestatus.cstatusID = customer.cID and vehiclestatus.vstatusID = vehicle.vID and vehiclestatus.statusID = status.statusID and customer.cID = " + activeCustomer.GetcID() + ";");
            while(rs.next())
            {
                GetDifferentVehicle().addAll(rs.getInt("vID") + " " + rs.getString("vYear") + " " + rs.getString("vMake") +" " + rs.getString("vModel"));
            }
            rs.close();
            trDatabase.CloseConnection();
        }
        catch(Exception e)
        {
            System.out.println("Exception at FillVehicleComboBoxBasedOnCurrentCustomer (Diagnostic Report): " + e.getMessage());
        }
    }
    
    public void FillSymptomComboBox()
    {
        try
        {
            trDatabase.Connect(); // get quick connection to database
            GetDifferentSymptoms().clear(); // clear the box
            Statement sql = trDatabase.GetStatement(); // get statement
            ResultSet rs = sql.executeQuery("select * from symptom;"); // sql query
            // while there are still rows in result set
            while (rs.next())
            {
                GetDifferentSymptoms().addAll(rs.getInt("diagID") + " " + rs.getString("diagName")); // add column values to combo box
            }
            rs.close(); // close the result set
            trDatabase.CloseConnection(); // close the connection
        } catch (Exception e)
        {
            System.out.println("Exception at FillSymptomComboBox (DiagnosticReport): " + e.getMessage());
        }
    }
}