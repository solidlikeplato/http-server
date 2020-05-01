(ns http_server.server
  (:require [http_server.request_handler :refer :all])
  (:import (java.io InputStreamReader BufferedReader BufferedWriter OutputStreamWriter)
           (java.net ServerSocket))
  (:gen-class))

(defn- respond-to-request [socket] 
  (let [client-socket (. socket accept)
        in (BufferedReader. (InputStreamReader. (.getInputStream client-socket)))
        out (BufferedWriter. (OutputStreamWriter. (.getOutputStream client-socket)))]
      (with-open [reader in
                  writer out]
        (process-request reader writer))
    (.close client-socket)))

(defn server [port]
  (let [socket (ServerSocket. port)]
    (loop []
      (respond-to-request socket)
      (recur))
      (.close socket)))
