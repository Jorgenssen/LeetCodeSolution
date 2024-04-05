package org.me.solution;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("canConstructTestArguments")
    void canConstructTest(String ransomNote, String magazine, boolean expected) {
        Solution s = new Solution();
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

}
