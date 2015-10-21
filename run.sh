#!/bin/bash

# specify the full path if you link to this script from the scratch script
#DIR=/home/pi/RaspberryPi-ExampleGPIO
DIR=.

export DISPLAY=:0.0
echo $DIR
cd $DIR
sudo java -Xmx128m -cp `sh getclasspath.sh`:classes WalkTurtleDemo




