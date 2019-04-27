/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracking;

import javafx.scene.layout.BorderPane;

/**
 *
 * @author Matthew Rodriguez
 */
public class TrackingView extends BorderPane
{
    private TrackingForm trackingForm = new TrackingForm();
    
    public TrackingView()
    {
        this.getChildren().clear();
        this.setCenter(trackingForm);
    }

    /**
     * @return the trackingForm
     */
    public TrackingForm getTrackingForm()
    {
        return trackingForm;
    }

    /**
     * @param trackingForm the trackingForm to set
     */
    public void setTrackingForm(TrackingForm trackingForm)
    {
        this.trackingForm = trackingForm;
    }
    
}
