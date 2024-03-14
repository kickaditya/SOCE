# Implement the First Come First Serve in operating systems by shell script. Keep everything inside a structure datatype and implement the FCFS algorithm. Calculate the arrival time, total time, waiting time, and turnaround time. Simulate the values in the form of a Gantt chart.
# Structure
# 1. Input the number of processes
# 2. Input the arrival time and burst time of each process
# 3. Calculate the total time
# 4. Calculate the waiting time and turnaround time
# 5. Print the gantt chart

#!/bin/bash

# Define the structure datatype
struct Process {
    int arrival_time
    int burst_time
    int waiting_time
    int turnaround_time
}

# Input the number of processes
read -p "Enter the number of processes: " num_processes

# Declare an array of Process structures
declare -a processes

# Input the arrival time and burst time of each process
for ((i=0; i<num_processes; i++))
do
    echo "Process $i"
    read -p "Enter the arrival time: " arrival_time
    read -p "Enter the burst time: " burst_time

    # Create a new Process structure and assign values
    processes[$i]=${Process}
    processes[$i].arrival_time=$arrival_time
    processes[$i].burst_time=$burst_time
done

# Calculate the total time
total_time=0
for ((i=0; i<num_processes; i++))
do
    total_time=$((total_time + processes[$i].burst_time))
done

# Calculate the waiting time and turnaround time
processes[0].waiting_time=0
processes[0].turnaround_time=processes[0].burst_time

for ((i=1; i<num_processes; i++))
do
    processes[$i].waiting_time=$((processes[$i-1].turnaround_time - processes[$i].arrival_time))
    processes[$i].turnaround_time=$((processes[$i].waiting_time + processes[$i].burst_time))
done

# Print the Gantt chart
echo "Gantt Chart:"
for ((i=0; i<num_processes; i++))
do
    echo -n "P$i "
done
echo ""

# Print the process details
echo "Process   Arrival Time   Burst Time   Waiting Time   Turnaround Time"
for ((i=0; i<num_processes; i++))
do
    echo "P$i         ${processes[$i].arrival_time}              ${processes[$i].burst_time}             ${processes[$i].waiting_time}               ${processes[$i].turnaround_time}"
done

# Calculate the average waiting time and average turnaround time
total_waiting_time=0
total_turnaround_time=0

for ((i=0; i<num_processes; i++))
do
    total_waiting_time=$((total_waiting_time + processes[$i].waiting_time))
    total_turnaround_time=$((total_turnaround_time + processes[$i].turnaround_time))
done

average_waiting_time=$(bc <<< "scale=2; $total_waiting_time / $num_processes")
average_turnaround_time=$(bc <<< "scale=2; $total_turnaround_time / $num_processes")

echo "Average Waiting Time: $average_waiting_time"
echo "Average Turnaround Time: $average_turnaround_time"