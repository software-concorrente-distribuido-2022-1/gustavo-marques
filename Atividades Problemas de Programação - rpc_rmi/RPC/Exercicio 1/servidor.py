from xmlrpc import server
from xmlrpc.server import SimpleXMLRPCServer


def reajuste(nome, cargo, salario):
    if cargo.upper() != 'OPERADOR' and cargo.upper() != 'PROGRAMADOR':
        return('Cargo incorreto, somente \'OPERADOR\' e \'PROGRAMADOR\'')
    else:
        if cargo == 'OPERADOR':
            salario = salario*1.2
        else:
            salario = salario*1.18

    return('Nome: {} \nSalário reajustado: {}'.format(nome, salario))


server = SimpleXMLRPCServer(("localhost", 8080))
print("Listening on port 8080...")
server.register_function(reajuste, 'reajuste')

server.serve_forever()
