# To check whether the inputed number is a palindrome or not.

echo "Enter a number: "
read num

temp=$num
rev=0
while [ $num -gt 0 ]; do
    rem=`expr $num % 10`
    rev=`expr $rev \* 10 + $rem`
    num=`expr $num / 10`
done

if [ $temp -eq $rev ]; then
    echo "Palindrome"
else
    echo "Not a palindrome"
fi
