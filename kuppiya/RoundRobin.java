import java.util.*;

class Process {
    int pid; // Process ID
    int bt; // Burst Time
    int art; // Arrival Time
    int remainingTime; // Remaining Burst Time

    Process(int pid, int bt, int art) {
        this.pid = pid;
        this.bt = bt;
        this.art = art;
        this.remainingTime = bt;
    }
}

public class RoundRobin {
    static void findWaitingTime(Process[] processes, int n, int quantum, int[] wt, int[] tat) {
        int[] remainingBt = new int[n];

        for (int i = 0; i < n; i++) {
            remainingBt[i] = processes[i].bt;
        }

        int currentTime = 0;

        while (true) {
            boolean done = true;

            for (int i = 0; i < n; i++) {
                if (remainingBt[i] > 0) {
                    done = false;

                    if (remainingBt[i] > quantum) {
                        currentTime += quantum;
                        remainingBt[i] -= quantum;
                    } else {
                        currentTime += remainingBt[i];
                        wt[i] = currentTime - processes[i].bt - processes[i].art;
                        remainingBt[i] = 0;
                    }
                }
            }

            if (done)
                break;
        }

        for (int i = 0; i < n; i++) {
            tat[i] = processes[i].bt + wt[i];
        }
    }

    static void findavgTime(Process[] processes, int n, int quantum) {
        int[] wt = new int[n];
        int[] tat = new int[n];

        findWaitingTime(processes, n, quantum, wt, tat);

        int total_wt = 0, total_tat = 0;
        System.out.println("Process\tBurst Time\tArrival Time\tWaiting Time\tTurnaround Time");

        for (int i = 0; i < n; i++) {
            total_wt += wt[i];
            total_tat += tat[i];
            System.out.println(processes[i].pid + "\t\t" + processes[i].bt + "\t\t\t" + processes[i].art + "\t\t\t"
                    + wt[i] + "\t\t\t" + tat[i]);
        }

        System.out.println("\nAverage waiting time = " + (float) total_wt / (float) n);
        System.out.println("Average turnaround time = " + (float) total_tat / (float) n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        Process[] processes = new Process[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Process " + (i + 1) + ": ");
            System.out.print("Burst Time: ");
            int bt = sc.nextInt();
            System.out.print("Arrival Time: ");
            int art = sc.nextInt();
            processes[i] = new Process(i + 1, bt, art);
        }

        System.out.print("Enter time quantum: ");
        int quantum = sc.nextInt();

        findavgTime(processes, n, quantum);
    }
}
