package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

class Spline_DCR_CSR2 extends BaseAutonGenerator {

  Spline_DCR_CSR2 (Trajectory.Config conf) {
    this.config = conf;
    baseFileName = this.getClass().getSimpleName();
    gnuPlotString = "plot '%s' using 2:3 w lp lt rgb 'orange'";
  }

  protected Trajectory gen_DCR_CSR2(){
    Waypoint[] points = new Waypoint[] {
        SplinePointsLib.DCR,
        SplinePointsLib.DCR_Approach,
        new Waypoint(6.00, 2.00, Pathfinder.d2r(0)),
        SplinePointsLib.CSR2_Appraoch,
        SplinePointsLib.CSR2
      };
      return (Pathfinder.generate(points, config));
  }

  void generate () {
    segments.add (gen_DCR_CSR2());
    write();
  }
}