#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <pthread.h>

#define N 10
#define SIZE 30

int buffer[N][SIZE];

void *sum_row(void* ptr)
{
	int index = 0, sum = 0;
	int *b = (int*) ptr;
	
	while(index < SIZE-1)
		sum += b[index++];
		
	b[index] = sum;
	
	pthread_exit(NULL);
}

int main(void)
{
	int i, j;
	pthread_t tid[N];
	
	for(i = 0; i < SIZE-1; i++)
		for(j = 0; j < SIZE-1; j++)
			buffer[i][j] = rand() % 10;
	
	for(i = 0; i < N; i++)
		if(pthread_create(&tid[i], NULL, sum_row, (void *) &(buffer[i])) != 0)
		{
			printf("Error creating thread, id=%d\n",i);
			exit(-1);
		}
		else
			printf("Created thread with id %d\n", i);
			
	for(i = 0; i < N; i++)
		pthread_join(tid[i], NULL);
		
	printf("All threads have concluded.\n");
	
	for(i = 0; i < N; i++)
	{
		for(j = 0; j < SIZE; j++)
			printf(" %d ", buffer[i][j]);
		
		printf("Row %d \n", i);
	}
	
	return 0;
}
































