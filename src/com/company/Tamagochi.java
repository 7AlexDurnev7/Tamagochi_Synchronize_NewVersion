package com.company;

import java.io.Serializable;

// Class "Tamagotchi"
public class Tamagochi implements Serializable {

    // Fields
    private int age; // возраст
    private int health; // здоровье
    private int satiety; // сытость
    private int clean; // чистота
    private int bonus; // награда за действия

    // empty constructor
    public Tamagochi() {
        this.age = 0;
        this.health = 100;
        this.satiety = 100;
        this.clean = 100;
        this.bonus = 0;
    }

    // constructor with parameters
    public Tamagochi (int age, int health, int satiety, int clean, int bonus) {
        this.age = age;
        this.health = health;
        this.satiety = satiety;
        this.clean = clean;
        this.bonus = bonus;
    }

    // Getters
    public int getAge() {
        return age;
    }
    public int getHealth() {
        return health;
    }
    public int getSatiety() {
        return satiety;
    }
    public int getClean() {
        return clean;
    }
    public int getBonus() {
        return bonus;
    }

    // Setters
    public void setAge(int age) {
        this.age = age;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }
    public void setClean(int clean) {
        this.clean = clean;
    }
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    // Method to play the game
    public void play() {
        if (isAlive()) {
            health -= 10;
            clean -= 10;
            satiety -= 10;
            bonus += 1;
        } else
            System.out.println("Tamagotchi died");
//            age++;
    }

    // Method goes to the bed
    public void goToSleep() {
        if(isAlive()) {
            health = 100;
            clean -= 10;
            satiety = 100;
            bonus += 1;
            age++;
        } else
            System.out.println("Tamagotchi died");
    }

    // Method to feed Tamagotchi
    public void feed(){
        if(isAlive()) {
            health = 100;
            clean -= 10;
            satiety = 100;
            bonus += 1;
        }else
            System.out.println("Tamagotchi died");
    }

    // Method to wash Tamagotchi
    public void takeAShower() {
        if(isAlive()) {
            health -= 10;
            clean = 100;
            satiety -= 10;
            bonus += 1;
        } else
            System.out.println("Tamagotchi died");
    }

    // Method to check alive my tamagochi or no
    public boolean isAlive() {
        return health >= 10 || satiety >= 10;
    }

    @Override
    public String toString () {
        return "Tamagotchi's health " + health + "% , he is satiety on " + satiety
                + "% , he clean on " + clean + "% , his age = " + age + " bonus = " + bonus;
    }

} // Class "Tamagotchi" - end
