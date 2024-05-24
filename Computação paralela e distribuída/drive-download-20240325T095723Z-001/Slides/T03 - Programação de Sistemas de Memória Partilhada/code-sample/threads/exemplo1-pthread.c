#include <stdlib.h>
#include <stdio.h>
#include <pthread.h>
#include <unistd.h>

void* hello (void* arg){
	int i = 0;

	for(; i < 5; i++){
		printf("[thread = %d, i = %d]!!!!\n", (int)pthread_self(),i);
		//sleep(1);
	}

	return NULL;
}

int main() {

	pthread_t id;

	printf("Antes [na thread main = %d ]!!!!\n", (int)pthread_self());

	// aqui criamos a segunda thread
	if(pthread_create(&id,NULL,hello,NULL) != 0){
		printf("Erro.\n");
		return -1;
	}

	// pthread_join(id,NULL);

	//printf("Depois da thread Hello terminar [a thread main = %d ]\n",(int)pthread_self());

	return 0;
}
