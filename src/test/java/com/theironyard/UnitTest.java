package com.theironyard;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import net.doughughes.testifier.exception.CannotAccessMethodException;
import net.doughughes.testifier.exception.CannotFindEnumException;
import net.doughughes.testifier.exception.CannotFindMethodException;
import net.doughughes.testifier.test.TestifierTest;
import net.doughughes.testifier.util.Invoker;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

@RunWith(JUnitParamsRunner.class)
public class UnitTest extends TestifierTest{

    @Test
    @Parameters
    public void testUnitValue(String name, double value){
        /* Arrange */

        /* Act */

        double millimeters = 0;
        try {
            Enum unit = Invoker.getEnumValue(Class.forName("com.theironyard.Unit"), name);
            millimeters = (double) Invoker.invoke(unit, "toMillimeters");
        } catch (ClassNotFoundException | CannotFindMethodException | CannotAccessMethodException | CannotFindEnumException e) {
            fail(e.getClass().getName() + ": " + e.getMessage());
        }

        /* Assert */
        assertThat(name + " value should be " + value + " mm",
                millimeters, closeTo(value, 0.001));
    }

    private Object[] parametersForTestUnitValue() {
        return new Object[]{
                new Object[]{"MILE", 1609344},
                new Object[]{"YARD", 914.4},
                new Object[]{"FOOT", 304.8},
                new Object[]{"INCH", 25.4},
                new Object[]{"KILOMETER", 1000000},
                new Object[]{"METER", 1000},
                new Object[]{"CENTIMETER", 10},
                new Object[]{"MILLIMETER", 1},
        };
    }
}
