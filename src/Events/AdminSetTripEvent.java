/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events;

import Models.*;
import UI.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Paul_NIYUNGEKO
 */
public class AdminSetTripEvent implements ActionListener{

    private AdminPlanTripUI get_PlanTripUI;
    public AdminSetTripEvent(AdminPlanTripUI win){
        get_PlanTripUI = win;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       
        Trip newTrip = new Trip((Bus)get_PlanTripUI.getId_bus().getSelectedItem(),
                (Driver)get_PlanTripUI.getId_driver().getSelectedItem(),
                (Location)get_PlanTripUI.getDeppart().getSelectedItem(),
                (Location)get_PlanTripUI.getArrival().getSelectedItem(),
                get_PlanTripUI.getDep_hour().getSelectedItem().toString())
                ;
        newTrip.PlanTrip();
        JOptionPane.showMessageDialog(null, newTrip.getInfo());
        get_PlanTripUI.dispose();
        new AdminUI().setVisible(true);
        
        
    }
    
}
