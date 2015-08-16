#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdio.h>
#include <stdlib.h>
#include <iostream>

using namespace std;

#define SHMSZ 27

main()
{
int shmid;
key_t key;
char *shm, *s;

key = 5678;

if ((shmid = shmget(key, SHMSZ, 0666)) < 0) {
perror("shmget");
exit(1);
}


if ((shm = (char *)shmat(shmid, NULL, 0)) == (char *) -1) {
perror("shmat");
exit(1);
}

if (*shm != '*') {
	for (s = shm; *s != '\0'; s++)
		putchar(*s);
	putchar('\n');
	*shm = '*';
} else
   	cout << "No hay datos que consumir" << endl;
 shmdt(shm);
exit(0);
}
