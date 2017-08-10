(ns translatr.google-test
  (:require [clojure.test :refer :all]
            [translatr.google :refer :all]))

(deftest test-translate
  (testing "Testing translations"
    (testing "with options map."
      (is (= "Hola" (translate "Hello" {:source "en" :target "es"})))
      (is (= "привет" (translate "hallo" {:source "de" :target "ru"}))))))
