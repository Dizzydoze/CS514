package MartianGenome;

import java.util.ArrayList;

/**
 * GenomeSeriesAnalyzer should extend GenomeAnalyzer and define a list of PatternDetectors,
 * an addDetector method, and a “run” method.
 */
public class GenomeSeriesAnalyzer extends GenomeAnalyzer{

    // data member list of detectors
    private ArrayList<PatternDetector> detectors;

    /**
     * just get the input
     * @param fileName
     */
    public GenomeSeriesAnalyzer(String fileName) {
        super(fileName);
        this.detectors = new ArrayList<>();
    }

    public void addDetector(PatternDetector patternDetector){
        this.detectors.add(patternDetector);
    }

    /**
     * “run” should loop through all detectors that have been added and display the results.
     * It should use PatternDetector’s methods (labelString and additionalInfo) to display the info for the tests.
     */
    public void run(){

        for (PatternDetector patternDetector: this.detectors){
            String label = patternDetector.labelString();
            System.out.println("LABEL: " + label);
            int index = patternDetector.detect(this);
            System.out.println("INDEX: " + index);
            String additional = patternDetector.additionalInfo();
            System.out.println("ADDITIONAL: " + additional);
        }
    };

    public static void main(String[] args) {
        // create analyzer to read files and save to buffer
        GenomeSeriesAnalyzer genomeSeriesAnalyzer = new GenomeSeriesAnalyzer("/Users/single/workspaces/CS514-Labs/src/MartianGenome/test.txt");

        // add detectors into list
        GeniusDetector geniusDetector = new GeniusDetector();
        RepeaterDetector repeaterDetector = new RepeaterDetector(5, 'G');
        GastroDiseaseDetector gastroDiseaseDetector = new GastroDiseaseDetector();
        genomeSeriesAnalyzer.addDetector(geniusDetector);
        genomeSeriesAnalyzer.addDetector(repeaterDetector);
        genomeSeriesAnalyzer.addDetector(gastroDiseaseDetector);
        genomeSeriesAnalyzer.run();
    }
}
