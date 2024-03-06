/*
 * Define an interface Emploee with a method getDetails() to get employee details as Empid and Ename.
 * Also define a derived interface Manager with a method getDeptDetails() to get department details such as Deptid and Deptname.
 * Then define a class Head which implements Manager interface and also prints all details of the employee.
 * Write the complete program to display all details of one head of the department.
 * Input - Enter employee id - 123
 * Enter employee name - Sidharth Ambani
 * Enter department id - 06
 * Enter department name - Marketing
 * Take the user input of employee id, employee name, department id and department name.
 */

 import java.util.Scanner;

 interface Employee {
     void getDetails(String empId, String empName);
 }

 interface Manager extends Employee {
     void getDeptDetails(String deptId, String deptName);
 }

 class Head implements Manager {
     private String empId;
     private String empName;
     private String deptId;
     private String deptName;

     @Override
     public void getDetails(String empId, String empName) {
         this.empId = empId;
         this.empName = empName;
     }

     @Override
     public void getDeptDetails(String deptId, String deptName) {
         this.deptId = deptId;
         this.deptName = deptName;
     }

     public void printDetails() {
         System.out.println("Employee ID: " + this.empId);
         System.out.println("Employee Name: " + this.empName);
         System.out.println("Department ID: " + this.deptId);
         System.out.println("Department Name: " + this.deptName);
     }
 }

 public class deptHead {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         System.out.println("Enter employee id: ");
         String empId = scanner.nextLine();

         System.out.println("Enter employee name: ");
         String empName = scanner.nextLine();

         System.out.println("Enter department id: ");
         String deptId = scanner.nextLine();

         System.out.println("Enter department name: ");
         String deptName = scanner.nextLine();

         Head head = new Head();
         head.getDetails(empId, empName);
         head.getDeptDetails(deptId, deptName);
         head.printDetails();

         scanner.close();
     }
 }