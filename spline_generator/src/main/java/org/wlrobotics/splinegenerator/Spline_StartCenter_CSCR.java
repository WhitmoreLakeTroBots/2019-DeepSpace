package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

class Spline_StartCenter_CSCR extends BaseAutonGenerator {

  Spline_StartCenter_CSCR (Trajectory.Config conf) {
    this.config = conf;
    baseFileName = this.getClass().getSimpleName();
    gnuPlotString = "plot '%s' using 2:3 w lp lt rgb 'orange'";
  }

  private Trajectory gen_StartCenter_CSCR() {
	  Waypoint[] points = new Waypoint[] {
      SplinePointsLib.startCenter,
      SplinePointsLib.CSCR_Approach,
		  SplinePointsLib.CSCR
	  };
	    return (Pathfinder.generate(points, config));
    }

  void generate () {
    segments.add (gen_StartCenter_CSCR());
    write();
  }
}
