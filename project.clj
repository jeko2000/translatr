(defproject translatr "0.1.1"
  :description "A free, key-less implementation of the Google Translate API allowing translation between different languages."
  :url "https://github.com/jeko2000/translatr"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [http-kit "2.2.0"]
                 [ring/ring-codec "1.0.1"]
                 [clj-json "0.5.3"]]
  :profiles {:dev {:plugins [[com.jakemccrary/lein-test-refresh "0.8.0"]]}})
