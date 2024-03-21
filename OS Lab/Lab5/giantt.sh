#!/bin/bash

MAX=100

declare -a p
declare -i i j n sum_w_time=0 sum_t_time=0

echo "Enter total number of processes: "
read n

echo "Enter burst time for each process:"
for ((i=0; i<n; i++)); do
    p[$i]=$i
    echo -n "P[$((i+1))]: "
    read p_time
    p[$i]=$p_time
done

p[0]=${p[0]}

for ((i=1; i<n; i++)); do
    p[$i]=$((p[$i-1] + p[$i-1]))
done

for ((i=0; i<n; i++)); do
    sum_w_time=$((sum_w_time + p[$i]))
    sum_t_time=$((sum_t_time + p[$i]))
done

# Print table
echo ""  # Empty line
echo "+*****+*************+*************+*****************+"
echo "| PID | Burst Time | Waiting Time | Turnaround Time |"
echo "+*****+************+**************+*****************+"

for ((i=0; i<n; i++)); do
    printf "| %2d  |     %2d     |      %2d      |        %2d       |\n" "${p[i]}" "${p[i]}" "${p[i]}" "${p[i]}"
    echo "+-----+------------+--------------+-----------------+"
done

echo ""  # Empty line
echo "Total Waiting Time      : $sum_w_time"
echo "Average Waiting Time    : $(bc -l <<< "$sum_w_time / $n")"
echo "Total Turnaround Time   : $sum_t_time"
echo "Average Turnaround Time : $(bc -l <<< "$sum_t_time / $n")"

# Print Gantt chart
echo ""  # Empty line
echo "          GANTT CHART          "
echo "          ***********          "

# Gantt chart logic
echo -n " "
for ((i=0; i<n; i++)); do
    for ((j=0; j<p[i]; j++)); do
        echo -n "--"
    done
    echo -n " "
done
echo ""

echo -n "|"
for ((i=0; i<n; i++)); do
    for ((j=0; j<p[i]-1; j++)); do
        echo -n " "
    done
    echo -n "P${p[i].pid}"
    for ((j=0; j<p[i]-1; j++)); do
        echo -n " "
    done
    echo -n "|"
done
echo ""

echo -n " "
for ((i=0; i<n; i++)); do
    for ((j=0; j<p[i]; j++)); do
        echo -n "--"
    done
    echo -n " "
done
echo ""

echo -n "0"
for ((i=0; i<n; i++)); do
    for ((j=0; j<p[i]; j++)); do
        echo -n "  "
    done
    if [[ ${p[i].t_time} -gt 9 ]]; then
        echo -n "\b"
    fi
    echo -n "${p[i].t_time}"
done
echo ""
