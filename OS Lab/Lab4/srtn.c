// Implement the Shortest remaining time algorithm in operating systems by shell script. Keep everything inside a structure datatype and implement the FCFS algorithm. Calculat the arrivakl time total time, waiting time and turnaround time. Simulate the value in the form of giantt chart.
// Structure
// 1. Input the number of processes
// 2. Input the arrival time and burst time of each process and time quantum
// 3. Calculate the total time
// 4. Calculate the waiting time and turnaround time
// 5. Print the gantt chart

#include <stdio.h>
#include <stdlib.h>

struct process
{
    int pid;
    int arrival_time;
    int burst_time;
    int waiting_time;
    int turnaround_time;
    int remaining_time;
};

void sort(struct process *p, int n)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n - i - 1; j++)
        {
            if (p[j].arrival_time > p[j + 1].arrival_time)
            {
                struct process temp = p[j];
                p[j] = p[j + 1];
                p[j + 1] = temp;
            }
        }
    }
}

int main()
{
    int n;
    printf("Enter the number of processes: ");
    scanf("%d", &n);
    struct process *p = (struct process *)malloc(n * sizeof(struct process));
    for (int i = 0; i < n; i++)
    {
        printf("Enter the arrival time of process %d: ", i + 1);
        scanf("%d", &p[i].arrival_time);
        printf("Enter the burst time of process %d: ", i + 1);
        scanf("%d", &p[i].burst_time);
        p[i].pid = i + 1;
        p[i].remaining_time = p[i].burst_time;
    }
    sort(p, n);
    int total_time = 0;
    for (int i = 0; i < n; i++)
    {
        total_time += p[i].burst_time;
    }
    int *gantt_chart = (int *)malloc((total_time + 1) * sizeof(int));
    int current_time = 0;
    int completed = 0;
    while (completed < n)
    {
        int min_remaining_time = 1000000;
        int min_remaining_time_index = -1;
        for (int i = 0; i < n; i++)
        {
            if (p[i].arrival_time <= current_time && p[i].remaining_time < min_remaining_time && p[i].remaining_time > 0)
            {
                min_remaining_time = p[i].remaining_time;
                min_remaining_time_index = i;
            }
        }
        if (min_remaining_time_index == -1)
        {
            gantt_chart[current_time] = 0;
            current_time++;
        }
        else
        {
            gantt_chart[current_time] = p[min_remaining_time_index].pid;
            p[min_remaining_time_index].remaining_time--;
            current_time++;
            if (p[min_remaining_time_index].remaining_time == 0)
            {
                completed++;
                p[min_remaining_time_index].turnaround_time = current_time - p[min_remaining_time_index].arrival_time;
                p[min_remaining_time_index].waiting_time = p[min_remaining_time_index].turnaround_time - p[min_remaining_time_index].burst_time;
            }
        }
    }
    printf("Gantt Chart: ");
    for (int i = 0; i < total_time; i++)
    {

        printf("%d -> ", gantt_chart[i]);
    }

    printf("%d\n", gantt_chart[total_time]);

    printf("PID\tAT\tBT\tWT\tTAT\n");
    for (int i = 0; i < n; i++)
    {
        printf("%d\t%d\t%d\t%d\t%d\n", p[i].pid, p[i].arrival_time, p[i].burst_time, p[i].waiting_time, p[i].turnaround_time);
    }
    return 0;
}
