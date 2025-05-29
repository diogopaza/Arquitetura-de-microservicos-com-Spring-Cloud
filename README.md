# Arquitetura-de-microservicos-com-Spring-Cloud

<p>Este repositorio ter por objetivo criar um projeto para usar ferramentas do ecossistema Spring Cloud:
<ul>
  <li>Eureka: descoberta de servicos</li>
  <li>Spring Cloud Config: configuracao centralizada</li>
  <li>Circuit Breaker (fallback e etc) e Resiliencia</li>
  <li>Gateway (com LoadBalancer)</li>
  <li>RabbitMQ</li>
  
</ul>

</p>
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

</p>

<h4>Microservicos para teste do projeto</h4>
<p>O primeiro microsservico sera o de pedido, alem desse teremos o de pagamentos usando comunicacao sincrona e o de emails usando comunicacao assincrona.</p>

