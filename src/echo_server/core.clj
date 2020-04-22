(ns echo_server.core
  (:import (java.io InputStreamReader BufferedReader BufferedWriter OutputStreamWriter)
           (java.net ServerSocket))
  (:gen-class))

(require '[clojure.string :as str])

(defn write-hello-world []
  (println "hello world!"))

(defn socket-read [reader]
  (. reader readLine))

(defn socket-write [writer message]
  (. writer write message 0 (count message))
  (. writer flush))

(defn -main []
  (write-hello-world ))
