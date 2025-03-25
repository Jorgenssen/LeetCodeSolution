package org.me.solution;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

class SolutionTest {

    private final Solution s = new Solution();

    @ParameterizedTest(name = "(note: {0}, magazine: {1}, expected bool: {2})")
    @MethodSource("canConstructTestArguments")
    @DisplayName("Ransom Note")
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

    @ParameterizedTest(name = "(number: {0}, expected steps: {1})")
    @MethodSource("numberOfStepsArguments")
    @DisplayName("Number of steps")
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

    @ParameterizedTest(name = "(number: {0}, expected list: {1})")
    @MethodSource("fizzBuzzArguments")
    @DisplayName("Fizz Buzz")
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

    @ParameterizedTest
    @MethodSource("maxConsecutiveOnesInArrayArguments")
    @DisplayName("Maximum number of consecutine ones in array")
    void testMaxConsecutiveOnesInArray(int[] nums, int expected) {
        Assertions.assertEquals(expected, s.maxConsecutiveOnesInArray(nums));
    }

    private static List<Arguments> maxConsecutiveOnesInArrayArguments() {
        return List.of(
                Arguments.arguments(new int[]{1,1,0,1,1,1}, 3),
                Arguments.arguments(new int[]{1,0,1,1,0,1}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("findNumsWithEvenNumberOfDigitsArguments")
    @DisplayName("Amount of nums with even number of digits")
    void testFindNumsWithEvenNumberOfDigits(int[] nums, int expected) {
        Assertions.assertEquals(expected, s.findNumsWithEvenNumberOfDigits(nums));
    }

    private static List<Arguments> findNumsWithEvenNumberOfDigitsArguments() {
        return List.of(
                Arguments.arguments(new int[]{12,345,2,6,7896}, 2),
                Arguments.arguments(new int[]{555,901,482,1771}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("squaresOfASortedArrayArguments")
    @DisplayName("Squares of a Sorted Array")
    void testSquaresOfASortedArray(int[] nums, int[] expected) {
        Assertions.assertArrayEquals(expected, s.squaresOfASortedArray(nums));
    }

    private static List<Arguments> squaresOfASortedArrayArguments() {
        return List.of(
                Arguments.arguments(new int[]{-4,-1,0,3,10}, new int[]{0,1,9,16,100}),
                Arguments.arguments(new int[]{-7,-3,2,3,11}, new int[]{4,9,9,49,121})
        );
    }
}
