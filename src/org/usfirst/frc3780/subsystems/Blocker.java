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

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc3780.robot.RobotMap;

/**
 *
 * @author Brian
 */
public class Blocker extends Subsystem {

    private static Blocker __instance;
    
    public static Blocker getInstance() {
        if(__instance == null) {
            __instance = new Blocker();
        }
        return __instance;
    }
    
    private Relay _relay;
    
    private Blocker() {
        _relay = new Relay(RobotMap.blockerServoSlot, RobotMap.blockerServoChannel);
    }
            
    public void runCIM(Relay.Value direction) {
        _relay.set(direction);
    }
    
    public Relay.Value PulleyState() {
        return _relay.get();
    }
    
    public void initDefaultCommand() {
    }
}