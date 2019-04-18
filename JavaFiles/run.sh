#!/bin/bash
# sysinfo_page 

echo "MainClass = " $1
javac $1
echo "Complied.. "
echo "Running.."
echo "----------" 
java $(echo "$1" | cut -f 1 -d '.')
echo "----------" 
echo "Program Closed."
echo "Cleaning up '.class' files"
rm *.class
echo -e "\e[32mFinished! \e[0m"

