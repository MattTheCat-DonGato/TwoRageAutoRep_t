package networking;

import javafx.scene.layout.BorderPane;

/**
 *
 * @author Matthew Rodriguez
 */
public class EmailView extends BorderPane
{
    private EmailForm emailForm = new EmailForm();
    
    public EmailView()
    {
        this.getChildren().clear();
        this.setCenter(emailForm);
    }

    /**
     * @return the emailForm
     */
    public EmailForm GetEmailForm()
    {
        return emailForm;
    }

    /**
     * @param emailForm the emailForm to set
     */
    public void SetEmailForm(EmailForm emailForm)
    {
        this.emailForm = emailForm;
    }
    
    //functions
    public void SetEmailForm()
    {
        this.getChildren().clear();
        this.setCenter(emailForm);
    }
}
