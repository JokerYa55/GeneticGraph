package gen_algoritm;

/**
 * Алель элемент гена
 * @author admin
 */
public interface AlelInterface<T> {
    T getValue();
    void setValue(T val);
    String getName();
}
