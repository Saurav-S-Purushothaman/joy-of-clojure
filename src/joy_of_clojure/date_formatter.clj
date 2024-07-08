(ns joy-of-clojure.date-formatter
  (:import [java.time LocalDate DayOfWeek Month])
  (:gen-class))


(defn format-date [date-str]
  (let [date (LocalDate/parse date-str)]
    (str (.getMonth date)
         " "
         (.getDayOfMonth date)
         (case (.getDayOfMonth date)
           1 "st"
           2 "nd"
           3 "rd"
           "th")
         " "
         (.getYear date))))

(format-date "2024-06-25")
