# contacts

This service stores and retrieves contact information.

## Configuration

### Environment

| name                                | example                                     | description                                                                                      |
|-------------------------------------|---------------------------------------------|--------------------------------------------------------------------------------------------------|
| CONTACTS_APIKEY                     | your_contacts_apikey                        | The apikey that needs to be provided in the header when communicating with the contacts service. |
| SPRING_DATASOURCE_URL               | jdbc:postgresql://contacts_db:5432/contacts | The spring datasource url to use.                                                                |
| SPRING_DATASOURCE_USERNAME          | postgres                                    | The spring datasource username to use.                                                           |
| SPRING_DATASOURCE_PASSWORD          | your_postgres_password                      | The spring datasource password to use.                                                           |
| SPRING_SQL_INIT_MODE                | always                                      | The initialization mode to chose. Possible values: always, embedded, never.                      |
| SPRING_JPA_HIBERNATE_DDL_AUTO       | none                                        | Hibernate feature for ddl generation. Possible values: none, validate, update, create-drop.      |

## Build & Deploy with Docker
1. Run `mvn clean install` to build the application.
2. The configuration for the application is defined in environment variables. For this demo they are defined in two separate files.
   Normally these files should be ignored and not be pushed in version control, but for the purpose of this demo they are so you don't have to create them.
    1. .env_contacts: will contain the following (values are examples and can be changed to your liking):
        * `CONTACTS_APIKEY=cb4e56e7-712d-4899-a8ed-a5f7d9b938ca`
        * `SPRING_DATASOURCE_URL=jdbc:postgresql://contacts_db:5432/contacts`
        * `SPRING_DATASOURCE_USERNAME=postgres`
        * `SPRING_DATASOURCE_PASSWORD=postgres`
        * `SPRING_SQL_INIT_MODE=always`
        * `SPRING_JPA_HIBERNATE_DDL_AUTO=none`
    2. .env_postgres: will contain the following (values are examples and can be changed to your liking):
        * `POSTGRES_USERNAME=postgres`
        * `POSTGRES_PASSWORD=postgres`
        * `POSTGRES_DB=contacts`
3. Run `docker-compose build` to create a containerized image.
4. Run the container in detached mode with `docker-compose up -d`.

## OpenApi documentation
The openapi documentation for this service can be found under `src/main/resources/openapi/contacts-openapi.html`.

## The database
This service uses a postgres database with the name contacts.
Internally it uses the default port 5432 and for remote port 3001 is exposed.
You can connect remotely using the jdbc url: `jdbc:postgresql://localhost:3001/contacts` with username postgres and password postgres.  
