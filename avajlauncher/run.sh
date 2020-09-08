#!/bin/bash
find . -name "*.class" -type f -delete
find -name *.java > sources.txt
javac @sources.txt
# java simulator.Simulator scenario.txt