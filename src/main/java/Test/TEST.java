package Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;


public class TEST {

    // Создаём логгер на данный класс
    private static final Logger logger = LoggerFactory.getLogger(TEST.class);

    public static void main(String[] args) {
        // Пример логирования
        logger.trace("выводится все сообщения");
        logger.info("Приложение запущено! прсотые сообщение");
        logger.debug("Это сообщение уровня DEBUG.");
        logger.warn("Это сообщение уровня WARN.");
        logger.error("Это сообщение уровня ERROR.");


    }
}