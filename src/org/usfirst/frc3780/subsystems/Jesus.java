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
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc3780.robot.RobotMap;

/**
 *
 * @author Brian
 */
public class Jesus extends Subsystem {

    public static class State {

        /**
         * The integer value representing this enumeration
         */
        public final int state;
        static final int kRetracted_val = 0;
        static final int kRearExtended_val = 1;
        static final int kBothExtended_val = 2;
        
        /**
         * state Retracted
         */
        public static final State kRetracted = new State(kRetracted_val);
        
        /**
         * state Rear Extended
         */
        public static final State kRearExtended = new State(kRearExtended_val);
        
        /**
         * state BothExtended
         */
        public static final State kBothExtended = new State(kBothExtended_val);

        private State(int state) {
            this.state = state;
        }
    }
    
    private DoubleSolenoid _front;
    private DoubleSolenoid _back;
    
    private static Jesus __instance;
    private State _currentState;
    
    public static Jesus getInstance() {
        if (__instance == null) {
            __instance = new Jesus();
        }
        return __instance;
    }
    
    /**
     * Set the state of Jesus.
     * @param state
     */
    public void setState(State state) {
        _currentState = state;
        if (state == State.kBothExtended) {
            extendFront();
            extendRear();
        } else if (state == State.kRearExtended) {
            retractFront();
            extendRear();
        } else {
            retractFront();
            retractRear();
        }
    }
    
    /**
     * Gets the current state of Jesus.
     * @return State of Jesus.
     */
    public State getState() {
        return _currentState;
    }
    
    private Jesus() {
        _front = new DoubleSolenoid(RobotMap.jesusFrontModule, RobotMap.jesusFrontForwardPort, RobotMap.jesusFrontReversePort);
        _back = new DoubleSolenoid(RobotMap.jesusBackModule, RobotMap.jesusBackForwardPort, RobotMap.jesusBackReversePort);
    }
    
    public void extendFront() {
        _front.set(DoubleSolenoid.Value.kForward);
    }
    
    public void extendRear() {
        _back.set(DoubleSolenoid.Value.kForward);
    }
    
    public void retractFront() {
        _front.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void retractRear() {
        _back.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void initDefaultCommand() {
    }
}
