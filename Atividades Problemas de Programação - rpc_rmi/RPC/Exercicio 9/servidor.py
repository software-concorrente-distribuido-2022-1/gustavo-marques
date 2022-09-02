from xmlrpc import server
from xmlrpc.server import SimpleXMLRPCServer


def carta(valor, naipe):
    if valor < 1 or valor > 13:
        return('Valor incorreto, somente de 1 a 13')
    elif naipe < 1 or naipe > 4:
        return('Naipe incorreto, somente de 1 a 4')
    else:
        valores = {1: 'Ás', 2: 'Dois', 3: 'Três', 4: 'Quatro',
                   5: 'Cinco', 6: 'Seis', 7: 'Sete', 8: 'Oito', 9: 'Nove',
                   10: 'Dez', 11: 'Valete', 12: 'Dama', 13: 'Rei'}
        naipes = {1: 'Ouros', 2: 'Paus', 3: 'Copas', 4: 'Espadas'}

        nome = valores[valor]+' de '+naipes[naipe]
        return(nome)


server = SimpleXMLRPCServer(("localhost", 8080))
print("Listening on port 8080...")
server.register_function(carta, 'carta')

server.serve_forever()
