#!/usr/bin/env bash
set -euo pipefail

# Compile sources into lab04/out and run pt.escnaval.exercicios.Livro
ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
SRC="$ROOT_DIR/src/main/java"
OUT="$ROOT_DIR/out"

mkdir -p "$OUT"
javac -d "$OUT" $(find "$SRC" -name "*.java")
java -cp "$OUT" pt.escnaval.exercicios.Livro
