import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Frame implements Comparable<Frame> {
    int seqNo;
    Integer data; // Use Integer to allow for null values

    public Frame(int seqNo, Integer data) {
        this.seqNo = seqNo;
        this.data = data;
    }

    @Override
    public int compareTo(Frame other) {
        return Integer.compare(this.seqNo, other.seqNo);
    }
}

public class Framesort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter the number of frames: ");
        int n = scanner.nextInt();

        List<Frame> frames = new ArrayList<>();

        List<Integer> seqList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = random.nextInt(n * 100) + 1;
            while (seqList.contains(x)) {
                x = random.nextInt(n * 100) + 1;
            }
            seqList.add(x);
        }

        for (int seqNo : seqList) {
            System.out.print(seqNo + " Frame data: ");
            int data = scanner.nextInt();
            frames.add(new Frame(seqNo, data));
        }

        // Sort frames based on sequence numbers
        Collections.sort(frames);

        // Print sorted frames
        for (Frame frame : frames) {
            System.out.println("Frame " + frame.seqNo + " : " + frame.data);
        }
    }
}

