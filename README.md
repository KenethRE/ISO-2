# ISO-2. GESTION DE TITULACIONES

### INDICE
#### 1.	Introducción
##### 1.1	Objetivos 
##### 1.2	Fases del proyecto
##### 1.3	Planificación
 
#### 2.	Especificaciones técnicas
##### 2.1.	 Base de Datos y Servidor de Base de datos 
##### 2.2.	 Definición de Requisitos
##### 2.3.	 Especificaciones de la arquitectura del sistema

#### 3.	Diseño del software
##### 3.1.	 Diseño preliminar
##### 3.1.1.1.	Diseño de datos
##### 3.2.	 Diseño procedimental o diseño detallado

#### 4.	Implementación y pruebas
##### 4.1.	 Implementación
##### 4.2.	Pruebas


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

**Tabla Centro: **En esta tabla se almacenarán los centros en donde se cursarán los diversos cursos.
Siendo: 
 - ID: identificador unico, es la clave primaria de esta tabla
 - Nombre: contendrá el nombre del centro
 - Localizacion: contendrá la ubicacion del centro

**Tabla Profesor: **En esta tabla guardaremos los datos del profesor asignado para impartir el curso.
Siendo:
 - DNI: identificador del profesor. Clave primaria
 - Nombre: contendrá el nombre del profesor
 - Apellidos: contendrá el apellido del profesor
 - Doctor: se conocerá si es o no doctor
Como clave foranea tenemos Centro cuya referencia será el id (del centro).
De acuerdo al id del centro cada uno tendrá sus repectivos profesores.

**Tabla Profesor Externo: **En esta tabla al igual que la tabla Profesor guardaremos los datos de los profesores externos.
Siendo:
 - DNI: identificador del profesor. Clave foranea
 - Titulacion: contendrá la titulacion que tenga el profesor.
 
 **Tabla ProfesorUCLM: **Se guardarán los datos del profesor perteneciente a la UCLM.
Siendo:
 -  DNI: identificador del profesor. Clave foranea
 - Nombre: contendrá el nombre del profesor
 - Apellidos: contendrá el apellido del profesor
 - Categoria profesor
 
**Tabla Curso Propio: ** Esta tabla almacenará los datos del curso.
Siendo:
 - ID: Clave primaria
 - Nombre: contendrá el nombre del curso
 - ECTS: contendrá los créditos asignados a ese curso
 - FechaInicio: contendrá la fecha de inicio del curso
 - FechaFin: contendrá la fecha fin del curso
 - TasaMatricula: se guardará el precio/tasa de la matricula del curso
 - Edicion: contendrá las edicion del curso
 - IdCentro: contendrá el id del centro al que pertenece ese curso. Clave foranea 
 - Secretario: contendrá el dni del secretario(es un profesor) de ese curso. Clave foranea
 - Director:contendrá el dni del director del curso. Clave foranea
 - TipoCurso: se almacenará el tipo del que sea el curos (Master, experto, ...)
 - EstadoCurso: se guardará el estado en el que se encuentre el curso (propuesto, validado, ...)
 
 **Tabla Estudiante: **Aquí serán guardados los datos que posee el estudiante de un curso.
 Siendo:
  - DNI: identificador del estudiante. Clave primaria.
  - Nombre: nombre del estudiante
  - Apellidos: apellidos del estudiante
  - Titulacion: se almacenará la titulacion del estudiante
  - Cualificacion.
 
 **Tabla Materia: **En esta tabla se guardarán los datos de las materias de un curso. 
 Siendo:
 - Nombre: se almacenará el nombre de la materia del curso
 - Horas: se almacenarán las horas que durará la materia
 - Fecha inicio: se almacenará la fecha en la que se comience la imparticion de la materia
 - Fecha fin: se almacenará la fecha en la que termine la imparticion de la materia
 - Id curso: Será necesario saber a que curso pertenece la materia. Clave foranea.
 - DNI Profesor: Será necesario conocer el profesor responsable de la materia. Clave foranea.
 
 **Tabla Matricula: **En esta tabla serán guardados los datos pertenecientes a la matricula de un estudiante a un determinado curso.
Siendo:
 - Fecha: Se almacenará la fecha en la que se realice la matricula
 - Pagado: Se guardará el dato de si está o no pagado
 - DNI Estudiante: Será necesario conocer el dni del estudiante matriculado en un curso. Clave foranea.
 - ID Curso: Será necesario conocer el id del curso en que se ha matriculado. Clave foranea.
 - Modo Pago: Se almacenará el modo de pago de la matricula (Transferencia bancaria o Targeta de crédito).
 
**Diagrama entidad-relacion**
Encontraremos el diagrama entidad-relacion en Confluence (JIRA).


