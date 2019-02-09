package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

class Spline_test2 extends BaseAutonGenerator {

  Spline_test2 (Trajectory.Config conf) {
    this.config = conf;
    baseFileName = this.getClass().getSimpleName();
    gnuPlotString = "plot '%s' using 2:3 w lp lt rgb 'black'";
  }

  private Trajectory gen_test2_01() {
		Waypoint[] points = new Waypoint[] {
  //      new Waypoint(1.51, 3.13, Pathfinder.d2r(90)),
  //      new Waypoint(1.51, 2.50, Pathfinder.d2r(90)),
  //      new Waypoint(0.10, 0.40, Pathfinder.d2r(0)),
  //	    new Waypoint(0.00, 0.40, Pathfinder.d2r(0))
          new Waypoint(0.00, 0.00, Pathfinder.d2r(0)),
          new Waypoint(2.00, 2.00, Pathfinder.d2r(90))
    };
		return (Pathfinder.generate(points, config));
    }

    void generate () {
        segments.add (gen_test2_01());
        write();
      }
    }