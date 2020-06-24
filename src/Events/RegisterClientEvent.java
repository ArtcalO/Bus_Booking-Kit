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
import javax.swing.JOptionPane;

/**
 *
 * @author Paul_NIYUNGEKO
 */
public class RegisterClientEvent implements ActionListener {

    private RegisterUI get_registerUI;
    public RegisterClientEvent(RegisterUI win){
        get_registerUI = win;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
       String username = get_registerUI.getUsername_register().getText();
       String first_name = get_registerUI.getNom_register().getText();
       String last_name = get_registerUI.getPrenom_register().getText();
       String password = get_registerUI.getPassword_register().getText();
       
       if(username.isEmpty() || username.equals(" ")){
           get_registerUI.getIncorrect_username1().setText("Incorect Username");
       }
       if(first_name.isEmpty() || first_name.equals(" ")){
           get_registerUI.getIncorrect_name().setText("First name Required !");
       }
       if(last_name.isEmpty() || last_name.equals(" ")){
           get_registerUI.getIncorrect_lastName().setText("Last name Required !");
       }
       if(password.isEmpty() || password.equals(" ")){
           get_registerUI.getIncorrect_password().setText("Last name Required !");
       }
       else{
           get_registerUI.getIncorrect_username1().setText(null);
           get_registerUI.getIncorrect_name().setText(null);
           get_registerUI.getIncorrect_lastName().setText(null);
           get_registerUI.getIncorrect_password().setText(null);
           RegisterClient newClient = new RegisterClient(username, first_name, last_name, password);
           newClient.RegisterClient();
           JOptionPane.showMessageDialog(null, newClient.getInfo());
           get_registerUI.dispose();
           new BookingUI().setVisible(true);
       }
       
       
    }
    
}
