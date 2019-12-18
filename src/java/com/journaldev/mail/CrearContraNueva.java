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
public class CrearContraNueva {
    public static void main(String[] args) {
        
        int numero;
        char[] cadena=new char[12];
        String frase ="";
        for(int i=0;i<12;i++){
            numero=(int) Math.floor(Math.random()*(133-97)+97);
            if(numero>=97 && numero<=122){
                cadena[i]=(char)numero;
                frase+=(char)numero;
            }else{
                cadena[i]=(char) (numero-75);
                 frase+=(char) (numero-75);
            }
        }
        String strin=cadena.toString();
        System.out.println(cadena);
        System.out.println(strin);
        System.out.println(frase);
        
    }
}
