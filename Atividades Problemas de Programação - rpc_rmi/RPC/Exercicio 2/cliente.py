import xmlrpc.client

proxy = xmlrpc.client.ServerProxy("http://localhost:8080/")

nome = str(input("Digite o nome: "))
sexo = str(input("Digite o sexo: "))
idade = int(input("Digite a idade: "))

respota = proxy.maioridade(nome, sexo, idade)

print(respota)
