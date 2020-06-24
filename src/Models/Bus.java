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
public class Bus {
    private int Id_Bus=-1, Seat;
    private String Imatriculation, Mark, info ;

    public Bus(String Imatriculation, String Mark, int Seat) {
        this.Imatriculation = Imatriculation;
        this.Mark = Mark;
        this.Seat = Seat;
    }
    public Bus(String Imatriculation, String Mark, int Seat, int Id_Bus){
        this.Imatriculation = Imatriculation;
        this.Mark = Mark;
        this.Id_Bus = Id_Bus;
     }
    

    public Bus() {}

    public Bus(int i) {
         this.Seat = i;
    }
    
    
    public void AddBus(){
        if(Connexion.updateBD("INSERT INTO Bus(Imatriculation, Mark, Seat) "
                + "values('"+this.Imatriculation+"', '"+this.Mark+"', "+this.Seat+")")>0)
            this.info = "Bus Added Succesfuly !";
        else
            this.info ="Failed to add Bus";
    }
    
    public static void printAllBus(javax.swing.JComboBox list){
        ResultSet request = Connexion.interrogerBD("SELECT * FROM BUS");
        list.removeAllItems();
        list.addItem(new Bus());
        
        if(request!=null){
            try {
                while(request.next())
                    list.addItem(new Bus(request.getString("Imatriculation"), request.getString("Mark"),request.getInt("Seat"),request.getInt("Id_Bus")));
                    } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
    }

    @Override
    public String toString() {
        if(this.Id_Bus==-1)
		return "";
	
        return this.Imatriculation + "  " +this.Mark; //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_Bus() {
        return Id_Bus;
    }

    public String getImatriculation() {
        return Imatriculation;
    }

    public String getMark() {
        return Mark;
    }

    public String getInfo() {
        return info;
    }

    public int getSeat() {
        return Seat;
    }


    
   
    
    
}
