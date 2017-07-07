enscript --fancy-header --portrait --columns=1 --font=Courier@10 --line-numbers -p - --word-wrap --highlight=java --color=1 PopulateUnique.java | pstopdf -i -o PopulateUnique.pdf && open PopulateUnique.pdf

enscript --fancy-header --portrait --columns=1 --font=Courier@10 --line-numbers -p - --word-wrap output.txt | pstopdf -i -o output.pdf && open output.pdf
