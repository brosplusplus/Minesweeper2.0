
/**
 * MailSenderMessagingExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.bros.services.mailer;

public class MailSenderMessagingExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1421093750026L;
    
    private com.bros.services.mailer.MailSender.MailSenderMessagingException faultMessage;

    
        public MailSenderMessagingExceptionException() {
            super("MailSenderMessagingExceptionException");
        }

        public MailSenderMessagingExceptionException(java.lang.String s) {
           super(s);
        }

        public MailSenderMessagingExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public MailSenderMessagingExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.bros.services.mailer.MailSender.MailSenderMessagingException msg){
       faultMessage = msg;
    }
    
    public com.bros.services.mailer.MailSender.MailSenderMessagingException getFaultMessage(){
       return faultMessage;
    }
}
    