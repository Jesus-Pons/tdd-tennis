package p3dev;

public class DeuceScoreRule implements IScoreRule{
    @Override
    public boolean applies(int scorePlayerOne, int scorePlayerTwo) {
        return scorePlayerOne ==scorePlayerTwo && scorePlayerOne>=3;
    }

    @Override
    public String getScore(int scorePlayerOne, int scorePlayerTwo) {
        return "deuce";
    }

}
