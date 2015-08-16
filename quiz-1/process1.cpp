//
//  process1.cpp
//  quiz-1
//
//  Created by Jorge Caballero on 8/5/15.
//  Copyright (c) 2015 Jorge Caballero. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <unistd.h>
#include <math.h>

using namespace std;

int main(int argc, const char * argv[]) {
    int status;
    pid_t pid = fork();
    if (pid == 0) {
        execl("./process3", NULL);
        if (pid == 0)
        {
        	execl("./process2","./process4", NULL);
        }
    } else {
    	int b,n;
        cout << "Ingrese b" << endl;
        cin >> b;
        cout << "Ingrese n" << endl;
        cin >> n;
        cout << "El valor es = " << pow(b,n) << endl;
    }
    wait(&status);
    return 0;
}