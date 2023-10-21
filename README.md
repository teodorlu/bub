# `bub`: Babashka Unix Bridge

## Status: experimental.

Using this code as a dependency is not recommened.
If you like it, take the source and roll with it.

## Operations

This is what you can do with `bul`.

### `,,from-lines` (TODO)

Converts a newline-separated string into an EDN list of strings.

### `,,from-json` (TODO)

Converts a JSON string to an EDN string.

### `,, f` (DONE)

Pipes an EDN value into `f`, printing `(f value)` as EDN.

`,,` is also known as _run_ when a valid Clojure identifier is required.

### `,,to-lines` (TODO)

Converts a sequence of EDN a newline-separated string of its components.

### `,,to-json` (TODO)

Converts and EDN string to a JSON string.

## Installing

All bub commands will be prefixed with `,,`.
Installing `bub` requires installing multiple commands.

### Installing `,,`

    bbin install . --as ,, --main-opts '["-m" "teodorlu.bub.cmd.run/-main"]'

Example usage:

    $ echo 3 | ,, inc
    4
