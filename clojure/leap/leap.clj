(ns leap)

(defn- divisible-by? [divisor dividend]
  (= 0 (mod dividend divisor)))

(defn leap-year? [year]
  (if (divisible-by? 4 year)
    (if (divisible-by? 100 year) (divisible-by? 400 year) true)
    false))
