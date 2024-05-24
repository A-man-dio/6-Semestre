#ifndef GESTOR
#define GESTOR

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

typedef struct Tarefa{
    char *id;
    int prioridade;
    struct Tarefa *next;
} tarefa ;

typedef struct Lista_tarefas {
   tarefa *inicio;
} lista_tarefas;

//insere uma tarefa na lista de tarefas
lista_tarefas *inserir (lista_tarefas *lista,int prioridade, char *id_nova_tarefa);

//apresenta todas as tarefas da lista com prioridade maior ou igual
void list (lista_tarefas *lista ,int prioridade);

//procura uma tarefa, retorna 1 se encontrar, retorna 0 se não encontrar
int buscar_tarefa(lista_tarefas *lista, char *id_tarefa);

//elimina uma tarefa da lista de tarefas
lista_tarefas *complete (lista_tarefas *lista, char *id_tarefa);
#endif 