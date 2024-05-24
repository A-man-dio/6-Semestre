/**
 * Aula#5: Introducao aos processos
 * Prof. Joao Costa
 * Date: April 2021
*/

#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>

int main(int argc, char **argv)
{
    int pid, pid_filho, status;

    printf("\n[Before] PPID = %d\n", getpid());

    pid = fork();

    printf("\n[#] ID = %d\n", getpid());

    if (pid == 0)
    {
        printf("\nPPID = %d and PID = %d\n", getppid(), getpid());
        execv("t", NULL);
    }
    else if (pid != -1)
    {
        pid_filho = wait(&status);
        printf("\nAfter wait... child process [%d], status [%d]\n", pid_filho, status / 256);
        //exit(0);
    }
    else
    {
        printf("\nError to create child process\n");
        exit(-1);
    }

    printf("\n[After] PPID = %d\n", getpid());
}