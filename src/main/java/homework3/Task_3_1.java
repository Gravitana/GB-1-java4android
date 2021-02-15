package homework3;

import java.util.Random;
import java.util.Scanner;

public class Task_3_1 {
    /*
        Создать массив из слов
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
        При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным словом и сообщает,
        правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
        apple – загаданное
        apricot - ответ игрока
        ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
        Для сравнения двух слов посимвольно можно пользоваться:
        String str = "apple";
        char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
        Играем до тех пор, пока игрок не отгадает слово.
        Используем только маленькие буквы.
     */

    public static void main(String[] args){
        String[] words = {
                "apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato",
        };
        Random rand = new Random();
        int index = rand.nextInt(words.length);
        String word = words[index];

        boolean gameOver = false;

        System.out.println("Угадайте слово, которое загадал компьютер.");

        while (!gameOver) {
            System.out.println("Варианты ответов:");
            for (int i = 0; i < words.length; i++) {
                System.out.print(words[i] + ", ");
                if ((i + 1) % 10 == 0)
                    System.out.println();
            }
            System.out.println();
            System.out.println("Введите ответ");

            String userAnswer = getAnswer();
            gameOver = userAnswer.equals(word);

            if (gameOver)
                System.out.println("Слово отгадано!");
            else
                hintAnswer(userAnswer, word);
        }
    }

    private static String getAnswer() {
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

    private static void hintAnswer(String userAnswer, String word) {
        System.out.println("Попробуйте ещё раз.");

        int len = userAnswer.length() < word.length() ? userAnswer.length() : word.length();

        System.out.println();

        for (int i = 0; i < 15; i++) {
            if (i < len) {
                char w = word.charAt(i);
                char u = userAnswer.charAt(i);
                System.out.print(w == u ? w : "#");
            }
            else
                System.out.print("#");
        }
        System.out.println();
        System.out.println();
    }
}