#### 3.2.	 Diseño procedimental o diseño detallado
**LOGUEARSE**
La primera pantalla cuando arrancamos el sistema será la "PantallaLogin". En ella tendremos que introducir el nombre de usuario (admin) y la contraseña (1234) además de rellenar esos datos tambien debemos elegir el tipo de usuario que entrará al sistema (comboBox), ya que no todos tendrán el mismo acceso. 
Para poder acceder al sistema, el usuario tendrá que hacer clic sobre el botón de acceso al sistema que es el botón ingresar. El sistema comprobará que los datos introducidos sean los correctos de no ser así devolverá el mensaje de: "Usuario o contraseña incorrectos".
Los tipos de usuario que podrán loguearse serán: 
- Empleado -> PantallaEmpleadosVicerrectorado
- Jefe Gabinete -> PantallaJefeGabineteVicerrectorado (consultar ingresos, consultar estado cursos, listar ediciones)
- Director -> PantallaDirectorCursos (Alta cursos, editar cursos)
- Estudiante -> Matricula
Estos usuarios al realizar un inicio de sesion correcto cada uno de ellos sera dirigido a determinadas ventanas. De acuerdo al tipo de usuario que se loguee.

**Empleado logueado**
Una vez logueado el usuario empleado este será dirigido a la "PantallaEmpleadosVicerrectorado" en donde se listarán los cursos que hayan sido aprobados, de los cuales aparecerá su id, nombre, ECTS, Fecha inicio, fecha fin, tasa matriculacion y edicion.
En esta misma ventana veremos que tambien aparece el botón logout, si el usuario empleado clickea este botón, se cerrará en inicio de sesión como empleado y será redirigido a la ventana de inicio de sesion "PantallaLogin".

**Jefe Gabinete logueado**
Una vez logueado el usuario Jefe Gabinete este será dirigido a la ventana "PantallaJefeGabineteVicerrectorado" en donde aparecen tres pestañas las cuales son:
- Consultar Ingresos: como bien dice el nombre de la pestaña aquí se listarán los ingresos de los estudiantes. Pero primeramente se debe introducir el tipo de curso del cual se listarán los ingresos, la fecha inicio y fecha fin. Cuando hagamos clic en el botón "Consultar Ingresos" aparecerán listados en la tabla dichos ingresos. Como datos de la tabla tenemos el número de matriculados; en donde aparecerá la cantidad de alumnos matriculados en ese curso, tambien tenemos en la tabla el campo ingresos totales y el campo id curso; donde aparecerá el id del curso seleccionado.
En esta ventana tambien tenemos el botón "Reset", este se encargará de resetear los campos, de esta forma se permite que puedan ser nuevamente rellenados.
Cabe destacar que a la hora de hace clic en "Consultar Ingresos" en el caso de que no se rellenen los campos de fecha inicio y fecha fin, el sistema dará una señal de fallo por medio de una ventana de mensaje en donde se le avisará al usuario: "Campo fecha inicio vacio" o "Campo fecha fin vacio". Es muy útil avisar al usuario de todas las alertas y posibles fallos, ya que de no ser avisadas, es dificil que puedan ser resueltas.
- Consultar estado curso: En esta ventana se consultará el estado en el que se encuentren los cursos. Pero primeramente se debe introducir el estado de curso, la fecha inicio y fecha fin. Cuando hagamos clic en el botón "Consultar Estados" aparecerán listados en la tabla los cursos que tengan ese estado. Como datos de la tabla tenemos id del curso, nombre del curso, ECTS, Fecha inicio, fecha fin, Tasa Matriculacion, Edicion.
En esta ventana tambien tenemos el botón "Reset", este se encargará de resetear los campos, de esta forma se permite que puedan ser nuevamente rellenados.
Cabe destacar que a la hora de hace clic en "Consultar Estados" en el caso de que no se rellenen los campos de fecha inicio y fecha fin, el sistema dará una señal de fallo por medio de una ventana de mensaje en donde se le avisará al usuario: "Campo fecha inicio vacio" o "Campo fecha fin vacio".
- Listar ediciones: En esta ventana se listarán las ediciones de un curso, debemos rellenar los campos de fecha inicio y fecha fin para evitar que nos de fallo. Una vez rellenados los campos podrémos listar las ediciones haciendo clic en el botón "Listar Ediciones", de los cuales se listará el ID, nombre, ECTS, fecha inicio, fecha fin, tasa matriculacion, edicion.
En esta ventana tambien tenemos el botón "Reset", este se encargará de resetear los campos, de esta forma se permite que puedan ser nuevamente rellenados.

En todas las ventanas tenemos la opcion de cerrar sesion basta con que el usuario haga clic en el botón "Logout".

