# Arquitetura-de-microservicos-com-Spring-Cloud

# 🗺️ Plano de Evolução Progressiva para Microsserviços — Escalonado e Completo

Este roadmap tem como objetivo construir uma arquitetura de microsserviços robusta, escalável e alinhada com as melhores práticas do mercado, utilizando o ecossistema **Spring Cloud**. O plano é dividido em etapas crescentes, começando de um projeto simples até uma solução corporativa completa.

---

## 🔥 Fase 1 — Infraestrutura Base

- ✅ **Config Server** (Configuração Centralizada)
- ✅ **Eureka Server** (Service Discovery)
- ✅ **Gateway API** (Roteamento e Balanceamento)
- ✅ **Primeiro microserviço:** `pedido-service`
  - Arquitetura inicial em **camadas (Controller, Service, Repository)**

---

## 🔗 Fase 2 — Comunicação entre Microsserviços

- ✅ **Feign Client** (Comunicação síncrona simplificada)
- ✅ **RabbitMQ** (Mensageria e comunicação assíncrona)
- ✅ Definir contratos básicos para interações síncronas e assíncronas

---

## 🏗️ Fase 3 — Evolução para Arquitetura Hexagonal

- 🔄 Refatoração dos microsserviços para o padrão **Ports and Adapters**
- 🔄 Separação clara entre:
  - **Domínio (Core):** entidades, regras e serviços de domínio
  - **Adapters de Entrada:** REST API, mensageria, etc.
  - **Adapters de Saída:** Banco de dados, clients Feign, filas, etc.

---

## 🔍 Fase 4 — Observabilidade e Resiliência

- 🔧 **Circuit Breaker:** Resilience4j
- 🔧 **Retry e Timeouts configuráveis**
- 🔧 **Distributed Tracing:** Spring Cloud Sleuth + Zipkin
- 🔧 **Monitoramento:** Prometheus + Grafana
- 🔧 **Health Check:** Actuator + endpoints

---

## 🔐 Fase 5 — Segurança

- 🛡️ **JWT no API Gateway**
- 🛡️ Segurança nos microsserviços com autenticação e autorização
- 🛡️ HTTPS / SSL
- 🛡️ Integração com **Keycloak** ou outro Identity Provider

---

## 🚀 Fase 6 — Deployment e Escalabilidade

- 🐳 **Docker:** Containerização dos serviços
- ☸️ **Kubernetes (K8s):** Orquestração e escalabilidade
- 🔄 **CI/CD:** GitHub Actions, GitLab CI, Jenkins ou outra ferramenta
- 🌍 Ambientes separados (**dev**, **staging**, **production**)

---

## ✅ Fase 7 — Testes Automatizados

- 🧪 **Testes Unitários:** JUnit + Mockito
- 🔗 **Testes de Integração:** Testcontainers
- 📜 **Testes de Contrato:** Spring Cloud Contract
- 🔄 **Testes End-to-End (E2E):** Postman/Newman, Selenium, Cypress ou outros

---

## 🚧 Próximos passos

> Cada fase será registrada neste repositório, com exemplos práticos, documentação, desafios e melhorias contínuas.

---

<h3>Servidor de configuracao - Config Server</h3>
<p>O servidor de configuracao e um padrao que busca a externalizacao das configuracoes das aplicacoes de modo que todas
ficam centralizadas em um determinado recurso da arquitetura.</p>
<p>Uma das implementacoes desse design pattern e o Spring Config Server. Este possui diversos artefatos desde um diretororio no servidor ate repositorios Git, Amazon S3, banco de dados entre outros. Tambem possui funcionalidades como reaproveitamento de properties entre aplicacoes e atualizacao de properties sem a necessidade de reiniciar o servico.</p>
<h4>Iniciando Spring Config Server</h4>
<p>Sao necessarias 3 dependencias para rodar o config server com Spring:
  <ul>
    <li>spring-cloud-config-server</li>
    <li>spring-boot-starter-actuator</li>
    <li>spring-cloud-dependencies</li>
  </ul>
<p>Proximo passo e necessario definir a anotacao <strong>@EnableConfigServer</strong> na classe principal do projeto do projeto Spring</p>
<p>Seguindo no application.properties sera definida as configuracoes de acesso ao repositorio GIT:
  <p align="center">
  <img src="images/application-01.png" width="500" alt="Logo do projeto">
</p>
  Importante notar que usuario e senha estao sendo passados via variaveis de ambiente para nao expormos nosso usuario e senha no repositorio.
</p>
</p>

<h3>Padrao Arquitetura - Service Discovery</h3>
<p>Uma das implementacoes desse padrao e o Spring Cloud Eureka Server. O primeiro passo e baixar a dependencia abaixo e habilitar a anotacao 
  <strong>@EnableEurekaServer</strong> na classe principal do projeto.:
   <ul>
    <li>spring-cloud-starter-netflix-eureka-server</li>
   
  </ul>
  <p>O Eureka Server e o responsavel por registrar os microservicos de dominio (pedidos, pagamentos, emails). Dessa forma nao e preciso saber em qual porta cada microservico inicializou e nem quantas instancias desse microservicos esta rodando.</p>

</p>

<h4>Microservicos para teste do projeto</h4>
<p>O primeiro microsservico sera o de pedido, alem desse teremos o de pagamentos usando comunicacao sincrona e o de emails usando comunicacao assincrona.</p>
<p>Inicialmente o microservico pedidiso ira implementar uma arquitetura baseada em camadas para iniciar o projeto e depois sera refatorado para a arquitetura hexagonal.</p>

