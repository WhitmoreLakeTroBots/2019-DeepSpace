package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

class Spline_CSL1_DCL extends BaseAutonGenerator {

  Spline_CSL1_DCL (Trajectory.Config conf) {
    this.config = conf;
    baseFileName = this.getClass().getSimpleName();
    gnuPlotString = "plot '%s' using 2:3 w lp lt rgb 'black'";
  }

  protected Trajectory gen_DCL_CSL1(){
    Waypoint[] points = new Waypoint[] {
        SplinePointsLib.CSL1,
        SplinePointsLib.CSL1_Approach,
        new Waypoint(5.50, 6.00, Pathfinder.d2r(0)),
        SplinePointsLib.DCL_Approach,
        SplinePointsLib.DCL
      };
      return (Pathfinder.generate(points, config));
  }

  void generate () {
    segments.add (gen_DCL_CSL1());
    write();
  }
}