/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.*;

import frc.robot.Constants;
import static frc.robot.utilities.Util.log;

/**
 * Add your docs here.
 */
public class Drive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  TalonSRX rightTalon = new TalonSRX(Constants.MAIN_RIGHT_TALON);
  TalonSRX leftTalon = new TalonSRX(Constants.MAIN_LEFT_TALON);

  TalonSRX rightTalon2 = new TalonSRX(Constants.FOL1_RIGHT_TALON);
  TalonSRX leftTalon2 = new TalonSRX(Constants.FOL1_LEFT_TALON);

  TalonSRX rightTalon3 = new TalonSRX(Constants.FOL2_RIGHT_TALON);
  TalonSRX leftTalon3 = new TalonSRX(Constants.FOL2_LEFT_TALON);

  Joystick rightJoy = new Joystick(Constants.RIGHT_JOYSTICK_PORT);
  Joystick leftJoy = new Joystick(Constants.LEFT_JOYSTICK_PORT);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

    rightTalon2.follow(rightTalon);
    rightTalon3.follow(rightTalon);
    leftTalon2.follow(leftTalon);
    leftTalon3.follow(leftTalon);

    //In the case it is needed, use the setInverted commands below to actually have the motors spin the right way
    /**
     * rightTalon.setInverted(true);
     * leftTalon.setInverted(true);
     * 
     * rightTalon2.setInverted(InvertedType.FollowMaster);
     * rightTalon3.setInverted(InvertedType.FollowMaster);
     * leftTalon2.setInverted(InvertedType.FollowMaster);
     * leftTalon3.setInverted(InvertedType.FollowMaster);
     */
  }

  public void setBoth(double rightVelocity, double leftVelocity) {
    if ((Math.abs(rightVelocity) < 1) && (Math.abs(leftVelocity) < 1)) {
      rightTalon.set(ControlMode.PercentOutput, rightVelocity);
      leftTalon.set(ControlMode.PercentOutput, leftVelocity);
    } else if ((Math.abs(rightVelocity) < Constants.JOYSTICK_MOTOR_STOP_POINT) && (Math.abs(leftVelocity) < Constants.JOYSTICK_MOTOR_STOP_POINT) {
      //This will set the velocity of the motors to 0 to stop the motors from moving when the joystick is at almost 0
      rightTalon.set(ControlMode.PercentOutput, 0);
      leftTalon.set(ControlMode.PercentOutput, 0);
    } else {
      log("Error: The velocity receieved by setBoth was too high/low. The velocity needs to be between -1 and 1. Right velocity received: " + rightVelocity + ", left velocity received: " + leftVelocity);
    }
  }
}
