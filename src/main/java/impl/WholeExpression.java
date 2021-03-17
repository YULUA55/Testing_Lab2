package impl;

import _aux.*;
import base.CosCalculator;
import base.LnCalculator;
import base.SinCalculator;

public class WholeExpression {

  private final Log3Calculator log3Calculator;
  private final Log2Calculator log2Calculator;
  private final LgCalculator lgCalculator;
  private final TanCalculator tanCalculator;
  private final SecCalculator secCalculator;
  private final CscCalculator cscCalculator;
  private final CosCalculator cosCalculator;
  private final SinCalculator sinCalculator;
  private final LnCalculator lnCalculator;

  public WholeExpression(
      Log3Calculator log3Calculator,
      Log2Calculator log2Calculator,
      LgCalculator lgCalculator,
      TanCalculator tanCalculator,
      SecCalculator secCalculator,
      CscCalculator cscCalculator,
      CosCalculator cosCalculator,
      SinCalculator sinCalculator,
      LnCalculator lnCalculator) {
    this.log3Calculator = log3Calculator;
    this.log2Calculator = log2Calculator;
    this.lgCalculator = lgCalculator;
    this.tanCalculator = tanCalculator;
    this.secCalculator = secCalculator;
    this.cscCalculator = cscCalculator;
    this.cosCalculator = cosCalculator;
    this.sinCalculator = sinCalculator;
    this.lnCalculator = lnCalculator;
  }

  public WholeExpression() {
    log3Calculator = Log3Calculator.getInstance();
    log2Calculator = Log2Calculator.getInstance();
    lgCalculator = LgCalculator.getInstance();
    tanCalculator = TanCalculator.getInstance();
    secCalculator = SecCalculator.getInstance();
    cscCalculator = CscCalculator.getInstance();
    cosCalculator = CosCalculator.getInstance();
    sinCalculator = SinCalculator.getInstance();
    lnCalculator = LnCalculator.getInstance();
  }

  public double compute(double arg) {
    if (arg <= 0) return new TrigonometricExpression().compute(arg);
    return new LogarithmicExpression().compute(arg);
  }

  private class LogarithmicExpression {

    public double compute(double arg) {
      final double log3 = log3Calculator.calculate(arg);
      final double log2 = log2Calculator.calculate(arg);
      final double lg = lgCalculator.calculate(arg);
      final double ln = lnCalculator.calculate(arg);
      return (((((log3 - ln) - lg) - log2) / (lg * ln)) + (log3 + log3));
    }
  }

  private final class TrigonometricExpression {
    public double compute(double x) {
      final double tan = tanCalculator.calculate(x);
      final double sin = sinCalculator.calculate(x);
      final double sec = secCalculator.calculate(x);
      final double csc = cscCalculator.calculate(x);
      final double cos = cosCalculator.calculate(x);

      final double expr1 = ((((tan/sin) * cos) / csc) / (csc - (cos / sec) + Math.pow(csc,3)));
      return Math.pow(expr1, 3);
    }
  }
}
