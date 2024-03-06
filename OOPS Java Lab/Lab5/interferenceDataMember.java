/*
 * Define an interface Motor with a data member –capacity and two methods such as run() and consume().
 * Define a Java class ‘Washing machine’ which implements this interface and write the code to check the value of the interface data member thru an object of the class.
 * Input - mentioned in the program
 * Output - Capacity of the motor is -----
 */

interface Motor {
    int capacity = 5;

    void run();

    void consume();
}

class WashingMachine implements Motor {
    public void run() {
        System.out.println("Running the motor");
    }

    public void consume() {
        System.out.println("Consuming the motor");
    }
}

public class interferenceDataMember {
    public static void main(String[] args) {
        WashingMachine wm = new WashingMachine();
        System.out.println("Capacity of the motor is " + Motor.capacity);
    }
}

