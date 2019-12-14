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
public class EnviarMailException extends Exception {

    /**
     * Creates a new instance of <code>EnviarMensajeException</code> without
     * detail message.
     */
    public EnviarMailException() {
    }

    /**
     * Constructs an instance of <code>EnviarMensajeException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public EnviarMailException(String msg) {
        super(msg);
    }
}
