package lesson14.annotation.student;

@XTable(tableName = "newstudents")
public class Student {
    @XField
    int id;

    @XField
    String name;

    @XField
    int age;

    @XField
    String secret;


   public Student(int id, String name, int age, String secret) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.secret = secret;
    }

}
