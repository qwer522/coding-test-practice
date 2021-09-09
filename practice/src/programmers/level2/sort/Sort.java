package programmers.level2.sort;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sort {
    public static void main(String[] args) {
        int[] citations = {12,11,10,9,8,1};
        int answer = 0;
        List<Integer> citationsList = IntStream.of(citations)
            .boxed()
            .sorted(Collections.reverseOrder())
            .collect(Collectors.toList());
        for (int i = 0; i < citationsList.size(); i++) {
            if ((i+1) > citationsList.get(i)) {
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }
}
