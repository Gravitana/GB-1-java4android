package lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static final int SIZE = 3;
    static int turnsCount;

    static final char[][] MAP = new char[SIZE][SIZE];

    static final char DOT_EMPTY = '•';
    static final char DOT_HUMAN = 'X';
    static final char DOT_AI = 'O';

    static final char HEADER_FIRST_SYMBOL = '♥';
    static final String EMPTY = " ";

    static final Scanner in = new Scanner(System.in);
    static final Random random = new Random();



    public static void main(String[] args) {
        turnGame();
    }

    private static void turnGame() {

        initMap();

        printMap();
        
        playGame();
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++ ) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printHeaderMap();
        printBodyMap();
    }

    private static void printHeaderMap() {
        System.out.print(HEADER_FIRST_SYMBOL + EMPTY);

        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
        }
        System.out.println();
    }

    private static void printMapNumber(int i) {
        System.out.print(i + 1 + EMPTY);
    }

    private static void printBodyMap() {
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + EMPTY);
            }
            System.out.println();
        }
    }

    private static void playGame() {

        while (true) {
            turnOfHuman();
            printMap();
            checkEnd(DOT_HUMAN);

            turnOfAi();
            printMap();
            checkEnd(DOT_AI);
        }


    }

    private static void turnOfHuman() {
        int rowNumber;
        int colNumber;
        boolean isInputValid = true;

        System.out.println("\nХод человека! Введите номер строки и столбца.");
        do {
            rowNumber = -1;
            colNumber = -1;
            isInputValid = true;

            System.out.print("Строка: ");
            if (in.hasNextInt()) {
                rowNumber = in.nextInt() - 1;
            } else {
                isInputValid = false;
                processingIncorectInput();
                continue;
            }

            System.out.print("Столбец: ");
            if (in.hasNextInt()) {
                colNumber = in.nextInt() - 1;
            } else {
                processingIncorectInput();
                isInputValid = false;
            }

        } while (!isInputValid || !isHumanTurnValid(rowNumber, colNumber));

        MAP[rowNumber][colNumber] = DOT_HUMAN;
        turnsCount++;
    }

    private static void processingIncorectInput() {
        System.out.println("Ошибка ввода! Введите число в диапазоне размера игрового поля.");
        in.nextLine();
    }

    private static boolean isHumanTurnValid(int rowNumber, int colNumber) {
        if (!isNumbersValid(rowNumber, colNumber)) {
            System.out.println("\nПроверьте значения строки и столбца.");
            return false;
        } else if (!isCellFree(rowNumber, colNumber)) {
            System.out.println("\nВы выбрали занятую чейку.");
            return false;
        }
        return true;
    }

    private static boolean isNumbersValid(int rowNumber, int colNumber) {
        return rowNumber < SIZE && rowNumber >= 0 && colNumber < SIZE && colNumber >= 0;
    }

    private static boolean isCellFree(int rowNumber, int colNumber) {
        return MAP[rowNumber][colNumber] == DOT_EMPTY;
    }

    private static void checkEnd(char symbol) {
        if (checkWin(symbol)) {
            if (symbol == DOT_HUMAN) {
                System.out.println("Ура! Вы победили!");
            } else {
                System.out.println("Восстание близко... ИИ победил...");
            }
            System.exit(0);
        }
        else if (isMapFull()) {
            System.out.println("Ничья!");
            System.exit(0);
        }
    }

    private static boolean isMapFull() {
        return turnsCount == SIZE * SIZE;
    }

    private static boolean checkWin(char symbol) {

        if (MAP[0][0] == symbol && MAP[0][1] == symbol && MAP[0][2] == symbol) return true;
        if (MAP[1][0] == symbol && MAP[1][1] == symbol && MAP[1][2] == symbol) return true;
        if (MAP[2][0] == symbol && MAP[2][1] == symbol && MAP[2][2] == symbol) return true;

        if (MAP[0][0] == symbol && MAP[1][0] == symbol && MAP[2][0] == symbol) return true;
        if (MAP[0][1] == symbol && MAP[1][1] == symbol && MAP[2][1] == symbol) return true;
        if (MAP[0][2] == symbol && MAP[1][2] == symbol && MAP[2][2] == symbol) return true;

        if (MAP[0][0] == symbol && MAP[1][1] == symbol && MAP[2][2] == symbol) return true;
        if (MAP[0][2] == symbol && MAP[1][1] == symbol && MAP[2][0] == symbol) return true;

        return false;
    }

    private static void turnOfAi() {
        int rowNumber;
        int colNumber;

        System.out.println("\nХод компьютра!");

        do {
            rowNumber = random.nextInt(SIZE);
            colNumber = random.nextInt(SIZE);
        } while (!isCellFree(rowNumber, colNumber));

        MAP[rowNumber][colNumber] = DOT_AI;
        turnsCount++;
    }


}
