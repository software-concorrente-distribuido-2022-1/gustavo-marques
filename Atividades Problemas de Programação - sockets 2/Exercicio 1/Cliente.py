import socket
import sys

portaDefault = 80
nomeHost = None
porta = portaDefault
socketCliente = None
nome = None
cargo = None
salario = 0.0
mensagem = None

if len(sys.argv) == 2 or len(sys.argv) == 3:
    nomeHost = sys.argv[1]
    if len(sys.argv) == 3:
        porta = int(sys.argv[2])
else:
    print("\n\nUso Correto: Cliente <NomeDoHost> [porta]\n\n")
    sys.exit(1)

socketCliente = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
try:
    socketCliente.connect((nomeHost, porta))
except:
    print("\n\nHost nao encontrado!\n")
    print("\n\nUso Correto: Cliente <NomeDoHost> [porta]\n\n")
    sys.exit(1)

nome = input("Digite o nome: ")
cargo = input("Digite o cargo: ")
salario = input("Digite o salario: ")
mensagem = (nome + "," + cargo + "," + salario + "\r\n")

socketCliente.send(mensagem.encode())

print("\nResposta do Host:\n")
resposta = socketCliente.recv(1024)
while resposta:
    print(resposta.decode())
    resposta = socketCliente.recv(1024)

socketCliente.close()