#!/bin/bash

# AUTHOR: Ravi S. Ramphal
# CLASS:  CCSF CS111B
# DATE:   2017.06.29
#
# These lists were created from scraping the lists of palindromes
# available at http://www.palindromelist.net/. It was manually sanitized
# to remove the comments (Ex.: "Malayalam (language)" --> "Malayalam").
#
# The two files were created using the same `Palindrome` program tested below.
# `shouldPass` were all the lines that passed, and
# `shouldFail` were all the lines that were presented as valid palidromes
#     on the website, but are in fact erroneous.
# The validity of these two lists can be manually inspected to verify accuracy.
#
# This script below confirms the findings yielded from the above process.
# In two loops, the respective files are passed in. If the results are as
# expected, then a period (`.`) is printed. If they are not as expected, then
# an `F` is printed to indicate an error.

##########################################
################# CONFIG #################
##########################################

shouldPass="palindromes.txt"
shouldFail="fake_palindromes.txt"

##########################################

echo;
echo "SHOULD PASS";

while read -r line
do
  if java Palindrome "$line" | grep -q 'IS a palindrome'; then
        echo -n '.'
    else
        echo -n 'F'
    fi
done < "$shouldPass"

##########################################

echo;
echo;
echo "SHOULD FAIL";

while read -r line
do
    if java Palindrome "$line" | grep -q 'IS a palindrome'; then
        echo -n '.'
    else
        echo -n 'F'
    fi
done < "$shouldFail"
