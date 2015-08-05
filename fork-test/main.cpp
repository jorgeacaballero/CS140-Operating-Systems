//
//  main.cpp
//  fork-test
//
//  Created by Jorge Caballero on 8/5/15.
//  Copyright (c) 2015 Jorge Caballero. All rights reserved.
//
//  Testing fork() on Xcode
//  Source: http://timmurphy.org/2014/04/26/using-fork-in-cc-a-minimum-working-example/

#include <iostream>
#include <unistd.h>

int main(int argc, const char * argv[]) {
    printf("--beginning of program\n");
    
    int counter = 0;
    pid_t pid = fork();
    
    if (pid == 0)
    {
        // child process
        int i = 0;
        for (; i < 5; ++i)
        {
            printf("child process: counter=%d\n", ++counter);
        }
    }
    else if (pid > 0)
    {
        // parent process
        int j = 0;
        for (; j < 5; ++j)
        {
            printf("parent process: counter=%d\n", ++counter);
        }
    }
    else
    {
        // fork failed
        printf("fork() failed!\n");
        return 1;
    }
    
    printf("--end of program--\n");
    
    return 0;
}
