#include <stdlib.h>
#include <stdio.h>
#include <omp.h>


int main(void)
{
	int i, j;
	
	omp_set_num_threads(4);
	

	#pragma omp parallel for schedule(static)
	for(i = 0; i < 16; i++)
		printf("iter.: %d, thread: %d\n",i,omp_get_thread_num());
	
	return 0;
}
































