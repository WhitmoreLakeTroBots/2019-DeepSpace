package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

class AutonCenter_HCR_CR2 extends BaseAutonGenerator {

AutonCenter_HCR_CR2 (Trajectory.Config conf) {
    this.config = conf;
    baseFileName = this.getClass().getSimpleName();
    gnuPlotString = "plot '%s' using 2:3 w lp lt rgb 'orchid'";
  }

  private Trajectory gen_Auton_HCR_CR2_01() {
	Waypoint[] points = new Waypoint[] {
		new Waypoint(1.50, 4.00, Pathfinder.d2r(0)),
		new Waypoint(5.66, 3.75, Pathfinder.d2r(0))
	  };
	  return (Pathfinder.generate(points, config));
    }

    private Trajectory gen_Auton_HCR_CR2_02(){
      Waypoint[] points = new Waypoint[] {
        new Waypoint(5.66, 3.75, Pathfinder.d2r(180)),
        new Waypoint(1.00, 2.00, Pathfinder.d2r(180))
      };
      return (Pathfinder.generate(points, config));
    }

    private Trajectory gen_Auton_HCR_CR2_03(){
      Waypoint[] points = new Waypoint[] {
        new Waypoint(1.00, 2.00, 0),
        new Waypoint(3.00, 2.00, 0),
        new Waypoint(6.50, 2.00, Pathfinder.d2r(0)),
        new Waypoint(7.18, 2.80, Pathfinder.d2r(-90)),
        new Waypoint(7.18, 3.33, Pathfinder.d2r(-90))
      };
      return (Pathfinder.generate(points, config));
    }

  void generate () {
    segments.add (gen_Auton_HCR_CR2_01());
    segments.add (gen_Auton_HCR_CR2_02());
    segments.add (gen_Auton_HCR_CR2_03());
    write();
  }
}
