(ns joy-of-clojure.file-conversion
  (:require [clj-pdf.core :as pdf])
  (:gen-class))

(require '[clj-pdf.core :as pdf])
(import (java.io FileOutputStream
                 ByteArrayOutputStream)
        (java.nio.file Files))



(def doc1 (ByteArrayOutputStream.))
(pdf/pdf [{} "first document"] doc1)

(def doc2 (ByteArrayOutputStream.))
(pdf/pdf [{} "second document"] doc2)


(def pdf-file "tf16403437.vsdx")

(def pdf-bytes (Files/readAllBytes (.toPath (java.io.File. pdf-file ))))

(def vsdx (Files/readAllBytes (.toPath (java.))))
(pdf/collate
 {:title "collated documents"
  :author "john doe"
  :creator "jane doe"
  :keywords "jane,school,notes"
  :orientation :landscape
  :size :a4
  :subject "some subject"}
 (FileOutputStream. (clojure.java.io/file "sample.pdf"))
 (.toByteArray doc1)
 pdf-bytes)

;;;;;;;;;;;;;
(import '[org.apache.poi.xwpf.usermodel XWPFDocument]
        '[java.io FileInputStream])


(defn read-word-file [file-path]
  (with-open [fis (FileInputStream. file-path)
              doc (XWPFDocument. fis)]
    (->> (.getParagraphs doc)
         (map #(.getText %))
         (clojure.string/join "\n"))))
