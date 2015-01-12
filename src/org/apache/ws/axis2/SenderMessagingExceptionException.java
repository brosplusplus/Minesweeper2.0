
/**
 * SenderMessagingExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package org.apache.ws.axis2;

public class SenderMessagingExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1421080127021L;
    
    private org.apache.ws.axis2.SenderStub.SenderMessagingException faultMessage;

    
        public SenderMessagingExceptionException() {
            super("SenderMessagingExceptionException");
        }

        public SenderMessagingExceptionException(java.lang.String s) {
           super(s);
        }

        public SenderMessagingExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public SenderMessagingExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(org.apache.ws.axis2.SenderStub.SenderMessagingException msg){
       faultMessage = msg;
    }
    
    public org.apache.ws.axis2.SenderStub.SenderMessagingException getFaultMessage(){
       return faultMessage;
    }
}
    