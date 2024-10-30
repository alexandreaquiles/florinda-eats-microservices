# florinda-eats-microservices

Florinda Eats é uma aplicação de entrega de comida para o restaurante da Dona Florinda.

É uma Arquitetura de Microservices composta pelos seguintes serviços:

- **Pedidos**, que tem informações do cardápio e dos pedidos realizados. Roda na porta 8080
- **Pagamentos**, que permite a confirmação de um pagamento. Roda na porta 8081
- **Nota Fiscal**, que gera XMLs de notas fiscais na saída padrão. Roda na porta 8082
- **Signer**, que gera um hash MD5 do pagamento na saída padrão. Roda na porta 8083

# O que você precisa fazer?

## Executar o Kafka

O arquivo `docker-compose.yml` contém uma configuração de Kafka cuja porta para conexões externas ao container é `9094`.

Para executar o Kafka, abra um Terminal e rode na raiz do projeto:

```sh
docker compose up
```

Espera um tiquinho que o Kafka deve subir.

Criar o tópico

## Executar o serviço de Pagamento

Abra a código do serviço de pagamentos no IntelliJ.

Execute o serviço através do IntelliJ, utilizando _Maven_ > _Plugins_ > _Quarkus_ > `quarkus:dev`.

Abra o Postman, e confirme um pagamento realizando um `PUT http://localhost:8081/pagamentos/1`.

Ao confirmar um pagamento, o serviço de pagamento produz um evento `PagamentoConfirmado` para o tópico `pagamentosConfirmados` do Kafka.

## Executar o serviço de Pedidos

Abra a código do serviço de pedidos no IntelliJ.

Execute o serviço através do IntelliJ, utilizando _Maven_ > _Plugins_ > _Quarkus_ > `quarkus:dev`.

Verifique a listagem de pedidos na URL `http://localhost:8080/pedidos`.

Detalhe um pedido (p. ex., o de id 1) com a URL `http://localhost:8080/pedidos/1`

## Executar o serviço Signer

Abra o código do Signer no IntelliJ.

O código está quase completo: 

- a extensão do Kafka está adicionada no `pom.xml`
- o endereço do broker já está configurado no `application.properties`
- já existe a classe `PagamentoConfirmadoEvent` com os devidos atributos
- já existe a classe `PagamentoConfirmadoConsumer` já invoca a classe `Hash` e imprime o resultado no console.

O que falta? Complete o código da classe `PagamentoConfirmadoConsumer`.

## Responda a pergunta do Quizz

Qual é o hash do pedido de Godinez?
