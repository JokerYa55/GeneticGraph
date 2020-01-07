package gen_algoritm.implementation;

import gen_algoritm.AlelInterface;
import gen_algoritm.GenInterface;
import java.util.ArrayList;
import java.util.List;

public class GraphicGen implements GenInterface<Double> {

    private final List<AlelInterface<Double>> alelList;

    public GraphicGen(int genAlelCount) {
        alelList = new ArrayList<>(genAlelCount);
        for (int i = 0; i < genAlelCount; i++) {
            alelList.add(new GraphicAlel("i_" + i, 0d));
        }
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

    @Override
    public void setGenAlel(int i, AlelInterface<Double> alel) {
        alelList.set(i, alel);
    }

    @Override
    public AlelInterface<Double> getGenAlel(int i) {
        return alelList.get(i);
    }

}
