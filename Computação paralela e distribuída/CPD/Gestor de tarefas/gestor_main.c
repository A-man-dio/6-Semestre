
#include <stdlib.h>
#include <stdio.h>
#include "gestor_tarefas.h"
#include "gestor_tarefas.c"


int readLineArguments(char **argVector, int vectorSize, char *buffer, int buffersize)
{
  int numtokens = 0;
  char *s = " \r\n\t";

  int i;

  char *token;
    
  if (argVector == NULL || buffer == NULL || vectorSize <= 0 || buffersize <= 0)
    
     return 0;
     
  if (fgets(buffer, buffersize, stdin) == NULL) {
    
    return -1;
  }
   
  /* get the first token */
  token = strtok(buffer, s);
   
  /* walk through other tokens */
  while( numtokens <= vectorSize-1 && token != NULL ) {
    argVector[numtokens] = token;
    numtokens ++;
    
    token = strtok(NULL, s);
  }
   
  for (i = numtokens; i<vectorSize; i++) {
    argVector[i] = NULL;
  }
  
  return numtokens;
}

int main()
{
  lista_tarefas *lista=(lista_tarefas*) malloc(sizeof(lista_tarefas));
    int prioridade;
    int opt=3;
    char *arguments[3];

    char buffer[256];

    lista->inicio=NULL;
    do
    {
        printf("---------Gestor de Tarefas------------\n");
        printf("1 - Adicionar uma tarefa\n");
        printf("2 - Apresentar as tarefas com prioridade \n");
        printf("3 - Completar uma tarefa\n");
        printf("4 - sair\n");
        scanf("%i",&opt);
        getchar();

        switch(opt)
        {
            case 1:
            
            printf("Digite o comando 'new' seguido do ID da tarefa e sua prioridade: \n");
                
            if (readLineArguments(arguments, 3, buffer, sizeof(buffer)) >= 2) 
            {
                    if(strcmp("new",arguments[0]) != 0)
                    {
                    printf("Deve usar o comando 'new'\n");
                    goto erro1;
                    }
                    prioridade = atoi(arguments[2]); 
                    inserir(lista, prioridade, arguments[1]);
                } else {
                  erro1:
                    printf("Entrada inválida!\n");
                    
                }
            break;

            case 2:
            
            if(lista->inicio == NULL)
            {
              printf("Não existem tarefas\n");
              break;
            }
            printf("Digite o comando 'list' seguido da prioridade: \n");
            if (readLineArguments(arguments, 2, buffer, sizeof(buffer)) >= 1) 
            {
                    if(strcmp("list",arguments[0]) != 0)
                    {
                    printf("Deve usar o comando 'list'\n");
                    goto erro2;
                    }
                    prioridade = atoi(arguments[1]); 
                    list(lista, prioridade);
                } else {
                  erro2:
                    printf("Entrada inválida!\n"); 
                }
                
            break;

            case 3:
            
            if(lista->inicio == NULL)
            {
              printf("Não existem tarefas\n");
              break;
            }
            printf("Digite o comando 'complete' seguido do ID da tarefa: \n");
            if (readLineArguments(arguments, 2, buffer, sizeof(buffer)) >= 1) 
            {
              if(strcmp("complete",arguments[0]) != 0){
                    printf("Deve usar o comando 'complete'\n");
                    goto erro3;
              }
                    complete(lista, arguments[1]);
            } else {
              erro3:
              printf("Entrada inválida!\n");
                    
            }
                
            break;

            case 4:
            
            break;
            
            default: printf("Insira uma opção válida\n");

        }

    } while (opt != 4);
    
    return 0;
}