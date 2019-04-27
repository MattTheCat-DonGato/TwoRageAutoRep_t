/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Matthew Rodriguez
 */
public class Database
{
     //variables
    private Connection connection;
    private Statement statement;
    private ResultSet result;
    
    //Empty constructor
    public Database() {}
    
    /**
     * @return the connection
     */
    public Connection GetConnection() {
        return connection;
    }

    /**
     * @param connection the connection to set
     */
    public void SetConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * @return the statement
     */
    public Statement GetStatement() {
        return statement;
    }

    /**
     * @param statement the statement to set
     */
    public void SetStatement(Statement statement) {
        this.statement = statement;
    }

    /**
     * @return the result
     */
    public ResultSet GetResult() {
        return result;
    }

    /**
     * @param resul the result to set
     */
    public void SetResult(ResultSet resul) {
        this.result = resul;
    }
    
    //functions
    public void Connect()
    {
        try
        {
            connection = DriverManager.getConnection("jdbc:mysql://sql175.main-hosting.eu:3306/u746697959_2rage", "u746697959_matt", "SuperMar!064"); // need to export new database to remote server
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/tworageinvoice","root","SuperMar!064");
            statement = connection.createStatement();
            //System.out.println("Application connected to Database. Ready for statement queries.");
        }
        catch(Exception e)
        {
            System.out.println("Could not connect: " + e.getMessage());
        }
    }
    
    public void CloseConnection()
    {
        try
        {
            statement.close();
            connection.close();
            //System.out.println("Connection closed. Open again to get another connection.");
        }
        catch (Exception e)
        {
            System.out.println("Could not close: " + e.getMessage());
        }
    }
}
