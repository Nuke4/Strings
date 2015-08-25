import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Создаем синтаксический анализатор,
 * который читает текст от файла до списка предложений,
 * создает словарь и распечатывает его содержание к файлу TXT.
 */
public class Start {
    private static final  File FILE = new File ("Input.txt");
    private static Logger log = Logger.getLogger(Start.class);
    public static void main(String[] args) {
        SentenceParser parser = new SentenceParser();
        try {
            parser.parse(new Scanner(FILE));
            log.debug(parser);
        } catch (FileNotFoundException e) {
            System.out.println("Не могу открыть фаил Input.txt");
            log.error(e);
        }
        parser.createVocabulary().printToTXT("Output.txt");
        System.out.println("Проверьте вывод в Output.txt");
    }


    public String getNameFile() {
        return FILE.getName();
    }
}