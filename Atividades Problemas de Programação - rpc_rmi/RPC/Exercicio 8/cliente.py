import xmlrpc.client

proxy = xmlrpc.client.ServerProxy("http://localhost:8080/")

saldo = float(input("Digite o saldo medio: "))

respota = proxy.credito(saldo)

print(respota)
