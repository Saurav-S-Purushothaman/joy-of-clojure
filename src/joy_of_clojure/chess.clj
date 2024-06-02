(ns joy-of-clojure.chess)
;; chess game implementation
;; Just starting template

(defn initial-board
  "Initialize a chess board. Each elements represent a square in chess
  and those character represent what is currently at that square.
  These characters can be interpreted as follows:
  r : rook
  n : knight
  b : bishop
  q : queen
  k : king
  - : empty squre

  Small letters mean black piece. Captial letters mean white piece.

  *Args* : nil
  *Return*: vector
  - -"
  []
  [\r \n \b \q \k \b \n \r
   \p \p \p \p \p \p \p \p
   \- \- \- \- \- \- \- \-
   \- \- \- \- \- \- \- \-
   \- \- \- \- \- \- \- \-
   \- \- \- \- \- \- \- \-
   \P \P \P \P \P \P \P \P
   \R \N \B \Q \K \B \N \R])

;; Further implementation will be done in the future.
