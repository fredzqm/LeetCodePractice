all: cpp java py js

compile: Solution.class a.exe

a.exe: Solution.cpp ../IO.h
	g++ Solution.cpp -std=c++11 -Wfatal-errors > a.exe

Solution.class: Solution.java ../IO.java
	javac Solution.java ../IO.java
	
IO.class: ../IO.java
	javac ../IO.java
	mv ../IO.class .

cpp.out: a.exe
	@cat in | ./a.exe > cpp.out

cpp: cpp.out
	@../Preprocess.exe cpp.out cpp > cpp.ans
	@echo "=============================== c++:"
	@git diff -w --no-index out cpp.ans

java.out: Solution.class IO.class
	@cat in | java Solution > java.out

java: java.out
	@../Preprocess.exe java.out java > java.ans
	@echo "=============================== java:"
	@git diff -w --no-index out java.ans

py.out: Solution.py
	@cat in | py -3.4 Solution.py > py.out

py: py.out
	@../Preprocess.exe py.out py > py.ans
	@echo "=============================== python:"
	@git diff -w --no-index out py.ans

js.out: Solution.js
	@cat in | node Solution.js > js.out

js: js.out
	@../Preprocess.exe js.out js > js.ans
	@echo "=============================== javascript:"
	@git diff -w --no-index out js.ans

clean:
	rm  -rf *.class *.exe *.ans *.out