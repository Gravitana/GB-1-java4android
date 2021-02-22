package lesson5.am;

public class Person {
    protected String name;
    protected String job;
    protected String email;
    protected String phone;
    protected int salary;
    protected int age;

    public Person(String name, String job, String email, String phone, int salary, int age) {
        this.name = name;
        this.job = job;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return  "Данные о сотруднике:\n" +
                "\tФ.И.О.:\t\t" + name + "\n" +
                "\tДолжность:\t" + job + "\n" +
                "\tE-mail:\t\t" + email + "\n" +
                "\tТелефон:\t" + phone + "\n" +
                "\tЗарплата:\t" + salary + "\n" +
                "\tВозраст:\t" + age +  "\n";
    }
}
