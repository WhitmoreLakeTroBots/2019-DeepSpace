package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

class Spline_StartCenterR_CSCR extends BaseAutonGenerator {

  Spline_StartCenterR_CSCR (Trajectory.Config conf) {
    this.config = conf;
    baseFileName = this.getClass().getSimpleName();
    gnuPlotString = "plot '%s' using 2:3 w lp lt rgb 'purple'";
  }

  private Trajectory gen_StartCenterR_CSCR() {
	  Waypoint[] points = new Waypoint[] {
        SplinePointsLib.startCenterR,
        SplinePointsLib.CSCR_Approach,
	    SplinePointsLib.CSCR
	  };
	    return (Pathfinder.generate(points, config));
    }

  void generate () {
    segments.add (gen_StartCenterR_CSCR());
    write();
  }
}
