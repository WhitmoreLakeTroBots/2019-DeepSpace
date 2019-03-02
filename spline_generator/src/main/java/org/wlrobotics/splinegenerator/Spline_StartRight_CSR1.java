package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

class Spline_StartRight_CSR1 extends BaseAutonGenerator {

    Spline_StartRight_CSR1 (Trajectory.Config conf) {
    this.config = conf;
    baseFileName = this.getClass().getSimpleName();
    gnuPlotString = "plot '%s' using 2:3 w lp lt rgb 'red'";
  }

  protected Trajectory gen_DCR_CSR1(){
    Waypoint[] points = new Waypoint[] {
        SplinePointsLib.startRight,
        new Waypoint(5.50, 2.00, Pathfinder.d2r(0)),
        SplinePointsLib.CSR1_Appraoch,
        SplinePointsLib.CSR1
      };
      return (Pathfinder.generate(points, config));
  }

  void generate () {
    segments.add (gen_DCR_CSR1());
    write();
  }
}