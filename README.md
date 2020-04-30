# HTTP-server

This is a simple server.
Currently it replies to all http requests with a http response with an empty body

## Installation
To install locally, you must have [Leiningen](https://leiningen.org/) and [Java](https://www.java.com/en/download/) installed


## Usage
Assuming you wish to run on port 5000 to run the server on the local machine you can use

`lein run 5000`

to run directly

or you can compile into an uberjar using

`lein uberjar`

The uberjar command creates 2 uberjars, in the `/target` directory the `standalone` uberjar is suitable for deployment and includes all needed dependincies

## Deployment
Currently set up to use Heroku for deployment.
#### Deployment Dependencies
To deploy to Heroku, Heroku CLI tools should be installed and the repo should have a second remote named heroku linked to a Heroku app.
1. commit all changes
2. `lein uberjar`
3. commit the repository to the heroku remote by 

    `git add .`
    
    `git commit -m 'update uberjar to latest version'`
    
    `git push heroku master` if on master branch, or if on another branch
    
    `git push heroku branch-name-here:master`

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
