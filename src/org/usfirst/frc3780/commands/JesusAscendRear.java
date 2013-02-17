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

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3780.subsystems.Jesus;
import org.usfirst.frc3780.subsystems.Jesus.State;

/**
 *
 * @author Brian
 */
public class JesusAscendRear extends Command {
    
    public JesusAscendRear() {
        requires(Jesus.getInstance());
    }

    protected void initialize() {
    }

    protected void execute() {
        Jesus.getInstance().setState(State.kRearExtended);
    }

    protected boolean isFinished() {
        return Jesus.getInstance().getState() == State.kRearExtended;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
