# To print the n number of fibbonacci series.

echo "Enter the number of terms: "
read n

a=0
b=1
i=2
echo "Fibbonacci series: "
echo $a
echo $b
while [ $i -lt $n ]; do
    c=`expr $a + $b`
    echo $c
    a=$b
    b=$c
    i=`expr $i + 1`
done
