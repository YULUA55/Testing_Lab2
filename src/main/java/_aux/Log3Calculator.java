package _aux;

import base.LnCalculator;
import base.TestFunction;

public class Log3Calculator implements TestFunction {

  private static final Log3Calculator INSTANCE = new Log3Calculator();
  private TestFunction lnCalc;

  public Log3Calculator() {}

  public Log3Calculator(TestFunction lnCalc) {
    this.lnCalc = lnCalc;
  }

  public double calculate(double arg) {
    if (arg <= 0) throw new IllegalArgumentException("log3(x) arg cannot be negative or 0");
    if (lnCalc == null) lnCalc = LnCalculator.getInstance();
    return lnCalc.calculate(arg) / lnCalc.calculate(3);
  }

  public static Log3Calculator getInstance() {
    return INSTANCE;
  }
}
