/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package updatetrack;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utilities.TRError;

/**
 *
 * @author Matthew Rodriguez
 */
public class UpdateTrackController
{
    //stage
    Stage mainStage;
    
    //views
    private UpdateTrackView updateTrackView;
    
    //scene
    Scene mainMenuScene2;
    
    //models
    private UpdateTrackModel updateTrackModel;
    
    public UpdateTrackController(Stage mainStage, UpdateTrackView updateTrackView, UpdateTrackModel updateTrackModel, Scene mainMenuScene2)
    {
        this.mainStage = mainStage;
        this.updateTrackView = updateTrackView;
        this.updateTrackModel = updateTrackModel;
        this.mainMenuScene2 = mainMenuScene2;
    }
    
    public void attachHandlers()
    {
        updateTrackView.GetUpdateTrackForm().GetSearchVehicleButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                if(updateTrackView.GetUpdateTrackForm().GetCustomerCB().getSelectionModel().isEmpty())
                {
                     TRError.TRError("ERROR", "Customer not selected", "Please select a customer before pressing the Display Customer Vehicles Button.");
                }
                else
                {
                    updateTrackView.GetUpdateTrackForm().FillVehicleComboBoxBasedOnSelectedCustomer();
                    updateTrackView.SetUpdateTrackForm();
                }
            }
        });
        updateTrackView.GetUpdateTrackForm().GetUpdateStatusButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                if(updateTrackView.GetUpdateTrackForm().GetCustomerCB().getSelectionModel().isEmpty())
                {
                    TRError.TRError("ERROR", "Customer Not Selected", "Please select a customer then press Display Customer Vehicles Button.");
                }
                else
                {
                    //check if the vehicle is selected
                    if (updateTrackView.GetUpdateTrackForm().GetVehicleCB().getSelectionModel().isEmpty())
                    {
                        TRError.TRError("ERROR", "Vehicle not selected", "Please select a vehicle. Press Display Customer Vehicles Button to refresh the Select Vehicle Box.");
                    }
                    else
                    {
                        if (updateTrackView.GetUpdateTrackForm().GetStatusCB().getSelectionModel().isEmpty())
                        {
                            TRError.TRError("ERROR", "Status not selected", "Please select a status.");
                        }
                        else
                        {
                             String CustomerItem = updateTrackView.GetUpdateTrackForm().GetCustomerCB().getSelectionModel().getSelectedItem().toString();
                             String VehicleItem = updateTrackView.GetUpdateTrackForm().GetVehicleCB().getSelectionModel().getSelectedItem().toString();
                             String StatusItem = updateTrackView.GetUpdateTrackForm().GetStatusCB().getSelectionModel().getSelectedItem().toString();
                             int cID, vID, sID;
                             String scID = CustomerItem.substring(0, 1);
                             cID = Integer.parseInt(scID);
                             String svID = VehicleItem.substring(0, 1);
                             vID = Integer.parseInt(svID);
                             String sstatusID = StatusItem.substring(0, 1);
                             sID = Integer.parseInt(sstatusID);
                             updateTrackModel.UpdateSelectedVehicle(cID, vID, sID);
                             updateTrackView.GetUpdateTrackForm().GetCustomerCB().getSelectionModel().clearSelection();
                             updateTrackView.GetUpdateTrackForm().GetVehicleCB().getSelectionModel().clearSelection();
                             updateTrackView.GetUpdateTrackForm().GetStatusCB().getSelectionModel().clearSelection();
                        }
                    }
                }
               
            }
        });
        updateTrackView.GetUpdateTrackForm().GetReturnButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
               updateTrackView.GetUpdateTrackForm().GetCustomerCB().getSelectionModel().clearSelection();
               updateTrackView.GetUpdateTrackForm().GetVehicleCB().getSelectionModel().clearSelection();
               updateTrackView.GetUpdateTrackForm().GetVehicleCB().getItems().clear();
               updateTrackView.GetUpdateTrackForm().GetStatusCB().getSelectionModel().clearSelection();
               mainStage.setScene(mainMenuScene2);
            }
        });
    }
}
