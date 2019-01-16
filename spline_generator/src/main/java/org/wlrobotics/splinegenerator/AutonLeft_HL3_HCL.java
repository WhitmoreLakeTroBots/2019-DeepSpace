package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

class AutonLeft_HL3_HCL extends BaseAutonGenerator {

  AutonLeft_HL3_HCL (Trajectory.Config conf) {
    this.config = conf;
    baseFileName = this.getClass().getSimpleName();
    gnuPlotString = "plot '%s' using 2:3 w lp lt rgb 'steelblue'";
  }

  private Trajectory gen_Auton_HL3_HCL_01() {
		Waypoint[] points = new Waypoint[] {
      new Waypoint(1.50, 5.00, Pathfinder.d2r(0)),
      new Waypoint(5.00, 6.00, Pathfinder.d2r(-25)),
      new Waypoint(6.25, 7.50, Pathfinder.d2r(0)),
      new Waypoint(7.75, 6.80, Pathfinder.d2r(90)),
      new Waypoint(7.75, 5.30, Pathfinder.d2r(90))
		};
		return (Pathfinder.generate(points, config));
    }

    private Trajectory gen_Auton_HL3_HCL_02(){
      Waypoint[] points = new Waypoint[] {
        new Waypoint(7.75, 5.30, Pathfinder.d2r(-90)),
        new Waypoint(7.75, 6.80, Pathfinder.d2r(-90)),
        new Waypoint(7.30, 7.60, Pathfinder.d2r(-160)),
        new Waypoint(0.45, 8.66, Pathfinder.d2r(180)),
        new Waypoint(0.00, 8.66, Pathfinder.d2r(180))
      };
      return (Pathfinder.generate(points, config));
    }

    private Trajectory gen_Auton_HL3_HCL_03(){
      Waypoint[] points = new Waypoint[] {
        new Waypoint(0.00, 8.66, Pathfinder.d2r(0)),
        new Waypoint(0.45, 8.66, Pathfinder.d2r(0)),
        new Waypoint(5.66, 5.75, Pathfinder.d2r(0))
      };
      return (Pathfinder.generate(points, config));
    }

    private Trajectory gen_Auton_HL3_HCL_04(){
      Waypoint[] points = new Waypoint[] {
        new Waypoint(5.66, 5.75, Pathfinder.d2r(180)),
        new Waypoint(0.45, 8.66, Pathfinder.d2r(180))
      };
      return (Pathfinder.generate(points, config));
    }

  void generate () {
    segments.add (gen_Auton_HL3_HCL_01());
    segments.add (gen_Auton_HL3_HCL_02());
    segments.add (gen_Auton_HL3_HCL_03());
    segments.add (gen_Auton_HL3_HCL_04());
    write();
  }
}
