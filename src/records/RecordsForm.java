/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package records;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
import javafx.scene.layout.VBox;

/**
 *
 * @author Matthew Rodriguez
 */
public class RecordsForm extends GridPane
{
    private Image backgroundImg = new Image("images/backgroundRecordsRoom.png");
    private BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
    private Background background = new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.NO_REPEAT, 
                                                    BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize));
    
    private VBox labelandTFVBox = new VBox(15);
    private VBox buttonVBox = new VBox(15);
    
    private Button searchDiagnosticFormButton = new Button("Search Diagnostic Forms On ID");
    private Button searchInvoiceFormButton = new Button("Search Invoice Forms On ID");
    private Button sendPDFByEmailButton = new Button("Email Invoice to Customer");
    private Button returnButton = new Button ("Return to Main Menu");
    
    private Label cIDLabel = new Label("Enter ID Number");
   
    private TextField cIDTF = new TextField();
    
    private TextArea infoScreen = new TextArea();
    
    public RecordsForm()
    {
       this.setBackground(background);
       this.setHgap(15);
    
       labelandTFVBox.getChildren().addAll(cIDLabel,cIDTF);
       buttonVBox.getChildren().addAll(searchDiagnosticFormButton,searchInvoiceFormButton,sendPDFByEmailButton,returnButton);
       infoScreen.setEditable(false);
       this.add(labelandTFVBox, 0, 0);
       this.add(buttonVBox, 1, 0);
       this.add(infoScreen, 2, 0);
       this.setAlignment(Pos.CENTER);
    }

    /**
     * @return the searchDiagnosticFormButton
     */
    public Button GetSearchDiagnosticFormButton()
    {
        return searchDiagnosticFormButton;
    }

    /**
     * @param searchDiagnosticFormButton the searchDiagnosticFormButton to set
     */
    public void SetSearchDiagnosticFormButton(Button searchDiagnosticFormButton)
    {
        this.searchDiagnosticFormButton = searchDiagnosticFormButton;
    }

    /**
     * @return the searchInvoiceFormButton
     */
    public Button GetSearchInvoiceFormButton()
    {
        return searchInvoiceFormButton;
    }

    /**
     * @param searchInvoiceFormButton the searchInvoiceFormButton to set
     */
    public void SetSearchInvoiceFormButton(Button searchInvoiceFormButton)
    {
        this.searchInvoiceFormButton = searchInvoiceFormButton;
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
     * @return the infoScreen
     */
    public TextArea GetInfoScreen()
    {
        return infoScreen;
    }

    /**
     * @param infoScreen the infoScreen to set
     */
    public void SetInfoScreen(TextArea infoScreen)
    {
        this.infoScreen = infoScreen;
    }

    /**
     * @return the sendPDFByEmailButton
     */
    public Button GetSendPDFByEmailButton()
    {
        return sendPDFByEmailButton;
    }

    /**
     * @param sendPDFByEmailButton the sendPDFByEmailButton to set
     */
    public void SetSendPDFByEmailButton(Button sendPDFByEmailButton)
    {
        this.sendPDFByEmailButton = sendPDFByEmailButton;
    }
    
}
