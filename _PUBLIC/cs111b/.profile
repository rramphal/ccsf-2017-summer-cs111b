# Developer's ksh .profile
# History:     cool stuff thanks to Abbas Moghtanei
#              last rev. 08/09/2008
# hills & fog version

set -o allexport
set -o vi   # --@@--
set -o monitor
set -o ignoreeof

#PATH=$PATH:/usr/bin/X11:/usr/local/bin:/etc:/usr/java/bin:.
PATH=/opt/java6:/opt/java6/bin:$PATH
PATH=$PATH:/usr/bin/X11:/usr/local/bin:/etc:.
PATH=$PATH:$HOME/bin:/usr/sbin
export PATH
export PAGER=more
export MYNANE="Abbas Moghtanei"
export LANG=C
##############################################################################

export HISTFILE=~/.hist$$
export HISTSIZE=512
export HISTEDIT=vi
export EDITOR=vi
export VISUAL=vi  # --@@--
export FCEDIT=vi
#export TERM=vt100
export TERM=ansi
export EXINIT='set aw sm smd noeb ts=4'
stty -tabs erase  "^?"  stop ^S intr ^C
stty kill ^K
if [ -f /bin/tset ]; then
   tset -I -Q
fi

alias chekroot='rootflag=$(id|grep "(root)")'
eval  chekroot
if [ -n "$rootflag" ]; then 
   PS1='$PWD# '
else
   PS1='$PWD> '
fi

PS2='>'
PS3="Select: "
PS4='(Trace $LINENO): '
export PS1 PS2 PS3 PS4
###############################################################################
umask 022
#ENV=$HOME/.kshrc
#export ENV
####################################aliases####################################
if [ $(basename $SHELL) = "ksh" ]; then
   X="-x"
else
   X=
