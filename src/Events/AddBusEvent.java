/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events;

import Models.*;
import Models.Bus;
import UI.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Paul_NIYUNGEKO
 */
public class AddBusEvent implements ActionListener{

    private AdminAddBusUI get_BusUI;
    
    public AddBusEvent(AdminAddBusUI win){
        get_BusUI = win;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String Imatriculation = get_BusUI.getPlaque().getText();
        String Mark = get_BusUI.getMark().getText();
        int Seat = Integer.parseInt(get_BusUI.getSeat().getSelectedItem().toString());
        
        if(Imatriculation.equals("") && Imatriculation.isEmpty()){
            get_BusUI.getIncorect_imatriculation().setText("Invalid plaque");
        }
        if(Mark.endsWith("") && Mark.isEmpty()){
            get_BusUI.getIncorrect_mark().setText("Invalid Mark");
        }
        else{
            get_BusUI.getIncorect_imatriculation().setText(null);
            get_BusUI.getIncorrect_mark().setText(null);
            get_BusUI.getIncorrect_driver_id().setText(null);
            Bus newBus = new Bus(Imatriculation, Mark, Seat);
            newBus.AddBus();
            JOptionPane.showMessageDialog(null, newBus.getInfo());
            get_BusUI.dispose();
            new AdminUI().setVisible(true);
        }
        
        
    }
    
}
