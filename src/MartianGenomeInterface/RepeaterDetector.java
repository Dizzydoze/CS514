package MartianGenomeInterface;

/**
 * detectRepeater - a martian who tends to repeat his words can be detected if,
 * anywhere in his genome, the letter G is repeated five times in a row.
 * findSimpleSequence can be used here,
 * and you should define the constructor with parameters so that it can be used for other repeat sequences.
 */
public class RepeaterDetector implements PatternDetector{
    int count;
    char letter;

    public RepeaterDetector(int count, char letter){
        this.count = count;
        this.letter = letter;
    }
    @Override
    public int detect(GenomeAnalyzer analyzer) {
        int cnt = 0;
        int start;
        for (int i = 0; i < analyzer.buffer.length(); i++) {
            if (analyzer.buffer.charAt(i) == this.letter){
                start = i;  // save the start of the matched char
                cnt += 1;   // add up count
            }
            else{
                cnt = 0;    // reset cnt
                start = 0;  // reset start
            }
            if (cnt == this.count) {
                return start - 4;
            }
        }
        return -1;
    }

    @Override
    public String labelString() {
        return "RepeaterDetector";
    }

    @Override
    public String additionalInfo() {
        return "Repeat Letter: " + this.letter + " | " + "Repeat Count: " + this.count;
    }
}
