package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TamagochiTest {

    static Tamagochi tam = null;

    @BeforeEach
    public void createTam() {
        tam = new Tamagochi(0, 100, 100, 100, 0);
    }

    @Test
    void play() {
        tam.play();
        assertEquals(0, tam.getAge());
        assertEquals(90, tam.getHealth());
        assertEquals(90, tam.getSatiety());
        assertEquals(90, tam.getClean());
        assertEquals(1, tam.getBonus());
    }

    @Test
    void goToSleep() {
        tam.goToSleep();
        assertEquals(1, tam.getAge());
        assertEquals(100, tam.getHealth());
        assertEquals(100, tam.getSatiety());
        assertEquals(90, tam.getClean());
        assertEquals(1, tam.getBonus());
    }

    @Test
    void feed() {
        tam.feed();
        assertEquals(100, tam.getHealth()); // health
        assertEquals(90, tam.getClean()); // clean
        assertEquals(100, tam.getSatiety()); // satiete
        assertEquals(1, tam.getBonus()); // bonus
    }

    @Test
    void takeAShower() {
        tam.takeAShower();
        assertEquals(90, tam.getHealth());
        assertEquals(100, tam.getClean());
        assertEquals(90, tam.getSatiety());
        assertEquals(1, tam.getBonus());
    }

    @Test
    void isAlive() {
        tam.isAlive();
        assertEquals(10 , 10);
        assertEquals(10, 10);
    }
}