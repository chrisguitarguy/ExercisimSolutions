(ns robot-name)

(def ^:private letters (map char (range (int \A) (inc (int \Z)))))

(defn- generate-name []
  (format
    "%c%c%03d"
    (rand-nth letters)
    (rand-nth letters)
    (rand-int 100)))

(defn- regen-name [old-name]
  (let [new-name (generate-name)]
    (if (= old-name new-name)
      (recur old-name)
      new-name)))

(defprotocol Robot
  (robot-name [robot])
  (reset-name [robot]))

(defrecord AtomicRobot [name]
  Robot
  (robot-name [robot]
    @(:name robot))
  (reset-name [robot]
    (swap! (:name robot) regen-name)))

(defn robot []
  (AtomicRobot. (atom (generate-name))))
