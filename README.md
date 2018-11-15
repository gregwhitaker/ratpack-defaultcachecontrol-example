# ratpack-defaultcachecontrol-example
[![Build Status](https://travis-ci.org/gregwhitaker/ratpack-defaultcachecontrol-example.svg?branch=master)](https://travis-ci.org/gregwhitaker/ratpack-defaultcachecontrol-example)

An example of setting a default cache-control header in a [Ratpack](https://ratpack.io) application.

## Running the Example
1. Run the following command to start the application:

        ./gradlew run
        
2. Run the following command to call the `/api/v1/get` endpoint with its own cache-control header set:

        curl -v http://localhost:5050/api/v1/get
        
    Notice that the `Cache-Control` header is set to a value of `3600` seconds, which is the value that was explicitly set in the handler.

        *   Trying ::1...
        * TCP_NODELAY set
        * Connected to localhost (::1) port 5050 (#0)
        > GET /api/v1/get HTTP/1.1
        > Host: localhost:5050
        > User-Agent: curl/7.54.0
        > Accept: */*
        >
        < HTTP/1.1 200 OK
        < Cache-Control: max-age=3600
        < content-type: text/plain;charset=UTF-8
        < content-length: 35
        <
        * Connection #0 to host localhost left intact
        
3. Next, run the following command to call the `api/v1/getwithoutcache` endpoint:

        curl -v http://localhost:5050/api/v1/getwithoutcache
        
    Notice that the `Cache-Control` header is set to a value of `1` second, which is the default value set by the filter.

        *   Trying ::1...
        * TCP_NODELAY set
        * Connected to localhost (::1) port 5050 (#0)
        > GET /api/v1/getwithoutcache HTTP/1.1
        > Host: localhost:5050
        > User-Agent: curl/7.54.0
        > Accept: */*
        >
        < HTTP/1.1 200 OK
        < content-type: text/plain;charset=UTF-8
        < content-length: 61
        < Cache-Control: max-age=1
        <
        * Connection #0 to host localhost left intact

## Bugs and Feedback
For bugs, questions, and discussions please use the [Github Issues](https://github.com/gregwhitaker/ratpack-defaultcachecontrol-example/issues).

## License
MIT License

Copyright (c) 2018 Greg Whitaker

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
