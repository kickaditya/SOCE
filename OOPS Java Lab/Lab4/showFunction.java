/*
 * Write a program in Java having three classes Apple, Banana and Cherry.
 * Class Banana and Cherry are inherited from class Apple and each class have their own member function show().
 * Using Dynamic Method Dispatch concept display all the show() method of each class.
 * Input: Mention show function of each class.
 * Output: Display show function of each class accordingly.
 */

class Apple {
    void show() {
        System.out.println("Show function of Apple");
    }
}

class Banana extends Apple {
    void show() {
        System.out.println("Show function of Banana");
    }
}

class Cherry extends Apple {
    void show() {
        System.out.println("Show function of Cherry");
    }
}

public class showFunction {
    public static void main(String[] args) {
        Apple obj1 = new Apple();
        Banana obj2 = new Banana();
        Cherry obj3 = new Cherry();

        obj1.show();
        obj2.show();
        obj3.show();
    }
}
