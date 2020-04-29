(ns http_server.server_test
  (:require [clojure.test :refer :all]
            [http_server.server :refer :all])
  (:import (java.io InputStreamReader BufferedReader BufferedWriter OutputStreamWriter)
           (java.net ServerSocket Socket)))

(require '[clojure.core.async :as async])

(defn eventually [test time-limit]
  (loop [time-elapsed 0
        failedTest true]
    
    (if (and (< time-elapsed time-limit) failedTest)
      (let [increment 1 ;how long to sleep before retrying test
            retry (try
                    (test) false ;if the test passes you shouldn't retry
                  (catch
                    Exception e true) ;if the test raises an exception you should retry
                  (finally
                    (Thread/sleep increment)))]
        
        (recur (+ time-elapsed increment) retry)) 
      (not failedTest)))) ;eventually returns whether the test passed

(deftest server-test
  (let [port 5000]
    (async/go 
      (server port))
  (testing "server opens a socket on localhost and listens using given port"

      (is (true? (eventually 
                  #(let [socket (Socket. "127.0.0.1" port)] 
                      (true? (.isBound socket))) 1000))))
                      
  
  (testing "server responds to multiple sequential requests"
      ; this shouldn't be working -- but it is.  
    (is (true? (eventually 
                  #(let [socket2 (Socket. "127.0.0.1" port)] 
                      (true? (.isBound socket2))) 1000)))
    (is (true? (eventually 
                  #(let [socket3 (Socket. "127.0.0.1" port)] 
                      (true? (.isBound socket3))) 1000))))))
