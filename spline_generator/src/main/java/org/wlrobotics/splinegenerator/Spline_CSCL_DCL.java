package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

import org.wlrobotics.splinegenerator.*;

class Spline_CSCL_DCL extends BaseAutonGenerator {

  Spline_CSCL_DCL (Trajectory.Config conf) {
    this.config = conf;
    baseFileName = this.getClass().getSimpleName();
    gnuPlotString = "plot '%s' using 2:3 w lp lt rgb 'orange'";
  }

  protected Trajectory gen_CSCL_DCL(){
    Waypoint[] points = new Waypoint[] {
        SplinePointsLib.CSCL,
        SplinePointsLib.DCL_Approach,
        SplinePointsLib.DCL
      };
      return (Pathfinder.generate(points, config));
  }

  void generate () {
    segments.add (gen_CSCL_DCL());
    write();
  }
}