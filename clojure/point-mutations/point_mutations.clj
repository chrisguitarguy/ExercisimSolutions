(ns point-mutations
  (:require [clojure.data :as data]))

(defn hamming-distance [a b]
  (when (= (count a) (count b))
    (count (filter identity (map not= a b)))))
