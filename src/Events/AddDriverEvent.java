/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events;

import UI.*;
import Models.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Paul_NIYUNGEKO
 */
public class AddDriverEvent implements ActionListener {
    
    private AdminAddDriverUI get_DriverUI;
    public AddDriverEvent(AdminAddDriverUI win){
        get_DriverUI = win;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String First_name = get_DriverUI.getFirst_name().getText();
        String Last_name = get_DriverUI.getLast_name().getText();
        int Cell_phone = Integer.parseInt(get_DriverUI.getCell_phone().getText());
        String Licence = get_DriverUI.getLicence().getText();
        String CNI = get_DriverUI.getCni().getText();
        


        if(First_name.isEmpty() || First_name.equals(" ")){
            get_DriverUI.getIncorrect_first_name().setText("Invalid Name");
        }
        if(Last_name.isEmpty() || Last_name.equals(" ")){
            get_DriverUI.getIncorrect_last_name().setText("Invalid Last_name");
        }
 
        if(Licence.isEmpty() || Licence.equals(" ")){
            get_DriverUI.getIncorrect_licence().setText("Invalid Licence");
        }
        if(CNI.isEmpty() || CNI.equals(" ")){
            get_DriverUI.getIncorrect_cni().setText("Invalid CNI");
        }
        else{
            get_DriverUI.getIncorrect_cell_phone().setText(null);
            Driver newDriver = new Driver(First_name, Last_name, Cell_phone, Licence, CNI);
            newDriver.AddDriver();
            JOptionPane.showMessageDialog(null, newDriver.getInfo());
            get_DriverUI.dispose();
            new AdminUI().setVisible(true);
            
        }
    }
    
    
    
}
