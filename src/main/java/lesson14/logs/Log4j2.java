package lesson14.logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.config.Property;

public class Log4j2 {
    public static void main(String[] args) {

        // TODO подключить конфигурацию

        Logger logger = (Logger) LogManager.getLogger();

        logger.info("111");
        logger.error("222");
        logger.warn("333");
    }
}
