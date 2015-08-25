
/**
 *Абстрактный класс для хранения и обработки символов
 */
public abstract class Symbol {
    private char symbol;

    //Создает новый символ с заданным параметром.
    protected Symbol(char symbol){
        this.symbol = symbol;
    }

    //Возвращает введенный символ.
    public char getSymbol(){
        return symbol;
    }
}
