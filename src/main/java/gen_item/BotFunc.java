package gen_item;

public class BotFunc {

    public double calc(double x, double... a) {
        double result = 0;
        for (int i = a.length-1; i >=0; i--) {
            result = result + a[i] * Math.pow(x, i);
        }
        return result;
    }

}
