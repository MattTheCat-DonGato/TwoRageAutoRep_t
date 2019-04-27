/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoice;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Matthew Rodriguez
 */
public class InvoiceView extends BorderPane
{
    private InvoiceForm invoiceForm = new InvoiceForm();
    
    public InvoiceView()
    {
        this.setCenter(invoiceForm);
    }

    /**
     * @return the invoiceForm
     */
    public InvoiceForm GetInvoiceForm()
    {
        return invoiceForm;
    }

    /**
     * @param invoiceForm the invoiceForm to set
     */
    public void SetInvoiceForm(InvoiceForm invoiceForm)
    {
        this.invoiceForm = invoiceForm;
    }
    
    //functions
    public void SetInvoiceForm()
    {
        this.getChildren().clear();
        this.setCenter(invoiceForm);
    }
}