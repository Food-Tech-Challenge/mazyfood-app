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

O **AYFood** é uma aplicação desenvolvida em **Spring Boot**, seguindo o padrão de **Arquitetura Hexagonal** para
garantir maior desacoplamento e facilidade de manutenção. Além da API em Spring Boot, o projeto utiliza o banco de dados
**PostgreSQL**. Este projeto tem como objetivo oferecer uma base sólida para estudos e aplicação prática de conceitos
avançados em arquitetura de software.

---

## Tecnologias Utilizadas

- **Java** (Spring Boot): Framework para construção de aplicações robustas e escaláveis.
- **Docker**: Ferramenta de containerização para garantir a portabilidade e consistência do ambiente.
- **PostgreSQL**: Banco de dados relacional utilizado para persistência de dados.
- **Arquitetura Hexagonal**: Padrão arquitetural focado em modularidade e independência de tecnologias externas.
- **Swagger/OpenAPI**: Ferramenta para documentação interativa e testes das APIs.
- **Minikube**: Ferramenta para executar clusters Kubernetes localmente.
- **Helm**: Gerenciador de pacotes para Kubernetes.

---

## Pré-requisitos

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas em seu ambiente:

- **Docker**: Para construir as imagens da aplicação.
- **Git**: Para clonar o repositório.
- **Minikube**: Para executar clusters Kubernetes localmente.
- **Kubectl**: Para gerenciar os recursos do cluster Kubernetes.
- **Helm**: Para gerenciar os pacotes Kubernetes.

---

## Como Executar Localmente

Siga os passos abaixo para configurar e executar o projeto em seu ambiente local:

1. **Clonar o repositório**
   ```bash
   git clone git@github.com:YanGianini/AYFood.git
   cd AYFood
   ```

2. **Rodar o banco de dados com Docker Compose**
   ```bash
   docker compose up
   ```

3. **Configurar e rodar a aplicação com Minikube**
    - **Iniciar o Minikube**:
      ```bash
      minikube start
      ```

    - **Habilitar o Minikube no Docker**:
      ```bash
      eval $(minikube docker-env)
      ```

    - **Habilitar o registro de imagens no Minikube**:
      ```bash
      minikube addons enable registry
      ```

    - **Construir e enviar a imagem para o registro do Minikube**:
      ```bash
      docker image build -t localhost:5000/ayfood:latest .
      docker image push localhost:5000/ayfood:latest
      ```

    - **Deploy com Helm**:
      ```bash
      helm upgrade --install ayfood helm/
      ```

4. **Obter o IP e porta do serviço**
    - **Encontrar o IP do Minikube**:
      ```bash
      minikube ip
      ```
    - **Encontrar a porta do NodePort do serviço**:
      ```bash
      kubectl get svc ayfood-service -o wide
      ```

5. **Acessar os endpoints da aplicação**
   Utilize os valores obtidos para configurar a variável `BASE_URL` na coleção Postman disponível no projeto. Isso
   permitirá acessar e testar os endpoints da aplicação corretamente.

---

## Documentação e Acesso

- **Swagger UI**: Acesse a interface interativa da API no seguinte
  link: [http://<minikube-ip>:<node-port>/swagger-ui/index.html](http://<minikube-ip>:<node-port>/swagger-ui/index.html).

- **Coleção Postman**: Utilize a coleção disponível em [
  `docs/AYFood.postman_collection.json`](./docs/AYFood.postman_collection.json) para facilitar o uso e a validação das
  APIs. Atualize a variável `BASE_URL` na coleção com o endereço obtido no Minikube.

- **Event Storming**: Consulte o arquivo [`docs/event_storm.pdf`](./docs/event_storm.pdf) para uma visão detalhada do
  processo de *Event Storming* utilizado no projeto.

    - **Miro**: Explore o quadro colaborativo no Miro para mais
      detalhes: [Event Storming no Miro](https://miro.com/app/board/uXjVLw047SM=/).

- **Descrição do Problema**: Consulte os documentos para entender os requisitos e o contexto do projeto.
  - Fase 1: [`docs/Pos_tech-Fase1.pdf`](./docs/Pos_tech-Fase1.pdf)
  - Fase 2: [`docs/Pos_tech-Fase2.pdf`](./docs/Pos_tech-Fase2.pdf)

- **Documentações e Diagramas - Fase 2**: Consulte o documento [`docs/AYFood_Arquitetura.pdf`](./docs/AYFood_Arquitetura.pdf) para entender os requisitos e contexto da fase 2 do projeto (Kubernetes e Clean Archtecture) 

---

## Participantes

- **Alison Israel - RM358367**  
  *Discord*: @taykarus | E-mail: taykarus@gmail.com

- **Yan Gianini - RM358368**  
  *Discord*: @.gianini | E-mail: yangianini@gmail.com
