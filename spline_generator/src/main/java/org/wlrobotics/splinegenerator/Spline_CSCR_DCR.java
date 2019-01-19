package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

class Spline_CSCR_DCR extends BaseAutonGenerator {

  Spline_CSCR_DCR (Trajectory.Config conf) {
    this.config = conf;
    baseFileName = this.getClass().getSimpleName();
    gnuPlotString = "plot '%s' using 2:3 w lp lt rgb 'orange'";
  }

  protected Trajectory gen_CSCR_DCR(){
    Waypoint[] points = new Waypoint[] {
        SplinePointsLib.CSCR,
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
