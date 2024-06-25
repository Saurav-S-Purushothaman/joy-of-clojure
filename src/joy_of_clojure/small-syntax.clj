(ns joy-of-clojure.small-syntax
  (:import [java.time LocalDate Period])
  (:gen-class))

;; This namespace contains detaials about several clojure functions
;; which are not used often by me or taken for granted

;; `for` and `doseq` does something similar
;; but `for` returns lazy-sequence and `doseq` is for generatting
;; side effects. Also doseq returns nil.

(def (for [x [:a :b], y (range 5) :when (odd? y)]
  [x y]))

;; => ([:a 1] [:a 3] [:b 1] [:b 3])

(doseq [x [:a :b], y (range 5) :when (odd? y)]
  (prn [x y]))

(defn date-difference
  "Finds the difference in date"
  [date-1 date-2]
  (let [d1 (LocalDate/parse date-1)
        d2 (LocalDate/parse date-2)
        period (Period/between d2 d1)]
    {
     :year (.getYears period)
     :months (.getMonths period)
     :days (.getDays period)
     }
    ))


(date-difference "2024-06-25" "2024-02-19")
