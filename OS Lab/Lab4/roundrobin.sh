# Implement the round robin algorithm in operating systems by shell script. Keep everything inside a structure datatype and implement the FCFS algorithm. Calculat the arrivakl time total time, waiting time and turnaround time. Simulate the value in the form of giantt chart.

# Structure
# 1. Input the number of processes
echo "Enter the number of processes:"
read num_processes

# Input the arrival time and burst time of each process
for ((i=1; i<=num_processes; i++))
do
    echo "Enter the arrival time of process $i:"
    read arrival_time[$i]
    echo "Enter the burst time of process $i:"
    read burst_time[$i]
done

# Input the time quantum of the round robin algorithm
echo "Enter the time quantum:"
read time_quantum

# Calculate the total time
total_time=0
for ((i=1; i<=num_processes; i++))
do
    total_time=$((total_time + burst_time[$i]))
done

# Calculate the waiting time and turnaround time
current_time=0
while [ $current_time -lt $total_time ]
do
    for ((i=1; i<=num_processes; i++))
    do
        if [ ${burst_time[$i]} -gt 0 ]
        then
            if [ ${burst_time[$i]} -gt $time_quantum ]
            then
                current_time=$((current_time + time_quantum))
                burst_time[$i]=$((burst_time[$i] - time_quantum))
            else
                current_time=$((current_time + burst_time[$i]))
                waiting_time[$i]=$((current_time - arrival_time[$i] - burst_time[$i]))
                turnaround_time[$i]=$((current_time - arrival_time[$i]))
                burst_time[$i]=0
            fi
        fi
    done
done

# Print the gantt chart
echo "Gantt Chart:"
for ((i=1; i<=num_processes; i++))
do
    echo "Process $i: ${arrival_time[$i]} - ${turnaround_time[$i]}"
done

# Print the waiting time and turnaround time
echo "Waiting Time:"
for ((i=1; i<=num_processes; i++))
do
    echo "Process $i: ${waiting_time[$i]}"
done

echo "Turnaround Time:"
for ((i=1; i<=num_processes; i++))
do
    echo "Process $i: ${turnaround_time[$i]}"
done