[![Build Status](https://travis-ci.org/ogstation/gas-station.svg)](https://travis-ci.org/ogstation/gas-station)

gas-station
===========

How to build ?
======
mvn clean install

How to run ?
======
mvn jetty:run
 
API
======
* /api/error/400: handle 400 error
* /api/error/401: handle 401 error
* /api/error/403: handle 403 error
* /api/error/404: handle 404 error
* /api/error/500: handle 500 error

* /api/stations(GET): retrieve a list of gas stations
* /api/stations/{id}(GET): retrieve a specific gas station
* /api/stations(POST): create gas station
* /api/stations/{id}(PUT): update gas station
* /api/stations/{id}(DELETE): delete gas station