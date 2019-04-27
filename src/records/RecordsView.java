/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package records;

import javafx.scene.layout.BorderPane;

/**
 *
 * @author Matthew Rodriguez
 */
public class RecordsView extends BorderPane
{
    private RecordsForm recordsForm = new RecordsForm();
    
    public RecordsView()
    {
        this.setCenter(recordsForm);
    }

    /**
     * @return the recordsForm
     */
    public RecordsForm GetRecordsForm()
    {
        return recordsForm;
    }

    /**
     * @param recordsForm the recordsForm to set
     */
    public void SetRecordsForm(RecordsForm recordsForm)
    {
        this.recordsForm = recordsForm;
    }
    
    //functions
    public void SetRecordsForm()
    {
        this.getChildren().clear();
        this.setCenter(recordsForm);
    }
}
