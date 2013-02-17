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

package org.usfirst.frc3780.robot;

import edu.wpi.first.wpilibj.*;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    //    Solenoids
    final public static int jesusFrontModule = 1;
    final public static int jesusFrontForwardPort = 1;
    final public static int jesusFrontReversePort = 2;
    
    final public static int jesusBackModule = 1;
    final public static int jesusBackForwardPort = 7;
    final public static int jesusBackReversePort = 8;
    
    //    Drive
    final public static int chassisFrontLeftDriveID = 2;
    final public static int chassisRearLeftDriveID = 3;
    final public static int chassisFrontRightDriveID = 4;
    final public static int chassisRearRightDriveID = 5;
    
    //    Compressor
    final public static int compressorRelayChannel = 1;
    final public static int compressorPressureSwitchChannel = 2;
    
    //    Servo
    final public static int walleServoSlot = 1;
    final public static int walleServoChannel = 1;
    
    //    Joystick
    final public static int driveJoystickPort = 1;
    final public static int walleButtonPort = 3;
    
}
