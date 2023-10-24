package MartianGenomeInterface;


public interface PatternDetector {

    /**
     * int detect(GenomeAnalyzer analyzer); -- detects if pattern exists in analyzer code. Return the index if found, -1 if not.
     */
    int detect(GenomeAnalyzer analyzer);

    /**
     * String labelInfo(); -- a string describing the detector (for display)
     */
    String labelString();

    /**
     * String additionalInfo() -- a string describing additional info about an analysis
     * e.g., the exact string that matched. additionalInfo should have a default implementation that returns “”.
     */
    String additionalInfo();

    public static void main(String[] args) {

    }
}
