# To print the prime numbers within a given range.

echo "Enter the range: "
read n

echo "Prime numbers within the range: "
for (( i=2; i<=n; i++ )); do
    flag=0
    for (( j=2; j<=i/2; j++ )); do
        if [ `expr $i % $j` -eq 0 ]; then
            flag=1
            break
        fi
    done
    if [ $flag -eq 0 ]; then
        echo $i
    fi
done
