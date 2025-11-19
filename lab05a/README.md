# Lab05a - POO: Encapsulamento, Composicao, Heranca e Interfaces

## Ambiente de desenvolvimento

Evidencias recolhidas diretamente da linha de comando deste portatil:

```bash
$ javac -version
javac 11.0.25

$ java -version
openjdk version "11.0.25" 2024-10-15 LTS
OpenJDK Runtime Environment Corretto-11.0.25.9.1 (build 11.0.25+9-LTS)
OpenJDK 64-Bit Server VM Corretto-11.0.25.9.1 (build 11.0.25+9-LTS, mixed mode)
```

## Estrutura essencial

```
lab05a/
   src/main/java/pt/escnaval/exercicios/
      *.java (dominio, demos e interfaces)
   out/ (artefactos de compilacao)
   .gitignore, README.md
```

## Compilar e executar

```bash
cd lab05a
javac -d out src/main/java/pt/escnaval/exercicios/*.java

java -cp out pt.escnaval.exercicios.MainDemo
java -cp out pt.escnaval.exercicios.DemoIdentidade
java -cp out pt.escnaval.exercicios.DemoArmadilhas
java -cp out pt.escnaval.exercicios.DemoOrdenacao
java -cp out pt.escnaval.exercicios.DemoHerancaInterface
```

## Tabela de testes manuais

| # | Caso | Passos / Entrada | Resultado esperado |
|---|------|------------------|--------------------|
| 1 | Endereco valido | `new Endereco("Rua", "Lisboa", "1000")` | `isValido()` retorna `true` e `toString()` legivel |
| 2 | Endereco invalido | parametros vazios | `isValido()` `false`, `toString()` `[Endereco invalido]` |
| 3 | Cliente valido | `new Cliente(1, nome, email, endereco, senha)` | `isValido()` `true` |
| 4 | Cliente invalido (email) | email sem `@` | `isValido()` `false` |
| 5 | Cliente invalido (id <= 0) | `id = 0` | `isValido()` `false` |
| 6 | `mudarEmail` valido | e-mail com formato correto | retorna `true` |
| 7 | `mudarEmail` invalido | texto sem dominio | retorna `false` |
| 8 | `mudarEndereco` valido | endereco valido | retorna `true` |
| 9 | `mudarEndereco` invalido | endereco invalido | retorna `false` |
| 10 | Autenticavel (senha correta) | `cliente.autenticar("senha")` | retorna `true` |
| 11 | Autenticavel (senha errada) | senha incorreta | retorna `false` |
| 12 | IBAN valido | `new Iban("PT5...")` | `isValid()` `true`, `toString()` devolve codigo |
| 13 | IBAN invalido | string curta | `isValid()` `false`, `toString()` `INVALID` |
| 14 | Conta valida | saldo inicial `>=0` | `isValida()` `true` |
| 15 | Conta invalida | saldo inicial `<0` | `isValida()` `false` |
| 16 | Deposito positivo | `conta.depositar(25)` | retorna `true`, saldo aumenta |
| 17 | Deposito invalido | valor `<=0` | retorna `false` |
| 18 | Levantamento valido | valor `<= saldo` | retorna `true`, saldo diminui |
| 19 | Levantamento invalido | valor `> saldo` | retorna `false` |
| 20 | Transferencia simples | `a1.transferirPara(a2, 30)` | ambos saldos ajustados, retorna `true` |
| 21 | Transferencia invalida | saldo insuficiente | retorna `false` sem alterar saldos |
| 22 | Banco abre conta | `banco.abrirConta(conta)` | `true`, `getNumContas()` incrementa |
| 23 | Banco rejeita duplicada | mesma conta por IBAN | `false`, tamanho mantem |
| 24 | Banco fecha conta | `banco.fecharConta(iban)` | `true`, array compaction |
| 25 | Banco procura conta | `banco.findByIban(iban)` | retorna referencia ou `null` |
| 26 | ContaOrdem descoberto | levantar dentro do limite | `true`, saldo pode ficar negativo |
| 27 | ContaOrdem alem do limite | levantar excedendo limite | `false` |
| 28 | ContaPoupanca calcular juros | saldo positivo | retorna valor proporcional a taxa |
| 29 | ContaPoupanca aplicar juros | saldo positivo | saldo aumenta |
| 30 | Ordenacao por nome | `DemoOrdenacao` | saida mostra array ordenado + buscas |
| 31 | DemoIdentidade clientes | dois clientes com mesmo id | `equals` `true` mesmo com enderecos distintos |
| 32 | DemoIdentidade contas | duas contas mesmo IBAN | `equals` `true` apesar do saldo |
| 33 | DemoArmadilhas `SemHash` | equals `true`, hash diferente | imprime violacao do contrato |
| 34 | Interface Autenticavel | `DemoHerancaInterface` | casting para `Autenticavel` funciona |
| 35 | Polimorfismo Conta[] | array com `Conta`, `ContaOrdem`, `ContaPoupanca` | `toString()` resolve dinamicamente |
| 36 | Casting especifico | `instanceof` em `DemoHerancaInterface` | acesso seguro a metodos extras |
| 37 | README comandos | executar sequencia `javac`+`java` | demos correm sem excecoes |
| 38 | Arrays sem colecoes | `Banco` e `DemoOrdenacao` | mostram manipulacao manual de arrays |
| 39 | Identidade preservada | `conta.equals(novaContaMesmoIban)` | `true`, mesmo saldo distinto |
| 40 | Interface vs implementacao | `Autenticavel auth = cliente` | metodos expostos apenas pelo contrato |

## Notas de design

- Objetos de valor (`Endereco`, `Iban`) sao finais, imutaveis e com `equals/hashCode` por conteudo.
- Entidades (`Cliente`, `Conta`) possuem identidade estavel (id ou IBAN) e podem mudar estado mantendo invariantes.
- Construtores nao lancam excecoes; objetos invalidos sao sinalizados por `isValido()`/`isValid()` e metodos de negocio retornam `boolean`.
- Arrays substituem colecoes: `Banco` faz expansao manual e copias defensivas; `DemoOrdenacao` implementa ordenacao/busca.
- Heranca apenas quando ha relacao legitima "e-um" (`ContaOrdem`, `ContaPoupanca` estendem `Conta`). Composicao usada para tem-um.
- Interface `Autenticavel` abstrai autenticacao, permitindo polimorfismo entre clientes e potenciais futuros atores.
- `toString()` amigaveis ajudam a depurar cenarios e acompanhar operacoes nas demos.
- README centraliza comandos, evidencias de ambiente e cenarios cobrindo heranca, interfaces, arrays, invariantes e identidade.
