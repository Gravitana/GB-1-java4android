package lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static final int SIZE = 7; //10;
    static final int MIN_SIZE = 3;
    static final int MAX_SIZE = 12;

    static int countChipsToWin;
    static int turnsCount;
    static int[] lustTurnCoordinates = new int[2];

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

        countChipsToWin = calcChipsToWin();

        initMap();

        printMap();
        
        playGame();
    }

    private static int calcChipsToWin() {
        return switch (SIZE) {
            case 1, 2 -> 0;
            case 3, 4, 5 -> 3;
            case 6, 7, 8, 9 -> 4;
            default -> 5;
        };
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++ ) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printHeader();
        printHeaderMap();
        printBodyMap();
    }

    private static void printHeader() {
        System.out.printf("Размер поля %d x %d. Выигрыш — %d %s в ряд\n\n", SIZE, SIZE, countChipsToWin, countChipsToWin < 5 ? "фишки" : "фишек");
    }

    private static void printHeaderMap() {
        System.out.printf("%2s%s", HEADER_FIRST_SYMBOL, EMPTY);

        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
        }
        System.out.println();
    }

    private static void printMapNumber(int i) {
        System.out.printf("%2d%s", i + 1, EMPTY);
    }

    private static void printBodyMap() {
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%2s%s", MAP[i][j], EMPTY);
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

        lustTurnCoordinates = new int[]{rowNumber, colNumber};
        MAP[rowNumber][colNumber] = DOT_HUMAN;
        turnsCount++;
    }

    private static void processingIncorectInput() {
        System.out.println("Ошибка ввода! Введите число в диапазоне размера игрового поля.");
        in.nextLine();
    }

    private static boolean isHumanTurnValid(int rowNumber, int colNumber) {
        if (isWrongNumber(rowNumber, colNumber)) {
            System.out.println("\nПроверьте значения строки и столбца.");
            return false;
        } else if (isCellOccupied(rowNumber, colNumber)) {
            System.out.println("\nВы выбрали занятую чейку.");
            return false;
        }
        return true;
    }

    private static boolean isWrongNumber(int rowNumber, int colNumber) {
        return rowNumber >= SIZE || rowNumber < 0 || colNumber >= SIZE || colNumber < 0;
    }

    private static boolean isCellOccupied(int rowNumber, int colNumber) {
        return MAP[rowNumber][colNumber] != DOT_EMPTY;
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
        if (turnsCount < (countChipsToWin * 2 - 1))             // проверить достаточность ходов для выигрыша
            return false;

        return checkLineForWin(-1, 0)       // проверить горизонталь
                || checkLineForWin(0, -1)   // проверить вертикаль
                || checkLineForWin(-1, -1)  // проверить главную диагональ
                || checkLineForWin(-1, 1);  // проверить побочную диагональ
    }

    private static boolean checkLineForWin(int coefficientX, int coefficientY) {
        int x = lustTurnCoordinates[0];
        int y = lustTurnCoordinates[1];
        char symbol = MAP[x][y];

        for (int delta = 1 - countChipsToWin, sumChips = 0; delta < countChipsToWin; delta++) {
            int rowNumber = x + delta * coefficientX;
            int colNumber = y + delta * coefficientY;

            if (isWrongNumber(rowNumber, colNumber))
                continue;

            if (MAP[rowNumber][colNumber] == symbol)
                sumChips++;
            else
                sumChips = 0;

            if (sumChips >= countChipsToWin)
                return true;
        }
        return false;
    }

    private static void turnOfAi() {
        int rowNumber;
        int colNumber;

        System.out.println("\nХод компьютра!");


        // TODO перенести это в отдельную функцию
        // найти самую длинную цепочку от последнего хода человека

        int lineSize;
        int maxLineSize = 0;
        int[] maxLineCoef = new int[]{0,-1};

        lineSize = findMaxLine(0,-1);
        if (lineSize > maxLineSize) {
            maxLineSize = lineSize;
            maxLineCoef = new int[]{0,-1};
        }

        lineSize = findMaxLine(-1,0);
        if (lineSize > maxLineSize) {
            maxLineSize = lineSize;
            maxLineCoef = new int[]{-1,0};
        }

        lineSize = findMaxLine(-1,-1);
        if (lineSize > maxLineSize) {
            maxLineSize = lineSize;
            maxLineCoef = new int[]{-1,-1};
        }

        lineSize = findMaxLine(-1,1);
        if (lineSize > maxLineSize) {
            maxLineSize = lineSize;
            maxLineCoef = new int[]{-1,1};
        }


//        System.out.println(maxLineSize);
//        System.out.println(Arrays.toString(maxLineCoef));






        do {
            rowNumber = random.nextInt(SIZE);
            colNumber = random.nextInt(SIZE);
        } while (isCellOccupied(rowNumber, colNumber));

        lustTurnCoordinates = new int[]{rowNumber, colNumber};
        MAP[rowNumber][colNumber] = DOT_AI;
        turnsCount++;
    }

    private static int findMaxLine(int coefficientX, int coefficientY) {
        int x = lustTurnCoordinates[0];
        int y = lustTurnCoordinates[1];
        char symbol = MAP[x][y];

        int maxLineSize = 0;

        for (int delta = 1 - countChipsToWin, sumChips = 0; delta < countChipsToWin; delta++) {
            int rowNumber = x + delta * coefficientX;
            int colNumber = y + delta * coefficientY;

            if (isWrongNumber(rowNumber, colNumber))
                continue;

            if (MAP[rowNumber][colNumber] == symbol) {
                sumChips++;
            }
            else {
                if (sumChips > maxLineSize)
                    maxLineSize = sumChips;

                sumChips = 0;
            }
       }

        return maxLineSize;
    }

}
