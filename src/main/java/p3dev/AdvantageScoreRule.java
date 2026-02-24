package p3dev;

public class AdvantageScoreRule implements IScoreRule{
    @Override
    public boolean applies(int scorePlayerOne, int scorePlayerTwo) {
        return scorePlayerOne >= 3 && scorePlayerTwo >= 3 && Math.abs(scorePlayerOne - scorePlayerTwo) == 1;
    }

    @Override
    public String getScore(int scorePlayerOne, int scorePlayerTwo) {
        if (scorePlayerOne>scorePlayerTwo){
            return "Advantage player 1";

        }else{
            return "Advantage player 2";
        }
    }
}
