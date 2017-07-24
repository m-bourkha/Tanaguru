/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2016  Tanaguru.org
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
package org.tanaguru.rules.rgaa32016;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.ruleimplementation.AbstractPageRuleWithSelectorAndCheckerImplementation;
import org.tanaguru.rules.elementchecker.element.SiblingElementsPresenceChecker;
import org.tanaguru.rules.elementselector.SimpleElementSelector;
import static org.tanaguru.rules.keystore.AttributeStore.SRC_ATTR;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.MEDIA_AUDIO_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.MEDIA_ONLY_VIDEO_TRANS_CSS_LIKE_QUERY;
import static org.tanaguru.rules.rgaa32016.Rgaa32016Rule040101.textualElementsTag;

/**
 * Implementation of the rule 4.1.1 of the referential Rgaa 3-2016.
 *
 * For more details about the implementation, refer to
 * <a href="http://tanaguru-rules-rgaa3.readthedocs.org/en/latest/Rule-4-1-1">the
 * rule 4.1.1 design page.</a>
 *
 * @see
 * <a href="http://references.modernisation.gouv.fr/referentiel-technique-0#test-4-1-1">
 * 4.1.1 rule specification</a>
 */
public class Rgaa32016Rule040101 extends AbstractPageRuleWithSelectorAndCheckerImplementation {

    // AbstractDetectionPageRuleImplementation
//    /**
//     * Default constructor
//     */
//    public Rgaa32016Rule040101() {
//        super(
//                new SimpleElementSelector(MEDIA_AUDIO_CSS_LIKE_QUERY),
//                // solution when at least one element is found
//                TestSolution.NEED_MORE_INFO,
//                // solution when no element is found
//                TestSolution.NOT_APPLICABLE,
//                // manual check message
//                MANUAL_CHECK_ON_ELEMENTS_MSG,
//                null
//                // evidence element
//                
//        );
//    }
    public static List<String> textualElementsTag = new ArrayList<String>() {
        {
            add("p");
            add("h1");
            add("h2");
        }
    };

    public Rgaa32016Rule040101() {
        super(new SimpleElementSelector(MEDIA_AUDIO_CSS_LIKE_QUERY),
                // new AttributeOnChildElementPresenceChecker(
                //"kind",
                // the set is not empty
                new SiblingElementsPresenceChecker(
                        textualElementsTag,
                        new ImmutablePair(TestSolution.NEED_MORE_INFO, "msg"),
                        new ImmutablePair(TestSolution.NOT_APPLICABLE, ""),
                        SRC_ATTR));

    }

}
