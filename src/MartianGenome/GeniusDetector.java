package MartianGenome;

/**
 * detectGenius -- a martian is a genius if it has the string, “GAGA” anywhere in its genome.
 * The method findSimpleSequence can be used.
 */
public class GeniusDetector implements PatternDetector{
    private final String GENIUS = "GAGA";

    @Override
    public int detect(GenomeAnalyzer analyzer) {
        return analyzer.findSimpleSequence(GENIUS);
    }

    @Override
    public String labelString() {
        return "GeniusDetector";
    }

    @Override
    public String additionalInfo() {
        return null;
    }
}
