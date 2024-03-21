# Implement the Round Robin algorithm in operating systems by shell script. Keep everything inside a structure datatype and implement the FCFS algorithm. Calculat the arrivakl time total time, waiting time and turnaround time. Simulate the value in the form of giantt chart.
# Structure
# 1. Input the number of processes
# 2. Input the arrival time and burst time of each process and time quantum
# 3. Calculate the total time
# 4. Calculate the waiting time and turnaround time
# 5. Print the gantt chart

# Define the structure for a process
struct Process {
    int arrival_time
    int burst_time
    int waiting_time
    int turnaround_time
}

# 1. Input the number of processes
echo "Enter the number of processes:"
read num_processes

# Declare an array of processes
declare -a processes

# Input the arrival time and burst time of each process
for ((i=0; i<num_processes; i++))
do
    echo "Enter the arrival time of process $((i+1)):"
    read arrival_time
    echo "Enter the burst time of process $((i+1)):"
    read burst_time

    # Create a new process and assign the input values
    process=Process
    process.arrival_time=$arrival_time
    process.burst_time=$burst_time

    # Add the process to the array
    processes[$i]=$process
done

# Input the time quantum of the round robin algorithm
echo "Enter the time quantum:"
read time_quantum

# Calculate the total time
total_time=0
for ((i=0; i<num_processes; i++))
do
    total_time=$((total_time + processes[$i].burst_time))
done

# Calculate the waiting time and turnaround time
current_time=0
while [ $current_time -lt $total_time ]
do
    for ((i=0; i<num_processes; i++))
    do
        if [ ${processes[$i].burst_time} -gt 0 ]
        then
            if [ ${processes[$i].burst_time} -gt $time_quantum ]
            then
                current_time=$((current_time + time_quantum))
                processes[$i].burst_time=$((processes[$i].burst_time - time_quantum))
            else
                current_time=$((current_time + processes[$i].burst_time))
                processes[$i].waiting_time=$((current_time - processes[$i].arrival_time - processes[$i].burst_time))
                processes[$i].turnaround_time=$((current_time - processes[$i].arrival_time))
                processes[$i].burst_time=0
            fi
        fi
    done
done

# Print the gantt chart
echo "Gantt Chart:"
for ((i=0; i<num_processes; i++))
do
    echo "Process $((i+1)): ${processes[$i].arrival_time} - ${processes[$i].turnaround_time}"
done

# Print the waiting time and turnaround time
echo "Waiting Time:"
for ((i=0; i<num_processes; i++))
do
    echo "Process $((i+1)): ${processes[$i].waiting_time}"
done

echo "Turnaround Time:"
for ((i=0; i<num_processes; i++))
do
    echo "Process $((i+1)): ${processes[$i].turnaround_time}"
done