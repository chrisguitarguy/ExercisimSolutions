(ns etl
  (:require [clojure.string :as string]))

(defn- reduce-legacy [coll score values]
  (let [values (map string/lower-case values)
        scores (repeat score)]
    (into coll (zipmap values scores))))

(defn transform [legacy]
  (reduce-kv reduce-legacy {} legacy))
