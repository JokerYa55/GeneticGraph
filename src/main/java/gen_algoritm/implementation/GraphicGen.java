package gen_algoritm.implementation;

import gen_algoritm.AlelInterface;
import gen_algoritm.GenInterface;
import java.util.ArrayList;
import java.util.List;

public class GraphicGen implements GenInterface<Double> {

    private final List<AlelInterface<Double>> alelList = new ArrayList<>(4);

    public GraphicGen() {
    }

    @Override
    public List<AlelInterface<Double>> getGenAsList() {
        return alelList;
    }

    @Override
    public Double[] getGenAsArray() {
        return alelList.stream().map(t -> {
            return t.getValue();
        }).toArray(Double[]::new);
    }

}
