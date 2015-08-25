import org.apache.log4j.Logger;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;


/**
 * Этот класс содержит отличные слова в лексикографическом порядке,
 * обеспечивает методы, чтобы добавить новые слова и распечатать
 * содержание к файлу TXT.
 */
public class Vocabulary {
    private static Logger log = Logger.getLogger(Vocabulary.class);
    private TreeSet<Word> words;

    public Vocabulary (){
        words = new TreeSet<Word>();
    }
    //Добавляет новое слово к словарю в случае, если оно уникально.
    //param слово, которое будет добавлено к словарю
    //return true, если слово было успешно добавлено, false - иначе
    public boolean addWord(Word word) {
        return words.add(word);
    }
    //Распечатывает содержание словаря в лексикографическом порядке к файлу TXT.
    //param имя файла TXT, который будет создаваться
    public void printToTXT(String filename){
        BufferedWriter out = null;
        char currentLetter = ' ';
        boolean newLetter = false;
        String currentWord = null;
        try {
            out = new BufferedWriter(new FileWriter(filename));
            out.write("6.\tНапечатать слова текста в алфавитном порядке по первой \n" +
                    "букве. Слова, начинающиеся с новой буквы, печатать с красной строки.\n");
            out.newLine();

            for (Word w : words){
                //записать каждое слово в фаил
                currentWord = w.getWord();
                if (Character.toLowerCase(currentWord.charAt(0))!= currentLetter){
                    log.debug(out);
                    //получим новую букву, таким образом, первое слово должно быть
                    //с красной строки.
                    newLetter = true;
                    currentLetter = Character.toLowerCase(currentWord.charAt(0));
                    out.write("    ");
                }

                out.write(currentWord);
                out.write(" ");

                if (newLetter){
                    newLetter = false;

                }
                out.newLine();
            }
            out.write("Конец текста");
            out.newLine();


            out.close();
        }catch (IOException e){
            System.out.println("не могу записать" + filename);
            log.error(e);
        }
    }

}