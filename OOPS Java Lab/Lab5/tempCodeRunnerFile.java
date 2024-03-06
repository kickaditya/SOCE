sc = new Scanner(System.in)) {
            System.out.println("Enter employee id: ");
            empId = sc.nextInt();
            System.out.println("Enter employee name: ");
            empName = sc.nextLine();
        }
    }

    public void getDeptDetails() {
        try (Scanner sc