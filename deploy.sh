#!/bin/sh

# compile fat jar
mvn package

# copy to RPI
scp target/LedBlink-1.0-SNAPSHOT-jar-with-dependencies.jar roman@10.0.1.47:StrobeLight.jar