#include<stdio.h>
#include<stdlib.h>
#include <omp.h> // this is a new library

main()
{
    //retorna num de processadores = num max de threads
    printf("%i",omp_get_num_procs());
}