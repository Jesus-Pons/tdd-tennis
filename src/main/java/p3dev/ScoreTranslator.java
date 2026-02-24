package p3dev;

public class ScoreTranslator {

    private final IScoreRule[] rules;

    public ScoreTranslator(){
        rules = new IScoreRule[]{
                new DeuceScoreRule(),
                new TieScoreRule(),
                new RegularScoreRule()
        };
    }

    private final String[] scoreNames = {"love","fifteen","thirty","forty"};

    public String translate(int scorePlayerOne, int scorePlayerTwo){
        for (IScoreRule rule: rules){
            if (rule.applies(scorePlayerOne,scorePlayerTwo)){
                return rule.getScore(scorePlayerOne, scorePlayerTwo);
            }
        }
        return "invalid score";
    }
}
