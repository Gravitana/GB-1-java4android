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

        return checkLineForWin(0, -1)       // проверить горизонталь
                || checkLineForWin(-1, 0)   // проверить вертикаль
                || checkLineForWin(-1, -1)  // проверить главную диагональ
                || checkLineForWin(-1, 1);  // проверить побочную диагональ
    }

    private static boolean checkLineForWin(int coefficientRow, int coefficientCol) {
        int lustTurnRow = lustTurnCoordinates[0];
        int lustTurnCol = lustTurnCoordinates[1];
        char symbol = MAP[lustTurnRow][lustTurnCol];

        for (int delta = 1 - countChipsToWin, sumChips = 0; delta < countChipsToWin; delta++) {
            int rowNumber = lustTurnRow + delta * coefficientRow;
            int colNumber = lustTurnCol + delta * coefficientCol;

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

        // найти коэффициенты для самой длинной цепочки от последнего хода человека
        int[] coef = findLongestLine();

        int[] turnCoordinates = doBlockLine(coef);

        System.out.printf("Ход человека: %2d %2d %n", lustTurnCoordinates[0] + 1, lustTurnCoordinates[1] + 1); // TODO remove after debug

        if (isWrongNumber(turnCoordinates[0], turnCoordinates[1])) {
            do {
                rowNumber = random.nextInt(SIZE);
                colNumber = random.nextInt(SIZE);
            } while (isCellOccupied(rowNumber, colNumber));
//            System.out.println("Случайные координаты"); // TODO remove after debug
        } else {
            rowNumber = turnCoordinates[0];
            colNumber = turnCoordinates[1];
//            System.out.println("Попытка блокировки"); // TODO remove after debug
        }

//        System.out.println(Arrays.toString(coef)); // TODO remove after debug

        lustTurnCoordinates = new int[]{rowNumber, colNumber};
        MAP[rowNumber][colNumber] = DOT_AI;
        turnsCount++;

//        System.out.printf("Ход AI: %2d %2d %n", lustTurnCoordinates[0] + 1, lustTurnCoordinates[1] + 1); // TODO remove after debug
    }

    private static int[] findLongestLine() {
        int lineSize;
        int maxLineSize = 0;
        int[] maxLineCoef = new int[]{0,0};

        lineSize = calcMaxChipsInLine(0,-1);
        if (lineSize > maxLineSize) {
            maxLineSize = lineSize;
            maxLineCoef = new int[]{0,-1};
        }

        lineSize = calcMaxChipsInLine(-1,0);
        if (lineSize > maxLineSize) {
            maxLineSize = lineSize;
            maxLineCoef = new int[]{-1,0};
        }

        lineSize = calcMaxChipsInLine(-1,-1);
        if (lineSize > maxLineSize) {
            maxLineSize = lineSize;
            maxLineCoef = new int[]{-1,-1};
        }

        lineSize = calcMaxChipsInLine(-1,1);
        if (lineSize > maxLineSize) {
//            maxLineSize = lineSize;
            maxLineCoef = new int[]{-1,1};
        }

        return maxLineCoef;
    }

    private static int[] doBlockLine(int[] coef) {
//        int[] turnCoordinates = new int[]{-1,-1};

        int turnRow = -1;
        int turnCol = -1;

        int lustTurnRow = lustTurnCoordinates[0];
        int lustTurnCol = lustTurnCoordinates[1];

        int coefficientRow = coef[0];
        int coefficientCol = coef[1];

        int deltaTemp = 0;

        // TODO цикл идёт задом наперёд? - возвращает координаты первой итерации

//        for (int delta = 1 - countChipsToWin; delta < countChipsToWin; delta++) {
        for (int delta = countChipsToWin; delta > 1 - countChipsToWin; delta--) {
            int rowNumber = lustTurnRow + delta * coefficientRow;
            int colNumber = lustTurnCol + delta * coefficientCol;

            if (isWrongNumber(rowNumber, colNumber))
                continue;

//            if (isCellOccupied(rowNumber, colNumber))
//                continue;

            if (MAP[rowNumber][colNumber] == DOT_HUMAN) {
                continue;
            }

            if (MAP[rowNumber][colNumber] == DOT_AI) {
//                turnRow = -1;
//                turnCol = -1;
                continue;
            }

            if (MAP[rowNumber][colNumber] == DOT_EMPTY) {
                turnRow = rowNumber;
                turnCol = colNumber;

//                deltaTemp = delta; // TODO remove after debug

//                continue;
            }
        }

//        System.out.printf("Дельта AI: %2d %n", deltaTemp); // TODO remove after debug

        return new int[]{turnRow, turnCol};
    }

    private static int calcMaxChipsInLine(int coefficientRow, int coefficientCol) {
        int lustTurnRow = lustTurnCoordinates[0];
        int lustTurnCol = lustTurnCoordinates[1];
        char symbol = MAP[lustTurnRow][lustTurnCol];

        int maxLineSize = 0;

        for (int delta = 1 - countChipsToWin, sumChips = 0; delta < countChipsToWin; delta++) {
            int rowNumber = lustTurnRow + delta * coefficientRow;
            int colNumber = lustTurnCol + delta * coefficientCol;

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
