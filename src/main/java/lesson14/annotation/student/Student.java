package lesson14.annotation.student;

@XTable(tableName = "newstudents") // какую таблицу берём из БД
public class Student { // какие поля заполняем автоматически
    @XField
    int id;

    @XField
    String name;

    @XField
    int age;

    @XField
    String secret;


   public Student(int id, String name, int age, String secret) { // при использовании аннотаций конструктор может и не понадобиться
        this.id = id;
        this.name = name;
        this.age = age;
        this.secret = secret;
    }

}
