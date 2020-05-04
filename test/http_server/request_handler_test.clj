(ns http_server.request_handler_test
  (:require [clojure.test :refer :all]
            [http_server.request_handler :refer :all]
            [http_server.headers :refer :all]
            )
  (:import (java.io ByteArrayOutputStream BufferedWriter OutputStreamWriter ByteArrayInputStream BufferedReader InputStreamReader)))

            
  (deftest make-response-test
    (testing "responds to request to /simple_get with 200 and empty body"
      (let [request "GET /simple_get HTTP/1.1\r\n\r\n"
            input (new ByteArrayInputStream (bytes (byte-array (map byte request))))
            in (new BufferedReader (new InputStreamReader input))
            output (new ByteArrayOutputStream)
            out (new BufferedWriter (new OutputStreamWriter output))
            empty-response "HTTP/1.1 200 OK\r\nContent-Type:text/html\r\nContent-Length:0\r\n\r\n"]
        
        (with-open [reader in
                    writer out]
          (process-request reader writer))
        
        (is (= empty-response (.toString output)))))
        
    (testing "responds to request to /simple_get_with_body with 200 and 'Hello world"
      (let [request "GET /simple_get_with_body HTTP/1.1\r\nHost: developer.mozilla.org\r\n\r\n"
            input (new ByteArrayInputStream (bytes (byte-array (map byte request))))
            in (new BufferedReader (new InputStreamReader input))
            output (new ByteArrayOutputStream)
            out (new BufferedWriter (new OutputStreamWriter output))
            empty-response "HTTP/1.1 200 OK\r\nContent-Type:text/html\r\nContent-Length:11\r\n\r\nHello world"]
        
        (with-open [reader in
                    writer out]
          (process-request reader writer))
        
        (is (= empty-response (.toString output))))))
