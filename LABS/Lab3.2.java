// Дадени се N состаноци со време на почеток и крај. 
//   Да се најде минималниот број на сали за состаноци потребен за да се одржат сите состаноци.


// Влез: Првиот број од влезот е бројот на состаноци N,
//   а потоа во следниот ред минутата на почнување и минутата на завршување на состанокот.



// Излез: Најмалиот потребен број на соби за состаноци за да можат да се одржат сите состаноци

// /

// We are given N scheduled meetings.
//   Write an algorithm that finds the minimum number of meeting rooms needed to schedule those meetings.

// Input: The first number in the input is the number of meetings N, 
//   then in the next N lines are the start and end time for each of the meetings.

// Output: The minimum number of needed meeting rooms to schedule the meetings.

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();
        int[][] intervals = new int[N][2];


        for (int i = 0; i < N; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }


        System.out.println(minMeetingRooms(intervals));

        sc.close();
    }

    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int startPointer = 0;
        int endPointer = 0;
        int numRooms = 0;

        while (startPointer < n) {
            if (starts[startPointer] <= ends[endPointer]) {
                startPointer++;
                numRooms++;
            } else {
                endPointer++;
startPointer++;
            }
        }


        return numRooms;
    }
}
