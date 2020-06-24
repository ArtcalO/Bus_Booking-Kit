/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Connexion.*;
/**
 *
 * @author Paul_NIYUNGEKO
 */
public class Booking {
    private int Id_Booking =-1, Cell_phone, Price;
    private String First_name,Last_name, info;
    private TripName Id_Trip;
    private Bus Id_Seat;

    public Booking() {}

    
    public Booking(String First_name, String Last_name,int Cell_phone, TripName Id_Trip, Bus Id_Seat, int Price) {
        this.Cell_phone = Cell_phone;
        this.First_name = First_name;
        this.Last_name = Last_name;
        this.Id_Trip = Id_Trip;
        this.Id_Seat = Id_Seat;
        this.Price = Price;
    }
    
    public void AddBooking(){
        if(Connexion.updateBD("INSERT INTO Bookings(First_name,Last_name,Cell_phone,Id_Trip,Id_Seat, Price) "
                + "values('"+this.First_name+"', '"+this.Last_name+"',"+this.Cell_phone+", "+this.Id_Trip.getId_Trip()+","+this.Id_Seat.getSeat()+","+this.Price+")")>0)
            this.info = "Booking Completed !";
        else
            this.info = "Booking Failed !";
    }

    public int getId_Booking() {
        return Id_Booking;
    }

    public int getCell_phone() {
        return Cell_phone;
    }

    public int getPrice() {
        return Price;
    }

    public String getFirst_name() {
        return First_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public String getInfo() {
        return info;
    }

    public TripName getId_Trip() {
        return Id_Trip;
    }

    public Bus getId_Seat() {
        return Id_Seat;
    }

  
    
    
    
    
}
