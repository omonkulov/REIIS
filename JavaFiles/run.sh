#!/bin/bash
# sysinfo_page 



if [[ $# -eq 0 ]]

 then
 printf "\e[31mNo Argument!\e[0m\n"
 exit 0

fi
javac $1
printf "\e[32mComplied.. \n"
printf "Running..\n"
printf "%s\n\n\e[0m" '----------' 
java $(echo "$1" | cut -f 1 -d '.')
printf "\e[32m\n\n----------\n" 
printf "Program Closed.\n"
printf "Cleaning up \e[31m'.class' \e[32mfiles\n"
rm *.class
printf "\e[32mFinished! \e[0m\n"

