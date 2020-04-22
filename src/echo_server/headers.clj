(ns echo_server.headers
  (:import)
  (:gen-class))

(require '[clojure.string :as str])

(defn generate-response-header [body]
  (str "HTTP/1.1 200 OK\r\nContent-Type:text/html\r\nContent-Length:"
        (count body)
        "\r\n\r\n"))
