# Problema de productor-consumidor

### Variables compartidas
	int N
	int sem_lleno = N
	int sem_vacio = 0
	int mutex_e = 1
	int mutex_s = 1
	int buffer[N]
	int entrada = 0
	int salida = 0

### Seudocodigo

#### Codigo del Productor
	while (true) {
		wait(sem_lleno)
		wait(mutex_e)
		buffer[entrada] = rand()
		entrada = (entrada + 1)/N
		signal(mutex_e)
		signal(sem_lleno)
	}
	
#### Codigo del consumido
	while (true) {
		wait(sem_vacio)
		wait(mutex_s)
		x = buffer[salida]
		salida = (salida + 1)/N
		signal(mutex_s)
		signal(sem_lleno)
	}

# Problema del lector-escritor

### Especificación

 - Varios lectores pueden leer el elemento x
 - Solo un escritor puede escribir el elemento x
  - No debe haber ningun lector leyendo
  - No debe haber ningun esctritor escribiendo

#### Variables compartidas
	int x
	int mutex = 1
	int n = 0 //cantidad de lectores
	int mutex_L = 1

#### Codigo del lector
	while (true) {
		wait(mutex_L)
		if(n == 0)
			wait(mutex)
		n++
		signal(mutex_L)
		//Lee el elemento X
		wait(mutex_L)
		n--
		if(n ==0)
			signal(mutex)
		signal(nutex_L)
	}

#### Codigo del escritor
	while (true) {
		wait(mutex)
		//Escribe el elemento X
		signal(mutex)
	}	
	
# Problema del barbero dormilón

### Especificación

 - El barbero tiene su priopia silla.
 - Si no hay clientes, el barbero se duerme en la silla.
 - Hay N sillas disponibles para los clientes.
 - Si no hay sillas disponibles, el cliente se va.
 - Cuando el babrero termina de cortar el pelo a un cliente, si hay clientes disponibles, entonces toma uno de ellos.

 