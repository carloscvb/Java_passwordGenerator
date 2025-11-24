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
