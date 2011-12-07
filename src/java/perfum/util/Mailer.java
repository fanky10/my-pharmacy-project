/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package perfum.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import perfum.config.Configuracion;

/**
 *
 * @author Fanky <fanky10@gmail.com>
 */
public class Mailer implements Serializable {

    private static final String MAIL_USER = "leperfumrosario@gmail.com";
    private static final String PASS = "grupojava";
    private static final String MAILER_CONFIGURATION_FILE="mailer.properties";

    public Mailer(){
        try{
            props = new Properties();
            String file_path = Configuracion.getRealPath()+MAILER_CONFIGURATION_FILE;
            props.load(new FileInputStream(file_path));
        }catch(IOException ex){//el sistema no tiene un archivo con las properties configuradas
//            props = System.getProperties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            //props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", MAIL_USER);
            props.setProperty("mail.smtp.auth", "true");
            session = Session.getDefaultInstance(props, null);
            //MyLogger.getLogger(Configuracion.class).fatal(ex);
            //System.exit(-1);
        }

        /*	Setting Properties for STMP host */
        
    }
    //sends a default Mail (to ourselves)
    public void sendMail() throws MessagingException {
        sendMail("leperfumrosario@gmail.com");
    }
    //sends a default Mail (to ourselves)
    public void sendMail(String recipient) throws MessagingException {//throws Exception {
//        if(!this.everythingIsSet())
//                throw new Exception("No se ha podido enviar el email, por favor intente nuevamente");
        MimeMessage mail_message = new MimeMessage(session);
        mail_message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(recipient));
        mail_message.setFrom(new InternetAddress("leperfumrosario@gmail.com"));
        mail_message.setSubject(this.subject);
        mail_message.setText(this.message);
        javax.mail.Transport t = session.getTransport("smtp");
         t.connect(MAIL_USER,PASS);
         t.sendMessage(mail_message,mail_message.getAllRecipients());
         t.close();
    }


//	suponemos que todo esta ok desde la parte de GUI (usuario) gracias a jscript
//    private boolean everythingIsSet() {
//
//            if((this.to == null) || (this.from == null) ||
//               (this.subject == null) || (this.message == null))
//                    return false;
//
//            if((this.to.indexOf("@") == -1) ||
//                    (this.to.indexOf(".") == -1))
//                    return false;
//
//            if((this.from.indexOf("@") == -1) ||
//                    (this.from.indexOf(".") == -1))
//                    return false;
//
//            return true;
//    }
    private String subject = null;
    private String message = null;

    public static Properties props = null;
    public static Session session = null;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
