package p3dev;

public class TieScoreRule implements IScoreRule{
    private final String[] scoreNames = {"love","fifteen","thirty","forty"};
    @Override
    public boolean applies(int scorePlayerOne, int scorePlayerTwo) {
        return scorePlayerOne==scorePlayerTwo && scorePlayerOne>0 && scorePlayerOne<3;
    }

    @Override
    public String getScore(int scorePlayerOne, int scorePlayerTwo) {
        return scoreNames[scorePlayerOne]+"-all";
    }

}
