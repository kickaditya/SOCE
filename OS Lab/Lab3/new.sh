# Implement the first come first serve in operating systems by shell script. Keep everything inside a structure datatype and implement the FCFS algorithm. Calculat the arrivakl time totak time, waiting time and turnaround time. Simulate the value in the form of giantt chart.

# Structure
# 1. Input the number of processes
# 2. Input the arrival time and burst time of each process
# 3. Calculate the total time
# 4. Calculate the waiting time and turnaround time
# 5. Print the gantt chart

#!/bin/bash

declare -a arrival_time=(0 2 4 6)
declare -a burst_time=(5 3 2 4)

num_processes=${#arrival_time[@]}

declare -a waiting_time
declare -a turnaround_time

waiting_time[0]=0
turnaround_time[0]=burst_time[0]

for ((i=1; i<num_processes; i++))
do
    waiting_time[$i]=$((turnaround_time[$i-1] - arrival_time[$i]))
    turnaround_time[$i]=$((waiting_time[$i] + burst_time[$i]))
done

total_waiting_time=0
total_turnaround_time=0

for ((i=0; i<num_processes; i++))
do
    total_waiting_time=$((total_waiting_time + waiting_time[$i]))
    total_turnaround_time=$((total_turnaround_time + turnaround_time[$i]))
done

average_waiting_time=$(bc <<< "scale=2; $total_waiting_time / $num_processes")
average_turnaround_time=$(bc <<< "scale=2; $total_turnaround_time / $num_processes")

echo "Process   Arrival Time   Burst Time   Waiting Time   Turnaround Time"
for ((i=0; i<num_processes; i++))
do
    echo "P$i         ${arrival_time[$i]}              ${burst_time[$i]}             ${waiting_time[$i]}               ${turnaround_time[$i]}"
done

echo "Average Waiting Time: $average_waiting_time"
echo "Average Turnaround Time: $average_turnaround_time"