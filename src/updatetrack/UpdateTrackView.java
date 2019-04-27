/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package updatetrack;

import javafx.scene.layout.BorderPane;

/**
 *
 * @author Matthew Rodriguez
 */
public class UpdateTrackView extends BorderPane
{
    private UpdateTrackForm updateTrackForm = new UpdateTrackForm();
    
    public UpdateTrackView()
    {
        this.getChildren().clear();
        this.setCenter(updateTrackForm);
    }

    /**
     * @return the updateTrackForm
     */
    public UpdateTrackForm GetUpdateTrackForm()
    {
        return updateTrackForm;
    }

    /**
     * @param updateTrackForm the updateTrackForm to set
     */
    public void SetUpdateTrackForm(UpdateTrackForm updateTrackForm)
    {
        this.updateTrackForm = updateTrackForm;
    }
    
    public void SetUpdateTrackForm()
    {
        this.getChildren().clear();
        this.setCenter(updateTrackForm);
    }
}
