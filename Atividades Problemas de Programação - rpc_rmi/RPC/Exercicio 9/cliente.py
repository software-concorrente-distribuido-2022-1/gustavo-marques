import xmlrpc.client
import random


class Carta:
    def __init__(self):
        self.valor = random.randint(1, 13)
        self.naipe = random.randint(1, 4)


proxy = xmlrpc.client.ServerProxy("http://localhost:8080/")

qtdCartas = int(input("Digite o numero de cartas para serem geradas: "))
while qtdCartas > 0:
    carta = Carta()

    respota = proxy.carta(carta.valor, carta.naipe)

    print(respota)
    qtdCartas = qtdCartas - 1
