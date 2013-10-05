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

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc3780.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    private static OI __instance;
    
    public static OI getInstance() {
        if (__instance == null) {
            __instance = new OI();
        }
        return __instance;
    }
    
    //  Instantiate the joystick buttons.
    private final Joystick driveJoystick;
    private final Joystick operatorJoystick;
    private final Button blockerExtendPulleyButton;
    private final Button blockerRetractPulleyButton;
    private final Button blockerAbortPulleyButton;
    
    private OI() {
        
        driveJoystick = new Joystick(RobotMap.driveJoystickPort);
        operatorJoystick = new Joystick(RobotMap.operatorJoystickPort);
        
        blockerExtendPulleyButton = new JoystickButton(operatorJoystick, RobotMap.blockerExtendPulleyPort);
        blockerExtendPulleyButton.whenPressed(new TogglePulley(RobotMap.pulleyTime, Relay.Value.kForward));
        
        blockerRetractPulleyButton = new JoystickButton(operatorJoystick, RobotMap.blockerRetractPulleyPort);
        blockerRetractPulleyButton.whenPressed(new TogglePulley(RobotMap.pulleyTime, Relay.Value.kReverse));
        
        blockerAbortPulleyButton = new JoystickButton(operatorJoystick, RobotMap.blockerAbortPulleyPort);
        blockerAbortPulleyButton.whenPressed(new AbortPulley());
        
    }
    
    /**
     * Gets the drive joystick.
     * @return driveJoystick
     */
    public Joystick getDriveJoystick() {
        return driveJoystick;
    }
}

