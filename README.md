Passo a Passo:
1.	Inicializar o repositório Git: Se o repositório ainda não foi inicializado, abra o terminal na pasta do seu projeto e execute:
git init
2.	Adicionar os arquivos ao repositório: Adicione todos os arquivos do seu projeto ao repositório:

git add .
3.	Realizar o commit: Agora, você pode realizar o commit com a descrição "Projeto inicial", incluindo o nome do projeto, explicação sobre o que se trata e as tecnologias utilizadas:


git commit -m "Projeto inicial: Sistema de Leilões\nDescrição: Este projeto é um sistema de cadastro de produtos para leilões, onde o usuário pode cadastrar e consultar produtos.\nTecnologias utilizadas: Java, Swing"
Explicação do Commit:
•	Nome do projeto: "Sistema de Leilões"
•	Descrição: O projeto permite que os usuários cadastrem novos produtos para leilões e consultem os produtos cadastrados.
•	Tecnologias utilizadas: Java (para o desenvolvimento do sistema), Swing (para a interface gráfica).
Exemplo de Commit:

git commit -m "Projeto inicial: Sistema de Leilões
Descrição: Este projeto é um sistema de cadastro de produtos para leilões, onde o usuário pode cadastrar e consultar produtos.
Tecnologias utilizadas: Java, Swing"
Após isso, os arquivos serão registrados no seu repositório Git com a descrição fornecida.
Se você quiser enviar o projeto para um repositório remoto no GitHub (ou outro serviço), basta configurar o repositório remoto e usar o comando git push:


git remote add origin <URL do repositório>
git push -u origin master

