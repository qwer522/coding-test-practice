package programmers.level3.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DoublePriorityQueue {
    public static void main(String[] args) {
        String[] operations = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};
        int[] answer = {0, 0};
        List<Integer> doublePriorityQueue = new ArrayList<>();
        for (String operation : operations) {
            if (operation.startsWith("I")) {
                doublePriorityQueue.add(Integer.valueOf(operation.split(" ")[1]));
            } else if(operation.contains("D 1") && !doublePriorityQueue.isEmpty()) {
                doublePriorityQueue.sort(Comparator.naturalOrder());
                doublePriorityQueue.remove(doublePriorityQueue.size()-1);
            } else if(operation.contains("D -1") && !doublePriorityQueue.isEmpty()) {
                doublePriorityQueue.sort(Comparator.naturalOrder());
                doublePriorityQueue.remove(0);
            }
        }

        if (!doublePriorityQueue.isEmpty()) {
            if (doublePriorityQueue.size() == 1) {
                answer[0] = Math.max(doublePriorityQueue.get(0), 0);
                answer[1] = Math.min(doublePriorityQueue.get(0), 0);
            }else {
                doublePriorityQueue.sort(Comparator.naturalOrder());
                answer[0] = doublePriorityQueue.get(doublePriorityQueue.size()-1);
                answer[1] = doublePriorityQueue.get(0);
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}
