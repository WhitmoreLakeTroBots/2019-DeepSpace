package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Trajectory;

import org.wlrobotics.splinegenerator.*;

public class TroBotSplineGenerator extends Object {

	static final double deltaTime = 0.02;
	static final double maxJerk   = 5.00;
	static final double maxVel    = 3.25;
	static final double maxAccel  = 3.00;
	public static void main(String[] args) {
		
		Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC,
				Trajectory.Config.SAMPLES_HIGH, deltaTime, maxVel, maxAccel, maxJerk);


		Spline_StartCenter_CSCL startCenter_CSCL = new Spline_StartCenter_CSCL(config);
		startCenter_CSCL.generate();
		startCenter_CSCL = null;

		Spline_StartCenter_CSCR startCenter_CSCR = new Spline_StartCenter_CSCR(config);
		startCenter_CSCR.generate();
		startCenter_CSCR = null;

		Spline_CSCL_DCL CSCL_DCL = new Spline_CSCL_DCL(config);
		CSCL_DCL.generate();
		CSCL_DCL = null;
		
		Spline_CSCL_LSL CSCL_LSL = new Spline_CSCL_LSL(config);
		CSCL_LSL.generate();
		CSCL_LSL = null;

		Spline_CSCR_DCR CSCR_DCR = new Spline_CSCR_DCR(config);
		CSCR_DCR.generate();
		CSCR_DCR = null;

		Spline_CSCR_LSR CSCR_LSR = new Spline_CSCR_LSR(config);
		CSCR_LSR.generate();
		CSCR_LSR = null;

		Spline_DCL_CSL1 DCL_CSL1 = new Spline_DCL_CSL1(config);
		DCL_CSL1.generate();
		DCL_CSL1 = null; 

		Spline_DCL_CSL2 DCL_CSL2 = new Spline_DCL_CSL2(config);
		DCL_CSL2.generate();
		DCL_CSL2 = null;

		Spline_DCL_CSL3 DCL_CSL3 = new Spline_DCL_CSL3(config);
		DCL_CSL3.generate();
		DCL_CSL3 = null;

		Spline_DCR_CSR1 DCR_CSR1 = new Spline_DCR_CSR1(config);
		DCR_CSR1.generate();
		DCR_CSR1 = null; 

		Spline_DCR_CSR2 DCR_CSR2 = new Spline_DCR_CSR2(config);
		DCR_CSR2.generate();
		DCR_CSR2 = null;

		Spline_DCR_CSR3 DCR_CSR3 = new Spline_DCR_CSR3(config);
		DCR_CSR3.generate();
		DCR_CSR3 = null;

		Spline_LSL_CSCL LSL_CSCL = new Spline_LSL_CSCL(config);
		LSL_CSCL.generate();
		LSL_CSCL = null;

		Spline_LSL_CSCR LSL_CSCR = new Spline_LSL_CSCR(config);
		LSL_CSCR.generate();
		LSL_CSCR = null;

		Spline_LSR_CSCL LSR_CSCL = new Spline_LSR_CSCL(config);
		LSR_CSCL.generate();
		LSR_CSCL = null;

		Spline_LSR_CSCR LSR_CSCR = new Spline_LSR_CSCR(config);
		LSR_CSCR.generate();
		LSR_CSCR = null;

		test test = new test(config);
		//test.generate();
		test = null;

		System.out.println("TroBot Splines Generation: Complete");
	}
}
