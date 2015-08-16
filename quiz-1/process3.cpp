//
//  process3.cpp
//  quiz-1
//
//  Created by Jorge Caballero on 8/6/15.
//  Copyright (c) 2015 Jorge Caballero. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <unistd.h>

using namespace std;

int fib(int n) {
	if (n==0) return 0;
	else if (n==1) return 1;
	else return fib(n-2) + fib(n-1);
}

int main() {
	cout << "P3" << endl;
    for (int i = 26; i <= 40; i++)
    cout << fib(i) << endl;
    return 0;

}

