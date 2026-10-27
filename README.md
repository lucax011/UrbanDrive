# Urban Drive (Kotlin)

Versão Android nativa do **Urban Drive**, um app de aluguel de carros por hora ou por dia, sem fila nem papelada, direto pelo celular.

Versões e serviços relacionados:
- [api-carRental](https://github.com/lucax011/api-carRental): API em Node.js + MySQL que este app consome
- [urbandrive_dart](https://github.com/lucax011/urbandrive_dart): versão em Flutter, com o mapa de carros próximos

## O que tem hoje

- Tela de login e de cadastro integradas à API com Retrofit
- `UserViewModel` com a lógica de autenticação
- Tela principal

## Stack

- Kotlin, Android SDK 34 (mínimo 24)
- Retrofit 2 + Gson + RxJava 3
- Room (dependência configurada)

## Como rodar

Pré-requisitos: Android Studio e a [api-carRental](https://github.com/lucax011/api-carRental) rodando na porta 3000.

1. Abra a pasta do projeto no Android Studio e aguarde o Gradle sincronizar.
2. Rode em um emulador. O app acessa a API em `http://10.0.2.2:3000/` (`data/ApiService.kt`).

## Estrutura

```
app/src/main/java/com/example/urbandrive/
  LoginActivity.kt, RegisterActivity.kt, MainActivity.kt
  data/   ApiService (Retrofit), LoginRequest, User
  ui/     UserViewModel
```
