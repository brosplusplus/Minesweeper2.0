
/**
 * SenderAddressExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package org.apache.ws.axis2;

public class SenderAddressExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1421080127034L;
    
    private org.apache.ws.axis2.SenderStub.SenderAddressException faultMessage;

    
        public SenderAddressExceptionException() {
            super("SenderAddressExceptionException");
        }

        public SenderAddressExceptionException(java.lang.String s) {
           super(s);
        }

        public SenderAddressExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public SenderAddressExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(org.apache.ws.axis2.SenderStub.SenderAddressException msg){
       faultMessage = msg;
    }
    
    public org.apache.ws.axis2.SenderStub.SenderAddressException getFaultMessage(){
       return faultMessage;
    }
}
    