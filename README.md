<h1 align="center">Insight TOTVS</h1>

<p align="center">
  <a href="#projeto">Projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#integrantes">Integrantes</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#funcionalidades">Funcionalidades</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#conceitos-aplicados">Conceitos Aplicados</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#estrutura-do-projeto">Estrutura</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#banco-de-dados">Banco de Dados</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#diagrama-de-classes">Diagrama de Classes</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#como-executar">Como Executar</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#testes-manuais">Testes Manuais</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#documentação">Documentação</a>
</p>

---

## Projeto

O **Insight TOTVS** é uma aplicação desenvolvida em **Java** para apoiar a análise de reuniões e conversas comerciais. A solução permite que um funcionário TOTVS crie uma conta, realize login, cadastre reuniões, registre transcrições e receba insights básicos gerados a partir do conteúdo informado.

Nesta Sprint 3, o foco do projeto foi a construção da base da aplicação Java com orientação a objetos, separação em camadas, persistência em banco de dados Oracle, padrão DAO e uma interface simples utilizando `JOptionPane`.

---

## Integrantes

| Nome | RM |
|---|---|
| Augusto Valerio | 562185 |
| Pedro Marchese | 563339 |
| Mariana Oliveira | 564241 |
| Jonas Esteves | 564143 |
| Vitor Tigre | 561746 |

---

## Funcionalidades

<details>
<summary>Ver funcionalidades implementadas</summary>

- Cadastro de funcionário TOTVS.
- Login com e-mail e senha.
- Cadastro de reunião.
- Cadastro de transcrição vinculada a uma reunião.
- Busca de transcrição por ID.
- Listagem de transcrições cadastradas.
- Atualização de transcrição.
- Exclusão de transcrição.
- Exclusão dos insights vinculados antes da remoção da transcrição.
- Geração básica de insight a partir do texto da transcrição.
- Retorno das operações em formato semelhante a JSON, simulando uma resposta de API.

</details>

---

## Conceitos Aplicados

<details>
<summary>Ver conceitos de Java e banco de dados</summary>

- Classes e objetos.
- Encapsulamento.
- Construtores.
- Getters e setters.
- Validação de dados nas entidades.
- Organização em pacotes.
- Separação em camadas.
- Interface com `JOptionPane`.
- Serviços para regras de login e geração de insight.
- Conexão com banco de dados Oracle via JDBC.
- Padrão DAO para persistência dos dados.
- Herança nos DAOs a partir da classe `FactoryDao`.
- Uso de `ArrayList` para listagem de registros.
- Tratamento de exceções nas operações de banco.

</details>

---

## Estrutura do Projeto

<details>
<summary>Ver estrutura principal</summary>

```txt
src
└── main
    └── java
        └── br
            └── com
                └── fiap
                    ├── conexoes
                    │   └── ConexaoFactory.java
                    │
                    ├── dao
                    │   ├── FactoryDao.java
                    │   ├── UserDao.java
                    │   ├── LoginDao.java
                    │   ├── TotvsEmployeeDao.java
                    │   ├── MeetingDao.java
                    │   ├── TranscriptionDao.java
                    │   └── InsightDao.java
                    │
                    ├── entities
                    │   ├── User.java
                    │   ├── TotvsEmployee.java
                    │   ├── Meeting.java
                    │   ├── Transcription.java
                    │   └── Insight.java
                    │
                    ├── jopanels
                    │   ├── Init.java
                    │   ├── Login.java
                    │   ├── Register.java
                    │   └── TranscriptionPanel.java
                    │
                    ├── main
                    │   ├── Main.java
                    │   ├── ConnectionTest.java
                    │   └── TranscriptionDaoTest.java
                    │
                    ├── services
                    │   ├── LoginService.java
                    │   └── InsightService.java
                    │
                    └── utils
                        ├── ApiResponse.java
                        └── Jopt.java
```

</details>

---

## Banco de Dados

O projeto utiliza banco de dados **Oracle** para armazenar os dados principais da aplicação. O modelo relacional é composto por cinco tabelas:

| Tabela | Finalidade |
|---|---|
| `USUARIO` | Armazena dados de autenticação, como nome, e-mail, senha e tipo de usuário. |
| `FUNCIONARIO_TOTVS` | Armazena os dados profissionais do funcionário TOTVS vinculado ao usuário. |
| `REUNIAO` | Armazena as reuniões cadastradas pelo funcionário. |
| `TRANSCRICAO` | Armazena o conteúdo textual da reunião. |
| `INSIGHT` | Armazena os insights gerados a partir das transcrições. |

As relações entre as tabelas são feitas por chaves estrangeiras, conectando usuário, funcionário, reunião, transcrição e insight.

---

## Diagrama de Classes

O diagrama de classes foi dividido em páginas para facilitar a leitura da estrutura do sistema. Ele apresenta as entidades do domínio, classes de interface, serviços, classes de persistência, utilitários e testes.

Nos diagramas são apresentados os principais métodos utilizados no funcionamento da aplicação, como login, cadastro, operações de CRUD, validações, geração de insight e acesso ao banco de dados. Construtores, getters, setters e cláusulas `throws` foram omitidos para manter a leitura objetiva.

[Arquivo editável do diagrama de classes](./Diagrama%20de%20Classes%20Sprint3.drawio)

---

## Tecnologias

| Tecnologia | Uso |
|---|---|
| Java 21 | Linguagem principal do projeto |
| Maven | Gerenciamento do projeto e dependências |
| Oracle Database | Banco de dados relacional |
| JDBC | Conexão entre Java e Oracle |
| OJDBC 17 | Driver Oracle utilizado pelo projeto |
| JOptionPane | Interface gráfica simples para interação com o usuário |

---

## Como Executar

<details>
<summary>Executar pelo IntelliJ IDEA</summary>

1. Abra o projeto no IntelliJ IDEA.
2. Verifique se o SDK do Java 21 está configurado.
3. Confira se a dependência `ojdbc17` foi carregada pelo Maven.
4. Configure a conexão Oracle na classe `ConexaoFactory`.
5. Crie as tabelas necessárias no banco de dados.
6. Acesse o arquivo `Main.java`.
7. Execute o método `main`.
8. Use as opções exibidas pelas telas do `JOptionPane`.

</details>

<details>
<summary>Executar pelo terminal</summary>

Compile o projeto com Maven:

```bash
mvn clean compile
```

Execute a classe principal:

```bash
mvn exec:java -Dexec.mainClass="br.com.fiap.main.Main"
```

Caso o plugin de execução não esteja configurado no Maven, execute diretamente pela IDE.

</details>

---

## Testes Manuais

<details>
<summary>Ver classes de teste</summary>

O projeto possui classes com método `main` para testes manuais:

| Classe | Finalidade |
|---|---|
| `ConnectionTest` | Testa a conexão com o banco Oracle. |
| `TranscriptionDaoTest` | Testa o fluxo de cadastro de reunião, transcrição, geração de insight e exclusão dos dados de teste. |

</details>

---

## Documentação

A documentação da Sprint 3 contém capa, sumário, objetivo e escopo, funcionalidades, protótipo com telas, modelo do banco de dados e diagrama de classes atualizado.

[📄 Acessar documentação da Sprint 3](./Documentação_Sprint3.pdf)

---

<p align="center">
  Desenvolvido para o Challenge 2026 - TOTVS | FIAP
</p>
