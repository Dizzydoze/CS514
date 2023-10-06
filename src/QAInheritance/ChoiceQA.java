package QAInheritance;

import java.util.ArrayList;

public class ChoiceQA extends QA {
    ArrayList<String> choices = new ArrayList<String>();

    public ChoiceQA(String question, String answer, ArrayList<String> choices) {
        super(question, answer);
        this.choices = choices;
    }

    // override QAInheritance.QA's display question so that we include the choices
    @Override
    public void displayQuestion() {
        super.displayQuestion();
        System.out.println(this.choices);
    }
}
