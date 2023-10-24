package MartianGenomeAbstract;

public class RepeaterDetector extends PatternDetector{

    int count;
    char letter;

    public RepeaterDetector(int count, char letter){
        this.count = count;
        this.letter = letter;
    }

    @Override
    public int detect(String buffer) {
        int cnt = 0;
        int start;
        for (int i = 0; i < buffer.length(); i++) {
            if (buffer.charAt(i) == this.letter){
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
        return "Repeat Letter: " + this.letter + " | " + "Repeat Count: " + this.count + '\n';
    }
}
