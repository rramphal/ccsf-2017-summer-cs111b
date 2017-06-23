enscript --fancy-header --portrait --columns=1 --font=Courier@10 --line-numbers -p - --word-wrap --highlight=java --color=1 Box.java | pstopdf -i -o Box.pdf && open Box.pdf
enscript --fancy-header --portrait --columns=1 --font=Courier@10 --line-numbers -p - --word-wrap --highlight=java --color=1 DemoBox.java | pstopdf -i -o DemoBox.pdf && open DemoBox.pdf
enscript --fancy-header --portrait --columns=1 --font=Courier@10 --line-numbers -p - --word-wrap output.txt | pstopdf -i -o output.pdf && open output.pdf
