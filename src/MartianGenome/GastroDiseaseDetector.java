package MartianGenome;

/**
 * detectGastroDisease - a martian has gastro disease if it contains a string that begins with G,
 * followed by one or more Ts, followed by another G.
 * So GTTTG and GTG fit the pattern, but GTTTC does not.
 */
public class GastroDiseaseDetector implements PatternDetector{
    @Override
    public int detect(GenomeAnalyzer analyzer) {
        String buffer = analyzer.getBuffer();
        for (int i = 0; i < buffer.length() - 2; i++) {
            if (buffer.charAt(i) == 'G' && buffer.charAt(i + 1) == 'T'){
                // loop the rest of the buffer
                for (int j = i + 1; j < buffer.length() - 1; j++) {
                   if (buffer.charAt(j) != 'T' && buffer.charAt(j) != 'G'){
                       break;
                   }
                   else if(buffer.charAt(j) == 'G'){
                       return i;
                   }
                }
            }
        }
        return -1;
    }

    @Override
    public String labelString() {
        return "GastroDiseaseDetector";
    }

    @Override
    public String additionalInfo() {
        return null;
    }
}
