package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

class SplinePointsLib {
    //Start Locations
    public static final Waypoint startCenter = new Waypoint (1.50, 4.00, Pathfinder.d2r(0));
    public static final Waypoint startLeft = new Waypoint (1.50, 5.00, Pathfinder.d2r(0));
    public static final Waypoint startRight = new Waypoint (1.50, 3.00, Pathfinder.d2r(0));

    //Cargo Ship Locations
    public static final Waypoint CSCL = new Waypoint(5.66, 4.25, Pathfinder.d2r(0));
    public static final Waypoint CSCL_Approach = new Waypoint (5.46, 4.25, Pathfinder.d2r(0));
    public static final Waypoint CSL1 = new Waypoint(6.66, 4.60, Pathfinder.d2r(90));
    public static final Waypoint CSL1_Approach = new Waypoint (6.66, 4.80, Pathfinder.d2r(90));
    public static final Waypoint CSL2 = new Waypoint(7.20, 4.60, Pathfinder.d2r(90));
    public static final Waypoint CSL2_Approach = new Waypoint (7.20, 4.80, Pathfinder.d2r(90));
    public static final Waypoint CSL3 = new Waypoint(7.75, 4.60, Pathfinder.d2r(90));
    public static final Waypoint CSL3_Approach = new Waypoint (7.75, 4.80, Pathfinder.d2r(90));

    public static final Waypoint CSCR = new Waypoint(5.66, 3.75, Pathfinder.d2r(0));
    public static final Waypoint CSCR_Approach = new Waypoint (5.46, 3.75, Pathfinder.d2r(0));
    public static final Waypoint CSR1 = new Waypoint(6.66, 3.30, Pathfinder.d2r(90));
    public static final Waypoint CSR1_Appraoch = new Waypoint (6.66, 3.10, Pathfinder.d2r(90));
    public static final Waypoint CSR2 = new Waypoint(7.20, 3.30, Pathfinder.d2r(90));
    public static final Waypoint CSR2_Appraoch = new Waypoint (7.20, 3.10, Pathfinder.d2r(90));
    public static final Waypoint CSR3 = new Waypoint(7.75, 3.30, Pathfinder.d2r(90));
    public static final Waypoint CSR3_Appraoch = new Waypoint (7.75, 3.10, Pathfinder.d2r(90));

    //Cargo Points
    public static final Waypoint DCL = new Waypoint(1.00, 6.00, Pathfinder.d2r(180));
    public static final Waypoint DCL_Approach = new Waypoint(1.20, 6.00, Pathfinder.d2r(180));
    public static final Waypoint DCR = new Waypoint(1.00, 2.00, Pathfinder.d2r(180));
    public static final Waypoint DCR_Approach = new Waypoint(1.20, 2.00, Pathfinder.d2r(180));

    //Loading Station
    public static final Waypoint LSL = new Waypoint(0.00, 7.37, Pathfinder.d2r(180));
    public static final Waypoint LSL_Approach = new Waypoint(0.20, 7.37, Pathfinder.d2r(180));
    public static final Waypoint LSR = new Waypoint(0.00, 0.66, Pathfinder.d2r(180));
    public static final Waypoint LSR_Approach = new Waypoint(0.20, 0.66, Pathfinder.d2r(180));
}