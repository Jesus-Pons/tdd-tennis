package p3dev;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class WinScoreRuleTest {

    @ParameterizedTest
    @CsvSource({
            "4, 0",
            "4, 1",
            "4, 2",
            "0, 4",
            "1, 4",
            "2, 4",
            "5, 3",
            "3, 5",
            "8, 6"
    })
    void should_apply_when_a_player_reaches_four_points_with_two_point_difference(int p1, int p2) {
        // Arrange
        WinScoreRule rule = new WinScoreRule();

        // Act & Assert
        assertTrue(rule.applies(p1, p2));
    }

    @ParameterizedTest
    @CsvSource({
            "3, 0",
            "0, 3",
            "3, 1",
            "4, 3",
            "3, 4",
            "3, 3",
            "2, 2"
    })
    void should_not_apply_when_no_player_reached_four_or_difference_is_less_than_two(int p1, int p2) {
        // Arrange
        WinScoreRule rule = new WinScoreRule();

        // Act & Assert
        assertFalse(rule.applies(p1, p2));
    }

    @ParameterizedTest
    @CsvSource({
            "4, 0, Player 1 wins",
            "4, 2, Player 1 wins",
            "5, 3, Player 1 wins",
            "0, 4, Player 2 wins",
            "2, 4, Player 2 wins",
            "3, 5, Player 2 wins"
    })
    void should_return_correct_winner_string(int p1, int p2, String expectedScore) {
        // Arrange
        WinScoreRule rule = new WinScoreRule();

        // Act
        String result = rule.getScore(p1, p2);

        // Assert
        assertEquals(expectedScore, result);
    }
}