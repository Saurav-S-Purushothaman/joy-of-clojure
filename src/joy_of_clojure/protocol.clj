(ns joy-of-clojure.protocol)

;; protocols

(defprotocol Concatenatable
  (cat [this other]))

;; polymorphism is the ability of function to perform different action
;; depending on the type of its argument or target

;; this function `cat` will work for any object that satisfies the
;; protocol Concatenatable. We can have different implementation
;; for each object.

;; extending this protocol to a string class

(extend-type String
  Concatenatable
  (cat [this other]
    (.concat this other)))

(cat "House " "of leaves")
;; => "House of leaves"  (how cool is this!!!)

(extend-type java.util.List
  Concatenatable
  (cat [this other]
    (concat this other)))

(cat [1 2 4] [2 4 6])
;; => (1 2 4 2 4 6)

;; this cat function can be called to either type in its first argument
;; and appropriate function will be called
