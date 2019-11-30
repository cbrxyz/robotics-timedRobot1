package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;
import static frc.robot.utilities.Util.log;

public class DriveStraight extends Command {
    
    /*
    public void DriveStraightInfo() {
        requires(Robot.drive);

    }
    */

    protected void initialize() {
        Robot.drive.setBoth(0, 0);
    }

    protected void execute() {
        double rightJoyYVal = Robot.rightJoy.getY();
        double leftJoyYVal = Robot.leftJoy.getY();
        Robot.drive.setBoth(rightJoyYVal, leftJoyYVal);
    }

    protected boolean isFinished() {
        return false;
        //This program is just supposed to always allow joysticks to control the robot! It should never turn off!
    }

    protected void end() {
        log("SERIOUS ERROR: Somehow the DriveStraight command ended.");
    }
    
    protected void interrupted() {
        log("The DriveStraight command was interrupted.");
    }
}