package com.theironyard;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import net.doughughes.testifier.exception.CannotAccessMethodException;
import net.doughughes.testifier.exception.CannotFindEnumException;
import net.doughughes.testifier.exception.CannotFindMethodException;
import net.doughughes.testifier.matcher.RegexMatcher;
import net.doughughes.testifier.output.OutputStreamInterceptor;
import net.doughughes.testifier.test.TestifierTest;
import net.doughughes.testifier.util.Invoker;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class ConverterTest extends TestifierTest{

    @Test
    @Parameters
    public void testConvert(double length, String fromUnitName, double expected, String toUnitName) {
        /* arrange */

        /* act */
        double converted = 0;
        try {
            Enum fromUnit = Invoker.getEnumValue(Class.forName("com.theironyard.Unit"), fromUnitName);
            Enum toUnit = Invoker.getEnumValue(Class.forName("com.theironyard.Unit"), toUnitName);
            converted = (double) Invoker.invokeStatic(Class.forName("com.theironyard.Converter"), "convert", length, fromUnit, toUnit);
        } catch (ClassNotFoundException | CannotFindMethodException | CannotAccessMethodException | CannotFindEnumException e) {
            fail(e.getClass().getName() + ": " + e.getMessage());
        }

        /* assert */
        assertThat(length + " " + fromUnitName + " should be " + expected + " " + toUnitName,
                converted, closeTo(expected, 0.001));

    }

    private Object[] parametersForTestConvert() {
        return new Object[]{
                new Object[]{0.25, "INCH", 6.35, "MILLIMETER"},
                new Object[]{1.1, "MILE", 5808, "FOOT"},
                new Object[]{314, "YARD", 28712.16, "CENTIMETER"},
                new Object[]{139, "FOOT", 42.3672, "METER"},
                new Object[]{39, "INCH", 0.0009906, "KILOMETER"},
                new Object[]{16, "KILOMETER", 9.9419391, "MILE"},
                new Object[]{9, "METER", 9.8425197, "YARD"},
                new Object[]{52, "CENTIMETER", 1.7060367, "FOOT"},
                new Object[]{70, "MILLIMETER", 2.7559055, "INCH"}
        };
    }

}