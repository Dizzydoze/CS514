package MartianGenomeAbstract;

public class GeniusDetector extends PatternDetector{

    private final String GENIUS = "GAGA";
    @Override
    public int detect(String buffer) {
        return super.findSimpleSequence(buffer, GENIUS);
    }

    @Override
    public String labelString() {
        return "GeniusDetector";
    }
}
