/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.components.factory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.Constants;
import static frc.robot.utilities.Util.log;

/**
 * Add your docs here.
 */
public class RobotConfigurationFactory extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private static int readFileIndentification() {
    BufferedReader bufferedReader = null;
    try {
      File file = new File(Constants.ROBOT_IDENTIFICATION_PATH);
      if (file.exists()) {
        if (!file.isFile()) {
          log("Error: " + Constants.ROBOT_IDENTIFICATION_PATH + " is not a file!");
          return -1;
        }
        bufferedReader = new BufferedReader(new FileReader(file));
        return Integer.parseInt(bufferedReader.readLine());
      } else
        log(file.getAbsolutePath() + "does not exist");
    } catch (IOException | NumberFormatException e) {
      log("Error reading robot ID file: " + e);
    } finally {
      if (bufferedReader != null)
        try {
          bufferedReader.close();
        } catch (IOException e) {
          log("Error closing buffered reader:" + e);
        }
    }
    return -1;
  }

  public static RobotConfigurationFactory getFactory() {
    int type = readFileIdentification();
    if (type == -1) {
      log("Error when attempting to identify robot type through its files.");
    }

    switch (type) {
      case 0:
        log("Robot identified as the competition robot.");
        return new CompetitionConfiguration();
      case 1:
        log("Robot identified as the sibling robot.")
        return new SiblingConfiguration();
      case 2:
        log("Robot identified as a mini robot.")
        return new MiniConfiguration();
      case -1:
        log("The type could not be identified. Sorry. :(");
        return;
    }
  }

  @Override
  protected void initDefaultCommand() {

  }
}
