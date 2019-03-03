package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

class Spline_StartRight2_CSR1 extends BaseAutonGenerator {

    Spline_StartRight2_CSR1 (Trajectory.Config conf) {
    this.config = conf;
    baseFileName = this.getClass().getSimpleName();
    gnuPlotString = "plot '%s' using 2:3 w lp lt rgb 'green'";
  }

  protected Trajectory gen_StartRight2_CSL1(){
    Waypoint[] points = new Waypoint[] {
        SplinePointsLib.startRight2,
        SplinePointsLib.startRight,
        new Waypoint(5.50, 2.00, Pathfinder.d2r(0)),
        SplinePointsLib.CSR1_Appraoch,
        SplinePointsLib.CSR1
      };
      return (Pathfinder.generate(points, config));
  }

  void generate () {
    segments.add (gen_StartRight2_CSL1());
    write();
  }
}