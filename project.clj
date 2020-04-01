(defproject echo_server "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]]
  :plugins [[lein-heroku "0.5.3"]]
  :min-lein-version "2.0.0"
  :main echo_server.core
  :aot [echo_server.core]
  :uberjar-name "echo_server-0.1.0-SNAPSHOT-standalone.jar"
  :heroku {
           :app-name "echo-server"
           :jdk-version "1.8"
           :include-files ["target/echo_server-0.1.0-SNAPSHOT-standalone.jar"]
           :process-types { "web" "java -jar target/echo_server-0.1.0-SNAPSHOT-standalone.jar" }
           })