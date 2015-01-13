
/**
 * MailSenderAddressExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.bros.services.mailer;

public class MailSenderAddressExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1421144113230L;
    
    private com.bros.services.mailer.MailSenderStub.MailSenderAddressException faultMessage;

    
        public MailSenderAddressExceptionException() {
            super("MailSenderAddressExceptionException");
        }

        public MailSenderAddressExceptionException(java.lang.String s) {
           super(s);
        }

        public MailSenderAddressExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public MailSenderAddressExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.bros.services.mailer.MailSenderStub.MailSenderAddressException msg){
       faultMessage = msg;
    }
    
    public com.bros.services.mailer.MailSenderStub.MailSenderAddressException getFaultMessage(){
       return faultMessage;
    }
}
    