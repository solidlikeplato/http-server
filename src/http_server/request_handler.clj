(ns http_server.request_handler
  (:require [http_server.headers :refer :all]
            [http_server.io :refer :all])
  (:gen-class))

(defn make-response [in out]
  (let [request (socket-read in)
        response (generate-response-header "")
        ; response (get-response request)
        ]
        (socket-write out response)))
        