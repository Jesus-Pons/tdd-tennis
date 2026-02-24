package p3dev;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class TieScoreRuleTest {
    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 2"
    })
    void should_apply_when_players_have_less_than_3_points_or_more_than_0_and_no_difference(int p1, int p2){
        TieScoreRule rule = new TieScoreRule();

        assertTrue(rule.applies(p1,p2));
    }
    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "3, 3",
            "2, 1"
    })
    void should_not_apply_when_conditions_are_not_met(int p1, int p2) {
        TieScoreRule rule = new TieScoreRule();

        assertFalse(rule.applies(p1, p2));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, fifteen-all",
            "2, 2, thirty-all"
    })
    void should_return_correct_tie_string(int p1, int p2, String expectedScore) {
        TieScoreRule rule = new TieScoreRule();

        String result = rule.getScore(p1, p2);

        assertEquals(expectedScore, result);
    }
}
