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
![image](https://github.com/user-attachments/assets/6198d378-eeb5-484e-add9-d1b1a275ff67)
  Importante notar que usuario e senha estao sendo passados via variaveis de ambiente para nao expormos nosso usuario e senha no repositorio.
</p>

</p>
