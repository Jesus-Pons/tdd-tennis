package p3dev;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class DeuceScoreRuleTest {
    @ParameterizedTest
    @CsvSource({
            "3, 3",
            "4, 4",
            "13, 13",
            "27, 27"
    })
    void should_apply_when_players_have_at_least_3_points_and_no_difference(int p1, int p2){
        DeuceScoreRule rule = new DeuceScoreRule();

        assertTrue(rule.applies(p1,p2));
    }
    @ParameterizedTest
    @CsvSource({
            "2, 2",
            "0, 0",
            "4, 3"
    })
    void should_not_apply_when_conditions_are_not_met(int p1, int p2) {
        DeuceScoreRule rule = new DeuceScoreRule();

        assertFalse(rule.applies(p1, p2));
    }

    @ParameterizedTest
    @CsvSource({
            "4, 4, deuce",
            "5, 5, deuce",
            "3, 3, deuce",
            "7, 7, deuce"
    })
    void should_return_correct_deuce_string(int p1, int p2, String expectedScore) {
        DeuceScoreRule rule = new DeuceScoreRule();

        String result = rule.getScore(p1, p2);

        assertEquals(expectedScore, result);
    }
}
