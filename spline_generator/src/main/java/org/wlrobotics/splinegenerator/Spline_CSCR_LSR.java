package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

class Spline_CSCR_LSR extends BaseAutonGenerator {

  Spline_CSCR_LSR (Trajectory.Config conf) {
    this.config = conf;
    baseFileName = this.getClass().getSimpleName();
    gnuPlotString = "plot '%s' using 2:3 w lp lt rgb 'gold'";
  }

  protected Trajectory gen_CSCR_LSR(){
    Waypoint[] points = new Waypoint[] {
        SplinePointsLib.CSCR,
        SplinePointsLib.CSCR_Approach,
        new Waypoint(2.00, 1.00, Pathfinder.d2r(195)),
        SplinePointsLib.LSR_Approach,
        SplinePointsLib.LSR
      };
      return (Pathfinder.generate(points, config));
  }

  void generate () {
    segments.add (gen_CSCR_LSR());
    write();
  }
}
