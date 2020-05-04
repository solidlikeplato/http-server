(ns http_server.parse_request
  (:require [http_server.headers :refer :all]
            [http_server.io :refer :all])
  (:gen-class))

(require '[clojure.string :as str])

(defn read-until-nil [reader]
  (loop [final-output []
         line (socket-read reader)]
    (if (not (nil? line))
      (let [output-so-far (conj final-output line)]
        (recur output-so-far (socket-read reader)))
        final-output)))

(defn parse-request [reader]
  (let [request-lines (read-until-nil reader)
        first-line (str/split (first request-lines) #" ")]

    (loop [request {:method (first first-line) :uri (second first-line)}
          remaining-request (rest request-lines)
          current-line (first remaining-request)]
    
      (if (not (= current-line ""))
        (let [line (str/split current-line #" ")
              key (str/join "" (drop-last (first line)))
              value (second line)]
            (recur (assoc request (keyword key) value) (rest remaining-request) (first remaining-request)))
          (assoc request :body (str (last remaining-request)))))))
