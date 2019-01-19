package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Settings;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class cmdGroupAutoTemplate extends CommandGroup {

    public cmdGroupAutoTemplate(Settings.actions [] actions, String [] parameters, boolean [] sque){
        for(int i = 0; i <= actions.length; i++){
            if(actions[i] == Settings.actions.moveArm){
                if(sque[i]){
                    addSequential(new cmdMoveArm(parameters[i]));
                } else {
                    addParallel(new cmdMoveArm(parameters[i]));
                }
            } else if (actions[i] == Settings.actions.placeHatch){
                if(sque[i]){
                    addSequential(new cmdGroupPlaceHatch(parameters[i]));
                } else {
                    addParallel(new cmdGroupPlaceHatch(parameters[i]));
                }
            } else if (actions[i] == Settings.actions.placeCargo){
                if(sque[i]){
                    addSequential(new cmdGroupPlaceCargo(parameters[i]));
                } else {
                    addParallel(new cmdGroupPlaceCargo(parameters[i]));
                }
            } else if (actions[i] == Settings.actions.invertDrive){
                if(sque[i]){
                    addSequential(new cmdInvertDriveAuto());
                } else {
                    addParallel(new cmdInvertDriveAuto());
                }
            } else if (actions[i] == Settings.actions.spline){
                if(sque[i]){
                    addSequential(new cmdSplineFollower(parameters[i]));
                } else {
                    addParallel(new cmdSplineFollower(parameters[i]));
                }
            }
        }
    }
}