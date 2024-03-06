# Write a shell script to check whether a the string is a vowel or consonant.

echo "Enter a character: "
read ch

case $ch in
    [aeiouAEIOU]) echo "Vowel";;
    [a-zA-Z]) echo "Consonant";;
    *) echo "Not a character";;
esac
