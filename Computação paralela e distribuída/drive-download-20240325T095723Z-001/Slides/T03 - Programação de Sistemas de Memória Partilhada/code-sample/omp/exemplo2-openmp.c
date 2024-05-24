#include <stdlib.h>
#include <stdio.h>
#include <omp.h>

#define N 10
#define SIZE 30

int buffer[N][SIZE];

void sum_row(int* b)
{
	int index = 0, sum = 0;
	
	while(index < SIZE-1)
		sum += b[index++];
		
	b[index] = sum;
}

int main(void)
{
	int i, j;
	
	for(i = 0; i < N-1; i++)
		for(j = 0; j < SIZE-1; j++)
			buffer[i][j] = rand() % 10;
	
	omp_set_num_threads(N);
	

	#pragma omp parallel for
	for(i = 0; i < N; i++)
		sum_row(buffer[i]);

		
	printf("All threads have concluded.\n");
	
	for(i = 0; i < N; i++)
	{
		for(j = 0; j < SIZE; j++)
			printf(" %d ", buffer[i][j]);
		
		printf("Row %d \n", i);
	}
	
	return 0;
}
































