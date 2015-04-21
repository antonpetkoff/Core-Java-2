package email.sender;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailSender {

    private String sender;
    private String reciever;
    private String password;
    private String hostName;
    private int smtpPort;
    private boolean isTLS;

    public EmailSender(String sender, String reciever, String password, String hostName, int smtpPort, boolean isTLS) {
        setSender(sender);
        setReciever(reciever);
        setPassword(password);
        setHostName(hostName);
        setSmtpPort(smtpPort);
        setTLS(isTLS);
    }
    
    public void sendEmail(String subject, String msg) {
        Email email = new SimpleEmail();
        email.setDebug(true);
        email.setStartTLSEnabled(isTLS);
        email.setHostName(hostName);
        email.setSmtpPort(smtpPort);
        System.out.println(email.getSmtpPort());
        email.setAuthenticator(new DefaultAuthenticator(sender, password));
        email.setSSLOnConnect(true);
        
        try {
            email.setFrom(sender);
            email.setSubject(subject);
            email.setMsg(msg);
            email.addTo(reciever);
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(int smtpPort) {
        this.smtpPort = smtpPort;
    }
   
    public boolean isTLS() {
        return isTLS;
    }

    public void setTLS(boolean isTLS) {
        this.isTLS = isTLS;
    }
    
    public static void main(String[] args) {
        EmailSender sender = new EmailSender("albundydummy@abv.bg", "groovyfunk@abv.bg", "741852963", "appssmtp.abv.bg", 465, true);
        String subject = "V rusiq sym, v rusiq sym";
        String msg = "Iztekoha ti limonadite. Lelq Conka pristigna v dvoreca.";
        sender.sendEmail(subject, msg);
    }
    
}
