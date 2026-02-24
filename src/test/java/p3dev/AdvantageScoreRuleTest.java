package p3dev;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class AdvantageScoreRuleTest {
    @ParameterizedTest
    @CsvSource({
            "4, 3",
            "3, 4",
            "5, 4",
            "12, 13"
    })
    void should_apply_when_players_have_at_least_3_points_and_difference_is_1(int p1, int p2){
        AdvantageScoreRule rule = new AdvantageScoreRule();

        assertTrue(rule.applies(p1,p2));
    }
    @ParameterizedTest
    @CsvSource({
            "3, 3",
            "4, 2",
            "2, 1",
            "0, 0"
    })
    void should_not_apply_when_conditions_are_not_met(int p1, int p2) {
        AdvantageScoreRule rule = new AdvantageScoreRule();

        assertFalse(rule.applies(p1, p2));
    }

    @ParameterizedTest
    @CsvSource({
            "4, 3, Advantage player 1",
            "5, 4, Advantage player 1",
            "3, 4, Advantage player 2",
            "6, 7, Advantage player 2"
    })
    void should_return_correct_advantage_string(int p1, int p2, String expectedScore) {
        AdvantageScoreRule rule = new AdvantageScoreRule();

        String result = rule.getScore(p1, p2);

        assertEquals(expectedScore, result);
    }
}
