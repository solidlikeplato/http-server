(ns http_server.request_handler
  (:require [http_server.io :refer :all]
            [http_server.parse_request :refer :all])
  (:gen-class))

(defn get-response [request]
  (let [method (request :method)
        uri (request :uri)
        _body (request :body)]
    (cond
      (= method "GET") 
        (cond 
          (and (= method "GET") (= uri "/simple_get"))
          "HTTP/1.1 200 OK\r\nContent-Type:text/html\r\nContent-Length:0\r\n\r\n"

          (and (= method "GET") (= uri "/simple_get_with_body"))
          "HTTP/1.1 200 OK\r\nContent-Type:text/html\r\nContent-Length:11\r\n\r\nHello world"))))

(defn send-response [out request]
  (socket-write out (get-response request)))

(defn process-request [in out]
  (let [request (parse-request in)]
    (send-response out request)))