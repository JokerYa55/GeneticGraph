package gen_algoritm;

/**
 *
 * @author admin
 * @param <T> - Тип аргумента функции
 * @param <V> - Тип результата вычисления функции
 */
public interface CalcResultInterface<T, V> {

    T getX();

    V getY();
    
    void setX(T val);
    
    void setY(V val);
}
