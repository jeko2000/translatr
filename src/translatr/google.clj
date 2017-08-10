(ns translatr.google
  (:require [org.httpkit.client :as h]
            [ring.util.codec :refer [url-encode]]
            [clojure.string :refer [join]]
            [clj-json.core :as j]))

(defonce defaults (atom {:source "auto"
                         :target "en"}))

(defn set-default-source! [source]
  "Destructively change the default source language. The recommended value is \"auto\" "
  (swap! defaults assoc :source source))

(defn set-default-target! [target]
  "Destructively change the default target language. The recommended value is \"en\" "  
  (swap! defaults assoc :target target))

(defn- encode [s]
  (if (string? s)
    (url-encode s)))

(defn- parse-body [s]
  (let [json (j/parse-string s)]
    (join (map first (first json)))))

(defn translate
  "Translates query using the same API that powers Google Translate."
  ([query] (translate query {}))
  ([query {:keys [source target] :or {source (:source @defaults) target (:target @defaults)}}]
   (as-> "https://translate.googleapis.com/translate_a/single?client=gtx&ie=UTF-8&oe=UTF-8&sl=" $
     (str $
          source "&tl="
          target "&dt=t&q="
          (encode query))
     @(h/get $)
     (:body $)
     (parse-body $))))
