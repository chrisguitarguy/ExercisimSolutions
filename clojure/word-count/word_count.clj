(ns word-count
  (:require [clojure.string :as string]))

(defn word-count [input]
  (-> (string/lower-case input)
      (string/split #"\W+")
      (frequencies)))
