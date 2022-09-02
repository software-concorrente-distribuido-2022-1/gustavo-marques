from xmlrpc import server
from xmlrpc.server import SimpleXMLRPCServer


def aposentadoria(idade, tempo):
    if idade >= 65 or tempo >= 30 or (idade >= 60 and tempo >= 25):
        return('O funcionário já pode se aposentar')
    else:
        return('O funcionário não pode se aposentar')


server = SimpleXMLRPCServer(("localhost", 8080))
print("Listening on port 8080...")
server.register_function(aposentadoria, 'aposentadoria')

server.serve_forever()
