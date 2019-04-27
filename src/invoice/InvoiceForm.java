/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoice;
import database.Database;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.SelectionModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
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
public class InvoiceForm extends GridPane
{
    private Image backgroundImg = new Image("images/backgroundCreateInvoice.png");
    private BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
    private Background background = new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.NO_REPEAT, 
                                                    BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize));
    
    private VBox labelandTFVBox = new VBox(15);
    private VBox comboboxVBox = new VBox(15);
    private VBox buttonVBox = new VBox(15);
    
    private Button selectCustomerButton = new Button("Display Customer Vehicles");
    private Button createInvoiceButton = new Button("Create Invoice");
    private Button returnButton = new Button ("Return to Main Menu");
    
    private Label customerLabel = new Label("Select Customer Name");
    private Label vehicleLabel = new Label("Select Vehicle");
    private Label serviceLabel = new Label("Select Service Applied");
    private Label diagnosticLabel = new Label("Select Main Diagnostic");
    private Label laborOnlyLabel = new Label("Enter Labor Charge");
    
    private Label recievedDateLabel = new Label("Enter Date Recieved");
    private Label serialNumLabel = new Label("Enter Serial Number");
    private Label orderNumberLabel = new Label("Enter Order Number");
    private Label pdfNameLabel = new Label("Enter File Name");
    
    private TextField recievedDateTF = new TextField();
    private TextField serialNumTF = new TextField();
    private TextField orderNumberTF = new TextField();
    private TextField laborOnlyTF = new TextField();
    private TextField pdfNameTF = new TextField();
    
    private ObservableList<String> differentServices = 
            FXCollections.observableArrayList();
    
    private ObservableList<String> differentDiagnostics = 
            FXCollections.observableArrayList();
    
    private ObservableList<String> differentCustomers = 
            FXCollections.observableArrayList();
    
    private ObservableList<String> differentVehicles = 
            FXCollections.observableArrayList();
    
    private ComboBox customerCB = new ComboBox(differentCustomers);
    private ComboBox vehicleCB = new ComboBox(differentVehicles);
    private ComboBox diagnosticCB = new ComboBox(differentDiagnostics);
    private ComboBox serviceCB = new ComboBox(differentServices);
    
    Database trDatabase = new Database();
    
    public InvoiceForm()
    {
        this.setBackground(background);
        this.setHgap(15);
        
        selectCustomerButton.setPrefSize(200, 50);
        createInvoiceButton.setPrefSize(200, 50);
        returnButton.setPrefSize(200, 50);
           
        comboboxVBox.getChildren().addAll(customerLabel,customerCB,vehicleLabel,vehicleCB,diagnosticLabel,diagnosticCB,serviceLabel,serviceCB);
        labelandTFVBox.getChildren().addAll(recievedDateLabel,recievedDateTF,serialNumLabel,serialNumTF,orderNumberLabel,orderNumberTF,laborOnlyLabel,laborOnlyTF,pdfNameLabel,pdfNameTF);
        buttonVBox.getChildren().addAll(selectCustomerButton,createInvoiceButton,returnButton);
        
        FillCustomerComboBox();
        FillServiceComboBox();
        FillSymptomComboBox();
        
        this.add(comboboxVBox, 0, 0);
        this.add(labelandTFVBox, 1, 0);
        this.add(buttonVBox, 2, 0);
        this.setAlignment(Pos.CENTER);
    }

    /**
     * @return the createInvoiceButton
     */
    public Button GetCreateInvoiceButton()
    {
        return createInvoiceButton;
    }

    /**
     * @param createInvoiceButton the createInvoiceButton to set
     */
    public void SetCreateInvoiceButton(Button createInvoiceButton)
    {
        this.createInvoiceButton = createInvoiceButton;
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
     * @return the recievedDateTF
     */
    public TextField GetRecievedDateTF()
    {
        return recievedDateTF;
    }

    /**
     * @param recievedDateTF the recievedDateTF to set
     */
    public void SetRecievedDateTF(TextField recievedDateTF)
    {
        this.recievedDateTF = recievedDateTF;
    }

    /**
     * @return the serialNumTF
     */
    public TextField GetSerialNumTF()
    {
        return serialNumTF;
    }

    /**
     * @param serialNumTF the serialNumTF to set
     */
    public void SetSerialNumTF(TextField serialNumTF)
    {
        this.serialNumTF = serialNumTF;
    }

    /**
     * @return the orderNumberTF
     */
    public TextField GetOrderNumberTF()
    {
        return orderNumberTF;
    }

    /**
     * @param orderNumberTF the orderNumberTF to set
     */
    public void SetOrderNumberTF(TextField orderNumberTF)
    {
        this.orderNumberTF = orderNumberTF;
    }

    /**
     * @return the pdfNameTF
     */
    public TextField GetPdfNameTF()
    {
        return pdfNameTF;
    }

    /**
     * @param pdfNameTF the pdfNameTF to set
     */
    public void SetPdfNameTF(TextField pdfNameTF)
    {
        this.pdfNameTF = pdfNameTF;
    }

    /**
     * @return the laborOnlyTF
     */
    public TextField GetLaborOnlyTF()
    {
        return laborOnlyTF;
    }

    /**
     * @param laborOnlyTF the laborOnlyTF to set
     */
    public void SetLaborOnlyTF(TextField laborOnlyTF)
    {
        this.laborOnlyTF = laborOnlyTF;
    }

    /**
     * @return the differentServices
     */
    public ObservableList<String> GetDifferentServices()
    {
        return differentServices;
    }

    /**
     * @param differentServices the differentServices to set
     */
    public void SetDifferentServices(ObservableList<String> differentServices)
    {
        this.differentServices = differentServices;
    }

    /**
     * @return the differentDiagnostics
     */
    public ObservableList<String> GetDifferentDiagnostics()
    {
        return differentDiagnostics;
    }

    /**
     * @param differentDiagnostics the differentDiagnostics to set
     */
    public void SetDifferentDiagnostics(ObservableList<String> differentDiagnostics)
    {
        this.differentDiagnostics = differentDiagnostics;
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
     * @return the serviceCB
     */
    public ComboBox GetServiceCB()
    {
        return serviceCB;
    }

    /**
     * @param serviceCB the serviceCB to set
     */
    public void SetServiceCB(ComboBox serviceCB)
    {
        this.serviceCB = serviceCB;
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
     * @return the differentCustomers
     */
    public ObservableList<String> GetDifferentCustomers()
    {
        return differentCustomers;
    }

    /**
     * @param differentCustomers the differentCustomers to set
     */
    public void SetDifferentCustomers(ObservableList<String> differentCustomers)
    {
        this.differentCustomers = differentCustomers;
    }
    
     /**
     * @return the differentVehicles
     */
    public ObservableList<String> GetDifferentVehicles()
    {
        return differentVehicles;
    }

    /**
     * @param differentVehicles the differentVehicles to set
     */
    public void SetDifferentVehicles(ObservableList<String> differentVehicles)
    {
        this.differentVehicles = differentVehicles;
    }
             
    /**
     * @return the selectCustomerButton
     */
    public Button GetSelectCustomerButton()
    {
        return selectCustomerButton;
    }

    /**
     * @param selectCustomerButton the selectCustomerButton to set
     */
    public void SetSelectCustomerButton(Button selectCustomerButton)
    {
        this.selectCustomerButton = selectCustomerButton;
    }
    
    public void FillCustomerComboBox()
    {
        try
        {
            trDatabase.Connect();
            GetDifferentCustomers().clear();
            Statement sql = trDatabase.GetStatement();
            ResultSet rs = sql.executeQuery("select cID, cFirstName, cMiddleName, cLastName from customer;");
            while(rs.next())
            {
                GetDifferentCustomers().addAll(rs.getInt("cID") + " " + rs.getString("cFirstName") + " " + rs.getString("cMiddleName") + " " + rs.getString("cLastName"));
            }
            rs.close();
            trDatabase.CloseConnection();
        }
        catch (Exception e)
        {
            System.out.println("Exception at TwoRage AutoRep-T: " + e);        
        }
    }
    
    public void FillSymptomComboBox()
    {
        try
        {
            trDatabase.Connect();
            GetDifferentDiagnostics().clear();
            Statement sql = trDatabase.GetStatement();
            ResultSet rs = sql.executeQuery("select symptom.diagID, symptom.diagName from symptom;");
            while (rs.next())
            {
                GetDifferentDiagnostics().addAll(rs.getInt("diagID") + " " + rs.getString("diagName"));
            }
            rs.close();
            trDatabase.CloseConnection();
        }
        catch (Exception e)
        {
            System.out.println("Exception at TwoRage AutoRep-T: " + e); 
        }
    }
    
    public void FillServiceComboBox()
    {
        try
        {
        trDatabase.Connect();
        GetDifferentServices().clear();
        Statement sql = trDatabase.GetStatement();
        ResultSet rs = sql.executeQuery("select service.serviceID, service.serviceName from service;");
            while (rs.next())
            {
                GetDifferentServices().addAll(rs.getInt("serviceID") + " " + rs.getString("serviceName"));
            }
            rs.close();
        trDatabase.CloseConnection();
        }
        catch (Exception e)
        {
            System.out.println("Exception at TwoRage AutoRep-T: " + e); 
        }
    }
    
    public void FillVehicleComboBoxBasedOnSelectedCustomer()
    {
        try
            {   
                trDatabase.Connect();
                GetDifferentVehicles().clear();
                String s = GetCustomerCB().getSelectionModel().getSelectedItem().toString();
                //System.out.println(s);
                String myIDString = s.substring(0, 1);
                //System.out.println(myIDString);
                int ID = Integer.parseInt(myIDString);
                Statement sql = trDatabase.GetStatement();
                ResultSet rs = sql.executeQuery("select vehicle.vID, vehicle.vYear, vehicle.vMake, vehicle.vModel from vehiclestatus inner join customer inner join vehicle inner join status where vehiclestatus.cstatusID = customer.cID and vehiclestatus.vstatusID = vehicle.vID and vehiclestatus.statusID = status.statusID and customer.cID = " + ID + ";");                  
                    while (rs.next())
                    {
                        GetDifferentVehicles().addAll(rs.getInt("vID")+ " " + rs.getString("vYear") + " " + rs.getString("vMake") + " " + rs.getString("vModel"));
                    }
                rs.close();
                trDatabase.CloseConnection();
            }
        catch (Exception e)
            {           
                System.out.println("Exception at FillVehicleComboBoxBasedOnSelectedCustomer (Invoice Form): " + e);  
            }
    }
    
    public void ClearTF()
    {
        GetRecievedDateTF().clear();
        GetSerialNumTF().clear();
        GetOrderNumberTF().clear();
        GetLaborOnlyTF().clear();
        GetPdfNameTF().clear();
    }
}