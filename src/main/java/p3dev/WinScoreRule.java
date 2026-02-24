package p3dev;

public class WinScoreRule implements IScoreRule{
    @Override
    public boolean applies(int scorePlayerOne, int scorePlayerTwo) {
        boolean someoneHasReachedFour = scorePlayerOne >= 4 || scorePlayerTwo >= 4;
        boolean differenceIsAtLeastTwo = Math.abs(scorePlayerOne - scorePlayerTwo) >= 2;

        return someoneHasReachedFour && differenceIsAtLeastTwo;
    }

    @Override
    public String getScore(int scorePlayerOne, int scorePlayerTwo) {
        if (scorePlayerOne>scorePlayerTwo){
            return "Player 1 wins";
        }else{
            return "Player 2 wins";
        }
    }
}
