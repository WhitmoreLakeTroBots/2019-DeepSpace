package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Trajectory;

public class TroBotSplineGenerator extends Object {

	static final double deltaTime = 0.02;
	static final double maxJerk   = 5.00;
	static final double maxVel    = 3.00;
	static final double maxAccel  = 3.00;
	public static void main(String[] args) {
		
		Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC,
				Trajectory.Config.SAMPLES_HIGH, deltaTime, maxVel, maxAccel, maxJerk);


		Spline_StartCenter_CSCL startCenter_CSCL = new Spline_StartCenter_CSCL(config);
		startCenter_CSCL.generate();
		startCenter_CSCL = null;

		Spline_StartCenterL_CSCL startCenterL_CSCL = new Spline_StartCenterL_CSCL(config);
		startCenterL_CSCL.generate();
		startCenterL_CSCL = null;

		Spline_StartCenter_CSCR startCenter_CSCR = new Spline_StartCenter_CSCR(config);
		startCenter_CSCR.generate();
		startCenter_CSCR = null;

		Spline_StartCenterR_CSCR startCenterR_CSCR = new Spline_StartCenterR_CSCR(config);
		startCenterR_CSCR.generate();
		startCenterR_CSCR = null;

		Spline_StartLeft_CSL1 startLeft_CSL1 = new Spline_StartLeft_CSL1(config);
		startLeft_CSL1.generate();
		startLeft_CSL1 = null;

		Spline_StartLeft2_CSL1 startLeft2_CSL1 = new Spline_StartLeft2_CSL1(config);
		startLeft2_CSL1.generate();
		startLeft2_CSL1 = null;

		Spline_StartRight_CSR1 startRight_CSR1 = new Spline_StartRight_CSR1(config);
		startRight_CSR1.generate();
		startRight_CSR1 = null;

		Spline_StartRight2_CSR1 startRight2_CSR1 = new Spline_StartRight2_CSR1(config);
		startRight2_CSR1.generate();
		startRight2_CSR1 = null;

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

		Spline_DCL_CSL2 DCL_CSL2 = new Spline_DCL_CSL2(config);
		DCL_CSL2.generate();
		DCL_CSL2 = null;

		Spline_CSL1_DCL CSL1_DCL = new Spline_CSL1_DCL(config);
		CSL1_DCL.generate();
		CSL1_DCL = null; 

		Spline_CSR1_DCR CSR1_DCR = new Spline_CSR1_DCR(config);
		CSR1_DCR.generate();
		CSR1_DCR = null; 

		Spline_DCR_CSR2 DCR_CSR2 = new Spline_DCR_CSR2(config);
		DCR_CSR2.generate();
		DCR_CSR2 = null;

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

		Spline_test test = new Spline_test(config);
		//test.generate();
		test = null;

		config.max_velocity = 3;
		config.max_acceleration = 2.5;
		config.max_jerk = 8;
		Spline_test2 test2 = new Spline_test2(config);
		test2.generate();
		test2 = null;

		Spline_BendTest bend = new Spline_BendTest(config);
		//bend.generate();
		bend = null;
		
		System.out.println("TroBot Splines Generation: Complete");
	}
}
