# Lab06 — Exceções, Interfaces e Polimorfismo

## Ambiente de desenvolvimento

Evidências recolhidas neste portátil:

```bash
$ javac -version
javac 11.0.25

$ java -version
openjdk version "11.0.25" 2024-10-15 LTS
OpenJDK Runtime Environment Corretto-11.0.25.9.1 (build 11.0.25+9-LTS)
OpenJDK 64-Bit Server VM Corretto-11.0.25.9.1 (build 11.0.25+9-LTS, mixed mode)
```

## Descrição

Sistema bancário em linha de comandos que demonstra hierarquia de exceções (checked/unchecked), interface `ContaBancaria`, classe abstrata com validações, implementações concretas (`ContaCorrente`, `ContaPoupanca`), serviço `Banco` com arrays polimórficos e tratamento robusto de erros no menu principal. Inclui utilitário de I/O resiliente para impedir `NumberFormatException`.

## Estrutura essencial

```
lab06/
  ├─ src/main/java/pt/escnaval/exercicios/
  │   ├─ exceptions/ (hierarquia customizada)
  │   ├─ modelo/ (interface + abstrata + concretas)
  │   ├─ servicos/ (gestão de contas)
  │   ├─ utils/ (leitura robusta)
  │   └─ MenuBanco.java (CLI)
  ├─ out/ (classes compiladas)
  └─ .gitignore, README.md
```

## Compilar e executar

```bash
cd lab06
javac -encoding UTF-8 -d out $(find src/main/java -name "*.java")
java -cp out pt.escnaval.exercicios.MenuBanco
```

## Casos de teste manuais

| # | Caso | Passos / Entrada | Resultado observado | Conceito validado |
|---|------|------------------|---------------------|-------------------|
| 1 | Criar conta corrente válida | Opções `2 → PT01-1234-12345678, Ana, 1000, 500` | Conta criada com sucesso | Validação construtor + arrays |
| 2 | Número inválido | `2 → ABC, Ana, 1000, 500` | `ContaInvalidaException` no construtor | Exceção unchecked para invariante |
| 3 | Titular vazio | `3 → PT02-2222-11111111, ""` | `ContaInvalidaException` | Validação de argumentos |
| 4 | Depósito válido | `4 → PT01-1234-12345678, 250` | Saldo atualizado, mensagem de sucesso | Exceção checked tratada (OK) |
| 5 | Depósito negativo | `4 → PT01-1234-12345678, -10` | `ContaBancariaException` capturada | Validação `depositar` |
| 6 | Levantamento CC com saldo suficiente | `5 → PT01-1234-12345678, 300` | Operação concluída | Polimorfismo ContaCorrente |
| 7 | Levantamento CC excede descoberto | `5 → PT01-1234-12345678, 9999` | `SaldoInsuficienteException` | Tratamento específico |
| 8 | Levantamento Poupança maior que limite | `5 → PT02-2222-11111111, 600` | `OperacaoNaoPermitidaException` | Regra de negócio unchecked |
| 9 | Levantamento Poupança saldo insuficiente | `5 → PT02-2222-11111111, 2000` | `SaldoInsuficienteException` | Checked propagada |
| 10 | Estatísticas e contas em descoberto | Opção `8` após operações | Mostra total e contas negativas | Arrays + agregações |

> Todos os cenários foram executados no CLI após compilar; as exceções aparecem com mensagens descritivas e o loop principal mantém-se operacional.
