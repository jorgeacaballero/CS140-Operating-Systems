//
//  main.cpp
//  fibonacci-threads
//
//  Created by Jorge Caballero on 8/5/15.
//  Copyright (c) 2015 Jorge Caballero. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <unistd.h>

using namespace std;

int main(int argc, const char * argv[]) {
    int status;

    if (fork() == 0) {
        execl("./child","./child", NULL);
    } else {
        cout << "Actividades finalizadas" << endl;
    }
    wait(&status);
    
    return 0;
}