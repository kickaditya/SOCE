#!/bin/bash

# Define the structure datatype
struct() {
    local name=$1
    shift
    local fields=$@
    eval "
        $name() {
            local i=1
            for field in $fields; do
                eval \"\${field}=\$i\"
                ((i++))
            done
        }
    "
}

# Define the process structure
struct Process "pid arrival_time burst_time priority waiting_time turnaround_time remaining_time"

# Function to calculate waiting time and turnaround time for each process
calculate_times() {
    local processes=("$@")
    local total_processes=${#processes[@]}

    # Sort the processes based on arrival time
    for ((i = 0; i < $((total_processes - 1)); i++)); do
        for ((j = 0; j < $((total_processes - i - 1)); j++)); do
            local current_arrival_time=${processes[j].arrival_time}
            local next_arrival_time=${processes[j + 1].arrival_time}
            if ((current_arrival_time > next_arrival_time)); then
                local temp=${processes[j]}
                processes[j]=${processes[j + 1]}
                processes[j + 1]=$temp
            fi
        done
    done

    # Calculate waiting time and turnaround time
    local current_time=0
    local total_waiting_time=0
    local total_turnaround_time=0
    local completed_processes=0

    while ((completed_processes < total_processes)); do
        local min_priority=9999
        local selected_process=-1

        for ((i = 0; i < total_processes; i++)); do
            if ((processes[i].arrival_time <= current_time && processes[i].remaining_time > 0 && processes[i].priority < min_priority)); then
                min_priority=${processes[i].priority}
                selected_process=$i
            fi
        done

        if ((selected_process == -1)); then
            ((current_time++))
            continue
        fi

        processes[selected_process].remaining_time=$((processes[selected_process].remaining_time - 1))

        if ((processes[selected_process].remaining_time == 0)); then
            completed_processes=$((completed_processes + 1))
            processes[selected_process].waiting_time=$((current_time - processes[selected_process].arrival_time - processes[selected_process].burst_time))
            processes[selected_process].turnaround_time=$((current_time - processes[selected_process].arrival_time))
            total_waiting_time=$((total_waiting_time + processes[selected_process].waiting_time))
            total_turnaround_time=$((total_turnaround_time + processes[selected_process].turnaround_time))
        fi

        ((current_time++))
    done

    # Calculate average waiting time and average turnaround time
    local avg_waiting_time=$(bc <<<"scale=2; $total_waiting_time / $total_processes")
    local avg_turnaround_time=$(bc <<<"scale=2; $total_turnaround_time / $total_processes")

    # Print the results
    echo "ProcessID ArrivalTime BurstTime Priority WaitingTime TurnaroundTime"
    for ((i = 0; i < total_processes; i++)); do
        echo "${processes[i].pid} ${processes[i].arrival_time} ${processes[i].burst_time} ${processes[i].priority} ${processes[i].waiting_time} ${processes[i].turnaround_time}"
    done
    echo "Average Waiting Time: $avg_waiting_time"
    echo "Average Turnaround Time: $avg_turnaround_time"
}

# Main program

# Take user input for number of processes
read -p "Enter the number of processes: " num_processes

# Create an array of processes
processes=()
for ((i = 0; i < num_processes; i++)); do
    read -p "Enter the arrival time for process $((i + 1)): " arrival_time
    read -p "Enter the burst time for process $((i + 1)): " burst_time
    read -p "Enter the priority for process $((i + 1)): " priority

    processes+=("Process $((i + 1)) $arrival_time $burst_time $priority 0 0 $burst_time")
done

# Call the function to calculate waiting time and turnaround time
calculate_times "${processes[@]}"