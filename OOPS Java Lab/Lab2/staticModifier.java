/*
 * Program to find no. of objects created out of a class using ‘static’ modifier.
 *Input: No of objects created
 *Output: Display the number of objects created (e.g. no of objects=3)
 */

class staticModifier {
    static int count = 0;

    staticModifier() {
        count++;
    }

    public static void main(String[] args) {
        staticModifier obj1 = new staticModifier();
        staticModifier obj2 = new staticModifier();
        staticModifier obj3 = new staticModifier();
        System.out.println("No of objects=" + count);
    }
}

