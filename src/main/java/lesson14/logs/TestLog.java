package lesson14.logs;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

public class TestLog {

    protected static final Logger loger = Logger.getLogger("TestLogger");

    public static void main(String[] args) throws IOException {

        loger.setLevel(Level.ALL);

        Handler handler = new FileHandler("src/main/resources/logs/myLog.log");
        loger.addHandler(handler);

        loger.getHandlers()[0].setLevel(Level.ALL);

/*
        handler.setFormatter(new Formatter() { // задаём свой формат вывода сообщений
            @Override
            public String format(LogRecord record) {
                return record.getLevel() + "\t" + record.getMessage() + "\t" + record.getMillis() + "\n";
            }
        });
*/

        handler.setFormatter(new SimpleFormatter()); // упрощённый формат вывода

        loger.log(Level.SEVERE, "Checkpoint S");
        loger.log(Level.INFO, "Checkpoint I");
        loger.warning("Checkpoint W");
        loger.config("Checkpoint C");
    }

    //OFF
    //SEVERE
    //WARNING
    //INFO
    //CONFIG
    //FINE(3)
    //ALL
}
