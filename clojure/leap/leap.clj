(ns leap)

(defn- divisible-by? [divisor dividend]
  (= 0 (mod dividend divisor)))

(defn leap-year? [year]
  (condp divisible-by? year
    400 true
    100 false
    4 true
    false))
