package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

class Spline_LSR_CSCL extends BaseAutonGenerator {

  Spline_LSR_CSCL (Trajectory.Config conf) {
    this.config = conf;
    baseFileName = this.getClass().getSimpleName();
    gnuPlotString = "plot '%s' using 2:3 w lp lt rgb 'green'";
  }

  protected Trajectory gen_LSR_CSCL(){
    Waypoint[] points = new Waypoint[] {
        SplinePointsLib.LSR,
        SplinePointsLib.LSR_Approach,
        new Waypoint(2.00, 1.00, Pathfinder.d2r(15)),
        SplinePointsLib.CSCL_Approach,
        SplinePointsLib.CSCL
      };
      return (Pathfinder.generate(points, config));
  }

  void generate () {
    segments.add (gen_LSR_CSCL());
    write();
  }
}
