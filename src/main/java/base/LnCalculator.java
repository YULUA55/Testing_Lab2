package base;

public class LnCalculator implements TestFunction {

    private final static LnCalculator INSTANCE = new LnCalculator();

    public double calculate(double arg) {
        if (arg <= 0)
            throw new IllegalArgumentException("ln(x) arg cannot be negative or 0");
        int elemNum = 100000;
//        if (arg < 1000)
//            elemNum = 1000;
//        else
//            elemNum = 100000000;
        double result = 0;
        for (int i = 1; i < elemNum; ++i)
            result += seriesElement(i, arg);
        return 2*result;
    }

    public static LnCalculator getInstance() {
        return INSTANCE;
    }

    private double seriesElement(int num, double arg) {
        return Math.pow((arg-1)/(arg+1), 2*num-1)/(2*num - 1);
    }

}
