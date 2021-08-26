package programmers.level2;

import java.util.Arrays;

public class Lifeboat {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        int result = 0;
        int minIndex = 0;
        Arrays.sort(people);
        for (int i = people.length-1; minIndex < i; i--) {
            int sum = people[minIndex] + people[i];
            if (sum <= limit) {
                minIndex++;
            }
            result++;
        }
        System.out.println(result);
    }
}
