/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package updatetrack;

import database.Database;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
public class UpdateTrackForm extends GridPane
{
    private Image backgroundImg = new Image("images/backgroundUpdateStatus.png");
    private BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
    private Background background = new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.NO_REPEAT, 
                                                    BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize));
    
    private VBox labelandTFVBox = new VBox(15);
    private VBox comboboxVBox = new VBox(15);
    private VBox buttonVBox = new VBox(15);
    
    private Label cIDLabel = new Label("Select Customer");
    private Label vehicleLabel = new Label("Select Vehicle");
    private Label statusLabel = new Label("Select Status");
    
    private TextField cIDTF = new TextField();
    
    private ObservableList<String> differentCustomer = 
            FXCollections.observableArrayList();
    
    private ObservableList<String> differentVehicle = 
            FXCollections.observableArrayList();
    
    private ObservableList<String> differentStatus = 
            FXCollections.observableArrayList();
      
    private ComboBox customerCB = new ComboBox(differentCustomer);
    private ComboBox vehicleCB = new ComboBox(differentVehicle);
    private ComboBox statusCB = new ComboBox(differentStatus);
    
    private Button searchVehicleButton = new Button("Search Vehicle by Name");
    private Button updateStatusButton = new Button("Update Vehicle Status");
    private Button returnButton = new Button ("Return to Main Menu");
    
    Database trDatabase = new Database();
    
    public UpdateTrackForm()
    {
        this.setBackground(background);
        this.setHgap(10);
        
        searchVehicleButton.setPrefSize(150, 50);
        updateStatusButton.setPrefSize(150, 50);
        returnButton.setPrefSize(150, 50);
        
        comboboxVBox.getChildren().addAll(cIDLabel,customerCB,vehicleLabel,vehicleCB,statusLabel,statusCB);
        buttonVBox.getChildren().addAll(searchVehicleButton, updateStatusButton, returnButton);
        
        FillCustomerComboBox();
        FillStatusComboBox();
        
        this.add(labelandTFVBox, 0, 0);
        this.add(comboboxVBox, 1, 0);
        this.add(buttonVBox, 2, 0);
        this.setAlignment(Pos.CENTER);
    }

    /**
     * @return the cIDTF
     */
    public TextField GetcIDTF()
    {
        return cIDTF;
    }

    /**
     * @param cIDTF the cIDTF to set
     */
    public void SetcIDTF(TextField cIDTF)
    {
        this.cIDTF = cIDTF;
    }
    
    /**
     * @return the differentCustomer
     */
    public ObservableList<String> GetDifferentCustomer()
    {
        return differentCustomer;
    }

    /**
     * @param differentCustomer the differentCustomer to set
     */
    public void SetDifferentCustomer(ObservableList<String> differentCustomer)
    {
        this.differentCustomer = differentCustomer;
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

    /**
     * @return the differentStatus
     */
    public ObservableList<String> GetDifferentStatus()
    {
        return differentStatus;
    }

    /**
     * @param differentStatus the differentStatus to set
     */
    public void SetDifferentStatus(ObservableList<String> differentStatus)
    {
        this.differentStatus = differentStatus;
    }
    
    /**
     * @return the customerCB
     */
    public ComboBox GetCustomerCB()
    {
        return customerCB;
    }

    /**
     * @param customerCB the customerCB to set
     */
    public void SetCustomerCB(ComboBox customerCB)
    {
        this.customerCB = customerCB;
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
     * @return the statusCB
     */
    public ComboBox GetStatusCB()
    {
        return statusCB;
    }

    /**
     * @param statusCB the statusCB to set
     */
    public void SetStatusCB(ComboBox statusCB)
    {
        this.statusCB = statusCB;
    }

    /**
     * @return the searchVehicleButton
     */
    public Button GetSearchVehicleButton()
    {
        return searchVehicleButton;
    }

    /**
     * @param searchVehicleButton the searchVehicleButton to set
     */
    public void SetSearchVehicleButton(Button searchVehicleButton)
    {
        this.searchVehicleButton = searchVehicleButton;
    }

    /**
     * @return the updateStatusButton
     */
    public Button GetUpdateStatusButton()
    {
        return updateStatusButton;
    }

    /**
     * @param updateStatusButton the updateStatusButton to set
     */
    public void SetUpdateStatusButton(Button updateStatusButton)
    {
        this.updateStatusButton = updateStatusButton;
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
 
    public void FillCustomerComboBox()
    {
        try
        {
            trDatabase.Connect();
            GetDifferentCustomer().clear();
            Statement sql = trDatabase.GetStatement();
            ResultSet rs = sql.executeQuery("select cID, cFirstName, cMiddleName, cLastName from customer;");
            while(rs.next())
            {
                GetDifferentCustomer().addAll(rs.getInt("cID") + " " + rs.getString("cFirstName") + " " + rs.getString("cMiddleName") + " " + rs.getString("cLastName"));
            }
            rs.close();
            trDatabase.CloseConnection();
        }
        catch (Exception e)
        {
            System.out.println("Exception at FillCustomerComboBox (UpdateTrackForm): " + e.getMessage());        
        }
    }
    
    public void FillVehicleComboBoxBasedOnSelectedCustomer()
    {
        try
            {   trDatabase.Connect();
                GetDifferentVehicle().clear();
                String s = GetCustomerCB().getSelectionModel().getSelectedItem().toString();
                String myIDString = s.substring(0, 1);
                int ID = Integer.parseInt(myIDString);
                Statement sql = trDatabase.GetStatement();
                ResultSet rs = sql.executeQuery("select vehicle.vID, vehicle.vYear, vehicle.vMake, vehicle.vModel from vehiclestatus inner join customer inner join vehicle inner join status where vehiclestatus.cstatusID = customer.cID and vehiclestatus.vstatusID = vehicle.vID and vehiclestatus.statusID = status.statusID and customer.cID = " + ID + ";");                  
                    while (rs.next())
                    {
                        GetDifferentVehicle().addAll(rs.getInt("vID")+ " " + rs.getString("vYear") + " " + rs.getString("vMake") + " " + rs.getString("vModel"));
                    }
                rs.close();
                trDatabase.CloseConnection();
            }
        catch (Exception e)
            {           
                System.out.println("Exception at FillVehicleComboBoxBasedOnSelectedCustomer (UpdateTrackForm): " + e.getMessage());  
            }
    }
    
    public void FillStatusComboBox()       
    {
        try
            {   
                trDatabase.Connect();
                GetStatusCB().getSelectionModel().clearSelection();
                GetDifferentStatus().clear();
                Statement sql = trDatabase.GetStatement();
                ResultSet rs = sql.executeQuery("select statusID, statusName from status;");                  
                    while (rs.next())
                    {
                        GetDifferentStatus().addAll(rs.getString("statusID")+ " " + rs.getString("statusName"));
                    }
                rs.close();
                trDatabase.CloseConnection();
            }
        catch (Exception e)
            {           
                System.out.println("Exception at FillStatusComboBox (UpdateTrackForm): " + e.getMessage());  
            }
    }
}
