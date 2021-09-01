package programmers.level2.stackqueue;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Printer {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        int answer = 0;

        Queue<Document> orderDocuments = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            orderDocuments.offer(new Document(priorities[i], i));
        }

        while (Objects.nonNull(orderDocuments.peek())) {
            Document poll = orderDocuments.poll();
            boolean isOffer = false;
            for (Document document : orderDocuments) {
                if (poll.getPrioritie() < document.getPrioritie()) {
                    isOffer = true;
                }
            }
            if (isOffer) {
                orderDocuments.offer(poll);
            } else {
                answer++;
                if (poll.getLocation() == location) {
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    public static class Document {
        private int prioritie;
        private int location;

        public Document(int prioritie, int location) {
            this.prioritie = prioritie;
            this.location = location;
        }

        public int getLocation() {
            return location;
        }

        public int getPrioritie() {
            return prioritie;
        }
    }
}
