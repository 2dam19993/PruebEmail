/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.journaldev.mail;

/**
 *
 * @author Usuario
 */
public class Util {
    /**
     * Comprobación del formato del Email.
     * Verification of the email format.
     * @param email El propio email. / The current email.
     * @return  True si el email es correcto | False en los demas casos /
     * True if correct | False in the other cases.
     */
    private  boolean esEmail(String email) {
        boolean resu=true;
        String firstPart,secondPart,thirdPart;
        if(email.length()<5 || email.length()>40){
            resu=false;
        }else{
            try{
                firstPart=email.substring(0, email.indexOf('@'));
                secondPart=email.substring(email.indexOf('@')+1,email.indexOf('.', email.indexOf('@')));
                thirdPart=email.substring(email.indexOf('.',email.indexOf('.', email.indexOf('@')))+1);
                if(!isEmailFirstPart(firstPart) || !isEmailSecondPart(secondPart) || !isEmailThridPart(thirdPart))
                    resu=false;
            }catch(StringIndexOutOfBoundsException e){
                resu=false;
            }
        }
        return resu;
    }
    /**
     * Comprobar primera parte del email (anterior al "@").
     * Check first part of email (before the ".").
     * @param cadena. El trozo de email | The email part.
     * @return True si esta correcto |False en todo los demás casos. / True if 
     * correct | False in all other cases.
     */
    private  boolean isEmailFirstPart(String cadena) {
        boolean resu=true;
        for(int i=0;i<cadena.length();i++){
            if(!Character.isAlphabetic(cadena.charAt(i)) && !Character.isDigit(cadena.charAt(i)) && cadena.charAt(i)!='.' && cadena.charAt(i)!='-' && cadena.charAt(i)!='_'){
                resu=false;
                break;
            }
        }
        return resu;
    }
    /**
     * Comprobar segunda parte del email (despues del "@" y antes del punto).
     * Check second part of email (After the "@" and before the ".").
     * @param cadena. El trozo de email | The email part.
     * @return True si esta correcto |False en todo los demás casos. / True if 
     * correct | False in all other cases.
     */
    private  boolean isEmailSecondPart(String cadena) {
        boolean resu=true;
        for(int i=0;i<cadena.length();i++){
            if(!Character.isAlphabetic(cadena.charAt(i)) && !Character.isDigit(cadena.charAt(i)) && cadena.charAt(i)!='-'){
                resu=false;
                break;
            }
        }
        return resu;
    }
    /**
     * Comprobar tercera parte del email (despues del ".").
     * Check third part of email (After the ".")
     * @param cadena. El trozo de email | The email part.
     * @return True si esta correcto |False en todo los demás casos. / True if 
     * correct | False in all other cases.
     */
    private  boolean isEmailThridPart(String cadena) {
        boolean resu=true;
        for(int i=0;i<cadena.length();i++){
            if(!Character.isAlphabetic(cadena.charAt(i)) && !Character.isDigit(cadena.charAt(i))){
                resu=false;
                break;
            }
        }
        return resu;
    }
    
}
