/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Connexion.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Paul_NIYUNGEKO
 */
public class Driver {
    private int Id_Driver=-1, Cell_phone;
    private String First_name, Last_name,Licence,CNI, info;

    public Driver() {
    }

    public Driver( String First_name, String Last_name,int Cell_phone, String Licence, String CNI) {
        this.Cell_phone = Cell_phone;
        this.First_name = First_name;
        this.Last_name = Last_name;
        this.Licence = Licence;
        this.CNI = CNI;
    }

    public Driver(String First_name, String Last_name, int Id_Driver) {
        this.First_name = First_name;
        this.Last_name = Last_name;
        this.Id_Driver = Id_Driver;
    }

    
    public void AddDriver(){
        if(Connexion.updateBD("INSERT INTO Drivers(First_name,Last_name,Cell_phone,Licence,CNI)"
                + " values('"+this.First_name+"','"+this.Last_name+"',"+this.Cell_phone+",'"+this.Licence+"','"+this.CNI+"')")>0)
            this.info ="Driver added Succesfully !";
        else
            this.info = "Driver Add Failed";
    }
    
    
    public static void printAllDrivers(javax.swing.JComboBox list){
        ResultSet request = Connexion.interrogerBD("SELECT * FROM DRIVERS");
        list.removeAllItems();
        list.addItem(new Driver());
        
        if(request!=null){
            try {
                while(request.next())
                    list.addItem(new Driver(request.getString("First_name"), request.getString("Last_name"), request.getInt("Id_Driver")));
                    } catch (SQLException e) {
                        e.printStackTrace();
            }
        }
        
    }

    @Override
    public String toString() {
        if(this.Id_Driver==-1)
		return "";
        return this.First_name +"  "+this.Last_name; //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_Driver() {
        return Id_Driver;
    }

    public int getCell_phone() {
        return Cell_phone;
    }

    public String getFirst_name() {
        return First_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public String getLicence() {
        return Licence;
    }

    public String getCNI() {
        return CNI;
    }

    public String getInfo() {
        return info;
    }
    
    
    
    
    
}
