package QAInheritance;

/**
 * 1. Create a new Intellij project with the code from [here](https://www.notion.so/Inheritance-Worksheet-c2ca245d5e0d467ca32a91827801a294?pvs=21). Run the QAInheritance.Quiz class-- it just creates two types of questions and allows the user to answer.
 * 2. Create a second subclass of QAInheritance.QA, NumberRangeQA, which allows for integer answers that fall within a range, e.g., "How old is David Wolber" and the answer can be within 3 years
 * Define NumberRangeQA as:
 * - extending QAInheritance.QA
 * - with integer data members for *intAnswer* and *range*
 * - with a constructor which accepts a question, an answer of type int, and parameter for how close the answer must be. The constructor should use super to call QAInheritance.QA's constructor.
 * - Overriding the *checkAnswer* method of QAInheritance.QA so that it checks if the answer is within the specified range.
 * - Overriding the *displayQuestion* method of QAInheritance.QA. so that when displaying the question, it lets the user know the "within" range. The displayQuestion method should call super.displayQuestion, then add the additional part.
 * Test your NumberRangeQA class by adding to the code in QAInheritance.Quiz.
 * 3. Modify the QAInheritance.Quiz class to create and administer a quiz with at least three questions and at least one each of types QAInheritance.QA, QAInheritance.ChoiceQA, and NumberRangeQA. Follow these specifications:
 * - Provide QAInheritance.Quiz with a private data member QAList of type ArrayList.
 * - Provide QAInheritance.Quiz with an *add* method that adds a new QAInheritance.QA (or one of its subclasses). It should just forward the QAInheritance.QA to ArrayLists's add method.
 * - Provide QAInheritance.Quiz with a *run* method that administers a quiz consisting of all the QAs in the QAList.
 * - Modify main so that it creates 3 questions of different types, adds them, then calls run to administer the quiz.
 * 4. Write a class ScoredQuiz which is a subclass of QAInheritance.Quiz and adds code to keep a tally of the correct and incorrect answers. Reuse as much of the code in QAInheritance.Quiz as you can. You may need to and are welcome to refactor QAInheritance.Quiz to make it easier for your subclass to reuse code.
 */


public class QA {
    protected String question;
    protected String answer;
    public QA(String q, String a) {
        this.question = q;
        this.answer = a;
    }
    public void displayQuestion() {
        System.out.println(question);
    }
    public boolean checkAnswer (String userAnswer) {
        return this.answer.equals(userAnswer);
    }
    public void displayAnswer() {
        System.out.println("The correct answer is:"+ answer);
    }
}
