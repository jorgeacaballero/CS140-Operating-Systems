#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <iostream>
#include <string.h>

using namespace std;

#define SHMSZ 27
main()
{
char c;

int shmid;
key_t key;

struct pizarra {
	int n;
	char mensaje[10][100];
};

pizarra *shm;

key = 5678;

cout << "Memory size: " << sizeof(pizarra) << endl;

if ((shmid = shmget(key, sizeof(pizarra), IPC_CREAT | 0666)) < 0) {
perror("shmget");
exit(1);
}

if ((shm = (struct pizarra *)shmat(shmid, NULL, 0)) == (struct pizarra *) -1) {
perror("shmat");
exit(1);
}

char opcion;
char mensaje[100];
for(;;) {
	cout << "Guardar mensaje: ";
	cin.getline(mensaje, 100);
	if (shm->n < 100)
		strcpy(shm->mensaje[shm->n++], mensaje);
	sleep(1);
	cout << "Continua (s/S/n/N): ";
	cin >> opcion;
	cin.ignore(10000,'\n');
	system("clear");
	for (int i=0; i<shm->n;i++)
		cout << shm->mensaje[i]<< endl;	
	if (opcion == 'N' || opcion == 'n') break;
}
shmdt(shm);
exit(0);
}
