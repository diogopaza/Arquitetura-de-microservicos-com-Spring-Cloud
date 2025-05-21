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
<p>Uma das implementacoes desse design pattern e o Spring Config Server. Este possui diversos artefatos desde um diretororio no servidor ate repositorios Git, Amazon S3, banco de dados entre outros. Tambem poossui funcionalidades como reaproveitamento de properties entre aplicacoes e atulizacao de properties sem a necessidade de reiniciar o servico.</p>
