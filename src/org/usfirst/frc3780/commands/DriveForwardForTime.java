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
package org.usfirst.frc3780.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3780.subsystems.Chassis;

/**
 *
 * @author ograff
 */
public class DriveForwardForTime extends Command{
    
    private Timer timer;
    private double numberOfSeconds;
    private double speed;
    
    public DriveForwardForTime(double numberOfSeconds, double speed) {

        requires(Chassis.getInstance());
        this.numberOfSeconds = numberOfSeconds;
        timer = new Timer();
        timer.stop();
        this.speed = speed;
        
    }

    protected void initialize() {
        timer.start();
    }

    protected void execute() {
        Chassis.getInstance().driveStraightAtSpeed(speed);
    }

    protected boolean isFinished() {
        // System.out.println(timer.get());
        return timer.get() >= numberOfSeconds;
    }

    protected void end() {
        Chassis.getInstance().driveStraightAtSpeed(0);
    }

    protected void interrupted() {
    }
    
}
