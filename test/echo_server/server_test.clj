(ns echo_server.server-test
  (:require [clojure.test :refer :all]
            [echo_server.server :refer :all])
  (:import (java.io InputStreamReader BufferedReader BufferedWriter OutputStreamWriter)
           (java.net ServerSocket Socket)))

(require '[clojure.core.async :as async])

(defn eventually [test time-limit]
  (loop [time-elapsed 0
        failedTest true]
    
    (if (and (< time-elapsed time-limit) failedTest)
      (let [increment 1 ;how long to sleep before retrying test
        retry
          (try
            (test) false ;if the test passes you shouldn't retry
          (catch
            Exception e true) ;if the test raises an exception you should retry
          (finally
            (Thread/sleep increment)))]
        
        (recur (+ time-elapsed increment) retry)) 
      (not failedTest)))) ;eventually returns whether the test passed

(deftest server-test
  (testing "server opens a socket on localhost and listens using given port"
    
    (let [port 5000]
      (async/go 
      (server port))
        (is (true? (eventually 
                    #(let [socket (Socket. "127.0.0.1" port)] 
                        (is (true? (.isBound socket)))) 15000))))))
