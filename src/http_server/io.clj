(ns http_server.io
  (:gen-class))

(defn socket-read [reader]
  (. reader readLine))

(defn socket-write [writer message]
  (. writer write message 0 (count message))
  (. writer flush))
