#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>

int main(int argc, char **argv)
{
    int value = 3, status;
    printf("\nAntes da chamada do fork [%d]\n", getpid());
    pid_t pid = fork(); // in this point l9 not in stack
    printf("\nDepois da chama de sistema fork\nProcesso %d -  PID[%d]\n",getpid(), pid);

    if (pid == 0)
    {
        //printf("\nChild process %d, value %d\n", getpid(), value);
        //value = 7;
        //printf("\nChild process %d, value modified %d\n", getpid(), value);
	//exit(5);
	execv("hello",NULL);
    }
    else if (pid > 0)
    {
        printf("\nParent process %d, its child process %d, has value %d\n", getpid(), pid, value);
        int id = wait(&status);
        printf("\nStatus of the child process  %d\n", status/256);
    }
    else
    {
        printf("\nError to create child process\n");
    }

    printf("PID [%d]", getpid());
    return EXIT_SUCCESS;
}
