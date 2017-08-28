Driver.class: *.java
	javac *.java

run: Driver.class
	java Driver

clean:
	rm -f *.class
