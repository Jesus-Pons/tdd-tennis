package p3dev;

public class RegularScoreRule implements IScoreRule{
    private final String[] scoreNames = {"love","fifteen","thirty","forty"};
    @Override
    public boolean applies(int scorePlayerOne, int scorePlayerTwo) {
        boolean areSocresInBounds = scorePlayerOne<4 && scorePlayerTwo<4;
        boolean isNotTie = scorePlayerOne !=scorePlayerTwo;
        boolean isLoveLove = scorePlayerOne == 0 && scorePlayerTwo ==0;
        return areSocresInBounds && (isNotTie || isLoveLove);
    }

    @Override
    public String getScore(int scorePlayerOne, int scorePlayerTwo) {
        return scoreNames[scorePlayerOne] + "-" + scoreNames[scorePlayerTwo];
    }

}
