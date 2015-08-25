import java.util.*;

/**
 * Этот класс представляет предложение,
 * которое состоит из списка слов и знаков препинания (обе реализации SentenceObject).
 * Обеспечивает методы, чтобы читать
 * предложение, добавлять элементы к предложению.
 */
public class Sentence implements Iterable <SentenceObject> {
    private List<SentenceObject> tokens;//слова и знаки препинания

    public Sentence(){
        tokens = new ArrayList<SentenceObject>();
    }


    //Добавляет новый маркер к предложению (к списку маркеров).
    //param маркер элемент, который будет добавлен к предложению
    public void addToken(SentenceObject token){
        tokens.add(token);
    }

    //Читает маркеры предложения из Scanner
    //param Scanner источник входных данных

    public void read(Scanner scanner){
        String temp = null;
        int wordLenght = 0;
        boolean endOfSentence = false;
        Stack<PunktuationMark>marks = new Stack<PunktuationMark>();

        do{
        //Считает последовательность предложения, пока не встретит знак препинания,
        //который представляет конец предложения или последнюю строку которая была обработана.
        if (scanner.hasNext()){
            temp = scanner.next();

            //проверяет последний символ
            wordLenght = temp.length();
            //создать знаки препинания
            marks.push(PunktuationMark.create((temp.charAt(wordLenght - 1))));
            if (marks.peek()==null){
                //последний символ не знак препинания
                marks.pop();
                //создает новое слово из временного файла и добавляет его к списку
                addToken(new Word(temp));
                }else {
                //маркер - знак препинания
                --wordLenght;
                if (marks.peek().isEndOfSentence()){
                    endOfSentence = true;
                    }
                //считаем все знаки препинания, чтобы получить чистый текст
                for (int i = wordLenght - 1; i >= 0; --i){
                    marks.push(PunktuationMark.create(temp.charAt(i)));
                    if (marks.peek() == null){
                        marks.pop();
                        break;
                        }else {
                        //
                        -- wordLenght;
                        }
                    }
                //добавьте слово к списку
                if (wordLenght > 0){
                    addToken(new Word(temp.substring(0,wordLenght)));
                    }
                //добавьте все знаки препинания к списку
                while (!marks.empty()){
                    addToken(marks.pop());
                    }
                }
            }else {
            endOfSentence = true;
            }
        }
        while (!endOfSentence);
    }

    public Iterator<SentenceObject> iterator(){
        return tokens.iterator();
    }
}
