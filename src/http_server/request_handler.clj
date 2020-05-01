(ns http_server.request_handler
  (:require [http_server.io :refer :all]
            [http_server.parse_request :refer :all])
  (:gen-class))

(defn make-empty-body-response [out]
  (let [response "HTTP/1.1 200 OK\r\nContent-Type:text/html\r\nContent-Length:0\r\n\r\n"]
        (socket-write out response)))

(defn respond [out method uri body]
  (make-empty-body-response out))

(defn process-request [in out]
  (let [request (parse-request in)]
    (respond out (request :method "GET") (request :uri "/simple_get") (request :body ""))))