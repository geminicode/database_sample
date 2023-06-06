# database_sample
Maintain PostgreSQL DDL scripts and Java Persistence Layer

# Maven Build

```
PS C:\dev\git> cd database_sample
PS C:\dev\git\database_sample> mvn clean install
...	
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary for Sample JPA Model and Spring Boot Application 0.0.0-SNAPSHOT:
[INFO]
[INFO] Sample Data Tier Application ....................... SUCCESS [  8.521 s]
[INFO] Sample SpringBoot Application ...................... SUCCESS [ 12.646 s]
[INFO] Sample JPA Model and Spring Boot Application ....... SUCCESS [  0.019 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  21.460 s
[INFO] Finished at: 2023-06-06T14:38:35-05:00
[INFO] ------------------------------------------------------------------------
```

# Docker Compose Parameters

## DDL_AUTO

* create
* drop
* drop-create
* none

## DDL_AUTO: 

* validate - Hibernate will validate the existing schema against the model objects and fail if there is an inconsistency
* create - Hibernate will create the schema using the model object's metadata 
* create-drop - Hibernate will create the schema using the model object's metadata and the drop the schema when the JVM exits
* update - Hibernate will update the schema based on reconciling the model objects with the existing schema.
* none - Hibernate will NOT perform and actions. 

## NOTE

Most common use is (for development) **DDL_AUTO=create** and **DDL_ACTION=drop-and-create**.  This will allow hibernate to create the schema and produces a ``drop.sql`` and ``create.sql`` in the current directory.

A common production use is **DDL_AUTO=validate** and **DDL_ACTION=none**.  These options will expect the database schema to already be created and hibernate will validate the schema.  The ``create.sql`` and/or ``drop.sql`` will **NOT** be created.



# Docker Deploy

```
PS C:\dev\git> cd database_sample
PS C:\dev\git\database_sample> docker compose -p sample --profile all up --build -d

PS C:\dev\git\database_sample> docker ps
CONTAINER ID   IMAGE             COMMAND                  CREATED       STATUS       PORTS                    NAMES
3b1670447106   sample-java_app   "/opt/app/start-app.…"   3 hours ago   Up 3 hours   0.0.0.0:8080->8080/tcp   java_app
4f1919021adf   postgres          "docker-entrypoint.s…"   3 hours ago   Up 3 hours   0.0.0.0:5432->5432/tcp   postgres
```