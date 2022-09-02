import xmlrpc.client

proxy = xmlrpc.client.ServerProxy("http://localhost:8080/")

n1 = float(input("Digite a N1: "))
n2 = float(input("Digite a N2: "))
n3 = float(input("Digite a N3: "))

respota = proxy.aprovacao(n1, n2, n3)

print(respota)
