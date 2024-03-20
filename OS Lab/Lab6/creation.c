#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>

int main()
{
    int num = 10;
    int pid = fork();
    if (pid == 0) // child process
    {
        printf("I am the child process\n");
        printf("Values in the child process num = %d, pid  = %d\n", num, pid);
        printf("Address in the child process num = %u, pid = %u\n", &num, &pid);
    }

    else if (pid > 0) // parent process
    {
        printf("I am the parent process\n");
        printf("Values in the parent process num = %d, pid  = %d\n", num, pid);
        printf("Address in the parent process num = %u, pid = %u\n", &num, &pid);
    }

    else // child creation unsuccessful
    {
        printf("Child Creating Unsuccessful\n");
    }
    return 0;
}