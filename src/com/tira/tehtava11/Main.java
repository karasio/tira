package com.tira.tehtava11;

public class Main {
    static BinarySearch binarySearch = new BinarySearch();

    public static void main(String[] args) {
        //printMenu();
        demoPrinting();


    }

    public static void demoPrinting() {
        System.out.println("Esitäytetty aineisto:");
        binarySearch.print();
        System.out.println("---------------------------");

        System.out.println("Etsitään pienin: 1");
        binarySearch.searchHelp(1);
        System.out.println("---------------------------");


        System.out.println("Etsitään suurin: 78");
        binarySearch.searchHelp(78);
        System.out.println("---------------------------");


        System.out.println("Etsitään jotain siltä väliltä: 26");
        binarySearch.searchHelp(26);
        System.out.println("---------------------------");


        System.out.println("Lisätään 22");
        binarySearch.insertHelp(22);
        System.out.println("Aineisto nyt:");
        binarySearch.print();
        System.out.println("---------------------------");


        System.out.println("Etsitään pienin: 1");
        binarySearch.searchHelp(1);
        System.out.println("---------------------------");

        System.out.println("Etsitään suurin: 78");
        binarySearch.searchHelp(78);
        System.out.println("---------------------------");

        System.out.println("Etsitään jotain siltä väliltä: 67");
        binarySearch.searchHelp(67);


    }

    public static void printMenu() {
        char select;
        int data;
        do {
            System.out.print("\t\t\t1. Lisää avaimella");
            System.out.print("\t\t\t2. Etsi avaimella.");
            System.out.print("\t\t\t3. Tulosta lista");
            System.out.println("\t\t\t4. lopetus ");
            select = Lue.merkki();
            switch (select) {
                case '1':
                    System.out.println("Anna uusi avain (merkkijono)");
                    data = Lue.kluku();
                    binarySearch.insertHelp(data);

                    break;
                case '2':
                    System.out.println("Anna etsittävä avain (merkkijono)");
                    data = Lue.kluku();
                    binarySearch.searchHelp(data);
                    break;
                case '3':
                    binarySearch.print();
                    break;
                default:
                    break;
            }
        }
        while (select != '4');
    }
}
