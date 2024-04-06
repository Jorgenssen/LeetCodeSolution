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

    @ParameterizedTest
    @MethodSource("fizzBuzzArguments")
    void testFizzBuzz(int num, List<String> expected) {
        Assertions.assertEquals(expected, s.fizzBuzz(num));
    }

    private static List<Arguments> fizzBuzzArguments() {
        return List.of(
                Arguments.arguments(3, List.of("1","2","Fizz")),
                Arguments.arguments(5, List.of("1","2","Fizz","4","Buzz")),
                Arguments.arguments(15, List.of("1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"))
        );
    }
}
