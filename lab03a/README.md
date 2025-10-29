Lab03a


## Tabela de testes (modelo)

| Caso | Passos / Entrada | Saída esperada |
|------|------------------|----------------|
| 1 | Listar vazio | (vazio) |
| 2 | Adicionar → opção 1; id=1; nome=Ana | [OK] Adicionado. |
| 3 | Duplicado → opção 1; id=1; nome=Ana | [X] (falha por id repetido) |
| 4 | Remover ok → opção 3; id=1 | [OK] Removido. |
| 5 | Remover inexistente → opção 3; id=9 | [X] ID inexistente. |
| 6 | Adicionar vários → opção 1; id=1 Ana / opção 1; id=2 Bob → opção 2 listar | lista mostra 2 linhas com 1 Ana e 2 Bob |
| 7 | Nome vazio → opção 1; id=3; nome=" " | [X] Falhou (nome vazio). |
| 8 | Fluxo completo → 1→2→3→2 | estados coerentes após cada operação |
| 9 | Sair → opção 0 | Adeus! |

### Observações
- Use `ID` inteiro e `Nome` como texto não vazio.
- Os textos entre colchetes `[...]` representam mensagens exibidas pelo programa.

## Compilar / Executar (Linux / macOS)

No diretório `lab03a/` execute:

```bash
# compilar todos os fontes do lab
find src -name "*.java" -print0 | xargs -0 javac -d out

# executar o menu interactivo
java -cp out pt.escnaval.exercicios.MenuRegistos
```

---

Instruções de avaliação: preencher a tabela com o resultado real de cada caso ao executar o `MenuRegistos`.

PowerShell (Windows):
Get-ChildItem -Recurse src -Filter *.java | % { $_.FullName } | % { & javac -d
out $_ }
java -cp out pt.escnaval.exercicios.MenuRegistos