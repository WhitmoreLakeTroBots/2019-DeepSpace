package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

class Spline_CSCL_DCL extends BaseAutonGenerator {

  Spline_CSCL_DCL (Trajectory.Config conf) {
    this.config = conf;
    baseFileName = this.getClass().getSimpleName();
    gnuPlotString = "plot '%s' using 2:3 w lp lt rgb 'navy blue'";
  }

  protected Trajectory gen_CSCL_DCL(){
    Waypoint[] points = new Waypoint[] {
        SplinePointsLib.CSCL,
        SplinePointsLib.DCL_Approach,
        SplinePointsLib.DCL
      };
      return (Pathfinder.generate(points, config));
  }

  void generate () {
    segments.add (gen_CSCL_DCL());
    write();
  }
}