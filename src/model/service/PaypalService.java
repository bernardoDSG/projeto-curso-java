package model.service;

public class PaypalService implements OnlinePaymentService {

    @Override
    public Double interest(Double amount, Integer months) {
        Double interest = amount * 0.01 * months;
        return interest;
    }

    @Override
    public Double paymentFee(Double amount) {
        Double paymentFee = amount * 0.02;
        return paymentFee;
    }
    
}
