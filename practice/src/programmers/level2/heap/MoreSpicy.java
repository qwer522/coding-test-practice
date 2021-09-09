package programmers.level2.heap;

import java.util.PriorityQueue;

public class MoreSpicy {
    public static void main(String[] args) {
        int answer = 0;
        int[] scoville = {0,4,0,0};
        int K = 10;
        PriorityQueue<Integer> priorityScovilleQueue = new PriorityQueue<>();
        boolean isAllZero = true;
        boolean isNonMake = true;
        for (int i : scoville) {
            if (i < K) {
                if (i > 0) {
                    isAllZero = false;
                }
                priorityScovilleQueue.add(i);
            }
        }
        if (isAllZero) {
            answer = -1;
        }else {
            while (priorityScovilleQueue.size() > 1) {
                int mixScoville;
                answer++;
                mixScoville = priorityScovilleQueue.poll() + (priorityScovilleQueue.poll() * 2);
                if (mixScoville < K) {
                    priorityScovilleQueue.add(mixScoville);
                } else {
                    isNonMake = false;
                }
            }
            if (isNonMake) {
                answer = -1;
            }else {
                answer += priorityScovilleQueue.size();
            }
        }

        System.out.println(answer);

    }
}
