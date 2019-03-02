package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

class Spline_CSR1_DCR extends BaseAutonGenerator {

  Spline_CSR1_DCR (Trajectory.Config conf) {
    this.config = conf;
    baseFileName = this.getClass().getSimpleName();
    gnuPlotString = "plot '%s' using 2:3 w lp lt rgb 'orange'";
  }

  protected Trajectory gen_DCR_CSR2(){
    Waypoint[] points = new Waypoint[] {
        SplinePointsLib.CSR1,
        SplinePointsLib.CSR1_Appraoch,
        new Waypoint(6.00, 2.30, Pathfinder.d2r(20)),
        SplinePointsLib.DCR_Approach,
        SplinePointsLib.DCR,
      };
      return (Pathfinder.generate(points, config));
  }

  void generate () {
    segments.add (gen_DCR_CSR2());
    write();
  }
}