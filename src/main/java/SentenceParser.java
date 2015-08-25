
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Этот класс содержит текст как список предложений,
 * param методы, чтобы считать текст и создать словарь слов,
 * встреченных в тексте.
 */
public class SentenceParser {
    private static Logger log = Logger.getLogger(SentenceParser.class);
    private Vocabulary vocabulary;//содержит отличающиеся слова в лексикографическом порядке
    private List<Sentence>text;//список предложений

    public SentenceParser(){
        vocabulary = new Vocabulary();
        text = new ArrayList<Sentence>();
    }
    //Читает текст предложение-за-предложением из scanner.
    //param scanner источник входных данных
    public void parse(Scanner scanner){
        Sentence temp = null;

        //считывает все предложения
        while (scanner.hasNext()){
            temp = new Sentence();
            temp.read(scanner);
            text.add(temp);
            log.debug(temp);
        }
    }
    //Генерирует словарь из данного списка предложений.
    //return словарь создан из предложений
    public Vocabulary createVocabulary(){
        for (Sentence s : text){

            //цикл через все предложения
            for (SentenceObject token : s){

                //цикл через все маркеры в предложении
                if (token instanceof Word){
                    //добавить слово к словарю
                    vocabulary.addWord((Word)token);
                }
            }
        }return vocabulary;

    }
    public Vocabulary getVocabulary(){
        return vocabulary;
    }

}
