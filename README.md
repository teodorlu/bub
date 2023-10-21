# `bub`: Babashka Unix Bridge

## Status: experimental.

Using this code as a dependency is not recommened.
If you like it, take the source and roll with it.

## Operations

This is what you can do with `bul`.

### `,,from-lines`

Converts a newline-separated string into an EDN list of strings.

### `,,from-json`

Converts 

### `,, f`

pipes an EDN value into `f`, printing `(f value)` as EDN.

### `,,to-lines`

Converts a sequence of EDN a newline-separated string of its components.

### `,,to-json`

Converts and EDN string to a JSON string.
