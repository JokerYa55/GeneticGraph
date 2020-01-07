package gen_algoritm;

import java.util.List;

/**
 *
 * @author admin
 * @param <T> - Тип аллеля
 */
public interface GenInterface<T> {

    List<AlelInterface<T>> getGenAsList();

    Double[] getGenAsArray();

    void setGenAlel(int i, AlelInterface<T> alel);

    AlelInterface<T> getGenAlel(int i);
}
