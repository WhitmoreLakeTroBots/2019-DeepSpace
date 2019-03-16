package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

class SplinePointsLib {
    //Robot Settings
    public static final double wheelbase_width = 0.7;

    //Start Locations
    public static final Waypoint startCenter = new Waypoint (1.40, 4.00, Pathfinder.d2r(0));
    public static final Waypoint startLeft = new Waypoint (1.40, 5.12, Pathfinder.d2r(0));
    public static final Waypoint startLeft2 = new Waypoint (0.28, 5.12, Pathfinder.d2r(0));
    public static final Waypoint startRight = new Waypoint (1.40, 2.88, Pathfinder.d2r(0));
    public static final Waypoint startRight2 = new Waypoint (0.28, 2.88, Pathfinder.d2r(0));

    //Cargo Ship Locations
    public static final Waypoint CSCL = new Waypoint(5.36, 4.25, Pathfinder.d2r(0));
    public static final Waypoint CSCL_Approach = new Waypoint (4.41, 4.25, Pathfinder.d2r(0));
    public static final Waypoint CSL1 = new Waypoint(6.66, 4.90, Pathfinder.d2r(90));
    public static final Waypoint CSL1_Approach = new Waypoint (6.66, 5.10, Pathfinder.d2r(90));
    public static final Waypoint CSL2 = new Waypoint(7.20, 4.90, Pathfinder.d2r(90));
    public static final Waypoint CSL2_Approach = new Waypoint (7.20, 5.10, Pathfinder.d2r(90));

    public static final Waypoint CSCR = new Waypoint(5.36, 3.75, Pathfinder.d2r(0));
    public static final Waypoint CSCR_Approach = new Waypoint (5.16, 3.75, Pathfinder.d2r(0));
    public static final Waypoint CSR1 = new Waypoint(6.66, 3.00, Pathfinder.d2r(90));
    public static final Waypoint CSR1_Appraoch = new Waypoint (6.66, 2.80, Pathfinder.d2r(90));
    public static final Waypoint CSR2 = new Waypoint(7.20, 3.00, Pathfinder.d2r(90));
    public static final Waypoint CSR2_Appraoch = new Waypoint (7.20, 2.80, Pathfinder.d2r(90));

    //Cargo Points
    public static final Waypoint DCL = new Waypoint(1.15, 6.15, Pathfinder.d2r(35));
    public static final Waypoint DCL_Approach = new Waypoint(1.65, 6.65, Pathfinder.d2r(35));
    public static final Waypoint DCR = new Waypoint(1.20, 1.75, Pathfinder.d2r(135));
    public static final Waypoint DCR_Approach = new Waypoint(1.65, 1.20, Pathfinder.d2r(140));

    //Loading Station
    public static final Waypoint LSL = new Waypoint(0.30, 7.37, Pathfinder.d2r(180));
    public static final Waypoint LSL_Approach = new Waypoint(0.50, 7.37, Pathfinder.d2r(180));
    public static final Waypoint LSR = new Waypoint(0.30, 0.66, Pathfinder.d2r(180));
    public static final Waypoint LSR_Approach = new Waypoint(0.50, 0.66, Pathfinder.d2r(180));
}