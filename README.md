# echo-server

This is a simple server. Final functionality will be to reply to a http request with a http response containing the same body as the request.
Currently it replies to all http requests with a http response with the body containing the string "hello world!"

## Installation
To install locally, you must have [Leiningen](https://leiningen.org/) and [Java](https://www.java.com/en/download/) installed


## Usage
To run the server on the local machine you can use

`lein run`

to run directly

or you can compile into an uberjar using

`lein uberjar`

The uberjar command creates 2 uberjars, in the `/target` directory the `standalone` uberjar is suitable for deployment and includes all needed dependincies

## License

Copyright © 2020

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
