# AYFood

Tech Challenge Fast Food desenvolvido no curso de Pós-Graduação em Arquitetura de Software na Pós-Tech FIAP.

---

## Sumário
1. [Sobre o Projeto](#sobre-o-projeto)
2. [Tecnologias Utilizadas](#tecnologias-utilizadas)
3. [Pré-requisitos](#pré-requisitos)
4. [Como Executar Localmente](#como-executar-localmente)
5. [Documentação e Acesso](#documentação-e-acesso)
6. [Autores](#autores)

---

## Sobre o Projeto

O **AYFood** é uma aplicação desenvolvida em **Spring Boot**, seguindo o padrão de **Arquitetura Hexagonal** para garantir maior desacoplamento e facilidade de manutenção. Além da API em Spring Boot, o projeto utiliza o banco de dados **PostgreSQL**. Este projeto tem como objetivo oferecer uma base sólida para estudos e aplicação prática de conceitos avançados em arquitetura de software.

---

## Tecnologias Utilizadas
- **Java** (Spring Boot): Framework para construção de aplicações robustas e escaláveis.
- **Docker**: Ferramenta de containerização para garantir a portabilidade e consistência do ambiente.
- **PostgreSQL**: Banco de dados relacional utilizado para persistência de dados.
- **Arquitetura Hexagonal**: Padrão arquitetural focado em modularidade e independência de tecnologias externas.
- **Swagger/OpenAPI**: Ferramenta para documentação interativa e testes das APIs.

---

## Pré-requisitos

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas em seu ambiente:

- **Docker**: Para executar os contêineres da aplicação.
- **Git**: Para clonar o repositório.

---

## Como Executar Localmente

Siga os passos abaixo para configurar e executar o projeto em seu ambiente local:

1. **Clonar o repositório**
   ```bash
   git clone git@github.com:YanGianini/AYFood.git
   cd AYFood
   ```

2. **Copiar o arquivo de exemplo `.env`**
   ```bash
   cp .env.example .env
   ```

3. **Subir os contêineres**
   ```bash
   docker compose up --build
   ```

4. **Aguardar a criação da estrutura do banco**

   O Docker irá construir as imagens, subir o container do banco de dados PostgreSQL e, em seguida, a aplicação em Spring Boot. Aguarde até que a aplicação esteja totalmente inicializada.

---

## Documentação e Acesso

- **Swagger UI**: Acesse a interface interativa da API no seguinte link: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).

- **Coleção Postman**: Utilize a coleção disponível em [`docs/AYFood.postman_collection.json`](./docs/AYFood.postman_collection.json) para facilitar o uso e a validação das APIs.

- **Event Storming**: Consulte o arquivo [`docs/event_storm.pdf`](./docs/event_storm.pdf) para uma visão detalhada do processo de *Event Storming* utilizado no projeto.

    - **Miro**: Explore o quadro colaborativo no Miro para mais detalhes: [Event Storming no Miro](https://miro.com/app/board/uXjVLw047SM=/).

- **Descrição do Problema - Fase 1**: Consulte o documento [`docs/Pos_tech-Fase1.pdf`](./docs/Pos_tech-Fase1.pdf) para entender os requisitos e o contexto da fase inicial do projeto.

---

## Participantes

- **Alison Israel - RM358367**  
  *Discord*: @taykarus

- **Yan Gianini - RM358368**  
  *Discord*: @.gianini

---
