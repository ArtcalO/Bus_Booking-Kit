/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events;

import Models.TripName;
import UI.BookingUI;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author Paul_NIYUNGEKO
 */
public class BookingTripNameChangeEvent implements ItemListener {

    private BookingUI get_win;
    
    public BookingTripNameChangeEvent(BookingUI win){
        get_win = win;
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        TripName tp = new TripName(get_win.getTrip_bus().getSelectedItem().toString());
        if(tp!=null){
            tp.printBusSeatForTripName(get_win.getSeat());
        }
    }
    
}
