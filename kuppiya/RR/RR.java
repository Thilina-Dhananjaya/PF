import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Process {
    int processId;
    int burstTime;
    int remainingBurstTime;

    public Process(int processId, int burstTime) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingBurstTime = burstTime;
    }
}

public class RR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();
        System.out.print("Enter the time quantum: ");
        int timeQuantum = scanner.nextInt();

        Queue<Process> processQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter burst time for process " + (i + 1) + ":");
            int burstTime = scanner.nextInt();
            processQueue.add(new Process(i + 1, burstTime));
        }

        // Perform Round Robin Scheduling
        performRoundRobin(processQueue, timeQuantum);

        // Display results
        displayResults(processQueue);
    }

    private static void performRoundRobin(Queue<Process> processQueue, int timeQuantum) {
        Queue<Process> roundRobinQueue = new LinkedList<>();

        while (!processQueue.isEmpty()) {
            Process currentProcess = processQueue.poll();
            int remainingBurstTime = currentProcess.remainingBurstTime;

            // Execute the process for the given time quantum
            if (remainingBurstTime <= timeQuantum) {
                executeProcess(currentProcess, remainingBurstTime);
            } else {
                executeProcess(currentProcess, timeQuantum);
                currentProcess.remainingBurstTime -= timeQuantum;
                roundRobinQueue.add(currentProcess);
            }

            // Move processes waiting in the round robin queue to the main queue
            while (!roundRobinQueue.isEmpty()) {
                processQueue.add(roundRobinQueue.poll());
            }
        }
    }

    private static void executeProcess(Process process, int executionTime) {
        System.out.println("Executing Process " + process.processId + " for time " + executionTime);
        process.remainingBurstTime -= executionTime;
    }

    private static void displayResults(Queue<Process> processQueue) {
        System.out.println("\nProcess\tBurst Time\tTurnaround Time\tWaiting Time");
        for (Process process : processQueue) {
            int turnaroundTime = process.burstTime - process.remainingBurstTime;
            int waitingTime = turnaroundTime - process.burstTime;

            System.out.printf("%d\t\t%d\t\t\t%d\t\t\t%d%n",
                    process.processId, process.burstTime, turnaroundTime, waitingTime);
        }
    }
}
