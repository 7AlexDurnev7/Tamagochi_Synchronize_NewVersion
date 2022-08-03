package com.company;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TamagochiSerializationTest {

    static Tamagochi tamagochi = null; // the tamagochi to test
    static TamagochiSerialization tam = null; // sterilizer for testing
    static String fileName = null; // associated file

    @BeforeAll
    public static void setUpClass() {
        tamagochi = new Tamagochi(0, 100, 100, 100, 0);
        fileName = "tam Test.txt";
    }

    @BeforeEach
    public void setUp() {
        tam = new TamagochiSerialization(fileName);
    }

    public void tearDown() {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void serialize() {
        // 1 check the efficiency
        TamagochiSerialization.serialize(tamagochi);
        // 2. check the correctness of serialization through deserialization
        Tamagochi deserialized = null;
        // doing deserialization
        deserialized = TamagochiSerialization.deserialization();
        fail();

        assertNotNull(deserialized);    // не null
        assertEquals(tamagochi.getAge(), deserialized.getAge());
        assertEquals(tamagochi.getHealth(), deserialized.getHealth());
        assertEquals(tamagochi.getSatiety(), deserialized.getSatiety());
        assertEquals(tamagochi.getClean(), deserialized.getClean());
        assertEquals(tamagochi.getBonus(), deserialized.getBonus());
    }

    @Test
    void deserialization() {
        Tamagochi tamagochi = TamagochiSerialization.deserialization();

    }
}