fi
alias $X a=alias $X
alias $X h='fc -l'
alias $X home='cd'
alias $X l=ls
alias $X ll='ls -l'
alias $X runlevel='who -r'
alias $X lll='ls -lt | head -15'
alias $X lsh='lsdot'
alias $X irb='irb --simple-prompt'
alias $X runlevel='who -r'
#alias $X getmac='/usr/sbin/lanscan|grep lan0|tr -s " " " "|cut -d" " -f2 '
alias $X getmac="ifconfig -a|grep -i 'hwaddr'|tr -s ' ' ' '|cut -d' ' -f1,5"
alias $X ctrl_h='stty erase "^H"'
alias $X ctrl_q='stty erase "^?"'
alias $X dba1='ssh 147.144.23.61'
alias $X dba2='ssh 147.144.23.62'
alias $X newdba1='ssh 147.144.23.161'
alias $X dba3='ssh 147.144.23.163'
alias $X dba4='ssh 147.144.23.164'
alias $X dba5='ssh 147.144.23.165'
alias $X dba6='ssh 147.144.23.166'
alias $X dba-demo='ssh 147.144.23.170'
alias $X net1='telnet 147.144.23.57'
alias $X net2='telnet 147.144.23.58'
alias $X patty='ssh 147.144.23.37'
alias $X selma='ssh 147.144.23.38'
alias $X L424='ssh 10.100.20.35'
alias $X springfield='ssh 147.144.23.30'
alias $X shelbyville='ssh 147.144.23.68'
alias $X silver='ssh 147.144.23.64'
alias $X copper='ssh 147.144.23.63'
alias $X shell='grep "`whoami`" /etc/passwd|cut -d: -f7' 
alias $X BOLD='printf    "\033[1m"'
alias $X BBLACK='printf  "\033[40m"'
alias $X BLACK='printf   "\033[30m"'
alias $X RED='printf     "\033[31m"'
alias $X GREEN='printf   "\033[32m"'
alias $X YELLOW='printf  "\033[33m"'
alias $X BLUE='printf    "\033[34m"'
alias $X MAGENTA='printf "\033[35m"'
alias $X CYAN='printf    "\033[36m"'
alias $X WHITE='printf   "\033[37m"'
alias $X os='uname -a'
alias $X pico='/usr/bin/nano'
alias $X cmx='chmod +x'
alias $X FOG='ssh fog.ccsf.edu'
alias $X xt='xterm -fn courR14 &'
alias $X xtb='xterm -bg black -fg green -fn courR14 &'
alias $X pubdir='cd /pub/cs/amoghtan/'
alias $X utildir='cd /pub/cs/amoghtan/util'
alias $X sd='ls -al | grep "^d" | grep -v "\.\.$" | grep -v "\.$"'
alias $X vw='view'
alias $X reset='stty sane; tput sgr0'
alias $X bye='clear; reset;exit'
alias $X logout='clear; reset;exit'
alias $X logoff='clear; reset;exit'
alias $X av='appletviewer'
alias $X CNIT225='cd /pub/cs/amoghtan/cnit225'
alias $X CNIT270='cd /pub/cs/amoghtan/cnit270'
alias $X CS151B='cd /pub/cs/amoghtan/cs151b'
alias $X CS261A='cd /pub/cs/amoghtan/cs261A'
alias $X CS262='cd /pub/cs/amoghtan/cs262'
alias $X CS261B='cd /pub/cs/amoghtan/cs261b'
alias $X CS155A='cd /pub/cs/amoghtan/cs155a'
alias $X CS155B='cd /pub/cs/amoghtan/cs155b'
alias $X CS177='cd /pub/cs/amoghtan/cs177'
alias $X CS113A='cd /pub/cs/amoghtan/cs113a'
alias $X CS113B='cd /pub/cs/amoghtan/cs113b'
alias $X CS111A='cd /pub/cs/amoghtan/cs111a'
alias $X CS111B='cd /pub/cs/amoghtan/cs111b'
alias $X CS111C='cd /pub/cs/amoghtan/cs111c'
alias $X CS211G='cd /pub/cs/amoghtan/cs211g'
alias $X CS142='cd /pub/cs/amoghtan/cs142'
alias $X CS110A='cd /pub/cs/amoghtan/cs110a'
alias $X CS211D='cd /pub/cs/amoghtan/cs211d'
alias $X CS311D='cd /pub/cs/amoghtan/cs311d'
alias $X CS211E='cd /pub/cs/amoghtan/cs211e'
alias $X CS211S='cd /pub/cs/amoghtan/cs211s'
alias $X CS260B='cd /pub/cs/amoghtan/cs260b'
alias $X cgi-bin="cd $HOME/public_html/cgi-bin"
alias $X phdir="cd $HOME/public_html"
alias $X cls='clear'
#alias $X CPP='/usr/bin/CC'
#alias $X C++='/usr/bin/CC'
#alias $X c++='/usr/bin/CC'
#alias $X cc='/opt/aCC/bin/aCC'
alias $X cpp='/usr/local/bin/g++ -std=c++11'
alias $X cc='/bin/cc'
alias $X RESET='printf "\033[0m"'
alias $X HILLS='telnet hills.ccsf.cc.ca.us'
alias $X hills='ssh amoghtan@hills.ccsf.edu'
alias $X same='ls | grep "^\(.\)\1\1*"'
alias $X ipad="arp `hostname` | cut -d' ' -f2 | tr -d '()'"
alias $X KSH="chsh  $(whoami) /usr/bin/ksh; export SHELL=/usr/bin/ksh"
alias $X BASH="chsh $(whoami) /usr/bin/bash;export SHELL=/usr/bin/bash"
alias $X win1='xterm -bg navyblue -fg yellow -sl 2200 -cr white -sb -T wylie  -g  88x25+40+40&'
alias $X win2='xterm -bg navyblue -fg yellow -sl 2200 -cr white -sb -T daffy  -g  88x25+80+100&'
alias $X win3='xterm -bg navyblue -fg yellow -sl 2200 -cr white -sb -T tweety -g  88x25+120+150&'
alias $X win4='xterm -bg navyblue -fg yellow -sl 2200 -cr white -sb -T porky  -g  88x25+160+210&'
alias $X win5='xterm  -bg black -fg green -sl 2200 -cr green -sb -T Elmer -g 88x25 &'
alias $X win6='xterm -bg darkslategrey -fg yellow -sl 2200 -cr white -sb -T wylie  -g  88x25+40+40&'
alias $X win7='xterm -bg darkslateblue -fg yellow -sl 2200 -cr white -sb -T wylie  -g  88x25+40+40&'
alias $X win8='xterm -bg darkorchid -fg white -sl 2200 -cr white -sb -T wylie  -g  88x25+40+40&'
alias $X clk='xclock -fg red -bg gold3 -digital -geometry 190x30-129+0 &'
alias $X slp='sleep 2&'
alias $X win='win1  slp  win2 slp win3  slp win4  slp clk'
alias $X color='more ~/color.txt'
mesg y
#########################################################################
#MAIL=/usr/spool/mail/$USER
# please comment out the following 5 lines, if you do not like the color.

