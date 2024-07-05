# gapsitest
examen

#Patrones usados en el proyecto

1.- MVC
	La aplicacion se para la logia de negocio en servicios, controladores y modelos, a su vez la vista en una capa externa de html y js
2.- Inyeccion de dependencias
	El funcionamiento de spring boot (Spring Framework) ocurre gracias a este patron, esta presente en la creacion de beans por ejemplo en runtime
3.- Patron adaptador
	Cuando se generan las interfaces para ser extendidas en las implementacion con lo cual se adaptan y expanden funcionalidades a otras clases
4.- Microservicios
	Como tal puede considerarse un microservicio ya que se respeta un solo origen de datos y todas las operaciones ocurren hacia la misma db nosql aunque a distintas collections
	
#Tecnologias usadas en el Backend

java 17
Spring boot 3.3.1
Loombok
JPA
MongoDB
Maven
Tomcat

Por mencionar las principales

#Tecnologias usadas para el front

html
CSS
js - JQUERY y diversos componentes de este Framework (Datatable, Modal, buttons, etc)

Elegi por facilidad y rapidez a la vez de que las operaciones que se solicitaban no eran tan complejas.

#Para su ejecucion
puede ejecutarse el jar con el siguiente comando

java -jar gapsiproveedores-0.0.1-SNAPSHOT.jar

el jar en mencion se genero en el directorio target con la tarea "install" de maven. Dicho jar puede correr standalone con lo cual se pueden probar la api rest y los html generados


#API rest
Se comparte el postman collection para facilitar la prueba de los endpoints
endpoints get
http://localhost:8080/gapsi/v1/proveedores
http://localhost:8080/gapsi/v1/version
http://localhost:8080/gapsi/v1/candidato
http://localhost:8080/gapsi/v1/proveedores/paginated/{page}/{size}/{sortDir}/{sort}

endpoints delete
http://localhost:8080/gapsi/v1/proveedores/borrar/{nombre}	

endpoints post
http://localhost:8080/gapsi/v1/proveedores/guardar
 json form
 {      
        "nombre": "test nombre",
        "razon": "rtest razon social",
        "direccion": "test direccion"
 }
 
#DB NoSQL MongoDB
Me tome la libertar de usar una base de datos mongo
spring.data.mongodb.uri=mongodb+srv://isratest:test_2014#@cluster0.apra4vj.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0
spring.data.mongodb.database=isratest

se realizaron los mapeos con las librerias de persistencia de MONGO tal cual como si fuese mediante JPA

#Front html / js
http://localhost:8080/welcome.html
http://localhost:8080/proveedores.html