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

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc3780.robot.RobotMap;

/**
 *
 * @author ograff
 */
public class DumpInAuto extends CommandGroup {
    
    public DumpInAuto() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        addParallel(new DriveForwardForTime((15-RobotMap.timeToGetToGoal)-RobotMap.timeToDump, .25));
        addSequential(new JesusAscendAll());
        addSequential(new WallEOpen());
        addSequential(new JesusAscendRear());
        addSequential(new WaitCommand(RobotMap.timeToDump));
        addSequential(new JesusCrucify());
        addSequential(new WallEClose());
    }
}
