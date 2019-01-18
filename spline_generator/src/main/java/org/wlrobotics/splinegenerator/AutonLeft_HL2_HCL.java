package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

class AutonLeft_HL2_HCL extends BaseAutonGenerator {

  AutonLeft_HL2_HCL (Trajectory.Config conf) {
    this.config = conf;
    baseFileName = this.getClass().getSimpleName();
    gnuPlotString = "plot '%s' using 2:3 w lp lt rgb 'gray'";
  }

  private Trajectory gen_Auton_HL2_HCL_01() {
		Waypoint[] points = new Waypoint[] {
      new Waypoint(1.50, 5.00, Pathfinder.d2r(0)),
      new Waypoint(5.00, 6.00, Pathfinder.d2r(25)),
      new Waypoint(7.20, 4.60, Pathfinder.d2r(90))
		};
		return (Pathfinder.generate(points, config));
    }

    private Trajectory gen_Auton_HL2_HCL_02(){
      Waypoint[] points = new Waypoint[] {
        new Waypoint(7.20, 4.60, Pathfinder.d2r(90)),
        new Waypoint(4.75, 6.70, Pathfinder.d2r(160)),
        new Waypoint(0.45, 7.37, Pathfinder.d2r(-180)),
        new Waypoint(0.00, 7.37, Pathfinder.d2r(-180))
      };
      return (Pathfinder.generate(points, config));
    }

    private Trajectory gen_Auton_HL2_HCL_03(){
      Waypoint[] points = new Waypoint[] {
        new Waypoint(0.00, 7.37, Pathfinder.d2r(0)),
        new Waypoint(0.45, 7.37, Pathfinder.d2r(0)),
        new Waypoint(5.66, 4.25, Pathfinder.d2r(0))
      };
      return (Pathfinder.generate(points, config));
    }

  void generate () {
    segments.add (gen_Auton_HL2_HCL_01());
    segments.add (gen_Auton_HL2_HCL_02());
    segments.add (gen_Auton_HL2_HCL_03());
    write();
  }
}
