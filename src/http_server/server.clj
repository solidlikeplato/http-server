(ns http_server.server
  (:require [http_server.headers :refer :all])
  (:import (java.io InputStreamReader BufferedReader BufferedWriter OutputStreamWriter)
           (java.net ServerSocket))
  (:gen-class))

(defn respond-to-request [socket] 
  (let [client-socket (. socket accept)
        in (BufferedReader. (InputStreamReader. (.getInputStream client-socket)))
        out (BufferedWriter. (OutputStreamWriter. (.getOutputStream client-socket)))]
      ; (make-response in out)
    (.close client-socket)))


(defn server [port]
  (let [socket (ServerSocket. port)]
    (loop []
      (respond-to-request socket)
      (recur))))
