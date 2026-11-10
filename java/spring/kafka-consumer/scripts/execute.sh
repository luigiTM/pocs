#!/usr/bin/env bash

set -euo pipefail

SCRIPT_DIR="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd)"

if [[ -f "$SCRIPT_DIR/.env" ]]; then
  set -a
  # shellcheck disable=SC1091
  source "$SCRIPT_DIR/.env"
  set +a
fi

command="${1:-all}"

case "$command" in
  create-topics)
    node "$SCRIPT_DIR/create-topics.js"
    ;;
  produce-messages)
    node "$SCRIPT_DIR/produce-messages.js"
    ;;
  all)
    node "$SCRIPT_DIR/create-topics.js"
    node "$SCRIPT_DIR/produce-messages.js"
    ;;
  -h|--help|help)
    echo "Usage: $0 [create-topics|produce-messages|all]"
    ;;
  *)
    echo "Unknown command: $command" >&2
    echo "Usage: $0 [create-topics|produce-messages|all]" >&2
    exit 2
    ;;
esac
