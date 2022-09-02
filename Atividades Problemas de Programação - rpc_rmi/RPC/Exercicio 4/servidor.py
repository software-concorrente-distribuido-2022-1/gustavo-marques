from xmlrpc import server
from xmlrpc.server import SimpleXMLRPCServer


def peso(altura, sexo):
    if sexo.upper() != 'MASCULINO' and sexo.upper() != 'FEMININO':
        return('Sexo incorreto, somente \'MASCULINO\' e \'FEMININO\'')
    else:
        if sexo == 'MASCULINO':
            ideal = (72.7 * altura) - 58
        else:
            ideal = (62.1 * altura) - 44.7
        return('Peso Ideal = {}'.format(ideal))


server = SimpleXMLRPCServer(("localhost", 8080))
print("Listening on port 8080...")
server.register_function(peso, 'peso')

server.serve_forever()
