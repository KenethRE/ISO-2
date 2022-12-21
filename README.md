# ISO-2. GESTION DE TITULACIONES

# INDICE
## 1.	Introducción
### 1.1	Objetivos 
### 1.2	Fases del proyecto
### 1.3	Planificación
 
## 2.	Especificaciones técnicas
### 2.1.	 Base de Datos y Servidor de Base de datos 
### 2.2.	 Definición de Requisitos
### 2.3.	 Especificaciones de la arquitectura del sistema

## 3.	Diseño del software
### 3.1.	 Diseño preliminar
#### 3.1.1.1.	Diseño de datos
### 3.2.	 Diseño procedimental o diseño detallado

## 4.	Implementación y pruebas
### 4.1.	 Implementación
### 4.2.	Pruebas

## 5.	Conclusión 
____________________________________________________________________________________________________________________________________________________________________

### 1. Introducción
En este documento se recoge la memoria del proyecto de la asignatura de ingeniería del software II. “Gestión de títulos propios” ha sido realizado por:
-	Adrián Riza Pérez
-	Allipson Nicol Herrera Álvarez
-	David Arriero Ollero
-	Keneth Launies Rodríguez Escorcia.

El proyecto consiste en la gestión de enseñanzas propias de la Universidad de Castilla-La Mancha la cual se estructura en tres categorías: formación permanente con titulación universitaria, formación permanente que no requiere titulación universitaria y enseñanzas propias (independientemente de si requieren o no titulación universitaria).
Cada una de estas categorías dispone de una serie de cursos y actividades cada uno de ellos con una duración y créditos determinados. En el desarrollo de esta memoria aparecerán plasmados los requisitos requeridos y el desarrollo del proyecto.

#### 1.1 Objetivos
Como objetivo se desea un sistema informático por medio del cual se gestionarán las enseñanzas propias de la UCLM. Este sistema permitirá el acceso a diferentes usuarios, entre los cuales encontramos al vicerrector, gabinete, director y estudiante. Cada uno de ellos tendrá diferentes accesos al sistema.
Lo que se pretende con este sistema es conseguir que se puedan almacenar todas las gestiones. Así de esta forma es más cómodo y fácil acceder a todos los datos. Además, se pretende que este sistema sea lo más intuitivo posible, facilitando la introducción de datos y sus posteriores consultas.

**Entradas/Salidas del sistema:**

El sistema de principio mostrará la página principal donde se podrán seleccionar los diferentes usuarios de la aplicación. Todas las entradas, se realizarán mediante el teclado o el ratón, y todas las salidas serán devueltas por pantalla en la interfaz que le corresponda.
Todas las operaciones que se realicen se almacenarán en una base de datos. Así siempre se tendrá la posibilidad de consultar o modificar los datos almacenados anteriormente.

#### 1.2 Fases del proyecto
En esta sección vamos a definir las fases en las que hemos dividido el proyecto.
1.	Estudio del proyecto
2.	Análisis de los requisitos
3.	Organización de las tareas 
4.	Diseño del sistema
5.	Implementación
6.	Pruebas
7. Mantenimiento

