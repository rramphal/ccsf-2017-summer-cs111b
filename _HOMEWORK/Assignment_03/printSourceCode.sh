enscript --fancy-header --portrait --columns=1 --font=Courier@10 --line-numbers -p - --word-wrap --highlight=java --color=1 NameSwapper.java | pstopdf -i -o NameSwapper.pdf && open NameSwapper.pdf

enscript --fancy-header --portrait --columns=1 --font=Courier@10 --line-numbers -p - --word-wrap datafile | pstopdf -i -o datafile.pdf && open datafile.pdf

enscript --fancy-header --portrait --columns=1 --font=Courier@10 --line-numbers -p - --word-wrap datafile.fix | pstopdf -i -o datafile.fix.pdf && open datafile.fix.pdf
