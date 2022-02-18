[up]: #up "Ir arriba"
# robomatic-email-api <div id="up"/>
**Servicio de envío de correos.**

Servicio que permite enviar correos desde cualquier servicio.


# Índice de Contenido

1. [Ejecución.](#ejecucion)
2. [Dependencias.](#dependencias)
3. [Componentes con los que interactúa.](#componentes)
4. [Descripción funcionamiento.](#descripcion)
5. [Changelogs.](#changelogs)
6. [Contacto.](#contacto)


##  [»][up] Ejecución <div id="ejecucion"/>

Se debe ejecutar con comandos:

| Comando           | Descripción |
| ---------------- | ------------ |
| `./docker-build` | Crear imagen. |
| `./docker-run`   | Iniciar imagen creada. |
| `./docker-stop`  | Detener contenedor. |
| `./server`       | Disponibiliza la aplicación en local, en http://localhost:8026/ |


##  [»][up] Dependencias <div id="dependencias"/>

- PostgreSQL Server.
- ActiveMQ.


##  [»][up] Componentes con los que interactúa <div id="componentes"/>

- Microservicios que necesiten enviar correos.

##  [»][up] Descripción Funcionamiento <div id="descripcion"/>

Inicia cuando un microservicio necesita enviar un correo. 
Dicho microservicio consume un endpoint del servicio de correos, 
enviando la data a necesaria, correo origen, correo destino, 
asunto, templateId, cuerpo, archivos adjuntos, etc.

El servicio de correos enviará el correo
con la data proporcionada.


##  [»][up] Changelogs <div id="changelogs"/>
### - Versión 1 (30/09/2021)


##  [»][up] Contacto <div id="contacto"/>

* Vertical: **RPA.**
* Célula: **RPA**
* Product Owner: **Edgar Gonzalez Briceño** ([edgar.gonzalez@robomatic-rpa.com](mailto:edgar.gonzalez@robomatic-rpa.com)).
* Líder Técnico: **Edgar Gonzalez Briceño** ([edgar.gonzalez@robomatic-rpa.com](mailto:edgar.gonzalez@robomatic-rpa.com)).


---
© 2021 Robomatic
