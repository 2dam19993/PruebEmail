package com.journaldev.mail;

import java.util.Properties;
import java.util.ResourceBundle;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


/**
 * Es el hilo que controla la petición del cliente.
 * It is the thread that controls the client’s request.
 * @author Ricardo Peinado Lastra
 */
public class EmailThread extends Thread{
    private Properties properties = new Properties();
    private static ResourceBundle configFile=ResourceBundle.getBundle("com.journaldev.mail.confEmail");
    private Session sesion;
    
    public EmailThread(String receptor,String asunto, String mensaje) throws MontajeMailException, EnviarMailException{
        rellenarPropiedades();
        verificarSesion();
        prepararMensaje(receptor,asunto,mensaje);
        
    }
    /**
     * Este metodo es el inicio de la ejecución del hilo.
     * This method is the start of thread execution.
     */
    public void run(){
        
    }
    
    private void rellenarPropiedades() {
        
        String host=configFile.getString("host");
        Integer port=Integer.parseInt(configFile.getString("port"));
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.ssl.trust", host);
        properties.put("mail.imap.partialfetch", false);
        properties.put("mail.smtp.ssl.enable", "false");
        properties.put("mail.smtp.auth", "true");
        
    }
    
    private void verificarSesion() {
        
        Authenticator autenticacion=new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(configFile.getString("user"), configFile.getString("password"));
            }
        };
        sesion = Session.getInstance(properties,autenticacion);
    }
    
    private void prepararMensaje(String receptor, String asunto, String mensaje) throws MontajeMailException, EnviarMailException {
        Message message=null;
        try{
            message = new MimeMessage(sesion);
            message.setFrom(new InternetAddress(configFile.getString("user")));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receptor));
            message.setSubject(asunto);
            
            Multipart multipart = new MimeMultipart();
            
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(mensaje, "text/html");
            multipart.addBodyPart(mimeBodyPart);
            
            message.setContent(multipart);
            
        }catch(Exception e){
            throw new MontajeMailException(e.getMessage());
        }
        try{
            Transport.send(message);
        }catch(Exception e){
            throw new EnviarMailException(e.getMessage());
        }
    }
}