**Director logueado**
Una vez logueado el usuario Director este será dirigido a la ventana "PantallaDirectorCursos" en donde aparecen dos pestañas las cuales son:
- Alta curso: esta ventana permite dar de alta un curso para ello se deben rellenar los campos que aparecen en la ventana, asignar el nombre del curos el el textBox Nombre, asignar ECTS del curso en el campo ECTS, establecer la edidion del curso en el campo de edicion, establecer la tasa del curso en el campo Tasa tambien hay que seleccionar el tipo de curso en el comboBox y establecer una fecha de inicio y una fecha de fin. Al pulsar el boton "Añadir materia" se podrá registrar una nueva materia para ese curso. Esto nos llevará a una nueva ventana en donde se deben rellenar los campos, una vez rellenos hacemos clic en añadir materia para que sea añadida. Finalmente pulsamos "Guardar curso" en donde se guardará el curso dado de alta.
- Editar curso: En esta ventana se buscará un curso para editarlo, para ello es necesario primeramente introducir un id de un curso existente, despues hacemos clic en el botón "Buscar curso", veremos como se activan el resto de campos. Proseguimos a rellenar estos campos activados. En los JList aparecerá listados tanto las materias guardadas como las nuevas materias. Estas materias nuevas, las puede añadir el usuario haciendo clic en el botón "Añadir materia".
Esto nos llevará a una nueva ventana en donde se deben rellenar los campos, una vez rellenos hacemos clic en añadir materia para que sea añadida.
En la ventana de editar curso también está disponible el botón "Borrar", este botón borrará todos los campos y una vez borrados los desactivará y ya no aparecerán salvo el campo id curso, dando la posibilidad de editar un nuevo curso volviendo a introducir el id de un curso.

**Estudiante logueado**
Una vez logueado el usuario Estudiante este será dirigido a la ventana "Matriculacion" en donde el estudiante deberá rellenar los campos que aparecen en la ventana, en el caso de que no rellene los campos no se habilitará el botón "Realizar pago". Al hacer clic en el botón "Buscar Cursos" el estudiante podrá buscar el curso en el que desea ser matriculado, para ello debe introducir las fechas inicio y fin y al hacer clic en "Buscar curso" aparecerán en la lista los cursos disponibles. dandole la opcion de seleccionar el curso deseado. Una vez seleccionado el curso el usuario Estudiante podrá realizar el pago de la matricula bien sea pago con targeta o por transferencia bancaria al hacer clic en el botón "Realizar pago" se crea la matricula y su id tambien al hacer clic en ese botón se dirigirá al usuario a la ventana "RealizarPago" allí es donde escogerá el metodo de pago. En el caso de que seleccione pago por transferencia bancaria veremos como los campos pertenecientes al pago por targeta se deshabilitan y viceversa.
Los campos númericos tienen sus respectivas restricciones, por ejemplo, el campo Cvv solo admite tres digitos. Una vez que el estudiante realiza el pago el sistema le informa si se ha hecho o si no se ha podido hacer. 

Algo que tenemos en cuenta es que a la hora de establecer las fechas, el usuario debe establecer fechas correctas, es decir la fecha fin debe ser posterior a la fecha de inicio. De lo contrario el sistema devolverá un mensaje de error: "Rango de fechas incorrecto intentelo nuevamente".

### 4.	Implementación y pruebas
#### 4.1.	 Implementación
Este proceso es el más largo y el más complejo de todos. En este proceso es donde vamos a crear la aplicación.
Lo primero de todo fue crear la configuracion del maven, Exportar el codigo de VPP y hacer el primer commit a Git y añadir el repositorio Git a Eclipse. Todo esto lo hemos hecho en el primer Sprint.
Más tarde nos centramos en encontrar el driver de BBDD y configurarlo para hacerlo funcionar en el proyecto, creacion del Gestor de persistencia en BBDD, definir las consultas SQL para el proyecto, creacion del agente DB y las conexiones con el gestor de BBDD y gestionar las entidades de base de datos (Objetos DAO). Todo esto lo hemos plasmado en el segundo Sprint.
Despues hemos procedido a la creación de interfaces y a las funcionalidades, creacion de datos de prueba y funcion de inicializacion de BBDD, añadir asserts a test case, revisar control de fallos, realizar pruebas, etc. Todo esto y más queda definido en el tercer y cuarto Sprint. 


#### 4.2.	Pruebas
En el proyecto se ha creado una nueva carpeta (src/test/java) en esa carpeta se encuentran todos los testing que se han hecho del proyecto, dentro de la cual encontramos los controllers, entidades y el paquete persistencia que es en donde se encuentran las clases DAO de testing. Dentro de los controllers se encuentra el test de las clases GestorConsultaTest, GestorMatriculacionTest y GestorPropuestaCursoTest. Dentro de las entidades se encuentran los test de las entidades las cuales son: CentroTest, CursoPropioTest, MateriaTest, ProfesorExternoTest, ProfesorTest y ProfesorUCLMTest. Dentro del paquete de presentacion encontramos los test de todas las clases DAO.
Cada una de los paquetes mencionados tiene su respectiva clase TestRunner la cual se encargará de obtener los resultados de las clases test ya mencionadas.
Testing nos ayuda a reducir el número de errores y de esta forma es más sencillo realizar correcciones y mantenimiento.
____________________________________________________________________________________________________________________________________________________________________
