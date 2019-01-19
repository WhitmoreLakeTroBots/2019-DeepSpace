package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

class Spline_StartCenter_CSCL extends BaseAutonGenerator {

  Spline_StartCenter_CSCL (Trajectory.Config conf) {
    this.config = conf;
    baseFileName = this.getClass().getSimpleName();
    gnuPlotString = "plot '%s' using 2:3 w lp lt rgb 'orange'";
  }

  private Trajectory gen_StartCenter_CSCL() {
	  Waypoint[] points = new Waypoint[] {
        SplinePointsLib.startCenter,
        SplinePointsLib.CSCL_Approach,
		SplinePointsLib.CSCL
	  };
	return (Pathfinder.generate(points, config));
    }

  void generate () {
    segments.add (gen_StartCenter_CSCL());
    write();
  }
}
