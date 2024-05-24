#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>

int a; /*variavel global*/
int main(int argc, char **argv)
{
    a = 0;
    int pid, status;
    if (fork() == 0)
    {
        a++;
        //sleep(10);
        printf("%d", a);
        //exit(0);
    }
    else
    {
        //exit(0);
        pid = wait(&status);
    }
    printf("%d", a);
    return 0;
}