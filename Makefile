all:
	@find * -name "*.java" > sources.txt
	@javac @sources.txt
	@java weather/Simulation
	@rm -rf *.class */*.class sources.txt


clean fclean:
	rm -rf *.class */*.class sources.txt