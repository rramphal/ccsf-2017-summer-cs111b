enscript --fancy-header --portrait --columns=1 --font=Courier@10 --line-numbers -p - --word-wrap --highlight=java --color=1 SuperLotto.java | pstopdf -i -o SuperLotto.pdf && open SuperLotto.pdf

enscript --fancy-header --portrait --columns=1 --font=Courier@10 --line-numbers -p - --word-wrap output.txt | pstopdf -i -o output.pdf && open output.pdf
