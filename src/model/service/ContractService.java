package model.service;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

    private OnlinePaymentService service;

    public ContractService(OnlinePaymentService service) {
        this.service = service;
    }

    public void processContract(Contract contract, int months) {
        for (int i = 1; i <= months; i++) {
            Double basicQuota = contract.getTotalValue() / months;
            Double interest = service.interest(basicQuota, i);
            Double fee = service.paymentFee(basicQuota + interest);
            Double quota = basicQuota + interest + fee;
            LocalDate dueDate = contract.getDate().plusMonths(i);
            contract.addInstallment(new Installment(dueDate, quota));
        }
    }
}
