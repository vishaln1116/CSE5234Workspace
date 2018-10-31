import javax.jws.WebService;


@WebService (targetNamespace="http://defaultpackage/", serviceName="PaymentProcessorService", portName="PaymentProcessorPort")
public class {

    com.chase.payment.PaymentProcessor _paymentProcessor = null;

    public String ping () {
        return _paymentProcessor.ping();
    }

    public String processPayment (CreditCardPayment info) {
        return _paymentProcessor.processPayment(info);
    }

    public () {
        _paymentProcessor = new com.chase.payment.PaymentProcessor(); }

}