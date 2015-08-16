//
//  process4.cpp
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

int main(int argc, const char * argv[]) {
	int last = 45, c, first = 0, second = 1, next;
	cout << "P4" << endl;
 
	for ( c = 0 ; c < last ; c++ ) {
	    if ( c <= 1 )
	        next = c;
	    else {
	        next = first + second;
	        first = second;
	        second = next;
	    }
	 	
	}
 	cout << next << endl;
    return 0;
}
