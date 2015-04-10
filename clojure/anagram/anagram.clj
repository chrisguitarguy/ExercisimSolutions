(ns anagram
  (:require [clojure.string :as string]))

(defn- is-anagram? [original to-check]
  (let [to-check (string/lower-case to-check)]
    (and (not= original to-check)
         (= (sort original) (sort to-check)))))

(defn anagrams-for [word possiblities]
  (filter (partial is-anagram? (string/lower-case word)) possiblities))
