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
    private double numberOfMiliseconds;
    private double speed;
    public DriveForwardForTime(double numberOfSeconds, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Chassis.getInstance());
        numberOfMiliseconds = numberOfSeconds*1000;
        timer = new Timer();
        timer.stop();
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Chassis.getInstance().driveStraightAtSpeed(.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() >= numberOfMiliseconds;
    }

    // Called once after isFinished returns true
    protected void end() {
        Chassis.getInstance().driveStraightAtSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
