(ns echo_server.core-test
  (:require [clojure.test :refer :all]
            [echo_server.core :refer :all])
  (:import (java.io ByteArrayOutputStream BufferedWriter OutputStreamWriter ByteArrayInputStream BufferedReader InputStreamReader)))

(deftest writer-test
  (testing "Reader reads from input stream correctly"
    (let [message "hello world!"
          input (new ByteArrayInputStream (bytes (byte-array (map byte message))))
          in (new BufferedReader (new InputStreamReader input))]

      (is (= message (socket-read in)))))
  (testing "Reader reads from input stream correctly"
    (let [message "hello world!"
          input (new ByteArrayInputStream (bytes (byte-array (map byte message))))
          in (new BufferedReader (new InputStreamReader input))]

      (is (= message (socket-read in))))))