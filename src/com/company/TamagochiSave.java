package com.company;

public class TamagochiSave extends Thread {

    // Fields
    private final String fileName; // the name of the file associated with this synchronizer
    private Tamagochi tamagotchi;  // tamagotchi field
    private final int timeInterval; // time interval to wait syncing

    public TamagochiSave (Tamagochi tamagotchi, String fileName, int timeInterval) {
        this.tamagotchi = tamagotchi;
        this.fileName = fileName;
        this.timeInterval = timeInterval;
    }

    // Getter
    public Tamagochi getTamagotchi() {
        return tamagotchi;
    }

    // Method to launch sync
    public void run() {
        // The main cycle background task
        while (true) {
            // 1. Write information in file
            TamagochiSerialization.serialize(tamagotchi);
            //System.out.println("Data is synchronized");
            try {
                Thread.sleep(timeInterval);
            } catch (InterruptedException ex) {
                System.out.println("An error occurred during sleep: " + ex.getMessage());
                interrupt();
            }
            if(isInterrupted()) {
                TamagochiSerialization.serialize(tamagotchi);
                System.out.println("Synchronizer stopped.");
                break;
            }
        }
    }
}
