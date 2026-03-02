package com.example;
public class App {

    /**
     * Calculates the gross salary.
     *
     * @param baseSalary Base salary of the employee
     * @param bonus Additional bonus amount
     * @return Gross salary (base + bonus)
     */
    public static double calculateGrossSalary(double baseSalary, double bonus) {
        validateNonNegative(baseSalary, "Base salary");
        validateNonNegative(bonus, "Bonus");

        return baseSalary + bonus;
    }

    /**
     * Calculates tax amount based on gross salary and tax rate.
     *
     * @param grossSalary Gross salary amount
     * @param taxRate Tax rate as decimal (e.g., 0.20 for 20%)
     * @return Calculated tax amount
     */
    public static double calculateTax(double grossSalary, double taxRate) {
        validateNonNegative(grossSalary, "Gross salary");
        validateTaxRate(taxRate);

        return grossSalary * taxRate;
    }

    /**
     * Calculates net salary after deducting tax.
     *
     * @param baseSalary Base salary
     * @param bonus Bonus amount
     * @param taxRate Tax rate as decimal
     * @return Net salary
     */
    public static double calculateNetSalary(double baseSalary, double bonus, double taxRate) {
        double grossSalary = calculateGrossSalary(baseSalary, bonus);
        double tax = calculateTax(grossSalary, taxRate);
        return grossSalary - tax;
    }

    private static void validateNonNegative(double value, String fieldName) {
        if (value < 0) {
            throw new IllegalArgumentException(fieldName + " cannot be negative.");
        }
    }

    private static void validateTaxRate(double taxRate) {
        if (taxRate < 0 || taxRate > 1) {
            throw new IllegalArgumentException("Tax rate must be between 0 and 1.");
        }
    }

    public static void main(String[] args) {
        double baseSalary = 50000;
        double bonus = 5000;
        double taxRate = 0.20;

        double netSalary = calculateNetSalary(baseSalary, bonus, taxRate);

        System.out.println("Net Salary: " + netSalary);
    }
}
