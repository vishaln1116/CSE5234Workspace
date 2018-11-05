
package com.chase.payment;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PaymentProcessorDelegate", targetNamespace = "http://payment.chase.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PaymentProcessorDelegate {


    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "ping", targetNamespace = "http://payment.chase.com/", className = "com.chase.payment.Ping")
    @ResponseWrapper(localName = "pingResponse", targetNamespace = "http://payment.chase.com/", className = "com.chase.payment.PingResponse")
    @Action(input = "http://payment.chase.com/PaymentProcessorDelegate/pingRequest", output = "http://payment.chase.com/PaymentProcessorDelegate/pingResponse")
    public String ping();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "processPayment", targetNamespace = "http://payment.chase.com/", className = "com.chase.payment.ProcessPayment")
    @ResponseWrapper(localName = "processPaymentResponse", targetNamespace = "http://payment.chase.com/", className = "com.chase.payment.ProcessPaymentResponse")
    @Action(input = "http://payment.chase.com/PaymentProcessorDelegate/processPaymentRequest", output = "http://payment.chase.com/PaymentProcessorDelegate/processPaymentResponse")
    public String processPayment(
        @WebParam(name = "arg0", targetNamespace = "")
        CreditCardPayment arg0);

}
