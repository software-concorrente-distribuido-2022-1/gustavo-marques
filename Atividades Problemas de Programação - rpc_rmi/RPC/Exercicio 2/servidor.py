from xmlrpc import server
from xmlrpc.server import SimpleXMLRPCServer


def maioridade(nome, sexo, idade):
    if sexo.upper() != 'MASCULINO' and sexo.upper() != 'FEMININO':
        return('Sexo incorreto, somente \'MASCULINO\' e \'FEMININO\'')
    else:
        if (sexo == 'MASCULINO' and idade >= 18) or (sexo == 'FEMININO' and idade >= 21):
            return('{} já atingiu a maioridade'.format(nome))
        else:
            return('{} ainda não atingiu a maioridade'.format(nome))


server = SimpleXMLRPCServer(("localhost", 8080))
print("Listening on port 8080...")
server.register_function(maioridade, 'maioridade')

server.serve_forever()
