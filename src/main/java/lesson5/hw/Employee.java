package lesson5.hw;


public class Employee {

    private String firstName;
    private String surname;
    private int age;
    private String email;
    private String phoneNumber;
    private String position;
    private int salary;


    public Employee(String firstName, String surname, int age, String email, String phoneNumber, String position, int salary) {
        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.salary = salary;
    }


    public int getAge() {
        return age;
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Employee{" + "firstName='" + firstName + '\'' + ", lastName='" + surname + '\'' + ", age=" + age + ", email='" + email + '\'' + ", phoneNumber='" + phoneNumber + '\'' + ", position='" + position + '\'' + ", salary=" + salary + '}';
    }

}
