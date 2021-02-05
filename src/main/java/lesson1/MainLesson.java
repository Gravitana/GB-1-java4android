package lesson01;

public class MainLesson {
    public static void main(String[] args) {
//        System.out.println("Hello, world!");
//        testVars();
//        testSumVar();
//        calculateSalary();
//        testString();
        testCheckAppraisal();
    }

    public static void testVars() {
//        System.out.println("testVars");
        int varA;
        varA = 3;
        int varB = 7;
        int varC = (int) (varB / varA);
        double varCC = (double) varB / varA;
        System.out.println(varCC);

        double doubleVarA = 3.0;
        double doubleVarB = 7.0;
        System.out.println(doubleVarB / doubleVarA);

        char c = 40000;
//        char c = 'O';
        System.out.println(c);

        boolean b = true;
        boolean b2 = false;

        ++varA; //4

//        varA = varA + 4; //8
        varA %= 4; //8
        System.out.println(varA);
    }


    private static void testSumVar() {
        sumVar(3, 10);
        sumVar(7, 10);
        sumVar(-3, 10);
        sumVar(0, 0);
        sumVar(-3, -7);
    }

    private static void sumVar(int varA, int varB) {
        System.out.println(varA + varB);
    }

    private static void calculateSalary() {
        final int TAX_RUSSIA = 13;
        int salary = calculateSalaryAfterTax(10000, TAX_RUSSIA);
        System.out.println(salary);
        System.out.println(calculateSalaryAfterTax(25000, TAX_RUSSIA));
        System.out.println(calculateSalaryAfterTax(100000, TAX_RUSSIA));
        System.out.println(calculateSalaryAfterTax(600000, 15));
    }

    public static int calculateSalaryAfterTax(int salary, int tax) {
        return (int)(salary - salary * tax / 100.0);
    }


    private static void testString() {
        String helloStr = "Hello";
        String worldStr = "world";
        System.out.println(helloStr + " " + worldStr + (5 + 7));
    }


    private static void testCheckAppraisal() {
        checkAppraisal(5);
        checkAppraisal(4);
        checkAppraisal(3);
        checkAppraisal(2);
        checkAppraisal(0);
        checkAppraisal(6);
        checkAppraisal(-3);
    }

    private static void checkAppraisal(int appraisal) {
        System.out.print("Ученик получил оценку: " + appraisal + " -- ");

        if(appraisal == 5) {
            System.out.println("Молодец! Так держать!");
        }
        else if (appraisal == 4) {
            System.out.println("Хорошо, но ты можешь лучше");
        }
//        else if (appraisal == 3 || appraisal == 2 || appraisal == 1) {
        else if (appraisal >= 1 & appraisal <= 3) {
            System.out.println("Готовь уроки лучше!");
        }
//        else if(appraisal > 5 || appraisal < 1) {
        else {
            System.out.println("Не мухлюй! Говори правду!");
        }
        System.out.println("Проверка окончена");
    }
}
