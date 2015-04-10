(ns bob
  (:require [clojure.string :as string]))

(defn- has-letters? [message]
  (not (nil? (re-find #"[a-zA-Z]" message))))

(defn response-for [message]
  (cond
    (or (empty? message)
        (string/blank? message)) "Fine. Be that way!"
    (and (has-letters? message)
         (= (string/upper-case message) message)) "Whoa, chill out!"
    (.endsWith message "?") "Sure."
    :else "Whatever."))
