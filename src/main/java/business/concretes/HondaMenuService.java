package business.concretes;

import business.abstracts.MenuService;
import core.helpers.Slow;
import entities.concretes.Honda;

import java.util.Scanner;

public class HondaMenuService extends MenuService {

    Scanner inp = new Scanner(System.in);

    ReservationManager reservationManager = new ReservationManager();

    CustomersManager customersManager = new CustomersManager();
    Honda honda = new Honda();

    public void hondaMenu(){
        honda.fillHondaList();
        String select;
        honda.showHondaCars();
        System.out.println("========================");
        System.out.println("Rezervasyon işlemini bitirmek için 'Q', devam etmek için herhangi bir tuşa basınız");
        select = inp.nextLine();
        if (select.equalsIgnoreCase("Q")){
            getSelectionMenu();
        }
        System.out.println("Lütfen kiralamak istediğiniz arabanın kodunu giriniz");
        search();
        String s ="Müşreti kayıt menüsüne yönlendiriliyorsunuz...\n";
        Slow.slowPrint(s,30);
        customersManager.register();
    }


    @Override
    public void search() {
        int flag = 0;
        String id;

        do {
            id = inp.nextLine();
            for (Honda w:honda.hondaList){

                if (w.getId().equals(id)){
                    System.out.printf("%-7s  %-10s  %-10s  %-10s  %-14s  %-10s %-15s\n","Marka","Model","ID","Model Yılı","Otomatik Vites","Yakıt Tipi","Günlük Fiyat");
                    System.out.printf("%-7s  %-10s  %-10s  %-10s  %-14s  %-10s %-15s\n","-----","-----","--","----------","--------------","----------","------------");
                    System.out.printf("%-7s  %-10s  %-10s  %-10s  %-14s  %-10s $%-14s\n","Honda",w.getModel(),w.getId(),w.getModelYear(),w.isGear(),w.getFuelType(),w.getDailyPrice());
                    reservationManager.reservertCars.add(w);
                    honda.hondaList.remove(w);
                    flag++;
                    break;
                }

            }

            if (flag==0){
                System.out.println("Girlen kodla eşleşen araç bulunamadı!");
            }else {
                System.out.println("Başarıyla kaydolmuştur");
                break;
            }

        }while (true);



    }


}
