package p3dev;

public class MatchSimulator {

    private final ScoreTranslator scoreTranslator;
    private final PointProvider pointProvider;
    public MatchSimulator(ScoreTranslator scoreTranslator, PointProvider pointProvider) {
        this.scoreTranslator=scoreTranslator;
        this.pointProvider = pointProvider;

    }

    public String playMatch() {
        int matchGamesP1 = 0;
        int matchGamesP2 = 0;

        int gamePointsP1 = 0;
        int gamePointsP2 = 0;

        System.out.println("Marcador del partido: " + matchGamesP1 + "-" + matchGamesP2);
        System.out.println("Marcador del juego: " + scoreTranslator.translate(gamePointsP1, gamePointsP2));

        while (!isMatchWon(matchGamesP1, matchGamesP2)) {
            int winner = pointProvider.getNextPointWinner();
            if (winner == 1) {
                gamePointsP1++;
            } else {
                gamePointsP2++;
            }

            String gameScore = scoreTranslator.translate(gamePointsP1, gamePointsP2);
            System.out.println("Marcador del juego: " + gameScore);
            if (gameScore.equals("Player 1 wins")) {
                matchGamesP1++;
                gamePointsP1 = 0;
                gamePointsP2 = 0;
                System.out.println("Marcador del partido: " + matchGamesP1 + "-" + matchGamesP2);
                System.out.println("Marcador del juego: " + scoreTranslator.translate(gamePointsP1, gamePointsP2));
            } else if (gameScore.equals("Player 2 wins")) {
                matchGamesP2++;
                gamePointsP1 = 0;
                gamePointsP2 = 0;
                System.out.println("Marcador del partido: " + matchGamesP1 + "-" + matchGamesP2);
                System.out.println("Marcador del juego: " + scoreTranslator.translate(gamePointsP1, gamePointsP2));
            }
        }

        if (matchGamesP1 > matchGamesP2) {
            return "Match won by Player 1, Score: " + matchGamesP1 + "-" + matchGamesP2;
        } else {
            return "Match won by Player 2, Score: " + matchGamesP1 + "-" + matchGamesP2;
        }
    }

    private boolean isMatchWon(int p1Games, int p2Games) {
        return (p1Games >= 4 || p2Games >= 4) && Math.abs(p1Games - p2Games) >= 2;
    }
}
