package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

class Spline_BendTest extends BaseAutonGenerator {

  Spline_BendTest (Trajectory.Config conf) {
    this.config = conf;
    baseFileName = this.getClass().getSimpleName();
    gnuPlotString = "plot '%s' using 2:3 w lp lt rgb 'black'";
  }

  private Trajectory gen_test_01() {
		Waypoint[] points = new Waypoint[] {
        new Waypoint(0.00, 0.00, Pathfinder.d2r(0)),
        new Waypoint(3.20, 0.00, Pathfinder.d2r(0))
		};
		return (Pathfinder.generate(points, config));
    }

    void generate () {
        segments.add (gen_test_01());
        write();
      }
    }