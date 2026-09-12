#!/usr/bin/env bash

set -Eeuo pipefail

readonly PROJECT_ROOT="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd)"
readonly SERVICES=(
    "customer-service"
    "order-service"
    "payment-service"
    "product-service"
)

declare -a SERVICE_PIDS=()

stop_services() {
    local exit_code=$?

    trap - EXIT INT TERM

    if ((${#SERVICE_PIDS[@]} > 0)); then
        echo
        echo "Stopping services..."

        for pid in "${SERVICE_PIDS[@]}"; do
            if kill -0 "$pid" 2>/dev/null; then
                kill "$pid" 2>/dev/null || true
            fi
        done

        for pid in "${SERVICE_PIDS[@]}"; do
            wait "$pid" 2>/dev/null || true
        done
    fi

    exit "$exit_code"
}

trap stop_services EXIT
trap 'exit 130' INT
trap 'exit 143' TERM

for service in "${SERVICES[@]}"; do
    gradle_wrapper="$PROJECT_ROOT/$service/gradlew"

    if [[ ! -x "$gradle_wrapper" ]]; then
        echo "Gradle wrapper not found or not executable: $gradle_wrapper" >&2
        exit 1
    fi

    echo "Starting $service..."
    (
        cd "$PROJECT_ROOT/$service"
        exec ./gradlew bootRun --console=plain
    ) &
    SERVICE_PIDS+=("$!")
done

echo
echo "All services started. Press Ctrl+C to stop them."

set +e
wait -n "${SERVICE_PIDS[@]}"
exit_code=$?
set -e

echo "A service exited with status $exit_code; stopping the remaining services." >&2
exit "$exit_code"
