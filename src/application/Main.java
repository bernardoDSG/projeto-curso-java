package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.service.ContractService;
import model.service.PaypalService;

public class Main {
    
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Entre os dados do contrato:");
        System.out.print("Número: ");
        int number = sc.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("Valor do contrato: ");
        double totalValue = sc.nextDouble();
        Contract contract = new Contract(number, date, totalValue);
        System.out.print("Entre com o número de parcelas: ");
        int numberInstallments = sc.nextInt();
        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract, numberInstallments);
        System.out.println("Parcelas:");
        contract.printInstallments();
        sc.close();

    }




}
