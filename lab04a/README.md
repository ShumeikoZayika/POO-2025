# Lab04a — Objetos de Domínio e Repositórios em Memória

Laboratório guiado sobre encapsulamento, invariantes e repositórios em memória em Java.

## Ambiente e ferramentas (alíneas a–c)
- `javac -version`
  ```
  javac 11.0.25
  ```
- `java -version`
  ```
  openjdk version "11.0.25" 2024-10-15 LTS
  OpenJDK Runtime Environment Corretto-11.0.25.9.1 (build 11.0.25+9-LTS)
  OpenJDK 64-Bit Server VM Corretto-11.0.25.9.1 (build 11.0.25+9-LTS, mixed mode)
  ```

## Estrutura
```
lab04a/
  ├─ src/main/java/pt/escnaval/exercicios/
  │    ├─ Aluno.java
  │    ├─ AlunoRepo.java
  │    ├─ MenuAlunos.java
  │    └─ UtilsIO.java
  ├─ out/
  ├─ README.md
  └─ .gitignore
```

## Execução (alínea h)
A partir da pasta `lab04a/`:

```bash
find src -name "*.java" -print0 | xargs -0 javac -d out
java -cp out pt.escnaval.exercicios.MenuAlunos
```

## Notas de design
- `Aluno` mantém invariantes (`id>0`, `nome` não vazio) através do construtor e `setNome`, e redefine `equals/hashCode` pelo identificador para garantir identidade lógica.
- `AlunoRepo` guarda os objetos numa lista interna, expõe operações CRUD e imprime listagens ordenadas sem alterar a ordem interna (cópias antes de ordenar).
- `MenuAlunos` separa I/O (Scanner + `UtilsIO`) da lógica do repositório via fluxos auxiliares para adicionar, remover, procurar e renomear.
- `UtilsIO` centraliza toda a leitura (`Scanner.nextLine()` + `Integer.parseInt`) garantindo validação uniforme e mensagens consistentes.

## Tabela de testes manuais
| # | Caso | Passos / Entrada | Saída esperada |
|---|------|------------------|----------------|
| 1 | Listar vazio | `1` | `(sem registos)` |
| 2 | Adição válida | `3 → id=1, nome=Ana` | `Adicionado.` |
| 3 | Duplicado | `3 → id=1, nome=Ana` | `Falha: ID já existente.` |
| 4 | Remover existente | `4 → id=1` | `Removido.` |
| 5 | Remover inexistente | `4 → id=2` | `ID não encontrado.` |
| 6 | Buscar existente | `5 → termo="na"` | tabela com Ana |
| 7 | Buscar inexistente | `5 → termo="zzz"` | `Nenhum aluno encontrado ...` |
| 8 | Renomear existente | `6 → id=1, novo=Ana Maria` | `Atualizado.` |
| 9 | Renomear inexistente | `6 → id=9` | `ID não encontrado.` |
| 10 | Nome inválido | `3 → id=2, nome=" "` | `Erro: O nome não pode ser vazio.` |

> Mensagens entre operações incluem linha em branco para melhor legibilidade (alínea g).
