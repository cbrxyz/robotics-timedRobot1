/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.*;

/**
 * Add your docs here.
 */
public class Drive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  TalonSRX rightTalon = new TalonSRX(0);
  TalonSRX leftTalon = new TalonSRX(1);

  TalonSRX rightTalon2 = new TalonSRX(2);
  TalonSRX leftTalon2 = new TalonSRX(3);

  TalonSRX rightTalon3 = new TalonSRX(4);
  TalonSRX leftTalon3 = new TalonSRX(5);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    rightTalon.setOutput(ControlMode.PercentOutput, 0);
    leftTalon.setOutput(ControlMode.PercentOutput, 0);

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
}
