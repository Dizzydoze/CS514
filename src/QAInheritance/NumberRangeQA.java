package QAInheritance;

public class NumberRangeQA extends QA{
    private int intAnswer;
    private int range;

    public NumberRangeQA(String question, int answer, int range){
        super(question, String.valueOf(answer));
        this.intAnswer = answer;
        this.range = range;
    }

    /**
     * Overriding the *checkAnswer* method of QAInheritance.QA
     * so that it checks if the answer is within the specified range.
     */
    @Override
    public boolean checkAnswer(String answer) {
        return this.intAnswer >= Integer.parseInt(answer) - this.range && this.intAnswer <= Integer.parseInt(answer) + this.range;
    }

    /**
     * Overriding the *displayQuestion* method of QAInheritance.QA.
     * so that when displaying the question, it lets the user know the "within" range.
     * The displayQuestion method should call super.displayQuestion, then add the additional part.
     */
    @Override
    public void displayQuestion() {
        super.displayQuestion();
        System.out.println("[WITHIN RANGE] " + this.range);
    }
}
