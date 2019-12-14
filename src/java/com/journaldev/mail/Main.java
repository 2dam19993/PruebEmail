/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.journaldev.mail;

import javax.mail.MessagingException;

/**
 *
 * @author Usuario
 */
public class Main {
    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            //public EmailThread(String receptor,String asunto, String mensaje) throws MontajeMailException, EnviarMailException{
            try{
                EmailThread emailT=new EmailThread("2dam19993@gmail.com","pruebas PSP","Que tal hoy??");
                emailT.start();
            }catch(Exception e){
                
            }
        }
    }
}
