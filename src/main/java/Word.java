/**
 * Этот класс представляет слово, обеспечивает метод,
 * чтобы сравнить 2 слова согласно их лексикографическому порядку.
 */
    public class Word implements Comparable <Word>, SentenceObject {
    private String word;

    public Word(String word){this.word = word;}
    public void setWord(String word) {this.word = word;}
    public String getWord() {return word;}


    public int compareTo(Word anotherWord) {
        return word.compareToIgnoreCase(anotherWord.getWord());
    }

    public boolean endOfSentence() {
        return false;
    }
}

