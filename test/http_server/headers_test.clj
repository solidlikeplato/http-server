(ns http_server.headers_test
  (:require [clojure.test :refer :all]
            [http_server.headers :refer :all]))

(deftest response-header-test 
  (testing "generates http response header"
    (let [body "hello world"
          header (str "HTTP/1.1 200 OK\r\nContent-Type:text/html\r\nContent-Length:" 
                      (count body)
                      "\r\n\r\n")]
                      
      (is (= header (generate-response-header body))))))
