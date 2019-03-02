package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

class Spline_CSCR_DCR extends BaseAutonGenerator {

  Spline_CSCR_DCR (Trajectory.Config conf) {
    this.config = conf;
    baseFileName = this.getClass().getSimpleName();
    gnuPlotString = "plot '%s' using 2:3 w lp lt rgb 'gold'";
  }

  protected Trajectory gen_CSCR_DCR(){
    Waypoint[] points = new Waypoint[] {
        SplinePointsLib.CSCR,
        new Waypoint(3.50, 1.40, 120),
        SplinePointsLib.DCR_Approach,
        SplinePointsLib.DCR
      };
      return (Pathfinder.generate(points, config));
  }

  void generate () {
    segments.add (gen_CSCR_DCR());
    write();
  }
}
