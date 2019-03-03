package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

class Spline_StartLeft2_CSL1 extends BaseAutonGenerator {

    Spline_StartLeft2_CSL1 (Trajectory.Config conf) {
    this.config = conf;
    baseFileName = this.getClass().getSimpleName();
    gnuPlotString = "plot '%s' using 2:3 w lp lt rgb 'blue'";
  }

  protected Trajectory StartLeft2_CSL1(){
    Waypoint[] points = new Waypoint[] {
        SplinePointsLib.startLeft2,
        SplinePointsLib.startLeft,
        new Waypoint(5.50, 6.00, Pathfinder.d2r(0)),
        SplinePointsLib.CSL1_Approach,
        SplinePointsLib.CSL1
      };
      return (Pathfinder.generate(points, config));
  }

  void generate () {
    segments.add (StartLeft2_CSL1());
    write();
  }
}