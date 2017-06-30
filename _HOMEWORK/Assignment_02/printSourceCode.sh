enscript --fancy-header --portrait --columns=1 --font=Courier@10 --line-numbers -p - --word-wrap --highlight=java --color=1 Palindrome.java | pstopdf -i -o Palindrome.pdf && open Palindrome.pdf

enscript --fancy-header --portrait --columns=1 --font=Courier@10 --line-numbers -p - --word-wrap --highlight=bash --color=1 test_palindromes.sh | pstopdf -i -o test_palindromes.pdf && open test_palindromes.pdf

enscript --fancy-header --portrait --columns=1 --font=Courier@10 --line-numbers -p - --word-wrap palindromes.txt | pstopdf -i -o palindromes.pdf && open palindromes.pdf

enscript --fancy-header --portrait --columns=1 --font=Courier@10 --line-numbers -p - --word-wrap fake_palindromes.txt | pstopdf -i -o fake_palindromes.pdf && open fake_palindromes.pdf

enscript --fancy-header --portrait --columns=1 --font=Courier@10 --line-numbers -p - --word-wrap output.txt | pstopdf -i -o output.pdf && open output.pdf
