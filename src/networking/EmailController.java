/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import utilities.Email;
import utilities.TRError;

/**
 *
 * @author Matthew Rodriguez
 */
public class EmailController
{
    //Needed to open a window for file choosing
    FileChooser fileChooser = new FileChooser();
    
    //String of attached Files that wil be added to Email Object for submission
    String [] attachFiles = new String[1];
    
    //stage ref
    Stage mainStage;
    
    //scenes
    Scene recordsScene;
    
    //models
    private EmailModel emailModel;
    
    //views
    private EmailView emailView;
    
    
    public EmailController(Stage mainStage, EmailView emailView, EmailModel emailModel, Scene recordsScene)
    {
        this.mainStage = mainStage;
        this.emailModel = emailModel;
        this.emailView = emailView;
        this.recordsScene = recordsScene;
    }
    
    public void attachHandlers()
    {
        emailView.GetEmailForm().GetSelectFileButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {           
                    File file = fileChooser.showOpenDialog(mainStage);
                        if(file != null)
                        {
                            attachFiles[0] = file.toString();            
                        }
                    TRError.TRError("INFORMATION", "File Attached", "File " + attachFiles[0] + " has been attached to Email.");
                }
                catch(Exception e)
                {
                    System.out.println("Exception at EmailForm, Function ChooseFile: " + e.getMessage());
                }    
            }
        });
        emailView.GetEmailForm().GetSendEmailButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                if ( emailView.GetEmailForm().GetCustomerCB().getSelectionModel().isEmpty())
                {
                     TRError.TRError("ERROR", "Customer Not Selected", "Please select a customer from the dropdown box.");
                }
                else
                {
                    if (emailView.GetEmailForm().GetSubjectTF().getText().trim().length() == 0)
                    {
                        TRError.TRError("ERROR", "Subject Field Empty", "Please enter a subject in the text field.");
                    }
                    else
                    {
                        if (attachFiles == null)
                        {
                            TRError.TRError("ERROR", "File Not Selected", "Choose a file to send to the customer.");
                        }
                        else
                        {
                            try
                            {
                                final long startTime = System.currentTimeMillis();
                                String CustomerItem = emailView.GetEmailForm().GetCustomerCB().getSelectionModel().getSelectedItem().toString();
                                int cID;
                                String scID = CustomerItem.substring(0, 1);
                                cID = Integer.parseInt(scID);
                                Email myEmail = new Email();
                                myEmail.setHost("smtp.gmail.com");
                                String host = myEmail.getHost();
                                myEmail.setPort("465");
                                String port = myEmail.getPort();
                                myEmail.setMailFrom("tworageautomotive96@gmail.com");
                                String mailFrom = myEmail.getMailFrom();
                                myEmail.setPassword("tworage_96");
                                String password = myEmail.getPassword();
                                String toAddress = emailModel.SelectCustomerEmailAddress(cID);
                                String subject = emailView.GetEmailForm().GetSubjectTF().getText();
                                String message = emailView.GetEmailForm().GetMessageTA().getText();                           
                                EmailAttachmentSender.sendEmailWithAttachments(host, port, mailFrom, password, toAddress, subject, message, attachFiles);
                                final long endTime = System.currentTimeMillis();
                                System.out.println("Total Execution Time for Send Email in ms.: " + (endTime - startTime));
                                TRError.TRError("INFORMATION", "Email Sent", "Email has been sent to: " + toAddress);
                                if(attachFiles != null)
                                    for (int i = 0; i < attachFiles.length; i++)
                                    {
                                        attachFiles[i] = null;
                                    }
                                emailView.GetEmailForm().clearTF();
                                emailView.GetEmailForm().GetCustomerCB().getSelectionModel().clearSelection();
                            }
                            catch (Exception e)
                            {
                                System.out.println("Exception at Send Email Button (EmailController): " + e.getMessage());
                            }
                        }
                    }
                }   
            }
        });
        emailView.GetEmailForm().GetReturnButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
               emailView.GetEmailForm().GetCustomerCB().getSelectionModel().clearSelection();
               emailView.GetEmailForm().clearTF();
               if(attachFiles != null)
                   for (int i = 0; i < attachFiles.length; i++)
                   {
                       attachFiles[i] = null;
                   }  
               mainStage.setScene(recordsScene);
            }
        });
    }
}
