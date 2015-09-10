#include <signal.h>
#include <iostream>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/stat.h>
#include <semaphore.h>

#define SHARED 0
#define BUFSIZE 20

using namespace std;

int terminatethreades = 0;

void *Producer(void *);
void *Consumer(void *);

sem_t mutex_e;
sem_t mutex_s;
sem_t sem_lleno;
sem_t sem_vacio;

int buf[N];
int entrada = 0;
int salidad = 0;

int int main(int argc, char const *argv[])
{
	int ans;
	time_t now;
	pthread_t pid, cid, cid1;

	time(&now);
	srand(now);

	//Inicialización de los semaforos
	sem_init(&mutex_e,0,1);
	sem_init(&mutex_s,0,1);
	sem_init(&sem_lleno,0,N);
	sem_init(&sem_vacio,0,0);
	int n = 0;
	int m = 1;

	cout << "Programa principal iniciado" << endl;
	pthread_create(&pid, 0, Producer, NULL);
	pthread_create(&cid, 0, Consumer, &n);
	pthread_create(&cid1, 0, Consumer, &m);
	cout << "Crea ambos hilos" << endl;
	pthread_join(pid, NULL);
	pthread_join(pid, NULL);
	pthread_join(pid, NULL);
	sem_getvalue(&sem_lleno, &ans);
	cout << "El valor saliendo es " << ans << endl;
	cout << "Programa finalizado" << endl;
	return 0;
}

void *Producer(void *arg){
	
}