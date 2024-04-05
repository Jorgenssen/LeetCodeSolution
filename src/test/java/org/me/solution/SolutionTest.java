package org.me.solution;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

class SolutionTest {

    private final Solution s = new Solution();

    @ParameterizedTest
    @MethodSource("canConstructTestArguments")
    void testCanConstruct(String ransomNote, String magazine, boolean expected) {
        Assertions.assertEquals(expected, s.canConstruct(ransomNote, magazine));
    }

    private static List<Arguments> canConstructTestArguments() {
        return List.of(
                Arguments.arguments("a", "", false),
                Arguments.arguments("a", "b", false),
                Arguments.arguments("aa", "ab", false),
                Arguments.arguments("aa", "aab", true)
        );
    }

    @ParameterizedTest
    @MethodSource("numberOfStepsArguments")
    void testNumberOfSteps(int num, int expectedSteps) {
        Assertions.assertEquals(expectedSteps, s.numberOfSteps(num));
    }

    private static List<Arguments> numberOfStepsArguments() {
        return List.of(
                Arguments.arguments(14, 6),
                Arguments.arguments(8, 4),
                Arguments.arguments(123, 12)
        );
    }
}
