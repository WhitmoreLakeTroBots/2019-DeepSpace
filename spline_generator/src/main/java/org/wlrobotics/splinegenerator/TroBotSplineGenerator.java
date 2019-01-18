package org.wlrobotics.splinegenerator;

import jaci.pathfinder.Trajectory;

public class TroBotSplineGenerator extends Object {

	static final double deltaTime = 0.02;
	static final double maxJerk   = 5.00;
	static final double maxVel    = 3.25;
	static final double maxAccel  = 3.00;
	public static void main(String[] args) {
		
		Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC,
				Trajectory.Config.SAMPLES_HIGH, deltaTime, maxVel, maxAccel, maxJerk);

		AutonCenter_HCL_CL3 HCL_CL3 = new AutonCenter_HCL_CL3(config);
		//HCL_CL3.generate();
		HCL_CL3 = null;

		AutonCenter_HCR_CR3 HCR_CR3 = new AutonCenter_HCR_CR3(config);
		//HCR_CR3.generate();
		HCR_CR3 = null;

		AutonRight_HR1_HCR HR1_HCR = new AutonRight_HR1_HCR(config);
		//HR1_HCR.generate();
		HR1_HCR = null;

		AutonLeft_HL1_HCL HL1_HCL = new AutonLeft_HL1_HCL(config);
		//HL1_HCL.generate();
		HL1_HCL = null;

		AutonCenter_HCR_CR2 HCR_CR2 = new AutonCenter_HCR_CR2(config);
		HCR_CR2.generate();
		HCR_CR2 = null;

		AutonCenter_HCL_CR2 HCL_CR2 = new AutonCenter_HCL_CR2(config);
		HCL_CR2.generate();
		HCL_CR2 = null;

		AutonRight_HR2_HCR HR2_HCR = new AutonRight_HR2_HCR(config);
		//HR2_HCR.generate();
		HR2_HCR = null;


		test test = new test(config);
		//test.generate();
		test = null;

		AutonRight_HR3_HCR HR3_HCR = new AutonRight_HR3_HCR(config);
		//HR3_HCR.generate();
		HR3_HCR = null;

		AutonLeft_HL3_HCL HL3_HLR = new AutonLeft_HL3_HCL(config);
		//HL3_HLR.generate();
		HL3_HLR = null;

		AutonLeft_HL2_HCL HL2_HLR = new AutonLeft_HL2_HCL(config);
		//HL2_HLR.generate();
		HL2_HLR = null;

		System.out.println("TroBot Splines Generation: Complete");
	}
}
