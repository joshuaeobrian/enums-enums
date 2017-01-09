package com.theironyard;

import net.doughughes.testifier.exception.CannotFindMethodException;
import net.doughughes.testifier.matcher.RegexMatcher;
import net.doughughes.testifier.output.OutputStreamInterceptor;
import net.doughughes.testifier.test.TestifierTest;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.collection.IsIn.isIn;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class MainTest extends TestifierTest {

    @Test
    public void testMainShouldInvokeConverterConvertThreeTimes() {
        /* arrange */

        /* act */
        String source = null;
        try {
            source = codeWatcher.getMainSourceCodeService().getDescriptionOfMethod("main", String[].class);
        } catch (CannotFindMethodException e) {
            fail(e.getMessage());
        }

        Matcher matcher = Pattern.compile("NameExpr\\[Converter\\] MethodName\\[convert\\] MethodArguments .*?LiteralExpr\\[.*?\\] NameExpr\\[Unit\\] FieldAccessExpr\\[(.*?)\\] NameExpr\\[Unit\\] FieldAccessExpr\\[(.*?)\\] \\/MethodArguments").matcher(source);

        /* assert */
        int count = 0;
        Set<String> units = new HashSet<>();
        while (matcher.find()) {
            count++;

            units.add(matcher.group(1));
            units.add(matcher.group(2));
        }

        assertThat("The convert() function should have been invoked at least three times.",
                count, greaterThanOrEqualTo(3));
        assertThat("At least six distinct Unit values should have been used.",
                units.size(), greaterThanOrEqualTo(6));

    }
}