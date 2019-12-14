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
public class MontajeMailException extends Exception {

    /**
     * Creates a new instance of <code>MontajeMailException</code> without
     * detail message.
     */
    public MontajeMailException() {
    }

    /**
     * Constructs an instance of <code>MontajeMailException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public MontajeMailException(String msg) {
        super(msg);
    }
}
