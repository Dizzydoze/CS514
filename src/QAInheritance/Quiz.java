package QAInheritance;

public class Quiz {
    public static void main(String args[]) {
        // create an object of superclass (QAInheritance.QA) and use it
        QA qa = new QA("How many states are there?", "50");
        qa.displayQuestion();
        // create an object of subclass and use it.
        ArrayList<String> choices = new ArrayList<String>();
        choices.add("a. Sacramento");
        choices.add("b. San Francisco");
        QA cqa = new ChoiceQA("What is the capital of California?", "a", choices);
        cqa.displayQuestion();
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        if (cqa.checkAnswer(answer)) {
            System.out.println("correct");
        } else {
            System.out.println("incorrect");
            cqa.displayAnswer()
        }
    }
