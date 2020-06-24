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
public class Trip {
    
    private int Id_Trip=-1;
    private Bus Id_Bus;
    private Driver Id_Driver;
    private Location Id_Dep, Id_Arrv;
    private String Dep_hour, info;

    public Trip() {
    }

    public Trip(Bus Id_Bus, Driver Id_Driver, Location Id_Dep, Location Id_Arrv, String Dep_hour) {
        this.Id_Bus = Id_Bus;
        this.Id_Driver = Id_Driver;
        this.Id_Dep = Id_Dep;
        this.Id_Arrv = Id_Arrv;
        this.Dep_hour = Dep_hour;
    }
    
     public Trip(Location Id_Dep, Location Id_Arrv, String Dep_hour, int Id_Trip) {
        this.Id_Dep = Id_Dep;
        this.Id_Arrv = Id_Arrv;
        this.Dep_hour = Dep_hour;
        this.Id_Trip =Id_Trip;
    }

    
    
    
    public void PlanTrip(){
        if(Connexion.updateBD("INSERT INTO Trips(Id_Bus,Id_Driver,Id_Dep,Id_Arrv,Dep_hour) "
                + "values("+this.Id_Bus.getId_Bus()+","
                        + " "+this.Id_Driver.getId_Driver()+","
                                + ""+this.Id_Dep.getId_Location()+","
                                        + ""+this.Id_Arrv.getId_Location()+","
                                                + "'"+this.Dep_hour+"')")>0
                &&
                Connexion.updateBD("INSERT INTO TripNames(Id_Trip, Id_Bus, Trip_Name)"
                        + " values("+this.Id_Trip+","+this.Id_Bus.getId_Bus()+",'"+this.Id_Arrv.toString()+" "+this.Id_Dep.toString()+"')")>0)
            
            this.info = "Trip plained Siccesfully !";
        else
            this.info = "Failed to palin trip !";
    }
    
    
    public String toString(){
        return this.Id_Dep.toString()+" "+this.Id_Arrv.toString()+" à "+this.Dep_hour;
    }

    public int getId_Trip() {
        return Id_Trip;
    }
    

    public Bus getId_Bus() {
        return Id_Bus;
    }

    public Driver getId_Driver() {
        return Id_Driver;
    }

    public Location getId_Dep() {
        return Id_Dep;
    }

    public Location getId_Arrv() {
        return Id_Arrv;
    }

    public String getDep_hour() {
        return Dep_hour;
    }

    public String getInfo() {
        return info;
    }

  
    
    
    
    
}
    
    
