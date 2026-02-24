package p3dev;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MatchSimulatorTest {

    @Test
    void should_simulate_match_until_player_one_wins_four_games_to_zero() {
        ScoreTranslator translator = new ScoreTranslator();

        PointProvider mockProvider = mock(PointProvider.class);

        when(mockProvider.getNextPointWinner()).thenReturn(1);

        MatchSimulator simulator = new MatchSimulator(translator, mockProvider);

        String matchResult = simulator.playMatch();

        assertEquals("Match won by Player 1, Score: 4-0", matchResult);

        verify(mockProvider, times(16)).getNextPointWinner();
    }
    @Test
    void should_simulate_match_until_player_two_wins_four_games_to_zero() {
        ScoreTranslator translator = new ScoreTranslator();
        PointProvider mockProvider = mock(PointProvider.class);

        when(mockProvider.getNextPointWinner()).thenReturn(2);

        MatchSimulator simulator = new MatchSimulator(translator, mockProvider);

        String matchResult = simulator.playMatch();

        assertEquals("Match won by Player 2, Score: 0-4", matchResult);

        verify(mockProvider, times(16)).getNextPointWinner();
    }

    @Test
    void should_continue_match_beyond_four_games_if_difference_is_less_than_two() {
        ScoreTranslator translator = new ScoreTranslator();
        PointProvider mockProvider = mock(PointProvider.class);

        Integer[] pointSequence = new Integer[] {
                1,1,1,1,
                2,2,2,2,
                1,1,1,1,
                2,2,2,2,
                1,1,1,1,
                2,2,2,2,
                1,1,1,1,
                1,1,1,1
        };

        when(mockProvider.getNextPointWinner()).thenReturn(
                pointSequence[0],
                java.util.Arrays.copyOfRange(pointSequence, 1, pointSequence.length)
        );

        MatchSimulator simulator = new MatchSimulator(translator, mockProvider);

        String matchResult = simulator.playMatch();

        assertEquals("Match won by Player 1, Score: 5-3", matchResult);

        verify(mockProvider, times(32)).getNextPointWinner();
    }
}