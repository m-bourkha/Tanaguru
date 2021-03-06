/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2015  Tanaguru.org
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact us by mail: tanaguru AT tanaguru DOT org
 */

package org.tanaguru.rules.rgaa22;

import org.tanaguru.ruleimplementation.AbstractPageRuleWithCheckerImplementation;
import org.tanaguru.rules.elementchecker.contrast.ContrastChecker;

/**
 * Implementation of the rule 2.10 of the referential RGAA 2.2.
 * <br/>
 * For more details about the implementation, refer to <a href="http://www.tanaguru.org/en/content/rgaa22-rule-2-10">the rule 2.10 design page.</a>
 * @see <a href="http://rgaa.net/Valeur-du-rapport-de-contraste-du,12.html"> 2.10 rule specification </a>
 *
 * @author jkowalczyk
 */
public class Rgaa22Rule02101 extends AbstractPageRuleWithCheckerImplementation {

    /** The constract checker with a value of ratio set to 3*/
    private static final ContrastChecker CONSTRAST_CHECKER = 
            new ContrastChecker(3f, true, true, false);

    /**
     * Default constructor
     */
    public Rgaa22Rule02101 () {
        super(CONSTRAST_CHECKER);
    }

    @Override
    public int getSelectionSize() {
        return CONSTRAST_CHECKER.getElementCounter();
    }

}