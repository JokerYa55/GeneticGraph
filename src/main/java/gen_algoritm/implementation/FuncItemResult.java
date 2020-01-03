package gen_algoritm.implementation;

import gen_algoritm.CalcResultInterface;

/**
 *
 * @author admin
 */
public class FuncItemResult implements CalcResultInterface<Double, Double> {

    private Double x;
    private Double y;

    @Override
    public Double getX() {
        return x;
    }

    @Override
    public Double getY() {
        return y;
    }

    @Override
    public void setX(Double x) {
        this.x = x;
    }

    @Override
    public void setY(Double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "FuncItemResult{" + "x=" + x + ", y=" + y + '}';
    }

}
