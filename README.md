# INTRODUCCIÓN A DOCKER (TALLER 5 AREP)

Taller 5 del curso de Arquitecturas Empresariales (AREP) en el que se da un primer acercamiento al uso de contenedores usando Docker para almacenar una apliación tipo servicio Web que permite realizar operaciones seno, coseno, determinar si una palabra es palindroma y calcular la magnitud de un vector.

## Diseño
Este proyecto tiene un único componente crítico para la operación

1. `SparkWebServer` Componente que se encarga de administrar y resolver las diferentes peticiones que realizan los clientes. Dentro de este se encuentran todas las rutas para las operaciones solicitadas en esta solución.

## Instrucciones de uso

### Pre-requisitos

Antes de ejecutar el servidor es necesario contar con los siguientes programas instalados y funcionando:

1. JDK (Java Development Kit)
2. MVN (Maven)
3. Docker

### Instalación y Ejecución - Forma local

A continuación se muestra el paso a paso de como instalar y ejecutar el servidor web

1. Clone este repositorio localmente en un entorno o carpeta de trabajo.

```
$ git clone https://github.com/NickArB/AREP-TALLER-5.git
```

2. Dentro del entorno o directorio en el que clono el proyecto, asegurese de que no existan ejecutables previos o no deseados con maven.

```
$ mvn clean
```
3. Una vez que los targets han sido descartados compilelos y re asignelos al target.
```
$ mvn package
```
4. Con los target asignados, ejecute el metodo main de la clase `SparkWebServer.java`. Dependiendo de su IDE esta clase se puede ejecutar de varias formas, en caso de no tener un IDE se recomienda el uso del siguiente comando
```
$ mvn exec:java -"Dexec.mainClass"="com.edu.escuelaing.SparkWebServer"
```
5. Una vez el servicio esta corriendo puede verificar que esta funcionando al escribir la ruta en el navegador
```
http://localhost:4567/index.html
```
![alt text](image.png)

Prueba de cada una de las funcionalidades

![alt text](image-1.png)

### Creación de imagenes con Docker
1. Es necesario definir todas las clases y dependencias del proyecto para construir la imagen con Docker. Para ello ejecute la siguiente instrucción
```
$ mvn clean install
```
2. A continuación se va a construir la imagen con el ya implementado Dockerfile para ello ejecute la instrucción
```
$ docker build --tag dockertaller5 .
```
3. Para ejecutar el contenedor se hara uso de la siguiente instrucción.
```
$ docker run -d -p 34000:46000 --name sampletaller5 dockertaller5
```

## Construido con

* [Maven](https://maven.apache.org/) - Manejo de dependencias
* [Docker](https://www.docker.com) - Administrador de contenedores

## Version 1.0

## Autor

* **Nicolás Ariza Barbosa**

<!-- javadoc -d doc -sourcepath src/main/java -subpackages edu.escuelaing.app.taller -->
