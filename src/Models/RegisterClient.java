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
public class RegisterClient {
    private int Id_client=-1;
    private String Username, First_name, Last_name, Password, info;

    public RegisterClient(){};
    
    public RegisterClient(String Username, String First_name, String Last_name, String Password) {
        this.Username = Username;
        this.First_name = First_name;
        this.Last_name = Last_name;
        this.Password = Password;
    }

    public RegisterClient(String First_name, String Last_name, int Id_Client) {
        this.First_name = First_name;
        this.Last_name = Last_name;
        this.Id_client = Id_client;
    }
    
    public void RegisterClient(){
        if(Connexion.updateBD("INSERT INTO Clients(Username, First_name, Last_name, Password)"
                + " values('"+this.Username+"','"+this.First_name+"','"+this.Last_name+"','"+this.Password+"')")>0 && 
                Connexion.updateBD("INSERT INTO Users(Username, Password, Statut) "
                        + "values('"+this.Username+"','"+this.Password+"','client')")>0)
            this.info = "Regidtered succesfully !";
        else
            this.info = "Registration Failed";
    }
    
    public void printAllClients(javax.swing.JComboBox list){
        ResultSet request = Connexion.interrogerBD("SELECT * FROM Clients");
        list.removeAllItems();
        list.addItem(new RegisterClient());
        
        if(request!=null){
            try {
                while(request.next())
                    list.addItem(new RegisterClient(request.getString("First_name"), request.getString("Last_name"), request.getInt("Id_Client")));
                    } catch (SQLException e) {
                        e.printStackTrace();
            }
        }
        
    }

    @Override
    public String toString() {
        return this.First_name + " " +this.Last_name;
    }

    public int getId_client() {
        return Id_client;
    }

    public String getUsername() {
        return Username;
    }

    public String getFirst_name() {
        return First_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public String getPassword() {
        return Password;
    }

    public String getInfo() {
        return info;
    }
    
    
    
    
    
    
    
    
}
