#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(){
    printf("value: [%d]\n", getpid());
    return 9;
}