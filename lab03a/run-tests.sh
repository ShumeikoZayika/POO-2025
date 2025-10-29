#!/usr/bin/env bash
set -euo pipefail
ROOT_DIR="$(cd "$(dirname "$0")" && pwd)"
cd "$ROOT_DIR"

mkdir -p out results

echo "Compiling..."
find src -name "*.java" -print0 | xargs -0 javac -d out

run_case() {
  local name="$1"
  local input="$2"
  echo "--- Case: $name ---"
  printf "%s" "$input" | java -cp out pt.escnaval.exercicios.MenuRegistos | tee "results/${name}.txt"
  echo
}

echo "Running test cases (each case is a fresh run)..."

# Case 1: Listar vazio
case1=$'2\n0\n'
run_case "01-listar-vazio" "$case1"

# Case 2: Adicionar id=1 nome=Ana then list
case2=$'1\n1\nAna\n2\n0\n'
run_case "02-adicionar-1-Ana" "$case2"

# Case 3: Duplicado: add id=1 Ana then try add same id
case3=$'1\n1\nAna\n1\n1\nAna\n0\n'
run_case "03-duplicado" "$case3"

# Case 4: Remover ok (add then remove then list)
case4=$'1\n1\nAna\n3\n1\n2\n0\n'
run_case "04-remover-ok" "$case4"

# Case 5: Remover inexistente
case5=$'3\n9\n0\n'
run_case "05-remover-inexistente" "$case5"

# Case 6: Adicionar vários then list
case6=$'1\n1\nAna\n1\n2\nBob\n2\n0\n'
run_case "06-adicionar-varios" "$case6"

# Case 7: Nome vazio
case7=$'1\n3\n \n0\n'
run_case "07-nome-vazio" "$case7"

# Case 8: Fluxo completo
case8=$'1\n1\nAna\n1\n2\nBob\n2\n3\n1\n2\n0\n'
run_case "08-fluxo-completo" "$case8"

# Case 9: Sair imediato
case9=$'0\n'
run_case "09-sair" "$case9"

echo "All test outputs are saved under: $ROOT_DIR/results/"
