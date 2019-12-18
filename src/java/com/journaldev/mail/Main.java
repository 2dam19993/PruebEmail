/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.journaldev.mail;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author Usuario
 */
public class Main {
    public static void main(String[] args) {
        for(int i=0;i<1;i++){
            //public EmailThread(String receptor,String asunto, String mensaje) throws MontajeMailException, EnviarMailException{
            
            EmailThread emailT;
            try {
                emailT = new EmailThread("2dam19993@gmail.com","pruebas PSP","Que tal hoy?? PERCY!");
                emailT.start();
            } catch (MontajeMailException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (EnviarMailException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            
        }
    }
}
