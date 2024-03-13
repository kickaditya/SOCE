# To print the day of the week using switch case.

echo "Enter a number between 1 and 7"
read num

case $num in
    1) echo "Sunday";;
    2) echo "Monday";;
    3) echo "Tuesday";;
    4) echo "Wednesday";;
    5) echo "Thursday";;
    6) echo "Friday";;
    7) echo "Saturday";;
    *) echo "Invalid number";;
esac
