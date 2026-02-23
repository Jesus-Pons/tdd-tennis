package p3dev;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreTranslatorTests {
    static Stream<TestCase> testCasesProvider(){
        return Stream.of(
                new TestCase(0,0, "love-love")
        );
    }

    @ParameterizedTest
    @MethodSource("testCasesProvider")
    void should_return_expected_when_test_is_called(TestCase testCase){
        ScoreTranslator translator = new ScoreTranslator();

        String result = translator.translate(testCase.scorePlayerOne,testCase.scorePlayerTwo);

        assertEquals(testCase.expectedResult, result);
    }

    static class TestCase{
        int scorePlayerOne;
        int scorePlayerTwo;
        String expectedResult;

        TestCase(int scorePlayerOne,int scorePlayerTwo, String expectedResult){
            this.scorePlayerOne = scorePlayerOne;
            this.scorePlayerTwo = scorePlayerTwo;
            this.expectedResult = expectedResult;
        }

        @Override
        public String toString() {return String.format("%d-%d should return \"%s\"",scorePlayerOne,scorePlayerTwo,expectedResult);}
    }
}
