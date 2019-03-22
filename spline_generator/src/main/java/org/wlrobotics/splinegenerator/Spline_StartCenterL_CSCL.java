package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

class Spline_StartCenterL_CSCL extends BaseAutonGenerator {

    Spline_StartCenterL_CSCL(Trajectory.Config conf) {
        this.config = conf;
        baseFileName = this.getClass().getSimpleName();
        gnuPlotString = "plot '%s' using 2:3 w lp lt rgb 'purple'";
    }

    private Trajectory gen_StartCenterL_CSCL() {
        Waypoint[] points = new Waypoint[] { 
            SplinePointsLib.startCenterL, 
            SplinePointsLib.CSCL_Approach,
            SplinePointsLib.CSCL };
        return (Pathfinder.generate(points, config));
    }

    void generate() {
        segments.add(gen_StartCenterL_CSCL());
        write();
    }
}
