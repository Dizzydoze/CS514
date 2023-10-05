import java.util.List;

public class Data {
    public static float average1(List<Measurable> list){
        float cnt = 0;
        // BankAccount is implementation of Measurable
        for (Measurable bankAccount: list){
            cnt += bankAccount.getMeasure();
        }
        return cnt / list.size();
    }

    // Generics
    public static <T extends Measurable> float average2(List<T> list){
        float cnt = 0;
        for (Measurable bankAccount: list){
            cnt += bankAccount.getMeasure();
        }
        return cnt / list.size();
    }
}
