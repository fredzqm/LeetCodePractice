all: cpp java py js

compile: Solution.class a.exe

a.exe: two_sum.cpp
	g++ two_sum.cpp -std=c++11 > a.exe

Solution.class: Solution.java
	javac Solution.java

cpp: a.exe
	@cat in | ./a.exe > cpp.ans
	@echo "=============================== c++:"
	@git diff -w --no-index cpp.ans out

java: Solution.class
	@cat in | java Solution > java.ans
	@echo "=============================== java:"
	@git diff -w --no-index java.ans out

py:
	@cat in | py -3.4 two_sum.py > py.ans
	@echo "=============================== python:"
	@git diff -w --no-index py.ans out

js:
	@cat in | node two_sum.js > js.ans
	@echo "=============================== javascript:"
	@git diff -w --no-index js.ans out

clean:
	rm  -rf *.class *.exe *.ans