
/**
 * MailSenderCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.bros.services.mailer;

    /**
     *  MailSenderCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class MailSenderCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public MailSenderCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public MailSenderCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getName method
            * override this method for handling normal response from getName operation
            */
           public void receiveResultgetName(
                    com.bros.services.mailer.MailSender.GetNameResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getName operation
           */
            public void receiveErrorgetName(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for sendMail method
            * override this method for handling normal response from sendMail operation
            */
           public void receiveResultsendMail(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from sendMail operation
           */
            public void receiveErrorsendMail(java.lang.Exception e) {
            }
                


    }
    