#if alias BBLACK 1>/dev/null 2>&1; then BBLACK; fi
#sleep 2
#clear
if alias BOLD  1>/dev/null 2>&1; then BOLD;  fi

if [ -n "$rootflag" ]; then
   if alias RED 1>/dev/null 2>&1; then RED; fi
else
   if alias BLUE 1>/dev/null 2>&1; then BLUE; fi
fi
################################Oracle stuff#############################
export ORAENV_ASK=NO
### NOTES:  The following 3 lines are not working on new Hills/Linux
###         So, they are commented out.
if [ -f /usr/local/bin/oraenv ]; then   
  . /usr/local/bin/oraenv > /dev/null
fi
#export ORACLE_HOME=/oracle/app/product/11.2.0
#export ORACLE_BASE=/oracle
#export ORACLE_SID=cs11
PATH=$PATH:$ORACLE_HOME:$ORACLE_HOME/bin:$ORACLE_HOME/jdbc/lib
CLASSPATH=.:$ORACLE_HOME/jdbc/lib/ojdbc7.jar
CLASSPATH=$CLASSPATH:/usr/local/mysql-connector-java-5.1.23-bin.jar
CLASSPATH=$CLASSPATH:/opt/jakarta/jakarta-tomcat-4.1.18/common/lib/servlet.jar
CLASSPATH=$CLASSPATH:/opt/jakarta/jakarta-tomcat-4.1.18/common/lib/classes12.jar
export CLASSPATH
export SHLIB_PATH=$ORACLE_HOME/jdbc/lib:$SHLIB_PATH
export LD_LIBRARY_PATH=$ORACLE_HOME/jdbc/lib:$ORACLE_HOME/lib:$LD_LIBRARY_PATH

alias oradir="cd $ORACLE_HOME"

oracle_info()
{
   echo "ORACLE_HOME = $ORACLE_HOME"
   echo "ORACLE_BASE = $ORACLE_BASE"
   echo "ORACLE_SID  = $ORACLE_SID"
}

################################clean up##############################
#find . -name core -exec rm {} \;   # remove all core files
trap "rm -f .hist*" 0      # remove all history files when logoff
stty -tabs
##################################functions##########################
if [ -f "./lotto" ]; then
  #clear;
  ./lotto
fi
#########################################################################
xfind()
{
#  xfind
#  By Abbas Moghtanei 9-16-94
find . -name "$1" -print  
} 
#####################################################################
yfind()
{
#  yfind
#  By Abbas Moghtanei 9-16-94
find . -name "$1" -print -exec grep "$2" {} \;  
}
###################################################################
zfind()
{
#  zfind
#  By Abbas Moghtanei 9-16-94
find .  -exec grep -l "$1" {} \;  
}
##############################CC()#################################
export CFLAG="-s -O2 -DMAIN"
if [ -f "/users/amoghtan/cs262.a" ]; then
    export LIBFLAG=/users/amoghtan/cs262.a
else
    export LIBFLAG=""
