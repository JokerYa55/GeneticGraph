package gen_item;

public class ResultItem {
    private double x;
    private double fx;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getFx() {
        return fx;
    }

    public void setFx(double fx) {
        this.fx = fx;
    }

    @Override
    public String toString() {
        return "ResultItem{" + "x=" + x + ", fx=" + fx + '}';
    }
    
    
}
