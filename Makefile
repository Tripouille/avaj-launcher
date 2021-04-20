all:
	@find * -name "*.java" > sources.txt
	@javac @sources.txt
	@java Main

clean fclean:
	rm -rf *.class */*.class sources.txt