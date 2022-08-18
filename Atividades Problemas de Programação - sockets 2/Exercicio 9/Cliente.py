from random import random
import socket
import random
import sys

class Carta:
    def __init__(self):
        self.valor = random.randint(1, 13)
        self.naipe = random.randint(1, 4)

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

qtdCartas = int(input("Digite o numero de cartas para serem geradas: "))
while qtdCartas > 0:
    socketCliente = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    try:
        socketCliente.connect((nomeHost, porta))
    except:
        print("\n\nHost nao encontrado!\n")
        print("\n\nUso Correto: Cliente <NomeDoHost> [porta]\n\n")
        sys.exit(1)
    
    carta = Carta()
    mensagem = (str(carta.valor) + "," + str(carta.naipe) + "\r\n")

    socketCliente.send(mensagem.encode())

    print("\nResposta do Host:\n")
    resposta = socketCliente.recv(1024)
    while resposta:
        print(resposta.decode())
        resposta = socketCliente.recv(1024)

    socketCliente.close()
    qtdCartas = qtdCartas - 1