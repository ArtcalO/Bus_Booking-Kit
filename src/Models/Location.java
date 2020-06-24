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
public class Location {
    private int Id_Location=-1;
    private String Location_name, info;

    public Location() {
    }

    public Location(String Location_name) {
        this.Location_name = Location_name;
    }

    public Location(String Location_name, int Id_Location) {
          this.Location_name = Location_name;
          this.Id_Location = Id_Location;
    }
    
    public void AddLocation(){
        if(Connexion.updateBD("INSERT INTO Locations(Location_name) "
                + "values('"+this.Location_name+"')")>0)
            this.info = "Location added succesfuly !";
        else
            this.info = "Failed adding Location !";
    }
    
    public static void printAllLocation(javax.swing.JComboBox list){
        ResultSet request = Connexion.interrogerBD("SELECT * FROM Locations");
        list.removeAllItems();
        list.addItem(new Location());
        if(request!=null){
            try {
                while(request.next())
                    list.addItem(new Location(request.getString("Location_name"), request.getInt("Id_Location")));
                    } catch (SQLException e) {
                        e.printStackTrace();
            }
                
        }
        
    }
    
    public  void printUnlinkedLocation(javax.swing.JComboBox list) {
        ResultSet request = Connexion.interrogerBD("SELECT * FROM Locations where Id_Location !="+this.Id_Location);
        list.removeAllItems();
        list.addItem(new Location());
        if(request!=null){
            try {
                while(request.next())
                    list.addItem(new Location(request.getString("Location_name"), request.getInt("Id_Location")));
                    } catch (SQLException e) {
                        e.printStackTrace();
            }
                
        }
    }

    @Override
    public String toString() {
        return this.Location_name; //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_Location() {
        return Id_Location;
    }

    public String getLocation_name() {
        return Location_name;
    }

    public String getInfo() {
        return info;
    }
    
    
    
    
    
}
