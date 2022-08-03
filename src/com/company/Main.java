package com.company;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static Tamagochi checkExists(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            return new Tamagochi ();
        }
        return TamagochiSerialization.deserialization();
    }

    public static void main(String[] args) throws InterruptedException {

        String select;
        Scanner in = new Scanner(System.in);
//        Tamagochi tam = new Tamagochi();

        Tamagochi tam = TamagochiSerialization.deserialization();

        TamagochiSave tamagochiSave = new TamagochiSave
                (checkExists("Tamagoch.txt"), "Tamagoch.txt", 3000);

        //Tamagochi tam = TamagochiSynchronizer.deserialization();


        // Create new object "tamagotchi"
//       TamagochiSynchronizer tamagochi =
//               new TamagochiSynchronizer(tam,"Tamagochi.txt", 3000);

        // additional thread by daemon
        tamagochiSave.setDaemon(true);

        // Create tamagotchi
         tam = tamagochiSave.getTamagotchi();

        // launch synchronizer in a separate thread
        tamagochiSave.start();

        // Create CLI
        label:
        while(true) {
            System.out.println("1 - Create new Pet ");
            System.out.println("2 - Show your pet");
            System.out.println("3 - Play with your pet");
            System.out.println("4 - Feed your pet");
            System.out.println("5 - Wash your pet");
            System.out.println("6 - Go to the bed");
            System.out.println("0 - Exit");
            select = in.nextLine();
            switch(select) {
                case "1":
                    tam = new Tamagochi();
                    System.out.println(tam);
                    break;
                case "2":
                    System.out.println(tam);
                    break;
                case "3":
                    tam.play();
                    System.out.println(tam);
                    break;
                case "4":
                    tam.feed();
                    System.out.println(tam);
                    break;
                case "5":
                    tam.takeAShower();
                    System.out.println(tam);
                    break;
                case "6":
                    tam.goToSleep();
                    System.out.println(tam);
                case "0":
                    System.out.println("Goodbye");
                    break label;
            } // switch
        } // while

        in.close();// close scanner

        tamagochiSave.interrupt(); // interrupting a separate synchronization thread

        tamagochiSave.join(); // waiting for the self-completion of the thread

        System.out.println("Sub thread stopped, all data saved"); // thread has ended, the data is saved
    } // main

} // Main
