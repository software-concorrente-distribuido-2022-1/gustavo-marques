from xmlrpc import server
from xmlrpc.server import SimpleXMLRPCServer


def categoria(idade):
    if idade < 5:
        return('Sem classificação')
    elif idade <= 7:
        return('Infantil A')
    elif idade <= 10:
        return('Infantil B')
    elif idade <= 13:
        return('Juvenil A')
    elif idade <= 17:
        return('Juvenil B')
    else:
        return('Adulto')


server = SimpleXMLRPCServer(("localhost", 8080))
print("Listening on port 8080...")
server.register_function(categoria, 'categoria')

server.serve_forever()
