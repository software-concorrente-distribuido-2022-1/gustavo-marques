from xmlrpc import server
from xmlrpc.server import SimpleXMLRPCServer


def aprovacao(n1, n2, n3):
    m = (n1+n2)/2
    if (m >= 7) or (m > 3 and (m+n3)/2 >= 5):
        return('O aluno foi aprovado')
    else:
        return('O aluno foi reprovado')


server = SimpleXMLRPCServer(("localhost", 8080))
print("Listening on port 8080...")
server.register_function(aprovacao, 'aprovacao')

server.serve_forever()