#### 1.3 Planificación
En este apartado vamos a detallar cada una de las fases de este proyecto. 
##### Estudio del proyecto:
Lo más importante de este apartado, es saber definir de la forma más correcta posible las características y los requerimientos del sistema. Para ello es vital comprender el enunciado del proyecto, su diagrama de casos de uso y el diagrama de clases.
##### Análisis:
Esta etapa es una de las más importantes ya que se define la base de la construcción y cualquier descuido, error o falta de entendimiento, puede llevarnos a un erróneo desarrollo de la aplicación.
##### Organización de las tareas:
Como medio de organización y repartición de tareas hemos hecho uso de Jira. Jira es un software que proporciona herramientas de planificación y hojas de ruta para que el equipo pueda gestionar los requisitos de las funciones desde el primer día. En nuestro proyecto hemos organizado los requisitos en Sprint con una duración de dos semanas. 
##### Diseño del sistema:
Para la fase de diseño decidirémos cuál será la base de datos con la que trabajaremos. Nos decidimos por usar la API de JDBC de java.
##### Implementacion:
Esta etapa será la más larga y la de mayor dificultad. Puesto que en esta etapa es en la que desarrollamos el código del sistema, en la cual se realizaran funcionalidades propuestas según los requisitos con los que debe cumplir el sistema.
##### Pruebas y validación:
En esta etapa, validaremos que el sistema realiza su funcion y comprobaremos el correcto funcionamiento del mismo. Realizaremos pruebas de testing para comprobar los posibles errores que no se hayan tenido en cuenta.
##### Mantenimientto:
Una aplicacion o un sistema informático no es perfecto. Sabemos que con el uso y con los diversos cambios que tiene el sistema, pueden surgir errores que pensabamos que habían sido corregidos o que simplemente no los teniamos en cuenta. En estas situaciones, nos toca solucionar esos errores y constantemente dar mantenimiento al sistema.

### 2.	Especificaciones técnicas
#### 2.1.	 Base de Datos y Servidor de Base de datos 
El sistema de gestión de bases de datos, permitirá crear y manejar bases de datos relacionales. 
Para este sistema he mos decidido utilizar Apache derby. 

#### 2.2.	 Definición de Requisitos
##### En primer lugar, la aplicacion debe cumplir con tres categorias:

- Enseñanzas propias de la UCLM de formación permanente con titulación universitaria previa: tienen **Masters** de 60(1 curso), 90 o 120(2 cursos) creditos, **Especialistas** de 30 (minimo 1 semestre) a 59 (máximo 2 semestres) créditos y **Espertos** que tengan como minimo 15 creditos y como maximo 29 creditos.
- Formacion permanente que no requiere titulacion universitaria previa: **Cursos universitarios de formacion avanzada** con 15 creditos como minimo y 30 creditos como maximo y **Cursos de formacion continua** de 3 y 14 creditos.
- Enseñanzas propias(con o sin titulacion universitaria): **Microcredenciales** (min: 2 creditos, max: 14 creditos), **Actividades de corta duracion** (menos de 2 creditos o 20h), **Cursos de verano y extension universitaria**, **Formacion de mayores**.

##### La aplicacion estará dividida en diversas secciones:
- Pantallas que usarán los Estudiantes
- Pantallas que usarán Empleados
- Pantallas que usará el Jefe de gabinete 
- Pantallas que usará el Director
******************************EXPLICAR PANTALLAS***********************************************************************************************
##### Mantenimiento
Para el mantenimiento necesario del software habrá que tener en cuenta que todo este actualizado y que funcione correctamente. Lo que respecta al mantenimiento de la base de datos, únicamente tendríamos que comprobar esporádicamente la correcta introducción de datos al sistema. 

#### 2.3.	 Especificaciones de la arquitectura del sistema
![](http://revista.seguridad.unam.mx/sites/revista.seguridad.unam.mx/files/BD2.jpg)

- Peticion al sistema: El usuario que realice la peticion podrá realizar diferentes funcionalidades con la aplicacion. Podrá realizar consultas, inserciones o borrado de datos.
- Consulta a BD: el sistema se conectará a la base de datos y le pedirá datos, realizará inserciones o borrados.
- Respuesta de BD: El servidor de base de datos, dependiendo de lo que le haya pedido el usuario, realizará la respuesta.
- Respuesta al usuario: el sistema responderá al usuario con los datos que haya recibido del servidor de base de datos.

### 3.	Diseño del software
#### 3.1.	 Diseño preliminar
##### 3.1.1.1.	Diseño de datos
En este apartado vamos a describir la estructura interna de cada una de las tuplas de nuestra base de datos relacional.

