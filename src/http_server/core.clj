(ns http_server.core
  (:require [http_server.server :refer :all])
  (:gen-class))

(defn write-hello-world []
  (println "hello world!"))

(defn -main [port]
  (server (Integer. port) ))
