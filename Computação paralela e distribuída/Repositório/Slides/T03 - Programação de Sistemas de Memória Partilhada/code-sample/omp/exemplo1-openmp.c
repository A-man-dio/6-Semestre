#include <stdlib.h>
#include <stdio.h>
#include <omp.h>

int main() {

	printf("Serial Region 1 [Thread#%d]\n", omp_get_thread_num());
	
	omp_set_num_threads(4);
	
	#pragma omp parallel
	{
		printf("Parallel Region [Thread#%d]\n", omp_get_thread_num());
	}
	
	printf("Serial Region 1 [Thread#%d]\n", omp_get_thread_num());
	
	return 0;
}
