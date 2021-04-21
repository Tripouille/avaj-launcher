all:
	@find * -name "*.java" > sources.txt
	@javac @sources.txt
	@java weather/Simulation scenario.txt || true
	@rm -rf *.class */*.class sources.txt


clean fclean:
	rm -rf *.class */*.class sources.txt