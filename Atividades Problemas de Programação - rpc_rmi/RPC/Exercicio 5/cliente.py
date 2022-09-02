import xmlrpc.client

proxy = xmlrpc.client.ServerProxy("http://localhost:8080/")

idade = int(input("Digite a idade: "))

respota = proxy.categoria(idade)

print(respota)
