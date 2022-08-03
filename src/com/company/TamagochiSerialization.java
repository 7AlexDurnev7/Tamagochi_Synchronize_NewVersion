package com.company;

import java.io.*;

public class TamagochiSerialization {

    private final String fileName;

    public TamagochiSerialization(String fileName) {
        this.fileName = fileName;
    }

    // Method to serialization game
    public static void serialize(Tamagochi tam) {
        try (FileOutputStream fos = new FileOutputStream("Tamagoch.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(tam);
//            System.out.println("Data is synchronized");
        } catch (IOException ex) {
            System.out.println("Exception " + ex);
        }
    }

    // Method to deserialization game
    public static Tamagochi  deserialization() {
        try(FileInputStream fis = new FileInputStream("Tamagoch.txt");
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (Tamagochi) ois.readObject();
        } catch (IOException ex) {
            System.out.println("Exception " + ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Deserialization exception: " + ex);
        }
        return null;
    }
}
