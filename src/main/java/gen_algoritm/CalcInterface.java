package gen_algoritm;

/**
 * Интерфейс для классов вычислений значения функции в точке
 *
 * @param <T> - Тип входного параметра функции (x)
 * @param <V> - Тип выходного параметра функции (y)
 * @param <P> - Тип параметров функции (ген)
 */
public interface CalcInterface<T, V, P> {

    CalcResultInterface<T, V> calc(T x);

    CalcResultInterface<T, V> calc(T x, P... param);

}
