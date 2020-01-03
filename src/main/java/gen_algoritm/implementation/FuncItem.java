package gen_algoritm.implementation;

import gen_algoritm.CalcInterface;

/**
 *
 * @author admin
 */
public class FuncItem implements CalcInterface<Double, Double, Double> {

    @Override
    public Double calc(Double x, Double param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double calc(Double x, Double... param) {
        Double result = 0d;
        int i = 0;
        for (Double a : param) {
            result = result + a * Math.pow(x, i);
        }
        return result;
    }

}
