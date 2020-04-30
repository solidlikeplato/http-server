(ns http_server.core
  (:require [http_server.server :refer :all])
  (:gen-class))
  
(defn -main [port]
  (server (Integer. port) ))
