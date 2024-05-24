
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "gestor_tarefas.h"





//insere uma tarefa na lista de tarefas
lista_tarefas *inserir (lista_tarefas *lista,int prioridade, char *id_nova_tarefa){
    //verifica prioridade de 0 a 5
    if((prioridade > 5) || (prioridade < 0))
    {
        printf("Insira um valor de 0 a 5\n");
        return lista;
    }
    // verifica se ID ainda não existe
    if( buscar_tarefa(lista,id_nova_tarefa)==1){
    printf("Tarefa já existente, insira um outro ID\n");
    return lista;
    }
    // aloca memória e guarda os dados
    tarefa *taref, *aux = lista->inicio;
    taref = (tarefa*) malloc(sizeof(tarefa));
    taref->id = (char*) malloc(strlen(id_nova_tarefa) + 1);
    strcpy(taref->id, id_nova_tarefa);
    taref->prioridade = prioridade;
    taref->next = NULL;
    //se a lista estiver vazia apenas atribui a variavel de início
    if(aux == NULL){
        lista->inicio = taref;

        return lista;
    }
    // se lista tiver elementos, vai até ao ultimo nó  e insere no fim
    while (aux->next != NULL){
        aux = aux->next;
    }
    aux->next = taref;
    return lista;

}

//apresenta todas as tarefas da lista com prioridade maior ou igual
void list (lista_tarefas *lista ,int prioridade){
    
    tarefa *aux;
    int qntd=0;
    int prior_max = 5;
    
    if(lista->inicio == NULL)
    {
       printf("Não existem tarefas\n");
       return;
    }
    if((prioridade > 5) || (prioridade < 0))
    {
        printf("Insira um valor de 0 a 5\n");
        return;
    }

    printf("ID\t\t\tPrioridade\n");
    
    for ( ; prioridade <= prior_max; prior_max--)
    {   
        aux = lista->inicio;
        for ( ;aux != NULL; aux=aux->next)
        {
            if(aux->prioridade == prior_max)
            {
                printf("%s\t\t\t%i\n",aux->id,aux->prioridade);
                
                qntd++;
            }
        }
    }
    if(qntd == 0)
    {
        printf("Não existem tarefas de prioridade %i ou superior\n", prioridade);

    }
    printf("-----------------------------------------------\n");
}

int buscar_tarefa(lista_tarefas *lista, char *id_tarefa){
    tarefa *aux=lista->inicio;

    for(;aux != NULL; aux = aux->next){
        if (strcmp(aux->id,id_tarefa)==0)
        {
            return 1;
        }
    }
    return 0;
}

//elimina uma tarefa da lista de tarefas
lista_tarefas *complete (lista_tarefas *lista, char *id_tarefa){
    if(lista->inicio == NULL)
    {
       printf("Não existem tarefas\n");
       return lista;
    }
if( buscar_tarefa(lista,id_tarefa)==0){
    printf("Tarefa inexistente\n");
    return lista;
}
    tarefa *aux = lista->inicio, *ant = lista->inicio;
    //se a tarefa for a primeira da lista
    if(strcmp(aux->id,id_tarefa)==0){
        lista->inicio = aux->next;
        free(aux);
        return lista;
    }
    //se a tarefa não for a primeira da lista
    for ( aux = aux->next; aux != NULL;)
    {
        if(strcmp(aux->id,id_tarefa)==0)
        {
            ant->next=aux->next;
            free(aux);
            return lista;
        }
        ant = aux;
        aux = aux->next;
    }
    return lista;
}