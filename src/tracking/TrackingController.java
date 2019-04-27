/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracking;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utilities.TRError;
import utilities.VehicleStat;

/**
 *
 * @author Matthew Rodriguez
 */
public class TrackingController
{
    //stage
    Stage mainStage;
    
    //views
    private TrackingView trackingView;
    
    //scene
    Scene mainMenuScene;
    
    //models
    private TrackingModel trackingModel;
    
    // index for list
    int index = 0;

    public TrackingController(Stage mainStage, TrackingView trackingView, Scene mainMenuScene, TrackingModel trackingModel)
    {
        this.mainStage = mainStage;
        this.trackingView = trackingView;
        this.mainMenuScene = mainMenuScene;
        this.trackingModel = trackingModel;
    }
    
    public void attachHandlers()
    {
        trackingView.getTrackingForm().GetPullButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                boolean rFound = false;
                rFound = trackingModel.GetVehicleStatuses();
                if (rFound)
                {
                    VehicleStat vehicle = trackingModel.GetVehicles().get(index);
                    String info = trackingModel.DisplayInvoiceRecordToTextArea(vehicle);
                    trackingView.getTrackingForm().GetVehicleStatusInfo().setText(info);
                }
                else
                {
                    TRError.TRError("ERROR", "No Records Found", "There are no vehicles registered under your account.\nYou may register your vehicles in the Vehicle Registration Screen.");
                }
            }
        });
        
        trackingView.getTrackingForm().GetNextButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                if(trackingModel.GetVehicles().isEmpty())
                {
                    TRError.TRError("ERROR", "No Vehicles Pulled From Database", "Press the Pull Records From Database button to get the statuses on your vehicles.");
                }
                 else
                {
                    if(index < trackingModel.GetVehicles().size()-1)
                    {
                        index++;
                        VehicleStat vehicle = trackingModel.GetVehicles().get(index);
                        String info = trackingModel.DisplayInvoiceRecordToTextArea(vehicle);
                        trackingView.getTrackingForm().GetVehicleStatusInfo().setText(info);
                    }
                    else
                    {
                        TRError.TRError("ERROR", "Reached End of List", "There are no more records past this one.");
                    }
                }
            }
        });
        
        trackingView.getTrackingForm().GetLastButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                if(trackingModel.GetVehicles().isEmpty())
                {
                    TRError.TRError("ERROR", "No Vehicles Pulled From Database", "Press the Pull Records From Database button to get the statuses on your vehicles.");
                }
                 else
                {
                    if(index > 0)
                    {
                        index--;
                        VehicleStat vehicle = trackingModel.GetVehicles().get(index);
                        String info = trackingModel.DisplayInvoiceRecordToTextArea(vehicle);
                        trackingView.getTrackingForm().GetVehicleStatusInfo().setText(info);
                    }
                    else
                    {
                        TRError.TRError("ERROR", "Reached End of List", "There are no more records past this one.");
                    }
                }
            }
        });
        
        trackingView.getTrackingForm().GetReturnButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                trackingView.getTrackingForm().GetVehicleStatusInfo().clear(); // clear everything in the text area
                index = 0; // reset index of list to 0
                trackingModel.GetVehicles().clear(); // clear the list
                mainStage.setScene(mainMenuScene);
            }
        });
        
    }
}
