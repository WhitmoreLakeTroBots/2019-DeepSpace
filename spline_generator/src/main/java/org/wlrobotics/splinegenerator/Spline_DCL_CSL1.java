package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

class Spline_DCL_CSL1 extends BaseAutonGenerator {

  Spline_DCL_CSL1 (Trajectory.Config conf) {
    this.config = conf;
    baseFileName = this.getClass().getSimpleName();
    gnuPlotString = "plot '%s' using 2:3 w lp lt rgb 'orange'";
  }

  protected Trajectory gen_DCL_CSL1(){
    Waypoint[] points = new Waypoint[] {
        SplinePointsLib.DCL,
        SplinePointsLib.DCL_Approach,
        new Waypoint(5.50, 6.00, Pathfinder.d2r(0)),
        SplinePointsLib.CSL1_Approach,
        SplinePointsLib.CSL1
      };
      return (Pathfinder.generate(points, config));
  }

  void generate () {
    segments.add (gen_DCL_CSL1());
    write();
  }
}