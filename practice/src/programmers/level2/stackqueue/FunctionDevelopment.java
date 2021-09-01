package programmers.level2.stackqueue;

import java.util.ArrayList;
import java.util.List;

public class FunctionDevelopment {
    public static void main(String[] args) {
        int[] progresses = {99, 20, 1};
        int[] speeds = {3, 1, 10};
        int[] days = new int[progresses.length];
        List<Integer> answers = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remainder = 100 - progresses[i];
            days[i] = Double.valueOf(Math.ceil((double) remainder / (double) speeds[i])).intValue();
        }

        int progressDay = Integer.MIN_VALUE;
        int count = Integer.MIN_VALUE;
        for (int day : days) {
            if (progressDay < day) {
                if (count != Integer.MIN_VALUE) {
                    answers.add(count);
                }
                progressDay = day;
                count = 1;
            }else {
                count++;
            }
        }

        if (count != Integer.MIN_VALUE) {
            answers.add(count);
        }
        System.out.println(answers);
        //System.out.println(answers.stream().mapToInt(i->i).toArray());

    }
}
