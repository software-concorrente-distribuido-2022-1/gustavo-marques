import xmlrpc.client

proxy = xmlrpc.client.ServerProxy("http://localhost:8080/")

nome = str(input("Digite o nome: "))
nivel = str(input("Digite o nivel: "))
sal = float(input("Digite o salario bruto: "))
dependentes = int(input("Digite o numero de dependentes: "))

respota = proxy.salLiquido(nome, nivel, sal, dependentes)

print(respota)
