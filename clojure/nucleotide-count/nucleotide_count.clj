(ns nucleotide-count)

(def ^:private valid-nucleotides #{\A \C \G \T})

(defn- valid-nucleotide? [chr]
  (contains? valid-nucleotides chr))

(defn- get-nucleotide-counts [dna]
  {:pre [(every? valid-nucleotide? dna)]}
  (frequencies dna))

(defn nucleotide-counts [dna]
  (into
    (zipmap valid-nucleotides (repeat 0))
    (get-nucleotide-counts dna)))

(defn count [nt dna]
  (when (not (valid-nucleotide? nt))
    (throw (IllegalArgumentException. "invalid nucleotide")))
  (get (get-nucleotide-counts dna) nt 0))
