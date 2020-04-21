(ns echo_server.core-test
  (:require [clojure.test :refer :all]
            [echo_server.core :refer :all])
  (:import (java.io ByteArrayOutputStream BufferedWriter OutputStreamWriter)))

(deftest a-test
  (testing "one equals one"
    (is (= 1 1))))

(deftest writer-test
  (testing "writer writes to output stream correctly"
    (let [output (new ByteArrayOutputStream)
          out (new BufferedWriter (new OutputStreamWriter output))
          message "hello world"]

      (socket-write out message)

      (is (= message (.toString output))))))