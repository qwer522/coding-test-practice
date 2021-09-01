package programmers.level2.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class Bridge {
    public static void main(String[] args) {
        int bridge_length = 3;
        int weight = 10;
        int[] truck_weights = {7,4,3,4};
        int answer = 0;
        Queue<Integer> progress = new LinkedList<>();
        int bridgeWeights = 0;
        int index = 0;

        while (true) {
            if (index == truck_weights.length) {
                break;
            }
            answer++;
            if (progress.size() == bridge_length) {
                bridgeWeights -= progress.poll();
            }
            if ((bridgeWeights+truck_weights[index]) <= weight) {
                bridgeWeights += truck_weights[index];
                progress.offer(truck_weights[index]);
                index++;
            } else {
                progress.offer(0);
            }
        }
        answer += bridge_length;
        System.out.println(answer);

    }
}
