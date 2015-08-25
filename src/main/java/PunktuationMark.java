import org.apache.log4j.Logger;

/**
 * Класс PunktuationMark, предоставляет методы для проверки
   * Этот ли символ знак препинания и означает ли это конец предложения.
   *
 */
public class PunktuationMark extends Symbol implements SentenceObject {
    private boolean endOfSentence; // true, если символ означает конец предложение
    private static Logger log = Logger.getLogger(PunktuationMark.class);

    //Создаем объект PunctuationMark по данным символам.
    //param символы, которые представляют знаки препинания
    private PunktuationMark(char symbol) {
        super(symbol);

        if (symbol == '.' || symbol == '?' || symbol == '!') {
            endOfSentence = true;
            log.debug(endOfSentence);
        }
    }

    //Проверяем, является ли данный символ знаком препинания.
    //param Cимвол, который будет проверен
    //return true если символ является знаком препинания, false - не является
    public static boolean isPunktuation(char symbol) {
        if (symbol >= 'a' && symbol <= 'z' || symbol >= 'A' && symbol <= 'Z' || symbol == '\'') {
            return false;
        } else {
            return true;
        }
    }

    //Создаем объект PunctuationMark в случае, если входной символ действительно знак препинания.
    //param символ знаки препинания
    //return созданный объект или null, если не был создан
    public static PunktuationMark create(char symbol){
        if (isPunktuation(symbol)){
            return new PunktuationMark(symbol);
        }else {
            return null;
        }
    }

    //Проверка, представляет ли знак препинания конец предложения.
    //return true, если знак препинания означает конец предложения,
    //false - иначе
    public boolean isEndOfSentence(){
        return endOfSentence;
    }
}