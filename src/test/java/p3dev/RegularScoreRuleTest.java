package p3dev;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class RegularScoreRuleTest {
    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 0",
            "0, 2",
            "3, 1",
            "2, 3"
    })
    void should_apply_when_scores_are_regular_and_less_than_four(int p1, int p2){
        RegularScoreRule rule = new RegularScoreRule();

        assertTrue(rule.applies(p1,p2));
    }
    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 2",
            "3, 3",
            "4, 3",
            "5, 3"
    })
    void should_not_apply_when_tied_or_out_of_bounds(int p1, int p2) {
        RegularScoreRule rule = new RegularScoreRule();

        assertFalse(rule.applies(p1, p2));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0, love-love",
            "1, 0, fifteen-love",
            "0, 2, love-thirty",
            "3, 1, forty-fifteen",
            "2, 3, thirty-forty"
    })
    void should_return_correct_regular_score_string(int p1, int p2, String expectedScore) {
        RegularScoreRule rule = new RegularScoreRule();

        String result = rule.getScore(p1, p2);

        assertEquals(expectedScore, result);
    }
}
