package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

class Spline_DCL_CSL2 extends BaseAutonGenerator {

  Spline_DCL_CSL2 (Trajectory.Config conf) {
    this.config = conf;
    baseFileName = this.getClass().getSimpleName();
    gnuPlotString = "plot '%s' using 2:3 w lp lt rgb 'brown'";
  }

  protected Trajectory gen_DCL_CSL2(){
    Waypoint[] points = new Waypoint[] {
        SplinePointsLib.DCL,
        SplinePointsLib.DCL_Approach,
        new Waypoint(6.00, 6.00, Pathfinder.d2r(0)),
        SplinePointsLib.CSL2_Approach,
        SplinePointsLib.CSL2
      };
      return (Pathfinder.generate(points, config));
  }

  void generate () {
    segments.add (gen_DCL_CSL2());
    write();
  }
}