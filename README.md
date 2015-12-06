# Tecnologia em Análise e Desenvolvimento de Sistemas
Trabalho do 4º Bimestre - 2015

#Configuração
* Executar arquivo .sql que está na pasta resources no seu banco de dados;
* Configurar a classe ConexaoServidor com os parametros do seu banco;

#Padrões de projeto utilizado:
* Padrão Singleton para abrir conexão com o banco somente uma única vez e também para verificar se 
  algumas janelas já estavam instanciadas e assim poder passar dados de uma janela para outra.
* Padrão DAO para manipulação de dados no banco.

# Tela Login
* Login pelo ID do usuário e uma senha cadastrada
* Após executado o arquivo .sql, pode-se entrar com o usuário "1" e senha "1"

#Telas da aplicação:
* Cadastro de Cliente, Produto, Usuário e Venda
* Geração de Relatórios de Cliente, Produto e Venda.