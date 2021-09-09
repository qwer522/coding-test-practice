package programmers.level3.heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class DiskController {
    public static void main(String[] args) {
        int[][] jobs = {{1, 9}, {2, 6}, {0, 3}};
        int answer = 0;
        LinkedList<Job> waiting = new LinkedList<>();
        PriorityQueue<Job> progress =
            new PriorityQueue<>(Comparator.comparingInt(j -> j.workingTime));

        for (int[] job : jobs) {
            waiting.offer(new Job(job[0], job[1]));
        }

        Collections.sort(waiting, Comparator.comparingInt(j -> j.requestTime));

        int cnt = 0;
        int time = waiting.peek().requestTime;

        while (cnt < jobs.length) {
            while (!waiting.isEmpty() && waiting.peek().requestTime <= time) {
                progress.offer(waiting.pollFirst());
            }

            if (!progress.isEmpty()) {
                Job job = progress.poll();
                time += job.workingTime;
                answer += time - job.requestTime;
                cnt++;
            } else {
                time++;
            }
        }
        System.out.println(answer);
    }

    static class Job {
        int requestTime;
        int workingTime;

        Job(int requestTime, int workingTime) {
            this.requestTime = requestTime;
            this.workingTime = workingTime;
        }
    }
}
