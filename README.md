
# Demos AWS

Implementações de serviços AWS utilizando a AWS SDK for Java V2


## Localstack e scripts

Necessário baixar e iniciar o localstack localmente   
Docker e Localstack são pré-requisitos para que o exemplo funcione

No arquivo docker-compose.yml, alterar conforme abaixo:
```
DE
- "${PORT_WEB_UI-8080}
PARA
- "${PORT_WEB_UI-8081}
```
Também incluir quais serviços irá utilizar:
```
- SERVICES=secretsmanager
```
#### Com o serviço no ar A.K.A docker-compose up
Criação de Secret via console
```
 aws --endpoint http://localhost:4566 secretsmanager create-secret --name token-key --description "Chave do token" --secret-string "s3cr3t" --region sa-east-1
```
Atualização de Secret via console
```
aws --endpoint http://localhost:4566 secretsmanager update-secret --secret-id token-key --secret-string "n3w s3cr3t" --region sa-east-1
```

## Run Locally

Clone the project

```bash
  git clone https://github.com/felipejsm/demosaws.git
```

Go to the project directory

```bash
  cd demosaws
```

Install dependencies

```bash
  mvn clean install
```

Start the server

```bash
  mvn spring-boot:run
```

Access through browser
```bash
  http://localhost:8080/v1/secrets
```