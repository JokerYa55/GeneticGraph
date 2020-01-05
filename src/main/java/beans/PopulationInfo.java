package beans;

public class PopulationInfo {

    private final int id;
    private Double a, b, c, d, f;

    public PopulationInfo(int id, Double a, Double b, Double c, Double d, Double f) {
        this.id = id;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.f = f;
    }

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }

    public Double getC() {
        return c;
    }

    public void setC(Double c) {
        this.c = c;
    }

    public Double getD() {
        return d;
    }

    public void setD(Double d) {
        this.d = d;
    }

    public Double getF() {
        return f;
    }

    public void setF(Double f) {
        this.f = f;
    }

    public int getId() {
        return id;
    }

}
