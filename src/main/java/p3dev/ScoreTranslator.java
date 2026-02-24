package p3dev;

public class ScoreTranslator {

    private final String[] scoreNames = {"love","fifteen","thirty","forty"};

    public String translate(int scorePlayerOne, int scorePlayerTwo){
        if(scorePlayerOne == 3 && scorePlayerTwo== 3) return "deuce";
        if(scorePlayerOne==scorePlayerTwo && scorePlayerOne>0) return scoreNames[scorePlayerOne]+"-all";
        return scoreNames[scorePlayerOne] + "-" + scoreNames[scorePlayerTwo];
    }
}
