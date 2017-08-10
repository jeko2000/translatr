Translatr
==========

A __free__, __key-less__ Google Translate library implenting the same servers as the [translate.google.com](https://translate.google.com/).

## Dependency information

Upcoming!

## Usage

Translatr exposes a `translate` multi-arity function which takes either a query and an optional args map.

``` clojure
(use '[translatr.google])

;; When no args map is passed, the default values of {:source "auto", :target "en"} are used.
(translate "Hola")
=> "Hello"

(translate "Hello" {:source "en" :target "da"})
=> "Hej"
```
#### \*\*Important\*\*

For consistent results, please use 2 letter language codes defined by [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) as values for the `:source` and `:target` keys.


## Default values.

Though defaults for source and target are set to "auto" and "en", respectively, it may desirable to change these defaults within an application. To do so, we use the following functions.

``` clojure
(use '[translatr.google])

(set-default-source! "en")
=> {:source "en", :target "en"}
(set-default-target! "fr")
=> {:source "en", :target "fr"}
(translate "Hello")
=> "Bonjour"
```

[**Back To Top ⇧**](#Translatr)

## License

Distributed under the Eclipse Public License.

