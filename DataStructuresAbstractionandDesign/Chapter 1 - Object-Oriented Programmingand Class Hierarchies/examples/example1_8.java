

public class example1_8 {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Davidson", "Davidson.linhares@outlook.com");
        Employee emp2 = new Employee("Carlos", "Carlos@gmail.com");

        if (emp1.equals(emp2)) {
            System.out.println("They are the same employee");
        } else {
            System.out.println("Different employees");
        }

    }
}

class Employee {
    private String name;
    private String email;


    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() == obj.getClass()) {
            Employee other = (Employee) obj;
            return this.name.equals(other.name) &&
                    email.equals(other.email);
        } else {
            return false;
        }
    }
}
