// Program to create a child process

#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>

int main()
{
    printf("FORK SYSTEM CALL\n");
        fork();
        printf("PARENT CHILD PROCESS CREATION\n");
    return 0;
}