
# Welcome to the WLHS TroBots Spline Generator

This project uses JaciNoNonsense Spline Generator to generate robot paths.


## Getting Started
To generate the splines you will need to run the gradle task gen

````
gradlew gen
````

To generate the splines and see them ploted using gnu plot

````
gradlew plot
````




### Prerequisites

#### gnuplot must be installed an on the system path.

gnuplot can be downloaded here.   http://www.gnuplot.info/


In order to build you must have the files loaded to a local directory to be used in the 
Jaci maven URL https://dev.imjac.in/maven/

If one of the folders listed below is NOT found then an exception is thrown.   The last one located will be used to perform dependency lookups.

`````
  "${System.env.USERPROFILE}/wlrobotics-deps/jaci", 
  "c:/wlrobotics-deps/jaci",
  "d:/wlrobotics-deps/jaci",
  "${System.env.WLROBOTICS_DEPS_HOME}/wlrobotics-deps/jaci",
  "${System.env.HOME}/wlrobotics-deps/jaci"
 `````

#### Changes to the generated FRC Gradle file

| File Name    | added Lines                       | Comments                        |
 --------------|-----------------------------------|---------------------------------|
|build.gralde  |                                   | no changes needed  |
|settings.gradle| include 'spline_generator'       | should be near the bottom (last line)|





