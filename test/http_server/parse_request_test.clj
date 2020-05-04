(ns http_server.parse_request_test
  (:require [clojure.test :refer :all]
            [http_server.parse_request :refer :all])
  (:import (java.io ByteArrayOutputStream BufferedWriter OutputStreamWriter ByteArrayInputStream BufferedReader InputStreamReader)))

(deftest read-until-nil-test
  (testing "read until nil reads all lines"
    (let [inputed-request "POST /echo HTTP/1.1\r\nHost: localhost:5000\r\nContent-Length: 11\r\n\r\nHello world"
          expected-return ["POST /echo HTTP/1.1" "Host: localhost:5000" "Content-Length: 11" "" "Hello world"]
          stream (new ByteArrayInputStream (bytes (byte-array (map byte (str inputed-request)))))
          stream-reader (new BufferedReader (new InputStreamReader stream))]
      
      (with-open [reader stream-reader]
        (is (= expected-return (read-until-nil reader)))))))

(deftest parse-request-test
  (testing "returns formatted request with no body"
    (let [inputed-request "GET /echo HTTP/1.1\r\nHost: localhost:5000\r\n\r\n"
          expected-return {:method "GET" :uri "/echo" :Host "localhost:5000" :body ""}
          stream (new ByteArrayInputStream (bytes (byte-array (map byte (str inputed-request)))))
          stream-reader (new BufferedReader (new InputStreamReader stream))]

      (with-open [reader stream-reader]
        (is (= expected-return (parse-request reader))))))

  (testing "returns formatted request with body"
    (let [inputed-request "GET /echo HTTP/1.1\r\nHost: localhost:5000\r\nContent-Length: 11\r\n\r\nHello world"
          expected-return {:method "GET" :uri "/echo" :Host "localhost:5000" :Content-Length "11" :body "Hello world"}
          stream (new ByteArrayInputStream (bytes (byte-array (map byte (str inputed-request)))))
          stream-reader (new BufferedReader (new InputStreamReader stream))]

      (with-open [reader stream-reader]
        (is (= expected-return (parse-request reader)))))))
