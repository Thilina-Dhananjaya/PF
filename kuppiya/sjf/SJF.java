import java.util.Arrays;
import java.util.Scanner;

class Process {
    int processId;
    int arrivalTime;
    int burstTime;
    int completionTime;
    int turnaroundTime;
    int waitingTime;

    public Process(int processId, int arrivalTime, int burstTime) {
        this.processId = processId;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}

public class SJF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();

        Process[] processes = new Process[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for process " + (i + 1) + ":");
            System.out.print("Arrival Time: ");
            int arrivalTime = scanner.nextInt();
            System.out.print("Burst Time: ");
            int burstTime = scanner.nextInt();

            processes[i] = new Process(i + 1, arrivalTime, burstTime);
        }

        // Sort processes based on arrival time and burst time
        Arrays.sort(processes, (p1, p2) -> {
            if (p1.burstTime == p2.burstTime) {
                return Integer.compare(p1.arrivalTime, p2.arrivalTime);
            }
            return Integer.compare(p1.burstTime, p2.burstTime);
        });

        calculateCompletionTimes(processes);
        calculateTurnaroundTimes(processes);
        calculateWaitingTimes(processes);

        // Display results
        System.out.println("\nProcess\t    Arrival Time       \t\tBurst Time\t       \tCompletion Time\t       \tTurnaround Time\t       tWaiting Time");
        for (Process process : processes) {
            System.out.printf("%d\t\t%d\t\t\t%d\t\t\t%d\t\t\t%d\t\t\t%d%n",
                    process.processId, process.arrivalTime, process.burstTime,
                    process.completionTime, process.turnaroundTime, process.waitingTime);
        }

        // Calculate and display average turnaround time and waiting time
        double avgTurnaroundTime = calculateAverageTurnaroundTime(processes);
        double avgWaitingTime = calculateAverageWaitingTime(processes);

        System.out.printf("\nAverage Turnaround Time: %.2f%n", avgTurnaroundTime);
        System.out.printf("Average Waiting Time: %.2f%n", avgWaitingTime);
    }

    private static void calculateCompletionTimes(Process[] processes) {
        int currentTime = 0;

        for (Process process : processes) {
            currentTime = Math.max(currentTime, process.arrivalTime);
            process.completionTime = currentTime + process.burstTime;
            currentTime = process.completionTime;
        }
    }

    private static void calculateTurnaroundTimes(Process[] processes) {
        for (Process process : processes) {
            process.turnaroundTime = process.completionTime - process.arrivalTime;
        }
    }

    private static void calculateWaitingTimes(Process[] processes) {
        for (Process process : processes) {
            process.waitingTime = process.turnaroundTime - process.burstTime;
        }
    }

    private static double calculateAverageTurnaroundTime(Process[] processes) {
        double totalTurnaroundTime = 0;

        for (Process process : processes) {
            totalTurnaroundTime += process.turnaroundTime;
        }

        return totalTurnaroundTime / processes.length;
    }

    private static double calculateAverageWaitingTime(Process[] processes) {
        double totalWaitingTime = 0;

        for (Process process : processes) {
            totalWaitingTime += process.waitingTime;
        }

        return totalWaitingTime / processes.length;
    }
}
