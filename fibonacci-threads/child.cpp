//
//  child.cpp
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

int fib(int n){
    if (n==0) {
        return 0;
    } else if (n==1) {
        return 1;
    } else {
        return fib(n-2) + fib(n-1);
    }
}

int main(int argc, const char * argv[]) {
    cout << fib(10) << endl;
    return 0;
}
