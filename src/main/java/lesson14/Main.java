package lesson14;

import java.lang.ref.WeakReference;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random(); // сильная ссылка
        WeakReference weakReference = new WeakReference(random); // слабая ссылка
        random = null;
    }
}
