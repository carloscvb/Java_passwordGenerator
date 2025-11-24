# README – Secure Password Generator (Client/Server in Java)

📌 Author
Your Carlos J. Venegas Berrones
Project: PAC – DAM Development – Password Generator with Sockets
IDE: Eclipse
Language: Java

Project Description

This project implements a Client/Server application in Java using Sockets.
The objective is to generate secure passwords based on requirements defined by the user from the client.

The server:

Requests the password requirements (uppercase, lowercase, digits, and special characters).

Calculates the total length.

Optionally generates the password according to those requirements.

Applies validations and error handling.

Responds to the client following the flow established by the PAC.

The client:

Connects to the server.

Reads the server messages and displays the questions.

Sends the user’s answers when required.

Receives the generated password or the final message.

📂 Project Structure
src/
│
├── servidor/
│   ├── MainServidor.java
│   ├── Servidor.java
│   ├── ServicioPass.java
│   └── RequisitosPass.java
│
└── cliente/
    ├── MainCliente.java
    └── Cliente.java

🖥️ Execution
1️⃣ Run the Server

In Eclipse:
Right-click on MainServidor.java
→ Run As
→ Java Application

The server will wait for connections on port 4321.

2️⃣ Run the Client

In a separate execution:
Right-click on MainCliente.java
→ Run As
→ Java Application

The client will automatically connect to the server at localhost:4321.

🔧 General Operation
Server flow:

Asks for the user’s name.

Requests:

Number of uppercase letters

Number of lowercase letters

Number of digits

Number of special characters

Displays the total password length.

Asks whether the user wants to generate it.

Generates and sends the password (if confirmed).

Closes the connection.

Includes:

Error handling

Validations

Clear messages

Ordered disconnection

🔐 Password Generation

The ServicioPass class:

Uses SecureRandom for better security.

Selects characters from allowed groups.

Shuffles the final result to avoid patterns (extra point).

Returns a strong and random password.

⚠️ Implemented Validations

Negative numbers → error.

Non-numeric values → error.

“Yes/No” answers interpreted flexibly.

Client disconnection handled correctly.

If the user sends invalid data, the server:

Sends an error message.

Closes the connection (as required by the PAC).

📝 Technical Requirements Met

✔ Client/Server communication using Sockets
✔ Full validations
✔ Separated classes in packages
✔ Clear structure and comments
✔ Use of SecureRandom
✔ Encapsulated logic in ServicioPass
✔ RequisitosPass as a simple POJO
✔ Proper connection closing
✔ Conversational flow according to the assignment