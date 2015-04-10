(ns rna-transcription)

; global variable bad? Or do persistent data
; structures make it okay to do?
(def dna->rna {\G \C \C \G \T \A \A \U})

(defn- valid-dna-char? [chr]
  (contains? dna->rna chr))

(defn- valid-dna? [string]
  (every? valid-dna-char? string))

(defn to-rna [string]
  {:pre [(valid-dna? string)]}
  (apply str (map dna->rna string)))
