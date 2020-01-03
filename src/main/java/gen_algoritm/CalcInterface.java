package gen_algoritm;

/**
 * Интерфейс для классов вычислений значения функции
 *
 * @param <P> - Тип аргумента функции
 * @param <T> - Тип входного параметра
 * @param <V> - Тип выходного параметра
 */
public interface CalcInterface<P, T, V> {

    V calc(P x, T param);

    V calc(P x, T... param);
}
