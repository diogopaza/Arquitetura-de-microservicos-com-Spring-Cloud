# Arquitetura-de-microservicos-com-Spring-Cloud


# 🚀 Plano de Evolução Progressiva para Microsserviços — Com Roteiro de Testes Práticos

## 🏗️ Fase 1 — Arquitetura Básica Funcional (Fundação)

### ✅ O que implementar:
- Config Server
- Eureka Server
- Gateway
- Microsserviço de Pedidos (`pedido-service`) com arquitetura em camadas (`controller → service → repository`).

### 🧪 Roteiro de Testes:

#### 🔗 Teste 1 — Eureka funcionando
- Acesse `http://localhost:8761`
- **Esperado:** Veja o `pedido-service`, `gateway` e `config-server` registrados.

#### 🔧 Teste 2 — Gateway funcionando
- No Postman ou navegador:
```
GET http://localhost:8080/pedido-service/actuator/health
```
- **Esperado:** `{ "status": "UP" }`

#### 🗂️ Teste 3 — Configuração centralizada
- Pare o `Config Server` e suba o `pedido-service`.
- **Esperado:** O `pedido-service` não sobe, erro relacionado a `Config Server not available`.

#### 🔨 Teste 4 — CRUD básico do pedido
- No Postman:
```
POST http://localhost:8080/pedido-service/api/pedidos
Body:
{
  "descricao": "Teste de pedido",
  "valor": 120.0
}
```
- **Esperado:** Código 201 Created, e resposta com o objeto salvo (ID preenchido).
- Valide com:
```
GET http://localhost:8080/pedido-service/api/pedidos
```
- **Esperado:** Lista com seu pedido criado.

---

## 🔄 Fase 2 — Comunicação entre Microsserviços

### ✅ O que implementar:
- Microsserviço de Pagamentos (**REST — síncrono**)
- Microsserviço de Emails (**RabbitMQ — assíncrono**)
- RabbitMQ configurado

### 🧪 Roteiro de Testes:

#### 🔗 Teste 1 — Comunicação síncrona Pedido ↔️ Pagamento
- No Postman:
```
POST http://localhost:8080/pedido-service/api/pedidos/1/pagar
```
- **Esperado:** Pedido atualizado como `PAGO`. Verifique logs do `pagamento-service`.

#### 📨 Teste 2 — Comunicação assíncrona Pedido → Email via RabbitMQ
- Ao criar um pedido:
```
POST http://localhost:8080/pedido-service/api/pedidos
```
- **Esperado:** No log do email-service: `[EMAIL] Enviando email de confirmação para pedido ID: X`.
- Verifique no RabbitMQ Management (`http://localhost:15672`) se as filas estão processando.

---

## 🔗 Fase 3 — Resiliência e Observabilidade

### ✅ O que implementar:
- Circuit Breaker com Resilience4j
- Retry, Timeout e Fallback
- Monitoramento com Actuator, Prometheus e Zipkin

### 🧪 Roteiro de Testes:

#### ⚠️ Teste 1 — Circuit Breaker
- Desligue o `pagamento-service`.
- No Postman:
```
POST http://localhost:8080/pedido-service/api/pedidos/1/pagar
```
- **Esperado:** Retorno com fallback informando indisponibilidade do pagamento.

#### 🔁 Teste 2 — Retry + Timeout
- Simule lentidão no pagamento-service.
- Verifique nos logs do pedido-service os retries e timeout.

#### 🔎 Teste 3 — Traceabilidade
- Gere uma requisição e acompanhe o trace no Zipkin (`http://localhost:9411`).

---

## 🧠 Fase 4 — Arquitetura Hexagonal

### ✅ O que implementar:
- Refatoração para arquitetura Hexagonal
- Criação dos módulos: Domain, Application, Adapters

### 🧪 Roteiro de Testes:

#### ✅ Teste 1 — Validação funcional após refatoração
- Execute os mesmos testes de CRUD da Fase 1 e integração da Fase 2.

#### 🧠 Teste 2 — Teste Unitário orientado a domínio
```java
Pedido pedido = new Pedido();
pedido.marcarComoPago();
assertTrue(pedido.isPago());
```

---

## 🔒 Fase 5 — Segurança

### ✅ O que implementar:
- JWT
- Spring Security no Gateway e nos serviços

### 🧪 Roteiro de Testes:

#### 🔑 Teste 1 — Obter Token
```
POST http://localhost:8080/auth/login
Body:
{
  "username": "admin",
  "password": "123"
}
```
- **Esperado:** Retorno com JWT.

#### 🔐 Teste 2 — Acesso protegido
- Sem token → 401 Unauthorized
- Com token → Acesso permitido

---

## 🚀 Fase 6 — CI/CD e Deploy

### ✅ O que implementar:
- Pipelines no GitHub Actions
- Docker Compose
- Kubernetes

### 🧪 Roteiro de Testes:

#### 🔧 Teste 1 — Build automático no push

#### 🐳 Teste 2 — Docker Compose
```
docker-compose up
```

#### ☸️ Teste 3 — Kubernetes
```
kubectl get pods
kubectl get services
```

---

## 🌐 Fase 7 — Cloud e Escalabilidade

### 🧪 Roteiro de Testes:

#### 🔥 Teste 1 — Alta disponibilidade
```
kubectl scale deployment pedido-service --replicas=3
```

#### ☁️ Teste 2 — Failover cloud

---

## ✅ Checklist de Validação

| Fase | CRUD | Comunicação | Rabbit | Resiliência | Hexagonal | Segurança | CI/CD | Cloud |
|------|------|-------------|--------|-------------|-----------|-----------|-------|-------|
| 1    | 🔥   |             |        |             |           |           |       |       |
| 2    | 🔥   | 🔥           | 🔥      |             |           |           |       |       |
| 3    | 🔥   | 🔥           | 🔥      | 🔥           |           |           |       |       |
| 4    | 🔥   | 🔥           | 🔥      | 🔥           | 🔥         |           |       |       |
| 5    | 🔥   | 🔥           | 🔥      | 🔥           | 🔥         | 🔥         |       |       |
| 6    | 🔥   | 🔥           | 🔥      | 🔥           | 🔥         | 🔥         | 🔥     |       |
| 7    | 🔥   | 🔥           | 🔥      | 🔥           | 🔥         | 🔥         | 🔥     | 🔥     |

---

> Desenvolvido com 💙 para estudos e prática de microsserviços.

------------------------------------------------

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

