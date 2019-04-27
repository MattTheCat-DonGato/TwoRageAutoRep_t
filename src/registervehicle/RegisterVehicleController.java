/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registervehicle;

import invoice.InvoiceModel;
import invoice.InvoiceView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utilities.TRError;
import utilities.Vehicle;

/**
 *
 * @author Matthew Rodriguez
 */
public class RegisterVehicleController
{
    //stage
    Stage mainStage;
    
    //views
    private RegisterVehicleView registerVehicleView;
    
    //scene
    Scene mainMenuScene;
    
    //models
    private RegisterVehicleModel registerVehicleModel;

    public RegisterVehicleController(Stage mainStage, RegisterVehicleView registerVehicleView, Scene mainMenuScene, RegisterVehicleModel registerVehicleModel)
    {
        this.mainStage = mainStage;
        this.registerVehicleView = registerVehicleView;
        this.mainMenuScene = mainMenuScene;
        this.registerVehicleModel = registerVehicleModel;
    }
    
    public void attachHandlers()
    {
        registerVehicleView.GetRegisterVehicleForm().GetRegisterButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                if (registerVehicleView.GetRegisterVehicleForm().GetvYearTF().getText().trim().length() == 0)
                {
                    TRError.TRError("ERROR", "Year Field Empty", "Enter the Year of the Vehicle.");
                }
                else
                {
                    if (registerVehicleView.GetRegisterVehicleForm().GetvMakeTF().getText().trim().length() == 0)
                    {
                        TRError.TRError("ERROR", "Make Field Empty", "Enter the Make of the Vehicle.");
                    }
                    else
                    {
                        if (registerVehicleView.GetRegisterVehicleForm().GetvModelTF().getText().trim().length() == 0)
                        {
                            TRError.TRError("ERROR", "Model Field Empty", "Enter the Model of the Vehicle.");
                        }
                        else
                        {
                            if (registerVehicleView.GetRegisterVehicleForm().GetvColorTF().getText().trim().length() == 0)
                            {
                                TRError.TRError("ERROR", "Color Field Empty", "Enter the Color of the Vehicle.");
                            }
                            else
                            {
                                if (registerVehicleView.GetRegisterVehicleForm().GetvLicensePlateTF().getText().trim().length() == 0)
                                {
                                    TRError.TRError("ERROR", "License Plate Field Empty", "Enter the License Plate of the Vehicle");
                                }
                                else
                                {
                                    if (registerVehicleView.GetRegisterVehicleForm().GetvOdometerTF().getText().trim().length() == 0)
                                    {
                                        TRError.TRError("ERROR", "Odometer Field Empty", "Enter the Odometer Number of the Vehicle");
                                    }
                                    else
                                    {
                                        boolean isInt = false;
                                        int odometer = 0;
                                        String sOdometer = registerVehicleView.GetRegisterVehicleForm().GetvOdometerTF().getText();
                                        try
                                        {
                                            odometer = Integer.parseInt(sOdometer);
                                            isInt = true;
                                        }
                                        catch (Exception e)
                                        {
                                            isInt = false;
                                        }
                                        
                                        if(isInt)
                                        {
                                            String year = registerVehicleView.GetRegisterVehicleForm().GetvYearTF().getText();
                                            String make = registerVehicleView.GetRegisterVehicleForm().GetvMakeTF().getText();
                                            String model = registerVehicleView.GetRegisterVehicleForm().GetvModelTF().getText();
                                            String color = registerVehicleView.GetRegisterVehicleForm().GetvColorTF().getText();
                                            String licensePlate = registerVehicleView.GetRegisterVehicleForm().GetvLicensePlateTF().getText();
                                            Vehicle newVehicle = new Vehicle(0,year,make,model,color,licensePlate,sOdometer);
                                            
                                            registerVehicleModel.InsertVehicleToDatabase(newVehicle); //insert vehicle data into database
                                            int newVID = registerVehicleModel.GetRecentVehicleIDInsertedToDatabase(); // extract recent added vID from vehicle table
                                            registerVehicleModel.InsertIntoVehicleOwnerShipTable(newVID); // insert current customer ID and recent vehicle ID to vehicleownership table
                                            registerVehicleModel.InsertIntoVehicleStatusTable(newVID); // insert current customer ID, recent vehicle ID, and registered status ID to vehicle status
                                            registerVehicleView.GetRegisterVehicleForm().ClearTF();
                                        }
                                        else
                                        {
                                            TRError.TRError("ERROR", "Odometer Entry is Invalid", "Odometer value must be entered as a Number. Please re-enter the value");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
        
        registerVehicleView.GetRegisterVehicleForm().GetReturnButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                mainStage.setScene(mainMenuScene);
            }
        });
    }
}
