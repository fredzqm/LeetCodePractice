all: cpp java py js

compile: Solution.class a.exe

a.exe: Solution.cpp ../IO.h
	g++ Solution.cpp -std=c++11 -Wfatal-errors > a.exe

Solution.class: Solution.java ../IO.java
	javac Solution.java ../IO.java
	
IO.class: ../IO.java
	javac ../IO.java
	mv ../IO.class .

cpp: a.exe
	@cat in | ./a.exe > cpp.ans
	@echo "=============================== c++:"
	@git diff -w --no-index cpp.ans out

java: Solution.class IO.class
	@cat in | java Solution > java.ans
	@echo "=============================== java:"
	@git diff -w --no-index java.ans out

py:
	@cat in | py -3.4 Solution.py > py.ans
	@echo "=============================== python:"
	@git diff -w --no-index py.ans out

js:
	@cat in | node Solution.js > js.ans
	@echo "=============================== javascript:"
	@git diff -w --no-index js.ans out

clean:
	rm  -rf *.class *.exe *.ans