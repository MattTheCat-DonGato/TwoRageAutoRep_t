package invoice;

import database.Database;
import java.io.FileInputStream;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDJpeg;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;
import utilities.ActiveEmployee;
import utilities.TRError;

/**
 *
 * @author Matthew Rodriguez
 */
public class InvoiceModel
{
    Database trDatabase = new Database();
    private ActiveEmployee activeEmployee;
    
    public String GetCustomerAddressString(int ID)
    {
        String address = "";
        try
        {
            trDatabase.Connect();
            Statement sql = trDatabase.GetStatement();
            ResultSet rs = sql.executeQuery("select cAddress from customer where cID = " + ID +";");
            while (rs.next())
            {
                address = rs.getString("cAddress");
            }
            rs.close();
            trDatabase.CloseConnection();
        }
        catch (Exception e)
        {
              System.out.println("Exception at Get Customer Address String: " + e.getMessage());    
        }
        return address;
    }
    
    public String GetCustomerCityString(int ID)
    {
        String city = "";
        try
        {
            trDatabase.Connect();
            Statement sql = trDatabase.GetStatement();
            ResultSet rs = sql.executeQuery("select cCity from customer where cID = " + ID +";");
        while (rs.next())
        {
            city = rs.getString("cCity");
        }
        rs.close();
       trDatabase.CloseConnection();
        }
        catch (Exception e)
        {
              System.out.println("Exception at Get Customer City String: " + e.getMessage());    
        }
        
        return city;
    }
    
    public String GetCustomerStateString(int ID)
    {
        String state = "";
        try
        {
            trDatabase.Connect();
            Statement sql = trDatabase.GetStatement();
            ResultSet rs = sql.executeQuery("select cState from customer where cID = " + ID +";");
        while (rs.next())
        {
            state = rs.getString("cState");
        }
        rs.close();
      trDatabase.CloseConnection();
        }
        catch (Exception e)
        {
              System.out.println("Exception at Get Customer State String: " + e.getMessage());    
        }
        
        return state;
    }
    
    public String GetCustomerZipString(int ID)
    {
        String zip = "";
        try
        {
            trDatabase.Connect();
            Statement sql = trDatabase.GetStatement();
            ResultSet rs = sql.executeQuery("select cZip from customer where cID = " + ID +";");
        while (rs.next())
        {
            zip = rs.getString("cZip");
        }
        rs.close();
        trDatabase.CloseConnection();
        }
        catch (Exception e)
        {
              System.out.println("Exception at Get Customer Zip Stringe: " + e.getMessage());    
        }
        
        return zip;
    }
    
    public String GetCustomerPhoneNumberString(int ID)
    {
        String phone = "";
        try
        {
            trDatabase.Connect();
            Statement sql = trDatabase.GetStatement();
            ResultSet rs = sql.executeQuery("select cPhoneContact from customer where cID = " + ID +";");
        while (rs.next())
        {
            phone = rs.getString("cPhoneContact");
        }
            rs.close();
            trDatabase.CloseConnection();
        }
        catch (Exception e)
        {
              System.out.println("Exception at Get Customer Phone Nnumber String Function: " + e.getMessage());    
        }
        
        return phone;
    }
    
    public String GetVehicleOdometerString(int ID)
    {
        String odometer = "";
        try
        {
            trDatabase.Connect();
            Statement sql = trDatabase.GetStatement();
            ResultSet rs = sql.executeQuery("select vOdometer from vehicle where vID = " + ID +";");
        while (rs.next())
        {
            odometer = rs.getString("vOdometer");
        }
        rs.close();
        trDatabase.CloseConnection();
        }
        catch (Exception e)
        {
              System.out.println("Exception at Get Vehicle Odometer String Function " + e.getMessage());    
        }
        
        return odometer;
    }
    
    public String GetVehicleLicensePlateString(int ID)
    {
        String licenseplate = "";
        try
        {
            trDatabase.Connect();
            Statement sql = trDatabase.GetStatement();
            ResultSet rs = sql.executeQuery("select vLicensePlate from vehicle where vID = " + ID +";");
        while (rs.next())
        {
            licenseplate = rs.getString("vLicensePlate");
        }
        rs.close();
        trDatabase.CloseConnection();
        }
        catch (Exception e)
        {
              System.out.println("Exception at Get Vehicle License String : " + e.getMessage());    
        }
        
        return licenseplate;
    }
    
