from xmlrpc import server
from xmlrpc.server import SimpleXMLRPCServer


def credito(saldo):
    if saldo < 0:
        return('Somente saldo positivo')
    else:
        if saldo <= 200:
            return('Saldo médio: {}\nValor do Crédito {}')
        elif saldo <= 400:
            return('Saldo médio: {}\nValor do Crédito {}'.format(saldo, saldo*0.2))
        elif saldo <= 600:
            return('Saldo médio: {}\nValor do Crédito {}'.format(saldo, saldo*0.3))
        else:
            return('Saldo médio: {}\nValor do Crédito {}'.format(saldo, saldo*0.4))


server = SimpleXMLRPCServer(("localhost", 8080))
print("Listening on port 8080...")
server.register_function(credito, 'credito')

server.serve_forever()
