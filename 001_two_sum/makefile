all: java-c cpp-c

cpp-c:
	g++ .\two_sum.cpp -std=c++11

java-c:
	javac .\Solution.java

cpp: cpp-c
	./a.exe

java: java-c
	java Solution

py:
	py -3.4 two_sum.py

js:
	node two_sum.js

clean:
	rm *.class *.exe