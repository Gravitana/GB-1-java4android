package lesson14.logs;

import org.apache.log4j.*; // * - подключаем всё из этой библиотеки

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestLog4j {

    public static void main(String[] args) {
        PropertyConfigurator.configure("src/main/resources/logs/configs/log4j.properties"); // Где скачать? Взял из ресурсов к уроку
//        BasicConfigurator.configure(); // Базовая конфигурация
        Logger admin = Logger.getLogger("admin");

        admin.info("This is info");
        admin.warn("This is warn");
        admin.error("This is error");
        admin.fatal("This is fatal");

        Logger file = Logger.getLogger("file");

        file.info("This is info");
        file.warn("This is warn");
        file.error("This is error");
        file.fatal("This is fatal");

        try {
            Files.readAllBytes(Path.of("")); // Пытаемся прочитать то, чего нет (глянем, что будет в логах)
        } catch (IOException e) {
            file.error("error", e); // будет записано только для file (не для admin)
        }

    }
}
