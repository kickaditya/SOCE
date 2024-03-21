#!/bin/bash

# Define the process structure
declare -A Process

# Function to calculate waiting time and turnaround time
calculateTimes() {
    local -n processes=$1
    local total_time=0
    local remaining_processes=${#processes[@]}

    while ((remaining_processes > 0)); do
        local shortest_index=-1
        local shortest_burst_time=999999

        for ((i = 0; i < ${#processes[@]}; i++)); do
            if ((processes[i].arrival_time <= total_time && processes[i].burst_time < shortest_burst_time && processes[i].burst_time > 0)); then
                shortest_index=$i
                shortest_burst_time=${processes[i].burst_time}
            fi
        done

        if ((shortest_index == -1)); then
            ((total_time++))
            continue
        fi

        ((processes[shortest_index].burst_time--))
        ((total_time++))

        if ((processes[shortest_index].burst_time == 0)); then
            ((remaining_processes--))
            processes[shortest_index].turnaround_time=$((total_time - processes[shortest_index].arrival_time))
            processes[shortest_index].waiting_time=$((processes[shortest_index].turnaround_time - processes[shortest_index].burst_time))
        fi
    done
}

# Function to print the Gantt chart
printGanttChart() {
    local -n processes=$1

    echo "Gantt Chart:"
    for ((i = 0; i < ${#processes[@]}; i++)); do
        echo -n "P$i "
    done
    echo ""

    for ((i = 0; i < ${#processes[@]}; i++)); do
        echo -n "| "
        for ((j = 0; j < ${processes[i].burst_time}; j++)); do
            echo -n " "
        done
    done
    echo "|"

    for ((i = 0; i < ${#processes[@]}; i++)); do
        echo -n "${processes[i].arrival_time} "
        for ((j = 0; j < ${processes[i].burst_time}; j++)); do
            echo -n "P$i"
        done
    done
    echo "${processes[-1].arrival_time}"
}

# Main program
read -p "Enter the number of processes: " num_processes

# Declare an array to store the processes
declare -a processes

# Input the arrival time and burst time of each process
for ((i = 0; i < num_processes; i++)); do
    echo "Process $i:"
    read -p "  Arrival Time: " arrival_time
    read -p "  Burst Time: " burst_time

    # Create a new process and add it to the array
    processes+=("Process $i")
    processes[i].arrival_time=$arrival_time
    processes[i].burst_time=$burst_time
done

# Calculate the waiting time and turnaround time
calculateTimes processes

# Print the Gantt chart
printGanttChart processes
