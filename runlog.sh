#!/bin/bash

MAVEN_OPTS=-Djava.util.logging.config.file=/home/maslo/prime/logging.properties  mvn tomcat7:run-war
