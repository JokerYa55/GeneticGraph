package beans;

public class PopulationInfo {

    private final String id;
    private String a, b, c, d, f, g;

    public PopulationInfo(String id, String a, String b, String c, String d, String f, String g) {
        this.id = id;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.f = f;
        this.g = g;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    @Override
    public String toString() {
        return "PopulationInfo{" + "id=" + id + ", a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + ", f=" + f + '}';
    }

    public String getG() {
        return g;
    }

    public void setG(String g) {
        this.g = g;
    }

    public String getId() {
        return id;
    }
}
