(ns beer-song
  (:require [clojure.string :as string]))

(def first-line-template "%s of beer on the wall, %s of beer.")
(def second-line-template "Take %s down and pass it around, %s of beer on the wall.")
(def last-line-template "Go to the store and buy some more, 99 bottles of beer on the wall.")

(defn- join-lines [& lines]
  (str (string/join "\n" lines) "\n"))

(defn- bottles [beer-count]
  {:pre [(>= beer-count 0)]}
  (cond (> beer-count 1) (format "%d bottles" beer-count)
        (= beer-count 1) "1 bottle"
        :else "No more bottles"))

(defn- make-first-line [beer-count]
  (let [bottle (bottles beer-count)]
    (format first-line-template bottle (string/lower-case bottle))))

(defn- make-second-line [beer-count]
  (let [bottle (bottles (- beer-count 1))]
    (format second-line-template
            (if (< beer-count 2) "it" "one")
            (string/lower-case bottle))))

(defn verse [beer-count]
  (if (< beer-count 1)
    (join-lines (make-first-line beer-count) last-line-template)
    (join-lines (make-first-line beer-count)
                (make-second-line beer-count))))

(defn sing
  ([last-verse] (sing last-verse 0))
  ([last-verse first-verse]
   {:pre [(> last-verse first-verse)]}
   (string/join "\n" (->> (range first-verse (+ last-verse 1))
                          (map verse)
                          (reverse)))))
