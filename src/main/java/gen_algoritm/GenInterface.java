package gen_algoritm;

import java.util.List;

/**
 *
 * @author admin
 * @param <T> - Тип аллеля
 */
public interface GenInterface<T> {

    List<AlelInterface<T>> getGen();
}
