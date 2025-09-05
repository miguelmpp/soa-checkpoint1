````markdown
# WinerySys - API SOAP

## Descrição

Este repositório contém a implementação de uma API SOAP desenvolvida no contexto da disciplina de Arquitetura Orientada a Serviços (SOA) e Web Services.
O projeto abrange tanto a parte de publicação do serviço (Server) quanto o consumo do serviço (Client), com a criação de serviços genéricos, como
"WineStockService" e "WineWarningService".
A API foi desenvolvida utilizando a linguagem Java 17 e o framework Maven para gerenciamento de dependências e automação de builds.

## Objetivo

O objetivo deste checkpoint foi aplicar os conceitos iniciais de Arquitetura Orientada a Serviços (SOA) e desenvolvimento de APIs SOAP,
criando serviços para o gerenciamento de vinhos e de aviso de estoque, permitindo tanto a publicação como o consumo desses serviços.

## Estrutura do Projeto

O repositório é dividido em duas principais pastas:

- `Publisher`: Contém o serviço de publicação (lado servidor).
- `Consumer`: Contém os clientes que consomem os serviços SOAP.

### Publicação do Serviço (Server)

1. **WinerySys**: Implementa a interface `WineStockService` e publica o serviço SOAP em `http://localhost:8085/WineStockService`.
2. **WineStockService**: Serviço de gerenciamento de vinhos, com métodos para obter o menu de vinhos e realizar pedidos.
3. **WineWarningService**: Serviço de aviso de estoque insuficiente, que avisa quando o estoque de vinhos está abaixo do esperado.

### Consumo do Serviço (Client)

1. **WineStockClient**: Cliente que consome o serviço `WineStockService` e imprime o menu de vinhos no console.
2. **WineOrderClient**: Cliente que consome o serviço `WineStockService` e realiza um pedido, imprimindo a confirmação no console.
3. **WineWarningClient**: Cliente que consome o serviço `WineWarningService` e imprime o aviso de estoque insuficiente no console.

## Como Rodar o Projeto

### Pré-requisitos

1. **Java 17 ou superior**: Necessário para compilar e executar o código.
2. **Maven**: Utilizado para o gerenciamento de dependências e builds do projeto.

### Passo a Passo

#### 1. Clone este repositório

```bash
git clone https://github.com/SEU_USUARIO/WinerySys.git
cd WinerySys
````

#### 2. Gere as fontes do projeto

Antes de compilar o projeto, gere as fontes utilizando o comando Maven abaixo. O `-q` garante que o processo seja realizado de forma silenciosa:

```bash
mvn -q clean generate-sources
```

#### 3. Publique o serviço

* Navegue até a pasta `Publisher/WinerySys`.
* Execute a classe `Loader` para iniciar o serviço SOAP do `WineStockService` em `http://localhost:8085/WineStockService`.

```bash
cd Publisher/WinerySys
mvn clean install
mvn exec:java -Dexec.mainClass="br.com.fiap.winery.Loader"
```

#### 4. Consuma o serviço de estoque (WineStockClient)

* Navegue até a pasta `Consumer/WineStockClient`.
* Execute a classe `ApplicationClient1` para consumir o serviço `WineStockService` e obter o menu de vinhos.

```bash
cd Consumer/WineStockClient
mvn clean install
mvn exec:java -Dexec.mainClass="br.com.fiap.winery.ApplicationClient1"
```

#### 5. Consuma o serviço de pedidos (WineOrderClient)

* Navegue até a pasta `Consumer/WineOrderClient`.
* Execute a classe `ApplicationClient2` para consumir o serviço `WineStockService` e realizar um pedido.

```bash
cd Consumer/WineOrderClient
mvn clean install
mvn exec:java -Dexec.mainClass="br.com.fiap.winery.ApplicationClient2"
```

#### 6. Consuma o serviço de aviso de estoque (WineWarningClient)

* Navegue até a pasta `Consumer/WineOrderClient`.
* Execute a classe `ApplicationClient2` para consumir o serviço `WineWarningService` e obter o aviso de estoque insuficiente.

```bash
cd Consumer/WineOrderClient
mvn clean install
mvn exec:java -Dexec.mainClass="br.com.fiap.winery.ApplicationClient2"
```

## Descrição das Funcionalidades

### WineStockService

* **getMenu()**: Retorna uma lista de vinhos disponíveis.
* **placeOrder(String name, int quantity)**: Realiza um pedido de vinhos e retorna uma mensagem de confirmação.

### WineWarningService

* **sendWarn()**: Retorna um aviso de estoque insuficiente.

## Integrantes do Grupo

* **Integrante 1**: GABRIEL LEÃO – RM552642
* **Integrante 2**: VITOR PINHEIRO NASCIMENTO – RM553693
* **Integrante 3**: MIGUEL MAURICIO PARRADO PATARROYO – RM554007
* **Integrante 4**: MATHEUS FARIAS DE LIMA - RM554254

## Como Contribuir

Se você tiver sugestões de melhorias ou correções, fique à vontade para abrir uma *issue* ou enviar um *pull request*. Toda contribuição é bem-vinda!

## Licença

Este projeto está licenciado sob a Licença MIT - consulte o arquivo [LICENSE](LICENSE) para mais informações.

```
