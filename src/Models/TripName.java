/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Connexion.Connexion;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Paul_NIYUNGEKO
 */
public class TripName {
    
    private int Id_TripNname=-1;
    private Bus Id_Bus;
    private Trip Id_Trip;
    private String Trip_Name;

    public TripName( String Trip_Name, int Id_TripNname) {
        this.Trip_Name = Trip_Name;
        this.Trip_Name = Trip_Name;
    }
    public TripName( String Trip_Name, Trip Id_Trip) {
        this.Id_Trip = Id_Trip;
        this.Trip_Name = Trip_Name;
    }
    
    public TripName( String Trip_Name) {
        this.Trip_Name = Trip_Name;
    }
    
    
    
    
    public static void printLinkedLocationToTrips(javax.swing.JComboBox list){
        ResultSet request = Connexion.interrogerBD("SELECT * FROM TripNames");
        list.removeAllItems();
        list.addItem(new TripName());

        if(request!=null){
            try {
                while(request.next())
                    list.addItem(new TripName(request.getString("Trip_Name"), request.getInt("Id_Trip")));
                    } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
     public static void printBusSeatForTripName(javax.swing.JComboBox list){
        ResultSet request = Connexion.interrogerBD("SELECT B.Seat, B.Id_Bus, T.Id_Bus  FROM Bus B INNER JOIN  TripNames T ON B.Id_Bus=T.Id_Bus");
        list.removeAllItems();
        list.addItem(new TripName());
        
            try {
                if(request.next()){
                    int seat = request.getInt("Seat");
                    for(int i=1; i<seat; i++)
                        list.addItem(new Bus(i));
                }
                    } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    
    

    public TripName() {
         //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_TripNname() {
        return Id_TripNname;
    }

    public Trip getId_Trip() {
        return Id_Trip;
    }

    public String getTrip_Name() {
        return Trip_Name;
    }

    @Override
    public String toString() {
        return  Trip_Name;
    }
    
    
    
   
    
    
    
}
