# 🔊 DEV SCREEN MUSIC 🎙️

Projeto de criação de um banco de dados de artistas e suas músicas. Esse projeto foi criado a partir do desafio do Curso "[Java: trabalhando com lambdas, streams e Spring Framework](https://cursos.alura.com.br/course/java-persistencia-dados-consultas-spring-data-jpa)", da [Alura](https://www.alura.com.br/).

## **Como rodar o projeto: ✅**
- Cadastrar artistas:
*_(nesse exemplo, usarei o artista 'Bruno Mars')_*
```
Digite 1
Digite 'Bruno Mars'
Digite 'Solo'
Digite 'n'
```
- Cadastrar músicas:
*_(nesse exemplo, vamos adicionar três músicas do Bruno, sendo '24K Magic', 'Just The Way You Are' e 'Talking To The Moon')_*
```
Digite 2
Digite 'Bruno' ()
Digite '24K Magic'
Digite 's'
Digite 'Just The Way You Are'
Digite 's'
Digite 'Talking To The Moon'
Digite 'n'
```
*_O programa já irá localizar o Bruno Mars, único artista com o nome 'Bruno' no banco de dados até o momento_*
- Listar músicas cadastradas:
```
Digite 3
Imprimindo:
24K Magic
Just The Way You Are
Talking To The Moon
```
- Buscar músicas por artistas:
```
Digite 4
Digite 'Bruno Mars'
Imprimindo:
[24K Magic]
[Just The Way You Are]
[Talking To The Moon]
```
- Pesquisar dados sobre um artista:
  
_**Importante:** para rodar esse método, é imprescindível que acesse a classe "ConsultaChatGPT", no pacote 'service' e coloque sua própria APIKEY do ChatGPT._
```
Digite 5
Digite 'Bruno Mars'
Imprimindo:
"Bruno Mars é um cantor, compositor e produtor musical americano, nascido em 8 de outubro de 1985, no Havaí. Seu nome verdadeiro é Peter Gene Hernandez. Ele é conhecido por sua versatilidade musical, combinando elementos de pop, R&B, funk, soul, reggae e rock em suas músicas. Bruno Mars ganhou destaque com sucessos como "Just the Way You Are", "Grenade", "Locked Out of Heaven" e "Uptown Funk", este último em colaboração com Mark Ronson. Sua habilidade vocal e carisma no palco lhe renderam vários prêmios, incluindo Grammys. Além de sua carreira solo, Bruno Mars também escreveu e produziu músicas para outros artistas. Ele é reconhecido por suas apresentações energéticas e coreografias impressionantes, frequentemente comparadas aos estilos de lendas da música como Michael Jackson e Prince."
```
- Listar artistas cadastrados
```
Digite 6
Imprimindo:
Bruno Mars
```
- Buscar músicas cadastradas pelo nome
```
Digite 7
Digite 'Just The Way You Are'
Imprimindo:
Artista: Bruno Mars - Música: Talking to the moon
```
- Buscar artistas por categoria
```
Digite 8
Digite 'solo'
Imprimindo:
Bruno Mars
```
## **Para criar o projeto, fiz o seguinte passo a passo:**
📌 criar um menu para o usuário escolher a opção desejada, entre cadastrar, listar, buscar ou pesquisar sobre um artista;

📌 criar métodos para todas as opções informadas no Menu, fazendo já conexão com o banco de dados e salvando as informações no mesmo;

📌 criar uma classe específica para utilizar a API do ChatGPT para o método pesquisaDadosArtista();

📌 testar cada um dos métodos, criando, listando, buscando artistas e músicas; e testar se tudo estava sendo salvo corretamente no banco de dados.

Esse projeto foi sensacional! Além de consolidar meus conhecimentos em **consumo de API**, consumindo a API do ChatGPT, aprendi sobre **Spring Data JPA, Hibernate, Derived Queries** e ainda, sobre o banco de dados **Postgresql**. Reforçei a aprendizagem de lógica de programação, o uso de **Optional**, switch case, Interfaces e a separação das classes em pacotes. Pude exercitar melhor o uso da **application.properties** para a conexão junto ao banco de dados e o uso das anotações **@Entity, @Table, @ManyToOne, @OneToMany, @Id, @GeneratedValue** e **@Enumerated**, para lidar com classe ENUM.

## **Problemas enfrentados** ⚠️
#### Problema 01:
Criação de variáveis de ambiente da minha conta, para facilitar a implementação de outras pessoas junto a seus banco de dados e, também, garantir a segurança das minhas informações.
* **Como solucionei:** Realizei uma série de pesquisas para identificar a causa da dificuldade na implementação correta das variáveis em meu código. Descobri que a origem do problema era apenas um erro de digitação. Esse incidente foi significativo, pois proporcionou uma oportunidade valiosa para aprofundar meus conhecimentos em PostgreSQL e Hibernate.

#### Problema 02:
Criação da API do ChatGPT para poder utilizá-la para pesquisar sobre um artista. 
* **Como solucionei:** Para utilizar a API do ChatGPT, é necessário possuir créditos junto à IA. Enfrentei dificuldades na criação e no acesso à conta devido a um erro na plataforma, que frequentemente informava que minha senha era inválida. Após conseguir acessar a conta, verifiquei que não havia saldo disponível. Foi necessário adquirir créditos para criar a API. Após essa etapa, o problema foi completamente resolvido.
  
#### Problema 03:
Utilização do @AutoWired e a implementação do CommandLineRunner na classe ScreenmusicApplication.
* **Como solucionei:** Recorri às instrutoras do curso, o que foi fundamental para o meu progresso. Essa experiência ressaltou ainda mais a importância dos pequenos detalhes no desenvolvimento de código, pois sem a devida atenção a eles, meu código não funcionaria corretamente.

## **Tecnologias utilizadas:** 
* [Java](https://www.java.com/pt-BR/)
* [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
* [JPQL](https://docs.oracle.com/cd/E29542_01/apirefs.1111/e13946/ejb3_langref.html)
* [PostgreSQL](https://www.postgresql.org/)

## ⏭️ Próximos passos:
A partir dessa aplicação, quero seguir com o curso de "Java: criando sua primeira API e conectando ao front" para poder conectar meus projetos já criados com o front-end!
