main : gestor_tarefas.o gestor_main.o
	gcc -o main gestor_tarefas.o gestor_main.o

gestor_tarefas.o : gestor_tarefas.c gestor_tarefas.h
	gcc -g -c gestor_tarefas.c

gestor_main.o : gestor_tarefas.c gestor_main.c gestor_tarefas.h
	gcc -g -c gestor_main.c

clean:
	rm -f *.o main