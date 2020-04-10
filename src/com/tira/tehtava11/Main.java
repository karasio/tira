package com.tira.tehtava11;

public class Main {
    public static void main(String[] args) {


        char select;
        BinarySearch binarySearch = new BinarySearch();
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
