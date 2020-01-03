package gen_algoritm.implementation;

import gen_algoritm.AlelInterface;
import gen_algoritm.GenInterface;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class GraphicGen implements GenInterface<Double> {

    private final List<AlelInterface<Double>> alelList = new ArrayList<>(4);

    public GraphicGen() {
    }

    @Override
    public List<AlelInterface<Double>> getGen() {
        return alelList;
    }

}
