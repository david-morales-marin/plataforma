# Sistema de Control de Usuarios 

El objetivo principal de esta prueba es construir el 
backend para una aplicación enfocada 
en monitorear el comportamiento de los usuarios dentro de
una plataforma digital. 

Prueba realiza por la empresa PrevalentWare

## Tecnología usada para la prueba
- Java 17
- Spring boot 3.2.0
- JPA, H2
- Maven
- Swagger 3
- Database PostgreSQL
- JWT , Spring Security
- JUNIT 5
- Testing Mockito

## Prueba Unitaria 

Se realiza diferentes pruebas unitarias, en donde se simula la ejecutación de 
uno de los procesos como si se estuviera ejecutando desde postman, con lo cual 
permite saber el correcto funcionamiento de la logica empleada para los edpoints. 

## Procesos

Se intento seguir todas las reglas que se habian definido desde un comienzo, sin embargo, 
pido excusa por haber creado unas tablas dentro de la bd, puesto que no contaba con que
ya estaban creadas y solo se debian llamar para consultar. 

Todas las peticiones cuentan con sistema de paginancion, asi mismo se consulta directamente a la bd, 
por lo cual, no se creo ni las entidades ni el repositorio, sino que se realizaba el query 
que pudiera cumplir con la exposición de datos que se quería obtener. 

## Despliegue 

Los despliegues con AWS tanto para EC2 como Elastic, se hacen apartir de la generacion de un 
JAR el cual se sube en el ambiente creado, al subir este archivo y ejecutarlo, puedo tener mi 
aplicacion desplegada desde aws, pues solo es necesario configurar el ambiente y subir el jar 
de mi aplicacion. 