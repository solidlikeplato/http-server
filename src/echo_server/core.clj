(ns echo_server.core
  (:import (java.io InputStreamReader BufferedReader BufferedWriter OutputStreamWriter)
           (java.net ServerSocket))
  (:gen-class))

(require '[clojure.string :as str])

(defn socket-read [reader]
  (. reader readLine))

(defn write-hello-world []
    (println "hello world!"))

(defn -main []
  (write-hello-world ))