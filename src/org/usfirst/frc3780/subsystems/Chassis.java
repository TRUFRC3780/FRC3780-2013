/* All FRC 3780 code follows the following License:
 * Copyright 2013 FRC 3780 (Brian Fogarty, Oliver Graff) Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may not use 
 * this file except in compliance with the License. You may obtain a copy of the
 * License at 
 *      http://www.osedu.org/licenses/ECL-2.0 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */

package org.usfirst.frc3780.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc3780.commands.DriveRobot;
import org.usfirst.frc3780.robot.RobotMap;

/**
 * The chassis subsystem.
 * @author Brian + Oliver
 */
public class Chassis extends Subsystem {
    
    private static Chassis __instance;
    private RobotDrive _drive;
    
    public static Chassis getInstance() {
        if(__instance == null) {
            try {
                __instance = new Chassis();
            } catch(CANTimeoutException exception) {
                System.out.println(exception.getMessage());
                System.out.println("CANTimeout Exception in Chassis getInstance()");
            }
        }
        return __instance;
    }
    
    
    private CANJaguar _frontLeftDrive;
    private CANJaguar _rearLeftDrive;
    private CANJaguar _frontRightDrive;
    private CANJaguar _rearRightDrive;
    
    public void arcadeDrive(Joystick j) {
        _drive.arcadeDrive(j);
    }
    
    public void arcadeDrive(double magnitude, double turn) {
        _drive.arcadeDrive(magnitude, turn);
    }
        
    private Chassis() throws CANTimeoutException {
        _frontLeftDrive = new CANJaguar(RobotMap.chassisFrontLeftDriveID);
        _rearLeftDrive = new CANJaguar(RobotMap.chassisRearLeftDriveID);
        _frontRightDrive = new CANJaguar(RobotMap.chassisFrontRightDriveID);
        _rearRightDrive = new CANJaguar(RobotMap.chassisRearRightDriveID);
        _drive = new RobotDrive(_frontLeftDrive, _rearLeftDrive, _frontRightDrive, _rearRightDrive);
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new DriveRobot());
    }
    public void driveStraightAtSpeed(double speed){
        _drive.setLeftRightMotorOutputs(speed, speed);
    }
    
}
