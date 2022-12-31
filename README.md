# MEDICAL APPOINTMENTS PROJECT
Aplicación web construida bajo el framework **Spring Boot** del lenguaje de programación **Java**.
Este aplicativo permite realizar la gestión de la información de médicos, pacientes y realizar la asignación de citas medicas.

Ademas, mediante un **Servicio Web** permite el consumo de la lista de medicos registrados en el sistema.

Esta aplicación cuenta con un patron de diseño MVC para su estructura y un patron de especificación o de repostorio para 
la logica del negocio.

---
## Librerias usadas
Para el desarrollo del proyecto se creo una plantilla en la pagina **[Spring Initializr](https://start.spring.io/)** 
seleccionando la versión de **2.7.7** de **Spring Boot**, la version **8** de **Java**  y la herramienta **Maven** para 
la descarga y manejo las siguientes librerias: **Jpa, Thymeleaf, Spring Web, Data Rest** y **Mysql Connector**.

---
## Instalación del proyecto
Clone el repositorio mediante **HTTPS** o **SSH** usando los siguientes comandos:

```
 $ git clone https://github.com/espinosadvlpr/medical-appointments.git
 $ git clone git@github.com:espinosadvlpr/medical-appointments.git
```


Una vez clonado el respositorio el proyecto se debe importar a un editor de codigo o un IDE que permita la descarga de 
las dependencias de **Maven**, para el desarrollo de este proyecto se uso el IDE **[Intellij IDEA Community Edition](https://www.jetbrains.com/idea/download/#section=windows)**
y el **[JDK 1.8](https://www.oracle.com/co/java/technologies/javase/javase8-archive-downloads.html)** de Java, por lo 
cual se recomienda esta misma configuración.

Cuando el proyecto haya sido importado y mientras se descargan las dependencias de **Maven** podemos realizar la 
edición del archivo **src/main/resources/application.properties** para la conexión con la base de datos.
Editaremos las lineas 2 y 3 donde se encuentra el usuario y la contraseña de la base de datos.

```
2 spring.datasource.username={user}
3 spring.datasource.password={password}
```

Dentro del archivo **db_scripts.sql** se encuentran los scripts necesarios para crear la base de datos del proyecto y 
crear datos de prueba (que se realizará mas adelante). Para este paso se deben ejecutar dentro del **Shell** de **[MySQL](https://www.mysql.com/products/workbench/)** 
o dentro de la aplicación **Workbench** unicamente se deben ejecutar las siguientes lineas:

```
1 create database quileia;
2 use quileia;
```

---
## Ejecución y uso el proyecto
Una vez importado el proyecto, configurado el archivo **application.properties**, creada la base de datos dentro de **MySQL**
y descargadas correctamente las dependencias de **Maven** se podrá ejecutar el proyecto.

La clase donde se encuentra el metodo **main()** es **AppointmentsApplication**, esta clase es la que se debe ejecutar 
para lanzar el proyecto. Una vez el correcto se haya lanzado sin errores en la consola, podemos ingresar al proyecto usando
el link <http://localhost:8080/> el cual redirecciona a la pagina principal del aplicativo.

Dentro del aplicativo se encuentran tres opciones (Pacientes, Medicos, Citas), dentro de las cuales se puede crear, leer, 
editar y eliminar la información necesaria para el aplicativo.

**NOTA: Una vez ejecutada la aplicación, las tablas de la base de datos se crean automaticamente y se podrá hacer uso del
codigo SQL para la creación de datos de prueba dentro del archivo db_scripts.sql**

---
## Consumo del servicio web
Para el consumo del servicio web se uso un repositorio de la libreria **Jpa**, el archivo se puede encontrar como 
**repository/DoctorsRepository**. Dentro de este archivo se asigno la ruta para la URL del servicio web como **"doctors"** 
y en el archivo **application.properties** se asigno como extensión a la URL la base **"api"**, por lo cual para realizar 
el consumo del servicio web del listado de medicos en el aplicativo se debe realizar una petición **GET** el siguiente URL: <localhost:8080/api/doctors>

**NOTA: Para el consumo de este servicio web se puede usar el navegador, pero se recomiendo el uso de aplicaciones para 
peticiones HTTP. Para la prueba de este servicio se uso la aplicación [Postman](https://www.postman.com/downloads/) por lo cual se recomienda.**

---
**Happy Coding :)**
