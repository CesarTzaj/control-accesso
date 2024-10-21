
# Control de acceso y de empleados

Se ha contruido con java 17, el proyecto tiene como fin de poder registrar por medio de una tarjeta  RFID mandar la informacion y registrar la hora de entrada si el usuario tiene acceso a la puerta para controlar cuantas horas el empleado estuvo dentro de ese departamento. 

#


## Authors

- [@CesarTzaj](https://github.com/CesarTzaj)


## Deployment

Para ejecutar el proyecto de ejecutar la clase principal llamada ControlAccesoApplication se utilizo el puerto por defecto 8080 y la base de datos utilizada fue MySQL

Tambien se debe modificar las crediciales de la base de datos 
las variable que se deben de cambiar estan el archivo 
application.properties
spring.datasource.url= "url de la base de datos " jdbc:mysql://127.0.0.1:3306/mibasededatos
spring.datasource.username="usuario" 
spring.datasource.password="contraseña"

lo que esta entre comillas de debe replazar y no debe de llevar comillas. 



## Run Locally

Clonacion del proyecto

```bash
  git clone https://github.com/CesarTzaj/control-accesso.git
```

Entrar al directorio

```bash
  cd control-accesso
```

##Documentacion Swagger
Swagger http://localhost:8080/swagger-ui/index.html#/




