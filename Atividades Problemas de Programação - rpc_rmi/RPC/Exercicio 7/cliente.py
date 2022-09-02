import xmlrpc.client

proxy = xmlrpc.client.ServerProxy("http://localhost:8080/")

idade = int(input("Digite a idade: "))
tempo = int(input("Digite o tempo de servico (em anos): "))

respota = proxy.aposentadoria(idade, tempo)

print(respota)
