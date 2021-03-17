import _aux.*;
import impl.WholeExpression;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import stub.*;

import java.util.stream.Stream;

public class IntegrationTest {

    @ParameterizedTest()
    @MethodSource("getTestValues")
    // everything mocked
    public void testUpperModule(double arg, double expected, double delta) {
        final WholeExpression wholeExpression = new WholeExpression(new Log3StubCalculator(), new Log2StubCalculator(), new LgStubCalculator(),
                new TanStubCalculator(), new SecStubCalculator(), new CscStubCalculator(),new CosStubCalculator(),new SinStubCalculator(), new LnStubCalculator());
        Assertions.assertEquals(expected, wholeExpression.compute(arg), delta);
    }

    @ParameterizedTest()
    @MethodSource("getTestValues")
    // only sin, cos and ln mocked
    public void testUpperAndFuncModules(double arg, double expected, double delta) {
        final WholeExpression wholeExpression = new WholeExpression(new Log3Calculator(new LnStubCalculator()), new Log2Calculator(new LnStubCalculator()), new LgCalculator(new LnStubCalculator()),
                new TanCalculator(new SinStubCalculator(), new CosStubCalculator()), new SecCalculator(new CosStubCalculator()), new CscCalculator(new SinStubCalculator()),new CosStubCalculator(), new SinStubCalculator(), new LnStubCalculator());
        Assertions.assertEquals(expected, wholeExpression.compute(arg), delta);
    }

    @ParameterizedTest()
    @MethodSource("getTestValues")
    public void testAllModules(double arg, double expected, double delta) {
        final WholeExpression wholeExpression = new WholeExpression();
        Assertions.assertEquals(expected, wholeExpression.compute(arg), delta);
    }

    public static Stream<Arguments> getTestValues() {
        return Stream.of(
                Arguments.of(-Math.PI, Double.NaN, 0.0),
                Arguments.of(-0.69*Math.PI, 0.015, 0.01),
                Arguments.of(-0.69*Math.PI-Math.PI, 0.0302, 0.001),
                Arguments.of(-0.19 * Math.PI, 0.0006, 0.001),
                Arguments.of(-Math.PI/2, 0.1250, 0.001),
                Arguments.of(0, Double.NaN, 0.0),
                Arguments.of(0.20655, 0.0, 0.01),
                Arguments.of(0.8, 19.888, 0.01),
                Arguments.of(1, Double.NaN, 0.0),
                Arguments.of(3.25, -1.696, 1.0),
                Arguments.of(4.8414, 0.0, 0.01),
                Arguments.of(100, 7.400, 0.001)
        );
    }

}
