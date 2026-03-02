package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void testCalculateGrossSalary() {
        double gross = App.calculateGrossSalary(50000, 5000);
        assertEquals(55000, gross, 0.0001);
    }

    @Test
    void testCalculateTax() {
        double tax = App.calculateTax(55000, 0.20);
        assertEquals(11000, tax, 0.0001);
    }

    @Test
    void testCalculateNetSalary() {
        double net = App.calculateNetSalary(50000, 5000, 0.20);
        assertEquals(44000, net, 0.0001);
    }

    @Test
    void testNegativeBaseSalaryThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            App.calculateGrossSalary(-50000, 5000);
        });
    }

    @Test
    void testInvalidTaxRateThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            App.calculateTax(50000, 1.5);
        });
    }
}