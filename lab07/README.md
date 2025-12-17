## Mediateca (Lab 07)

Implementação base do exercício de Mediateca com CLI.

- Código fonte: `lab07/src/main/java/pt/escnaval/exercicios/mediateca/`
- Dados persistentes: `lab07/data/mediateca.csv`
- Repositório de media: `lab07/media/`

### Compilar e correr (bash)
```bash
cd lab07
find src/main/java -name \"*.java\" -print0 | xargs -0 javac -encoding UTF-8 -d out
java -cp out pt.escnaval.exercicios.mediateca.MenuMediateca
```

### Formato CSV
```
<id>;<titulo>;<autor>;<faixa1>|<duracao>|<path>,<faixa2>|<duracao>|<path>
```
Cada linha representa um álbum; o caminho da faixa é relativo (ex.: `media/exemplo.mp3`).
