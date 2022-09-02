from xmlrpc import server
from xmlrpc.server import SimpleXMLRPCServer


def salLiquido(nome, nivel, sal, dependentes):
    if nivel.upper() != 'A' and nivel.upper() != 'B' and nivel.upper() != 'C' and nivel.upper() != 'D':
        print('Nível incorreto, somente \'A\', \'B\', \'C\' e \'D\'')
    else:
        if dependentes <= 0:
            if nivel == 'A':
                sal = sal*(1-0.03)
            elif nivel == 'B':
                sal = sal*(1-0.05)
            elif nivel == 'C':
                sal = sal*(1-0.08)
            else:
                sal = sal*(1-0.1)
        else:
            if nivel == 'A':
                sal = sal*(1-0.08)
            elif nivel == 'B':
                sal = sal*(1-0.10)
            elif nivel == 'C':
                sal = sal*(1-0.15)
            else:
                sal = sal*(1-0.17)

        return('Nome: {}\nNível: {}\nSalário líquido: {}'.format(nome, nivel, sal))


server = SimpleXMLRPCServer(("localhost", 8080))
print("Listening on port 8080...")
server.register_function(salLiquido, 'salLiquido')

server.serve_forever()
