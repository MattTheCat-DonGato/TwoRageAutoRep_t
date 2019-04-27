/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registervehicle;

import javafx.scene.layout.BorderPane;

/**
 *
 * @author Matthew Rodriguez
 */
public class RegisterVehicleView extends BorderPane
{
    private RegisterVehicleForm registerVehicleForm = new RegisterVehicleForm();
    
    public RegisterVehicleView()
    {
       this.getChildren().clear();
       this.setCenter(registerVehicleForm);
    }

    /**
     * @return the registerVehicleForm
     */
    public RegisterVehicleForm GetRegisterVehicleForm()
    {
        return registerVehicleForm;
    }

    /**
     * @param registerVehicleForm the registerVehicleForm to set
     */
    public void SetRegisterVehicleForm(RegisterVehicleForm registerVehicleForm)
    {
        this.registerVehicleForm = registerVehicleForm;
    }
}
