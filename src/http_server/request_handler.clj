(ns http_server.request_handler
  (:require [http_server.headers :refer :all]
            [http_server.io :refer :all])
  (:gen-class))

(defn make-response [in out]
  (let [request (socket-read in)
        response "HTTP/1.1 200 OK\r\nContent-Type:text/html\r\nContent-Length:0\r\n\r\n"]
        (socket-write out response)))
