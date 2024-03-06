# To check whether the number is prime or not.

echo "Enter a number: "
read num

if [ $num -lt 2 ]; then
    echo "Not a prime number"
    exit
fi

i=2
while [ $i -lt $num ]; do
    if [ `expr $num % $i` -eq 0 ]; then
        echo "Not a prime number"
        exit
    fi
    i=`expr $i + 1`
done
echo "Prime number"