    public void InsertInvoiceRecordToDatabase(int cID, int vID, int diagID, 
            int servID, double laborOnly, String recievedDate, String serialVin, String orderNum)
    {
        activeEmployee = ActiveEmployee.GetSingletonEmployee();    
        try
        {
            trDatabase.Connect();
            Statement statement = trDatabase.GetStatement();
            String sql = "insert into invoice values (0," + activeEmployee.GeteID() + ", " + cID + ", " + vID + ", " + diagID + ", " + servID + ", " + laborOnly + ", '" + recievedDate + "', '" + serialVin + "', '" + orderNum + "');";
            statement.executeUpdate(sql);
            TRError.TRError("INFORMATION", "Invoice Record Insert Success", "Invoice Record has been successfully added to the database.");
            trDatabase.CloseConnection();
        }
        catch (Exception e)
        {
            System.out.println("Exception at Insert Invoice Record To Database Function: " + e.getMessage());
        }
    }
    
    public void CreatePDFInvoice(String cName, String vName, String servName, String sLaborOnly, 
            String cAddress, String cCity, String cState, String cZip, String cPhone, 
            String recievedDate, String orderNum, String serialNum, String vLicensePlate, String vOdometer, String pdfName)
    {
        //System.out.println("Creating PDF Invoice File");
        //final long startTime = System.currentTimeMillis();
        String fileName = pdfName; // name of the file
        String imageName = "cd_checkengine.jpg"; // name of image
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy"); // date format from system
        
            try
            {
                PDDocument doc = new PDDocument(); // create instance of the pdf doc file
                PDPage page = new PDPage();
                PDXObjectImage image = new PDJpeg(doc, new FileInputStream(imageName));
                doc.addPage(page); // Adding page in pdf doc file
                
                PDPageContentStream content = new PDPageContentStream(doc, page); // create stream to write to document
                
                content.drawImage(image, 220, 645);
                
                content.beginText();
                content.setFont(PDType1Font.TIMES_BOLD, 16);
                content.moveTextPositionByAmount(230, 620); //set position of text to be written
                content.drawString("TwoRage Automotive"); // writing text
                content.endText();
                
                content.beginText();
                content.setFont(PDType1Font.TIMES_BOLD, 16);
                content.moveTextPositionByAmount(146, 598); //set position of text to be written
                content.drawString("31054 GAMBLE RD SAN BENITO TX 78586"); // writing text
                content.endText();
                
                content.beginText();
                content.setFont(PDType1Font.TIMES_BOLD, 16);
                content.moveTextPositionByAmount(256, 576); //set position of text to be written
                content.drawString("(956)241-6886"); // writing text
                content.endText();
                
                content.beginText();
                content.setFont(PDType1Font.TIMES_BOLD, 16);
                content.moveTextPositionByAmount(226, 554); //set position of text to be written
                content.drawString("godson115@yahoo.com"); // writing text
                content.endText();
                
                content.beginText();
                content.setFont(PDType1Font.TIMES_BOLD, 14);
                content.moveTextPositionByAmount(448, 502); //set position of text to be written
                content.drawString("Date: " + df.format(date)); // writing text
                content.endText();
                
                content.beginText();
                content.setFont(PDType1Font.TIMES_ROMAN, 16);
                content.moveTextPositionByAmount(52, 482); //set position of text to be written
                content.drawString("Name: " + cName); // writing text
                content.endText();
                
                content.beginText();
                content.setFont(PDType1Font.TIMES_ROMAN, 16);
                content.moveTextPositionByAmount(52, 460); //set position of text to be written
                content.drawString("Address: " + cAddress); // writing text
                content.endText();
                
                content.beginText();
                content.setFont(PDType1Font.TIMES_ROMAN, 16);
                content.moveTextPositionByAmount(52, 438); //set position of text to be written
                content.drawString("City, State, Zip: " + cCity + ", " + cState + " " + cZip); // writing text
                content.endText();
                
                content.beginText();
                content.setFont(PDType1Font.TIMES_ROMAN, 16);
                content.moveTextPositionByAmount(362, 482);
                content.drawString("Phone: " + cPhone);
                content.endText();               
                
                content.drawLine(50, 498, 550, 498); // draw top horizontal line at coordinates (xStart,yStart,xEnd,yEnd) of box 1
                content.drawLine(50, 498, 50, 432); // draw left vertical line at coordinates (xStart,yStart,xEnd,yEnd)
                content.drawLine(550, 498, 550, 432); // draw right vertical line at coordinates (xStart,yStart,xEnd,yEnd)
                content.drawLine(50, 476, 550, 476); // draw 2nd horizontal line
                content.drawLine(360, 498, 360, 476); // draw vertical line between name and phone section
                content.drawLine(50, 454, 550, 454); // draw 3rd horizontal line 
                content.drawLine(50, 432, 550, 432); // draw bottom horizontal line of box 1
                
                content.beginText();
                content.setFont(PDType1Font.TIMES_ROMAN, 16);
                content.moveTextPositionByAmount(52, 416);
                content.drawString("Recieved Date & Time: " + recievedDate);
                content.endText();
                
                content.beginText();
                content.setFont(PDType1Font.TIMES_ROMAN, 16);
                content.moveTextPositionByAmount(342, 416);
                content.drawString("Order Number: " + orderNum);
                content.endText();
                
                content.beginText();
                content.setFont(PDType1Font.TIMES_ROMAN, 16);
                content.moveTextPositionByAmount(52, 394);
                content.drawString("Year/Make/Model: " + vName);
                content.endText();
                
                content.beginText();
                content.setFont(PDType1Font.TIMES_ROMAN, 16);
                content.moveTextPositionByAmount(52, 372);
                content.drawString("Serial #/VIN: " + serialNum);
                content.endText();
                
                content.beginText();
                content.setFont(PDType1Font.TIMES_ROMAN, 16);
                content.moveTextPositionByAmount(52, 350);
                content.drawString("License No.: " + vLicensePlate);
                content.endText();
                
                content.beginText();
                content.setFont(PDType1Font.TIMES_ROMAN, 16);
                content.moveTextPositionByAmount(302, 350);
                content.drawString("Odometer: " + vOdometer);
                content.endText();

                content.beginText();
                content.setFont(PDType1Font.TIMES_ROMAN, 16);
                content.moveTextPositionByAmount(52, 328);
                content.drawString(servName);
                content.endText();
                
                content.beginText();
                content.setFont(PDType1Font.TIMES_ROMAN, 16);
                content.moveTextPositionByAmount(362, 196);
                content.drawString("LABOR ONLY $" + sLaborOnly);
                content.endText();
                
                content.beginText();
                content.setFont(PDType1Font.TIMES_BOLD, 16);
                content.moveTextPositionByAmount(384, 174);
                content.drawString("TOTAL       $" + sLaborOnly);
                content.endText();
                
                content.drawLine(50, 432, 550, 432); // draw top (1st) horizontal line of box 2
                content.drawLine(50, 432, 50, 212); // draw left vertical line of box 2
                content.drawLine(550, 432, 550, 168); // draw right vertical line of box 2
                content.drawLine(340, 432, 340, 410); // draw line between date/time and order number
                content.drawLine(50, 410, 550, 410); // draw 2nd horizontal line   
                content.drawLine(50, 388, 550, 388); // draw 3rd horizontal line
                content.drawLine(50, 366, 550, 366); // draw 4th horizontal line
                content.drawLine(300, 366, 300, 344); // draw line between license no. and odometer
                content.drawLine(50, 344, 550, 344); // draw 5th horizontal line
                content.drawLine(466, 344, 466, 168); // draw line between quantity and labor info
                content.drawLine(50, 322, 550, 322); // draw 6th horizontal line
                content.drawLine(50, 300, 550, 300); // draw 7th horizontal line
                content.drawLine(50, 278, 550, 278); // draw 8th horizontal line
                content.drawLine(50, 256, 550, 256); // draw 9th horizontal line
                content.drawLine(50, 234, 550, 234); // draw 10th horizontal line
                content.drawLine(50, 212, 550, 212); // draw 11th horizontal line
                content.drawLine(360, 212, 360, 168); // draw vertical line for labor and total cost
                content.drawLine(360, 190, 550, 190); // draw 12th horizontal line
                content.drawLine(360, 168, 550, 168); // draw 13th horizontal line
                
                content.beginText();
                content.setFont(PDType1Font.TIMES_ROMAN, 16);
                content.moveTextPositionByAmount(336, 90);
                content.drawString("Signed");
                content.endText();
                
                content.beginText();
                content.setFont(PDType1Font.TIMES_ROMAN, 16);
                content.moveTextPositionByAmount(350, 50);
                content.drawString("Date");
                content.endText();
                
                content.drawLine(380, 90, 550, 90); // draw line for signed
                content.drawLine(380, 50, 550, 50); // draw line for date
                
                content.close();
                doc.save(fileName); //Saving PDF file with name parameter
                doc.close(); // cleaning memory
                //final long endTime = System.currentTimeMillis();
                //System.out.println("Total Execution Time for Create PDF Invoice: " + (endTime - startTime));
                TRError.TRError("INFORMATION", "PDF Document Created", "Your file was created in : " + 
                        System.getProperty("user.dir") + ". You may view it from there."); // Display Message where file is located
            }
            catch(Exception e)
              {
                  System.out.println(e.getMessage());
              }
    }
}
