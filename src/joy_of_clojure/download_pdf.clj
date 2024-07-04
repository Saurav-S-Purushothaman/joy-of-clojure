(ns joy-of-clojure.download-pdf
  (:require [clj-http.client :as client]
            [clojure.java.io :as io]))


(defn download-pdf []
  (let [url "http://localhost:4000/pdf"
        output-file "downloaded-document.pdf"]
    (try
      (with-open [response (client/get url {:as :stream})]
        (if (= 200 (:status response))
          (with-open [out-file (io/output-stream output-file)]
            (io/copy (:body response) out-file))
          (println "Failed to download PDF. Server returned status" (:status response))))
      (catch Exception e
        (println "Error downloading PDF:" (.getMessage e))))))


;; Call download-pdf function to initiate the download
(download-pdf)
