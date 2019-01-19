package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

class Spline_LSL_CSCR extends BaseAutonGenerator {

  Spline_LSL_CSCR (Trajectory.Config conf) {
    this.config = conf;
    baseFileName = this.getClass().getSimpleName();
    gnuPlotString = "plot '%s' using 2:3 w lp lt rgb 'orange'";
  }

  protected Trajectory gen_LSL_CSCR(){
    Waypoint[] points = new Waypoint[] {
        SplinePointsLib.LSL,
        SplinePointsLib.LSL_Approach,
        new Waypoint(2.00, 7.00, Pathfinder.d2r(-15)),
        SplinePointsLib.CSCR_Approach,
        SplinePointsLib.CSCR,
      };
      return (Pathfinder.generate(points, config));
  }

  void generate () {
    segments.add (gen_LSL_CSCR());
    write();
  }
}
