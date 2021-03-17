package stub;

import _aux.Log2Calculator;

public class Log2StubCalculator extends Log2Calculator {

  private static final Log2StubCalculator INSTANCE = new Log2StubCalculator();

  public double calculate(double arg) {
    return StubTables.log2Table.get(arg);
  }

  public static Log2StubCalculator getInstance() {
    return INSTANCE;
  }
}
