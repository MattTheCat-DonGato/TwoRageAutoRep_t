/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking;

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
public class EmailForm extends GridPane
{
    private Image backgroundImg = new Image("images/background1.png");
    private BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
    private Background background = new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.NO_REPEAT, 
                                                    BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize));
    
    // Boxes
    private VBox emailContentBox = new VBox(15);
    private VBox buttonBox = new VBox(25);
    private HBox groupedBoxes = new HBox(20);
    
    // Buttons
    private Button selectFileButton = new Button("Choose File...");
    private Button sendEmailButton = new Button("Send Email");
    private Button returnButton = new Button("Return to Records Room");
    
    // Labels
     private Label customerLabel = new Label("Select Customer:");
     private Label messageLabel = new Label("Enter Message:");
     private Label subjectLabel = new Label("Subject:");
     
    // TextFields 
    private TextField subjectTF = new TextField();
    private TextArea messageTA = new TextArea();
    
    // Customer Observable List
     private ObservableList<String> differentCustomers = 
            FXCollections.observableArrayList();
     
    // Combo Box
     private ComboBox customerCB = new ComboBox(differentCustomers);
     
    // Database
     Database trDatabase = new Database();
    
    public EmailForm()
    {
        this.setBackground(background);
        this.setHgap(15);  
        emailContentBox.getChildren().addAll(customerLabel,customerCB,subjectLabel,subjectTF,messageLabel,messageTA);
        buttonBox.getChildren().addAll(selectFileButton,sendEmailButton,returnButton);
        groupedBoxes.getChildren().addAll(emailContentBox,buttonBox);
        FillCustomerComboBox();       
        this.add(groupedBoxes, 0, 0);
        this.setAlignment(Pos.CENTER);
    }

    /**
     * @return the buttonBox
     */
    public VBox GetButtonBox()
    {
        return buttonBox;
    }

    /**
     * @param buttonBox the buttonBox to set
     */
    public void SetButtonBox(VBox buttonBox)
    {
        this.buttonBox = buttonBox;
    }

    /**
     * @return the selectFileButton
     */
    public Button GetSelectFileButton()
    {
        return selectFileButton;
    }

    /**
     * @param selectFileButton the selectFileButton to set
     */
    public void SetSelectFileButton(Button selectFileButton)
    {
        this.selectFileButton = selectFileButton;
    }

    /**
     * @return the sendEmailButton
     */
    public Button GetSendEmailButton()
    {
        return sendEmailButton;
    }

    /**
     * @param sendEmailButton the sendEmailButton to set
     */
    public void SetSendEmailButton(Button sendEmailButton)
    {
        this.sendEmailButton = sendEmailButton;
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
     * @return the messageLabel
     */
    public Label GetMessageLabel()
    {
        return messageLabel;
    }

    /**
     * @param messageLabel the messageLabel to set
     */
    public void SetMessageLabel(Label messageLabel)
    {
        this.messageLabel = messageLabel;
    }

    /**
     * @return the subjectLabel
     */
    public Label GetSubjectLabel()
    {
        return subjectLabel;
    }

    /**
     * @param subjectLabel the subjectLabel to set
     */
    public void SetSubjectLabel(Label subjectLabel)
    {
        this.subjectLabel = subjectLabel;
    }

    /**
     * @return the subjectTF
     */
    public TextField GetSubjectTF()
    {
        return subjectTF;
    }

    /**
     * @param subjectTF the subjectTF to set
     */
    public void SetSubjectTF(TextField subjectTF)
    {
        this.subjectTF = subjectTF;
    }

    /**
     * @return the messageTA
     */
    public TextArea GetMessageTA()
    {
        return messageTA;
    }

    /**
     * @param messageTA the messageTA to set
     */
    public void SetMessageTA(TextArea messageTA)
    {
        this.messageTA = messageTA;
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
     * @return the emailContentBox
     */
    public VBox GetEmailContentBox()
    {
        return emailContentBox;
    }

    /**
     * @param emailContentBox the emailContentBox to set
     */
    public void SetEmailContentBox(VBox emailContentBox)
    {
        this.emailContentBox = emailContentBox;
    }

    /**
     * @return the groupedBoxes
     */
    public HBox GetGroupedBoxes()
    {
        return groupedBoxes;
    }

    /**
     * @param groupedBoxes the groupedBoxes to set
     */
    public void SetGroupedBoxes(HBox groupedBoxes)
    {
        this.groupedBoxes = groupedBoxes;
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
    
    public void clearTF()
    {
        subjectTF.clear();
        messageTA.clear();
    }
}