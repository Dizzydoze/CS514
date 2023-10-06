package QAInheritance;

import java.util.ArrayList;
import java.util.Scanner;


public class Quiz {

    private ArrayList<QA> QAList = new ArrayList<>();

    /**
     * Provide QAInheritance.Quiz with an *add* method that adds a new QAInheritance.QA (or one of its subclasses).
     * It should just forward the QAInheritance.QA to ArrayLists's add method.
     */
    public void add(QA question){
        this.QAList.add(question);
    }

    /**
     * - Provide QAInheritance.Quiz with a *run* method that administers a quiz consisting of all the QAs in the QAList.
     */
    public void run(){
        for (int i = 0; i < this.QAList.size() ; i++) {
            QA curQA = this.QAList.get(i);
            curQA.displayQuestion();
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.next();
            if (curQA.checkAnswer(answer)){
                System.out.println("correct");
            }
            else{
                System.out.println("incorrect");
                curQA.displayAnswer();
            }
        }
    }

    public static void main(String args[]) {
        // create an object of superclass (QAInheritance.QA) and use it
        QA qa = new QA("How many states are there?", "50");

        // create an object of subclass ChoiceQA and use it.
        ArrayList<String> choices = new ArrayList<String>();
        choices.add("a. Sacramento");
        choices.add("b. San Francisco");
        QA cqa = new ChoiceQA("What is the capital of California?", "a", choices);

        // create an object of subclass NumberRangeQA and use it
        NumberRangeQA nrqa = new NumberRangeQA("How old is David?", 55, 3);

        Quiz quiz = new Quiz();
        quiz.add(qa);
        quiz.add(cqa);
        quiz.add(nrqa);
        quiz.run();
    }
}