package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Settings;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class cmdGroupAutoTemplate extends CommandGroup {

    public cmdGroupAutoTemplate(Settings.actions[] action, String [] parameters){
        System.err.println("Spline Files: " + parameters[0] + ", " + parameters[1] + ", " + parameters[2]);
        System.err.println("Actions: " + action[0] + ", " + action[1] + ", " + action[2]);
        for(int i = 0; i <= action.length - 1; i++){
             if(action[i] == Settings.actions.moveArm){
                addSequential(new cmdSwing(parameters[i]));
             } else if (action[i] == Settings.actions.placeHatch){
                addSequential(new cmdGroupPlaceHatch(parameters[i]));
             } else if (action[i] == Settings.actions.placeCargo){
                addSequential(new cmdGroupPlaceCargo(parameters[i]));
             } else if (action[i] == Settings.actions.invertDrive){
                addSequential(new cmdInvertDriveAuto());
             } else if (action[i] == Settings.actions.splineOmni){
                addSequential(new cmdSplineBenderOmni(parameters[i]));
             } else if (action[i] == Settings.actions.splineTrac){
                addSequential(new cmdSplineFollowerTrac(parameters[i]));
             }else if (action[i] == Settings.actions.switchPipelines){
                addSequential(new cmdSwitchLLVision(parameters[i]));
             }
        }
        addSequential(new cmdSwitchLLVision(Settings.llProcess));
    }
}