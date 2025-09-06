# Checkpoint 1 – Arquitetura SOA e Web Services (SOAP)

Este repositório apresenta o desenvolvimento do **Checkpoint 1** da disciplina **Arquitetura SOA e Web Services**, do curso de **Engenharia de Software** da FIAP.  

O objetivo da atividade foi aplicar, de maneira prática, os conceitos iniciais de **Arquitetura Orientada a Serviços (SOA)**, por meio da implementação de **APIs SOAP** utilizando a linguagem **Java (versão 17)** em conjunto com o **Maven** como gerenciador de dependências.  

No decorrer do trabalho foram elaborados dois módulos principais:

- **Publisher (WinerySys):** responsável pela publicação de dois serviços SOAP:
  - `WineStockService`: retorna um cardápio de vinhos (`getMenu`) e possibilita a realização de pedidos (`placeOrder`);
  - `WineWarningService`: emite avisos de alerta (`sendWarn`) em situações de estoque insuficiente.

- **Consumer (WineStockClient):** responsável por realizar o consumo dos serviços publicados, demonstrando a interação entre cliente e servidor em uma arquitetura baseada em serviços.

Este checkpoint teve como propósito consolidar os conhecimentos relacionados à criação, publicação e consumo de serviços SOAP, promovendo a integração entre conceitos teóricos e a prática de programação orientada a serviços.

## Integrantes do Grupo

- GABRIEL LEÃO – RM552642
- VITOR PINHEIRO NASCIMENTO – RM553693
- MIGUEL MAURICIO PARRADO PATARROYO – RM554007
- MATHEUS FARIAS DE LIMA – RM554254

**Disciplina:** Arquitetura SOA e Web Services  
**Professor:** Carlos Eduardo Machado de Oliveira  
**Curso:** Engenharia de Software – 5º semestre 

## Tecnologias Utilizadas

- **Java 17** – Linguagem de programação  
- **Maven** – Gerenciador de dependências e build  
- **JAX-WS (jaxws-rt)** – Implementação do SOAP em Java  
- **JAX-WS Maven Plugin (wsimport)** – Geração automática de stubs a partir do WSDL  
- **IntelliJ IDEA** – IDE utilizada para desenvolvimento  
- **Git/GitHub** – Controle de versão e repositório do projeto

## 📂 Estrutura do Repositório

A organização do repositório foi definida em duas pastas principais, separando a **publicação** e o **consumo** dos serviços SOAP:

```bash
soa-checkpoint/
├── Publisher/                 # Projeto responsável pela publicação dos serviços SOAP
│   ├── pom.xml
│   └── src/
│       └── main/java/br/com/fiap/winery/
│           ├── Loader.java
│           ├── WineStockService.java
│           ├── WineStockServiceImplementation.java
│           ├── WineWarningService.java
│           └── WineWarningServiceImplementation.java
│
├── Consumer/                  # Projeto responsável pelo consumo dos serviços publicados
│   ├── pom.xml
│   └── src/
│       └── main/java/br/com/fiap/winery/
│           ├── ApplicationClient1.java   # Consome getMenu()
│           ├── ApplicationClient2.java   # Consome placeOrder()
│           └── ApplicationClient3.java   # Consome sendWarn()
│
└── README.md
```

Essa estrutura facilita a compreensão do projeto, separando de forma clara:
- O **Publisher**: onde os serviços SOAP são criados e publicados.  
- O **Consumer**: onde os serviços publicados são consumidos e testados.

## Como Executar

### Pré-requisitos
- **Java 17** instalado e configurado no PATH  
- **Maven** instalado  
- **IntelliJ IDEA** (ou outra IDE compatível com Maven)  
- Conexão com a internet para download das dependências  

---

### 1. Executar o Publisher (WinerySys)
1. Abra o projeto **Publisher** no IntelliJ (ou terminal).  
2. Rode o comando Maven para compilar:  
   ```bash
   mvn clean install
Localize a classe Loader.java e execute-a.

Se tudo estiver correto, o console exibirá:

less
Copiar código
✅ Serviço publicado em: http://localhost:8085/WineStockService
✅ Serviço publicado em: http://localhost:8086/WineWarningService
É possível validar acessando os arquivos WSDL no navegador:

http://localhost:8085/WineStockService?wsdl

http://localhost:8086/WineWarningService?wsdl

2. Executar o Consumer (WineStockClient)
Abra o projeto Consumer no IntelliJ (ou terminal).

Antes da primeira execução, gere as classes de consumo a partir dos WSDLs com:

mvn clean generate-sources
Observação: este comando deve ser repetido se houver alterações nos serviços publicados.

Rode as classes de cliente:

ApplicationClient1 → executa o método getMenu()

ApplicationClient2 → executa o método placeOrder()

ApplicationClient3 → executa o método sendWarn()

Cada cliente exibirá a resposta correspondente no console.

Observações importantes
Se as portas 8085 ou 8086 estiverem ocupadas, altere os valores no Loader.java antes de rodar.

Certifique-se de que o Publisher esteja rodando antes de executar qualquer cliente.

## Testes e Exemplos de Saída

### 6.1. Validação dos WSDLs (Publisher)
- `WineStockService` — `http://localhost:8085/WineStockService?wsdl`
- `WineWarningService` — `http://localhost:8086/WineWarningService?wsdl`

> Ambos os WSDLs foram acessados em navegador e validados antes da geração dos stubs.

---

### 6.2. Client 1 — `getMenu()`
Classe: `ApplicationClient1`

**Saída esperada:**
Resposta do getMenu():
🍷 Cardápio (por uva)

Cabernet Sauvignon

Merlot

Syrah

Chardonnay

---

### 6.3. Client 2 — `placeOrder()`
Classe: `ApplicationClient2`

**Saída esperada:**
Resposta do placeOrder():
Pedido confirmado! 3x Merlot. Obrigado.

---

### 6.4. Client 3 — `sendWarn()`
Classe: `ApplicationClient3`

**Saída esperada:**
Resposta do sendWarn(): Estoque insuficiente!

---

### 6.5. Geração de Stubs (Consumer)
Comando utilizado antes da primeira execução:
```bash
mvn clean generate-sources
```

## Problemas Comuns e Soluções

Durante o desenvolvimento e execução do projeto, alguns problemas foram identificados e solucionados:

### 1. Dependências do JAX-WS não localizadas
- **Sintoma:** Erro `Provider com.sun.xml.ws.spi.ProviderImpl not found` ao rodar o `Loader`.
- **Causa:** Dependências incompletas no `pom.xml`.
- **Solução:** Ajustar o `pom.xml` para utilizar o **jaxws-rt** em conjunto com o **jaxws-ri-bom**, garantindo que todas as bibliotecas necessárias sejam baixadas.

---

### 2. Porta em uso (8085 ou 8086)
- **Sintoma:** Erro ao publicar o serviço no `Loader`.
- **Causa:** A porta já estava ocupada por outro processo no computador.
- **Solução:** Alterar a porta no `Loader.java` (ex.: 8095/8096) e atualizar a URL correspondente no cliente.

---

### 3. Stubs não encontrados no Consumer
- **Sintoma:** Erro `cannot find symbol WineStockService` ao compilar o cliente.
- **Causa:** As classes geradas pelo `wsimport` não foram incluídas no classpath.
- **Solução:** Rodar o comando:
  ```bash
  mvn clean generate-sources
```


