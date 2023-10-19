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
        // for GTG, length should be >= 3
        if (buffer.length() < 3){
            return -1;
        }
        // traverse the whole buffer string, find GT*G patterns
        for (int i = 0; i < buffer.length() - 2; i++) {
            if (buffer.charAt(i) == 'G' && buffer.charAt(i + 1) == 'T'){
                // loop the rest of the buffer
                for (int j = i + 2; j < buffer.length(); j++) {
                   if (buffer.charAt(j) != 'T' && buffer.charAt(j) != 'G'){
                       i = j + 1;
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
