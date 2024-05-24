#include <stdio.h>
#include <stdlib.h>
#include <omp.h>
#define MAX 10

 int main()
{
    int a[MAX] = {0};
    
    #pragma omp parallel for schedule (static,1) num_threads(2)
     for (int i = 0; i < MAX; i++)
    {
        a[i] += a[i+2]+5;
        printf("%i\n",a[i]);
    }


    
}
