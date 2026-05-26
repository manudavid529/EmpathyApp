<<<<<<< HEAD
# Empathy Project

## 1. Descripción técnica

Este proyecto es una aplicación Java con Spring Boot que administra pacientes, psicólogos y tests de compatibilidad. Utiliza JPA/Hibernate para persistencia y actualmente está configurado con una base de datos H2 en memoria.

### Estructura principal

- `src/main/java/com/empathym3/empathy/EmpathyApp.java`
  - Clase principal que ejecuta la lógica de consola.
- `src/main/java/com/empathym3/empathy/model/Usuario.java`
  - Superclase `@MappedSuperclass` con los atributos comunes de usuario.
- `src/main/java/com/empathym3/empathy/model/Paciente.java`
  - Entidad JPA `@Entity` para pacientes.
- `src/main/java/com/empathym3/empathy/model/Psicologo.java`
  - Entidad JPA `@Entity` para psicólogos.
- `src/main/java/com/empathym3/empathy/model/TestCompatibilidad.java`
  - Entidad JPA `@Entity` para tests de compatibilidad.
- `src/main/java/com/empathym3/empathy/repository/`
  - Repositorios Spring Data JPA para acceder a datos.

## 2. Cómo configurar la base de datos

La configuración actual se encuentra en:

`src/main/resources/application.properties`

### Configuración por defecto (H2 en memoria)

```properties
spring.datasource.url=jdbc:h2:mem:empathydb;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

server.port=8080
```

### Cambiar a una base de datos real

Si deseas usar MySQL, PostgreSQL u otra base de datos, modifica estas propiedades en `application.properties`. Ejemplo para MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/empathydb
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

> Asegúrate de tener el driver JDBC adecuado en `pom.xml` si cambias de H2 a otra base de datos.

### Credenciales de base de datos

- `spring.datasource.username` = nombre de usuario de la base de datos
- `spring.datasource.password` = contraseña de la base de datos
- `spring.datasource.url` = URL de conexión JDBC
- `spring.datasource.driver-class-name` = clase del driver JDBC

## 3. Cómo ejecutar el proyecto

Desde la raíz del proyecto (`empathy`):

```bash
./mvnw.cmd spring-boot:run
```

O bien:

```bash
./mvnw.cmd compile
./mvnw.cmd package
java -jar target/empathy-0.0.1-SNAPSHOT.jar
```

## 4. Manual para un desarrollador Frontend

Actualmente el proyecto no expone controladores REST (`@RestController`) en `src/main/java/com/empathym3/empathy/controller`. Para que el frontend pueda conectarse, hay que crear una capa de API que exponga los siguientes recursos.

### Clases y métodos de backend relevantes

- `PacienteRepository`:
  - `save(Paciente paciente)` → guardar paciente
  - `findByDocumento(String documento)` → buscar paciente por documento
  - `findAll()` → listar pacientes
  - `delete(Paciente paciente)` → eliminar paciente
- `PsicologoRepository`:
  - `save(Psicologo psicologo)` → guardar psicólogo
  - `findByDocumento(String documento)` → buscar psicólogo por documento
  - `findAll()` → listar psicólogos
  - `delete(Psicologo psicologo)` → eliminar psicólogo
- `TestCompatibilidadRepository`:
  - `save(TestCompatibilidad test)` → crear test de compatibilidad
- `EmpathyApp`:
  - Contiene la lógica de flujo de consola actual, pero no es un controlador web.

### API REST recomendada para frontend

Un frontend web debería consumir API HTTP como estas:

- `POST /api/pacientes`
  - Crear nuevo paciente
  - Internamente usa `PacienteRepository.save(...)`
- `POST /api/psicologos`
  - Crear nuevo psicólogo
  - Internamente usa `PsicologoRepository.save(...)`
- `GET /api/usuarios`
  - Listar todos los usuarios
  - Combina `pacienteRepository.findAll()` y `psicologoRepository.findAll()`
- `GET /api/usuarios/{documento}`
  - Buscar usuario por documento
  - Busca en pacientes y psicólogos
- `DELETE /api/usuarios/{documento}`
  - Eliminar usuario encontrado
- `POST /api/tests`
  - Crear un nuevo `TestCompatibilidad`
  - Internamente usa `TestCompatibilidadRepository.save(...)`

### Qué datos debe enviar el frontend

Para crear un paciente:

```json
{
  "nombre": "Juan",
  "edad": 30,
  "documento": "12345",
  "enfermedad": "Ansiedad",
  "nivelAnsiedad": "Moderado",
  "objetivoTerapia": "Mejorar sueño"
}
```

Para crear un psicólogo:

```json
{
  "nombre": "Ana",
  "edad": 40,
  "documento": "67890",
  "especialidad": "Cognitivo",
  "enfoque": "Terapia breve",
  "aniosExperiencia": 10
}
```

Para crear un test de compatibilidad:

```json
{
  "pacienteDocumento": "12345",
  "necesidadPrincipal": "Control de estrés",
  "estiloPreferido": "Empático"
}
```

## 5. Integración conceptual Frontend / Backend

### ¿Cómo se conectan el análisis de datos con el Frontend y el Backend?

1. El frontend es la capa de interacción del usuario. Un usuario ingresa datos en formularios: paciente, psicólogo, y preferencias de compatibilidad.
2. El frontend envía esos datos al backend mediante solicitudes HTTP.
3. El backend valida los datos y los persiste en la base de datos usando JPA:
   - `Paciente` se guarda en la tabla `pacientes`
   - `Psicologo` se guarda en la tabla `psicologos`
   - `TestCompatibilidad` se guarda en la tabla `tests_compatibilidad`
4. El análisis de datos consiste en relacionar un paciente con sus resultados de compatibilidad y permitir al frontend mostrar recomendaciones o estados.

### Flujo conceptual del proyecto

- El usuario completa un formulario en la interfaz web.
- La interfaz web envía JSON al backend.
- El backend crea o busca el usuario adecuado en la base de datos.
- Si se solicita un test de compatibilidad, el backend crea una entidad `TestCompatibilidad` ligada a un `Paciente`.
- El frontend obtiene la respuesta y muestra los resultados de compatibilidad.

### Qué partes del backend son clave para esta integración

- `Usuario`: define los datos comunes de paciente y psicólogo.
- `Paciente` / `Psicologo`: representan los tipos de usuarios que el frontend maneja.
- `TestCompatibilidad`: guarda el análisis y la relación con el paciente.
- Repositorios JPA: puente entre el backend y la base de datos.
- Una futura capa de controladores REST: puente entre el frontend y las clases Java.

## 6. Recomendación para finalizar el proyecto

Para que el frontend funcione correctamente con este código Java, debes:

1. Crear controladores REST (`@RestController`) en `src/main/java/com/empathym3/empathy/controller`.
2. Exponer los endpoints mencionados arriba.
3. Consumir esos endpoints desde el frontend con fetch/Axios o similares.
4. Configurar la base de datos en `application.properties` si vas a usar un motor distinto a H2.

---

Con esto, tu documento de integración técnica y conceptual queda listo para explicar cómo funciona el backend y cómo debería conectarse el frontend. Si quieres, también puedo generar la clase `EmpathyController` ejemplo que haga exactamente estas rutas REST.
=======
## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
>>>>>>> 745df8f9ef0bb8656d73fc1b2bfd7561f4b470cf
