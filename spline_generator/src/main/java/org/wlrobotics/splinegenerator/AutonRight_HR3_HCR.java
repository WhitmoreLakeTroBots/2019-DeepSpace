package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

class AutonRight_HR3_HCR extends BaseAutonGenerator {

  AutonRight_HR3_HCR (Trajectory.Config conf) {
    this.config = conf;
    baseFileName = this.getClass().getSimpleName();
    gnuPlotString = "plot '%s' using 2:3 w lp lt rgb 'coral'";
  }

  private Trajectory gen_Auton_HR3_HCR_01() {
		Waypoint[] points = new Waypoint[] {
      new Waypoint(1.50, 3.00, Pathfinder.d2r(0)),
      new Waypoint(5.00, 2.00, Pathfinder.d2r(-25)),
      new Waypoint(6.25, 1.50, Pathfinder.d2r(0)),
      new Waypoint(7.75, 2.80, Pathfinder.d2r(90)),
      new Waypoint(7.75, 3.30, Pathfinder.d2r(90))
		};
		return (Pathfinder.generate(points, config));
    }

    private Trajectory gen_Auton_HR3_HCR_02(){
      Waypoint[] points = new Waypoint[] {
        new Waypoint(7.75, 3.30, Pathfinder.d2r(-90)),
        new Waypoint(7.75, 2.80, Pathfinder.d2r(-90)),
        new Waypoint(7.30, 1.60, Pathfinder.d2r(-160)),
        new Waypoint(0.45, 0.66, Pathfinder.d2r(180)),
        new Waypoint(0.00, 0.66, Pathfinder.d2r(180))
      };
      return (Pathfinder.generate(points, config));
    }

    private Trajectory gen_Auton_HR3_HCR_03(){
      Waypoint[] points = new Waypoint[] {
        new Waypoint(0.00, 0.66, Pathfinder.d2r(0)),
        new Waypoint(0.45, 0.66, Pathfinder.d2r(0)),
        new Waypoint(5.66, 3.75, Pathfinder.d2r(0))
      };
      return (Pathfinder.generate(points, config));
    }

    private Trajectory gen_Auton_HR3_HCR_04(){
      Waypoint[] points = new Waypoint[] {
        new Waypoint(5.66, 3.75, Pathfinder.d2r(180)),
        new Waypoint(0.45, 0.66, Pathfinder.d2r(180))
      };
      return (Pathfinder.generate(points, config));
    }

  void generate () {
    segments.add (gen_Auton_HR3_HCR_01());
    segments.add (gen_Auton_HR3_HCR_02());
    segments.add (gen_Auton_HR3_HCR_03());
    segments.add (gen_Auton_HR3_HCR_04());
    write();
  }
}
