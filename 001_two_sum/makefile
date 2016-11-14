all: cpp java py js

compile: java-c cpp-c

cpp-c:
	g++ .\two_sum.cpp -std=c++11

java-c:
	javac .\Solution.java

cpp: cpp-c
	cat in | ./a.exe > cpp.ans
	@echo "=============================== c++:"
	@diff cpp.ans out

java: java-c
	cat in | java Solution > java.ans
	@echo "=============================== java:"
	@diff java.ans out

py:
	cat in | py -3.4 two_sum.py > py.ans
	@echo "=============================== python:"
	@diff py.ans out

js:
	cat in | node two_sum.js > js.ans
	@echo "=============================== javascript"
	@diff js.ans out

clean:
	rm *.class *.exe *.ans