fi
export MORESRC=""
CC()
{
#  CC to compile a C program
#  By Abbas Moghtanei 9-20-94, modified 1/28/2002
fname="$1"
a=`echo "$1" | grep "\.c$"`
if [ -n "$a" ]; then
   fname=`echo "$1" | cut -d. -f1`  # remove .c from the filename
fi
oname=$fname
if echo "$CFLAG" | grep -q -- "-c"; then
   oname=$fname.o
fi
if [ `uname -s` = "Linux" ]; then
   CFLAG="-O1 -s -DMAIN -DLINUX"
   gcc -o $oname $CFLAG $fname.c $MORESRC $LIBFLAG -lcurses
else
   #cc -o $oname -Aa $CFLAG -D_HPUX_SOURCE $fname.c $MORESRC $LIBFLAG -lcurses
   #print $oname $CFLAG $fname.c $MORESRC $LIBFLAG 
   cc -o $oname $CFLAG $fname.c $MORESRC $LIBFLAG -lcurses
fi
}  
###################################################################
kill_orig()
{
a= `ps | grep "\-ksh"`
if [ -n "$a" ]; then
   b = `awk '{print $1}'`
   echo "killing $b"
   kill -9 $b
fi
}
###################################################################
rm0()
{
#! /bin/ksh
#
#  rm0 (remove files with zero length)
#  By: Abbas Moghtanei  10-25-94
find . -size 0 -exec rm {} \;
}
###################################################################
# swap by Abbas Moghtanei  11-22-94
# swaps contents of two files.
# Syntax:  swap file1 file2
swap()
{
if [ $# -ne 2 ]
then
    echo "usage: swap file1 file2" 
else
    cp $1 /tmp/$1.$$
    cp $2 $1
    cp /tmp/$1.$$ $2 
fi
}
###################################################################
lst()
{
# lst lists all files created today.
# By Abbas Moghtanei 11-29-94
#
  today=$(date | cut -c5-10)
  find . ! \( -name . \) -mtime 0 -exec ls -la {} \; | grep "$today" | \
  sed "s!\./!!"
}
###################################################################
Prof()
{
  KEEP=$PWD
  cd
  . .profile
  cd $KEEP
}
##################################################################
las()
{
ls -l  *.c | while read line
do
   a=`echo "$line" | awk '{print $9}'`
   b=`echo $a | grep "^\(.\)\1\1\.c$"`
   
   if [ -n "$b" ]; then
      echo "$line"
   fi
done
}
##################################################################
func()   # displays all function names 
{
  #cat ~/.profile | grep "()" | grep -v grep
  typeset +f
}
##################################################################
list_func()   # displays contents of the function 
{
  typeset -f $1
}
##################################################################
dos2unix()
{
   if [ -z "$1" ]; then
      echo "Usage: dos2unix file1 [file2]"
      return 1
   fi
   if [ -z "$2" ]; then
      tr -d '\15' < $1 > $1.$$
      mv $1.$$ $1 2> /dev/null
   else
      tr -d '\15' < $1 > $2
   fi
}
##################################################################
sp()
{
#sp (show process)
  ps -ef | grep "$1" | grep -v grep | while read line
  do
         set -- $line
         echo "$1\t$2\t$5\t\c"
         shift 7
         echo $*
  done
}
##################################################################
lsdot()
{
#lsdot displays all dot files (like .profile) in the long format.
(ls -al | awk ' $9 ~ "^\."  { print $0 }')
}
##################################################################
MAN()
{
   if echo "$1" | grep "\.man$"
   then
       nroff -man $1 | more
   else
       nroff -man $1.man | more 
   fi
}
##################################################################
busy()
{
    trap "echo ; return 0" 2
    echo "Busy... \c" > /dev/tty
    while :; do
        :
    done
    echo " " > /dev/tty
}
#################################################################
show_env()
{
   if [ $# -eq 0 ]; then
      env
   fi
   env | grep "$1" 2> /dev/null
}
#################################################################
W()
{
   finger | sed -n '2,$p' | cut -c1-30 > /tmp/fing$$
   w      | sed -n '3,$p' | cut -c10-18,23-29,50- > /tmp/w$$
   paste  /tmp/fing$$ /tmp/w$$ | sort
   rm -f /tmp/fing$$ /tmp/w$$
}
#################################################################
set_display()
{
   c=0
   a=$(who -R | grep "`whoami`" | awk '{print $6}' | head -1 | tr -d '(' | tr -d ')')
   nslookup $a | while read line; do
       z=$(echo "$line\c" | grep "^Address:")
       if [ -n "$z" ]; then 
          (( c += 1 ))
          if (( c == 2 )); then
               b=$(echo $line | awk -F: '{print $2}')
               echo $b":0.0"
               return 0
          fi
       fi
   done
}
###################################sc()********************************
#sc (Show Command) would diplay all or some of the commands in unix
#   Syntax: sc <Regular Expression>
sc()
{
  param="$@"
  param=${param:-""}
  for p in /bin /usr/bin /sbin /usr/sbin /usr/local/bin ; do
    ls $p | egrep "$param" 2> /dev/null
  done |  sort -u 2> /dev/null
  return 0
}
##################################dict()##############################
# searches for words in the system's dictionary 
dict()
{
   mydict=/pub/cs/amoghtan/dictionary
   nflag=0
   (( $# == 0 || $# > 2 )) && print "usage: $0 <-n> regex" && return 0
   if [ "$1" = "-n" ]; then
      nflag=1
      shift
   fi
   (( $# == 0 )) && print "usage: $0 <-n> regex" && return 0
   if (( nflag == 1 )); then
      egrep "$@" $mydict | wc -l
   else
      egrep "$@" $mydict 
   fi
}
##################################wh()################################
#wh (which header) would display those headers containing the command-line
#   argument. For example wh printf   would display stdio.h
wh()
{
  find /usr/include -name "*.h" -exec grep -l "$@" {} \;
}
##################################tac()###############################
tac()
{
# reverse of cat, to display the file from end to beginning.
    
cat -n $1 | sort -n -r | cut -c8-
}    
##################################rev()########################### 
# To reverse the string
rev()
{
 if (( $# == 0 )); then
    while read t; do
      echo "$t"|awk '{for(i=length($0);i>0;i--) printf "%c",substr($0,i,1)}'
      echo 
    done
 else
      echo "$@"|awk '{for(i=length($0);i>0;i--) printf "%c",substr($0,i,1)}'
 fi   
}
##################################loginsql########################### 
# To enable/disable login.sql
loginsql()
{
  if (( $# == 0 )); then
     print "Usage: $0 off|on "
     return 1
  fi
  case $1 in
  on|ON)  if [ -f $HOME/login.sql.off ]; then
             mv $HOME/login.sql.off $HOME/login.sql
          else           
             print   $HOME/login.sql.off does not exist
             return 2
          fi;;
  off|OFF) if [ -f $HOME/login.sql ]; then
             mv $HOME/login.sql $HOME/login.sql.off
           else           
             print  $HOME/login.sql does not exist
             return 3
          fi;;
  esac
}
###############################bash_mode()##############################
bash_mode()
{
   sed -e '/--@@--$/s/-o vi/-o emacs/' \
       -e '/--@@--$/s/VISUAL=vi/VISUAL=emacs/' .profile > $HOME/.profile$$
   mv $HOME/.profile$$ $HOME/.profile
   . $HOME/.profile
}
###############################ksh_mode()###############################
ksh_mode()
{
   sed -e '/--@@--$/s/-o emacs/-o vi/' \
       -e '/--@@--$/s/VISUAL=emacs/VISUAL=vi/' .profile > $HOME/.profile$$
   mv $HOME/.profile$$ $HOME/.profile
   . $HOME/.profile
}
####################################rcopy()#################################
# This function copies file(s) from the remote system to yours or vice versa 
rcopy()
{
# rcopy  filename(s)  a,b,c,...
# where a and b and c ... are the last byte of the ip-addresses
# or dba1 dba2 dba3 dba4 dba5 or dba6.
# rcopy -r file_path last_byte_of_ipaddress      

rflag=0
partial_address="147.144.23"
filename=""
n=${#}

if [ "$1" = "-r" ]; then
   rflag=1
   shift
fi

if (( $# < 2 )); then
   print "usage: rcopy filename(s) address1,address2,address3..."
   print "usage: rcopy -r file_path address" 
   exit 1
fi

address="$(eval echo \${${#}})"

if (( $rflag == 1 )); then
   filename=$1
   address=$2
else
   while (( n > 1 )); do
      filename=$filename" "$1
      shift
      (( n -= 1 ))
   done
fi
for addr in $(echo $address|tr ',' ' '); do
  if [ "$addr" = "fog" ]; then
     ip_address="147.144.1.3"
  elif [ "$addr" = "hills" ]; then
     ip_address="147.144.1.2"
  elif [ "$addr" = "dba1" ]; then
     ip_address="147.144.23.61"
  elif [ "$addr" = "dba2" ]; then
     ip_address="147.144.23.62"
  elif [ "$addr" = "dba3" ]; then
     ip_address="147.144.23.163"
  elif [ "$addr" = "dba4" ]; then
     ip_address="147.144.23.164"
  elif [ "$addr" = "dba5" ]; then
     ip_address="147.144.23.165"
  elif [ "$addr" = "dba6" ]; then
     ip_address="147.144.23.166"
  else
     ip_address=${partial_address}.${addr}
  fi
  if (( $rflag == 1 )); then
     print "***** receiving $filename from $addr *****"
     scp ${ip_address}:${filename} .
  else
     print "***** sending $filename to $addr *****"
     scp $filename $ip_address:
  fi
done     
}
###################################UNZIP()#################################
# This function unzip the file if -z option is not supported by the tar
# command. It is equvalent to the tar -xzvf command.
UNZIP()
{
   (( $# == 0 ))&& print "usage: UNZIP filename" && exit 1
   gunzip -c $1 | tar xvf -
}
#export DISPLAY=$(set_display)

################################update_profile()###########################
update_profile()
{
   cd
   cp -f .profile .profile.ORIG
   cp -f /users/amoghtan/.profile .
   ksh
   . ~/.profile
   . ~/.profile
   echo "Please logoff and log back in to reset your profile."
}
#####################################save()################################
save()
{
   (( $# == 0 )) && echo "usage: save file1 file2 ..." && exit 1
   for filename in "$@"; do
     cp $filename ${filename}.ORIG
   done
}
##################################macopen()############################### 
# similar to the MAC OSX open command
# example:
# ls -l *.java | macopen
# macopen ls -l *.java
# Would put the output of ls -l *.java to the text editor (vi by default).

macopen()
{
  tmpfile=/tmp/xxxx
  > $tmpfile

  if (( $# == 0 )); then
     cat - | while read t; do
       echo $t >> $tmpfile
     done
  else
     eval "$@" >> $tmpfile
  fi   
  if [ -s "$tmpfile" ]; then
     exec < /dev/tty
     ${EDITOR:=vi} $tmpfile  
  fi
}
##################################ccpp()#################################
ccpp()
{
   (( $# == 0 )) && print "usage:$0 filename.cpp" && return 1
   [ ! -f $1 ] && print "$1 file does not exist" && return 2

   a=$(echo $1 | grep "\.cpp$")
   [ -z "$a" ] && print "Invalid c++ filename" && return 3

   filename=$1
   compiler="/opt/aCC/bin/aCC -AA"
   len=$(( ${#filename} - 4 ))
   oname=$(echo $filename | cut -c1-$len)

   $compiler -o $oname -O2 $filename
   (( $? == 0 )) && strip $oname
}
##################################runf()#################################
runf()
{
  bflag=0
  [ "$1" = "-b" ] && bflag=1 && shift
  (( $# == 0 )) && print "usage: runf <-b> mysql function(s)" && return 1
  [ ! -f ~/.my.cnf ] && print "Error: missing .my.cnf" && return 2

  if (( $bflag == 1 )); then 
     mysql -BN -e "select $@"
  else
     mysql -e "select $@"
  fi
}  
##################################xcat()#################################
# displays the file in single space, double space, triple space, ....
# syntax: xcat filename
# syntax: xcat <num> filename
# where num is 1 or 2 or 3 or .... for single, double, triple... space.
# if no number is specified, default is "single space".
xcat()
{ 
  (( $# == 0 )) && print "usage: xcat <num> filename" && return 1
  if (( $# == 1 )); then
     n=0
  else
     n=$(( $1 - 1 ))
     shift
  fi 
  (( $n < 0 )) && print "number can not be <=0" && return 2
  ruby -pe "$n.to_i.times {puts}" < $1
}
#################################jpd()################################### 
#jpd (Java Private Detector)
#  
jpd()
{
  (( $# == 0 ))&&print "usage:jpd class_name"&&return 1
  packages="java.lang java.util java.io java.awt java.applet java.net "
  packages=$packages" java.awt.event javax.swing java.sql"
  packages=$packages" java.lang.reflect java.util.regex"

  for p in $packages
  do
    javap $p.$1 2>/dev/null | sed -e "s/java\.[^.]*\.//g"\
    -e "s/[)][' '][' ']*throws/) throws/g" 
  done
}
##############################MailToAbbas()############################## 
MailToAbbas()
{
   (( $# < 1 )) && echo "usage:MailToAbbas <subject> filename(s)"&&return 1
   subject="Mail from $USER"
   if (( $# == 1 )); then
      filename=$1
   else
      subject="$1"
      shift
      filename="$*"
   fi
   for f in $filename; do
      if [ -f "$f" ]; then 
         mailx -s "$subject" amoghtan@ccsf.edu < $f
         echo "Mailed the file to Abbas: $f"
      else
         echo "$f does not exist"
      fi
   done
}
###################################wipe()################################
# This function acts as a safe delete command. It fills the
# file with random junk chars, and then deletes the file.
wipe()
{
   (( $# == 0 )) && print "usage: wipe filename" && return 1
   [ ! -f $1 ] && print "$1 does not exist" && return 2
   fsize=$(wc -c < $1)
   for i in 1 2; do
     dd if=/dev/urandom of=$1 bs=1 count=$fsize conv=notrunc 1>/dev/null 2>&1
     sync
   done
   rm -f $1
}
#********************************memsize()*******************************
memsize()
{
   if [ -f /proc/meminfo ]; then
     grep -i memtotal /proc/meminfo
   fi
}
#*******************************swapsize()*******************************
swapsize()
{
   if [ -f /proc/meminfo ]; then
     grep -i swaptotal /proc/meminfo
   fi
}
#*********************************macaddr()******************************
macaddr()
{
   ifconfig -a eth0 | grep -i hwaddr | awk '{print $5}'
}

