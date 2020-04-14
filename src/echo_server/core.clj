(ns echo_server.core
  (:import (java.io BufferedWriter OutputStreamWriter)
           (java.net ServerSocket))
  (:gen-class))

(require '[clojure.string :as str])

(defn sock-write [writer msg]
  (let [line (str msg "\r\n")]
    (. writer write line 0 (count line))))

(defn write-hello-world [out]
    (sock-write out (str "HTTP/1.1 200 OK\r\nContent-Type:text/html\r\nContent-Length:14\r\n\r\nhello world!!!"))
    (.flush out))

(defn server [port action]
  (let [sock (ServerSocket. port)]
    (loop []
      (let [client-socket (. sock accept)
              out (BufferedWriter. (OutputStreamWriter. (.getOutputStream client-socket)))]
          (action out)
          (.close client-socket)
          (recur)))))

(defn -main [port]
  (server (Integer. port) write-hello-world))