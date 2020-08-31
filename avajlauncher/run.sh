find . -name "*.class" -type f -delete
javac simulator/Simulator.java
java simulator.Simulator scenario.txt

# find -name *.java > sources.txt
# javac -sourcepath @sources.txt