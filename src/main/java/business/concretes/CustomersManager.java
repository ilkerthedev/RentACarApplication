package business.concretes;

import core.helpers.IdMaker;
import core.helpers.Slow;
import core.validations.AgeValidator;
import core.validations.IdValidator;
import core.validations.NameValidator;
import entities.concretes.Customers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomersManager implements IdMaker {

    public static int counter = 1000;

    Customers customers = new Customers();

    //Validations
    AgeValidator ageValidator = new AgeValidator();
    IdValidator idValidator = new IdValidator();
    NameValidator nameValidator = new NameValidator();

    Scanner inp = new Scanner(System.in);

    public List<Customers> registeredCustomerList = new ArrayList<>();

    public void register(){
        System.out.println("Müşteri kayıt bölümüne hoşgeldiniz !");
        System.out.println("====================================");
        System.out.println("Lütfen adınızı giriniz: ");
        customers.setFirstName(nameValidator.isValidFirstName());
        System.out.println("Lütfen soyadınızı giriniz: ");
        customers.setLastName(nameValidator.isValidLastName());
        System.out.println("Lütfen yaşınızı giriniz: ");
        customers.setAge(ageValidator.isValidAge());
        System.out.println("Lütfen kimlik numaranızı giriniz: ");
        customers.setTcNo(idValidator.isValid());

        customers.setId(idMaker(customers.getTcNo()));
        addCustomer();
        counter++;
        System.out.println("Başarıyla eklenmiştir...");
        String s ="Rezervasyon onay bölümüne yönlendiriliyorsunuz...\n";
        Slow.slowPrint(s,30);
    }

    public void addCustomer(){
        Customers customers1 = new Customers(customers.getTcNo(),customers.getAge(),customers.getId(),customers.getFirstName(),customers.getLastName());
    }

    @Override
    public String idMaker(String number) {
        String suffix= "CUST";

        number = number.substring(number.length()-3);

        return suffix+number+counter;

    }
}
