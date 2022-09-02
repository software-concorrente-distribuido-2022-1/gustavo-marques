import xmlrpc.client

proxy = xmlrpc.client.ServerProxy("http://localhost:8080/")

altura = str(input("Digite a altura (em metros): "))
sexo = str(input("Digite o sexo: "))

respota = proxy.peso(altura, sexo)

print(respota)
