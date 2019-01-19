package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

class Spline_CSCL_LSL extends BaseAutonGenerator {

  Spline_CSCL_LSL (Trajectory.Config conf) {
    this.config = conf;
    baseFileName = this.getClass().getSimpleName();
    gnuPlotString = "plot '%s' using 2:3 w lp lt rgb 'orange'";
  }

  protected Trajectory gen_CSCL_LSL(){
    Waypoint[] points = new Waypoint[] {
        SplinePointsLib.CSCL,
        SplinePointsLib.CSCL_Approach,
        new Waypoint(2.00, 7.00, Pathfinder.d2r(165)),
        SplinePointsLib.LSL_Approach,
        SplinePointsLib.LSL
      };
      return (Pathfinder.generate(points, config));
  }

  void generate () {
    segments.add (gen_CSCL_LSL());
    write();
  }
}
