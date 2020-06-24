/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events;

import Models.Booking;
import Models.Bus;
import Models.Trip;
import Models.TripName;
import UI.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Paul_NIYUNGEKO
 */
public class BookingEvent implements ActionListener{

    private BookingUI get_BookingUI;
    
    public BookingEvent(BookingUI win){
        get_BookingUI = win;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        String First_name = get_BookingUI.getFirst_name().getText();
        String Last_name = get_BookingUI.getLast_name().getText();
        int Cell_phone = Integer.parseInt(get_BookingUI.getCell_phone().getText());
        int Price = Integer.parseInt(get_BookingUI.getPrice().getText());
        
        if(First_name.isEmpty() || First_name.equals(" ")){
            get_BookingUI.getIncorrect_first_name().setText("Invalid Name");
        }
        
        if(Last_name.isEmpty() || Last_name.equals(" ")){
            get_BookingUI.getIncorrect_last_name().setText("Invalid Last_name");
        }
        if(get_BookingUI.getTrip_bus().getSelectedItem().equals(null)){
            get_BookingUI.getIncorrect_trip().setText("Select at least one !");
        }
        if(get_BookingUI.getSeat().getSelectedItem().equals(null)){
            get_BookingUI.getIncorrect_seat().setText("Select at least one !");
        }
 
        
        else{
            Booking newBooking = new Booking(
                    First_name,
                    Last_name,
                    Cell_phone,
                    (TripName)get_BookingUI.getTrip_bus().getSelectedItem(),
                    (Bus)get_BookingUI.getSeat().getSelectedItem(),
                     Price);

            newBooking.AddBooking();
            JOptionPane.showMessageDialog(null,newBooking.getInfo());
            get_BookingUI.dispose();
            new AdminUI().setVisible(true);
    }
    
}

}
