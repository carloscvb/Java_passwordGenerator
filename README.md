# 🔐 Secure Password Generator (Java Client/Server)

> PAC Project – DAM  
> IDE: **Eclipse**  
> Language: **Java**

---

## 📌 Author

- **Name:** Carlos J. Venegas Berrones 
- **Project:** Password Generator with Sockets (Client/Server)

---

## 📘 Project Description

This project implements a **Client/Server application in Java** using **Sockets**.  
The goal is to generate **secure passwords** based on requirements defined by the user from the client side.

### 🖥️ Server

The server is responsible for:

- Requesting password requirements:
  - Number of **uppercase letters**
  - Number of **lowercase letters**
  - Number of **digits**
  - Number of **special characters**
- Calculating the **total password length**.
- Asking whether the user wants to **generate the password**.
- Generating the password according to the provided specifications.
- Applying **validations** and **error handling**.
- Responding to the client following the PAC guidelines.
- Closing the connection properly.

### 💻 Client

The client:

- Connects to the server using sockets.
- Reads and displays the server messages to the user.
- Sends the user's responses back to the server.
- Receives the generated password or the final message.
- Closes the connection when instructed by the server.

---

## 📂 Project Structure

```bash
src/
│
├── servidor/
│   ├── MainServidor.java      # Server entry point
│   ├── Servidor.java          # Main server logic (sockets)
│   ├── ServicioPass.java      # Password generation logic
│   └── RequisitosPass.java    # POJO containing password requirements
│
└── cliente/
    ├── MainCliente.java       # Client entry point
    └── Cliente.java           # Client-server communication logic




-------------------------------------------------------------------
# README – Secure Password Generator (Client/Server in Java)

# 🔐 Generador de Contraseñas Seguras (Cliente/Servidor en Java)

> Proyecto PAC – DAM  
> IDE: **Eclipse**  
> Lenguaje: **Java**

---

## 📌 Autor

- **Nombre:** Carlos J. Venegas Berrones
- **Proyecto:** Generador de Contraseñas con Sockets (Cliente/Servidor)  

---

## 📘 Descripción del Proyecto

Este proyecto implementa una aplicación **Cliente/Servidor en Java** utilizando **Sockets**.  
El objetivo es generar **contraseñas seguras** siguiendo unos requisitos que el usuario define desde el cliente.

### 🖥️ Servidor

El servidor se encarga de:

- Solicitar los requisitos de la contraseña:
  - Número de **mayúsculas**
  - Número de **minúsculas**
  - Número de **dígitos**
  - Número de **caracteres especiales**
- Calcular la **longitud total** de la contraseña.
- Preguntar si el usuario desea **generar la contraseña**.
- Generar la contraseña cumpliendo los requisitos (si el usuario acepta).
- Aplicar **validaciones** y **manejo de errores**.
- Responder al cliente manteniendo el flujo establecido por la PAC.
- Realizar una **desconexión ordenada**.

### 💻 Cliente

El cliente:

- Se conecta al servidor mediante sockets.
- Lee los mensajes enviados por el servidor y muestra las preguntas al usuario.
- Envía las respuestas del usuario al servidor.
- Recibe la contraseña generada o el mensaje final.
- Cierra la conexión cuando el servidor lo indica.

---

## 📂 Estructura del Proyecto

```bash
src/
│
├── servidor/
│   ├── MainServidor.java      # Punto de entrada del servidor
│   ├── Servidor.java          # Lógica principal del servidor (sockets)
│   ├── ServicioPass.java      # Lógica de generación de contraseñas
│   └── RequisitosPass.java    # POJO con los requisitos de la contraseña
│
└── cliente/
    ├── MainCliente.java       # Punto de entrada del cliente
    └── Cliente.java           # Lógica de comunicación con el servidor
