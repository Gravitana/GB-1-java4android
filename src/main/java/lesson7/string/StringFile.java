package lesson7.string;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class StringFile {

    public static void main(String[] args) throws IOException {
//        var file = new File("X:\\Ya.Disk\\work\\Lessons\\java4android\\src\\main\\java\\lesson7\\string\\resources\\text.txt");
        var file = new File("src/main/java/lesson7/string/resources/java_platform.txt");
        var is = new FileInputStream(file);

//        System.out.println(new String(is.readAllBytes()));

        StringBuilder sb = new StringBuilder();
        int n;
        while ((n = is.read()) != -1) {
            sb.append((char)n);
        }
        System.out.println(sb);

    }
}
