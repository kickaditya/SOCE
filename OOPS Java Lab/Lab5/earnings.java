/*
 * Define an interface with three methods – earnings(), deductions() and bonus() and define a Java class ‘Manager’ which uses this interface without implementing bonus() method.
 * Also define another Java class ‘Substaff’ which extends from ‘Manager’ class and implements bonus() method.
 * Write the complete program to find out earnings, deduction and bonus of a sbstaff with basic salary amount entered by the user as per the following guidelines – 
 * earnings -> basic + DA (80% of basic) + HRA (15% of basic)
 * deduction PF -> 12% of basic
 * bonus -> 50% of basic
 * Input -Basic salary - 50000
 * Output -Earnings - 97500
 * Deduction -6000
 * Bonus - 25000
 * Take user input for basic salary
 */

import java.util.Scanner;

interface Salary {
    double earnings(double basic);
    double deductions(double basic);
    void bonus(double basic);
}

abstract class Manager implements Salary {
    @Override
    public double earnings(double basic) {
        return basic + (0.8 * basic) + (0.15 * basic);
    }

    @Override
    public double deductions(double basic) {
        return 0.12 * basic;
    }
}

class Substaff extends Manager {
    @Override
    public void bonus(double basic) {
        System.out.println("Bonus: " + (0.5 * basic));
    }
}

public class earnings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter basic salary: ");
        double basic = scanner.nextDouble();

        Substaff substaff = new Substaff();
        double earnings = substaff.earnings(basic);
        double deductions = substaff.deductions(basic);

        System.out.println("Earnings: " + earnings);
        System.out.println("Deductions: " + deductions);
        substaff.bonus(basic);

        scanner.close();
    }
}