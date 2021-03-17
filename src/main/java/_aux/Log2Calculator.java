package _aux;

import base.LnCalculator;
import base.TestFunction;

public class Log2Calculator implements TestFunction {

  private static final Log2Calculator INSTANCE = new Log2Calculator();
  private TestFunction lnCalc;

  public Log2Calculator(TestFunction lnCalc) {
    this.lnCalc = lnCalc;
  }

  public Log2Calculator() {}

  @Override
  public double calculate(double arg) {
    if (arg <= 0) throw new IllegalArgumentException("log2(x) arg cannot be negative or 0");
    if (lnCalc == null) lnCalc = LnCalculator.getInstance();
    return lnCalc.calculate(arg) / lnCalc.calculate(2);
  }

  public static Log2Calculator getInstance() {
    return INSTANCE;
  }
}
