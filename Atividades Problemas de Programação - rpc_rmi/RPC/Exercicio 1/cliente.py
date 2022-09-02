import xmlrpc.client

proxy = xmlrpc.client.ServerProxy("http://localhost:8080/")

nome = str(input("Digite o nome: "))
cargo = str(input("Digite o cargo: "))
salario = float(input("Digite o salario: "))

respota = proxy.reajuste(nome, cargo, salario)

print(respota)
