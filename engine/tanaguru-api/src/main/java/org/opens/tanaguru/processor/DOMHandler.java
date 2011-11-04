/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2011  Open-S Company
 *
 * This file is part of Tanaguru.
 *
 * Tanaguru is free software: you can redistribute it and/or modify
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
 * Contact us by mail: open-s AT open-s DOT com
 */
package org.opens.tanaguru.processor;

import org.opens.tanaguru.entity.subject.WebResource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.w3c.dom.Node;

import org.opens.tanaguru.entity.audit.ProcessRemark;
import org.opens.tanaguru.entity.audit.SSP;
import org.opens.tanaguru.entity.audit.TestSolution;
import org.opens.tanaguru.service.ProcessRemarkService;

/**
 * 
 * @author jkowalczyk
 */
public interface DOMHandler {

    /**
     *
     * @return the current SSPHandler instance
     */
    DOMHandler beginSelection();

    /**
     *
     * @param attributeName
     *            the name of the attribute to check
     * @return the result of the check processing
     */
    TestSolution checkAttributeExists(String attributeName);

    /**
     *
     * @param attributeName
     *            the name of the attribute to check
     * @param regex
     *            the regular expression to check on the value of the attribute
     * @return the result of the check processing
     */
    TestSolution checkAttributeValueExpression(String attributeName,
            String regex);

    /**
     *
     * @param attributeName
     *            the name of the attribute to check
     * @param length
     *            the length of the attribute value to check
     * @param defaultFailResult
     *            the default return value if the check processing fails
     * @return the result of the check processing
     */
    TestSolution checkAttributeValueLengthLower(String attributeName,
            int length, TestSolution defaultFailResult);

    /**
     *
     * @param attributeName
     *            the name of the attribute to check
     * @return the result of the check processing
     */
    TestSolution checkAttributeValueNotEmpty(String attributeName);

    /**
     *
     * @param attributeName
     *            the name of the attribute to check
     * @return the result of the check processing
     */
    TestSolution checkAttributeValueIsEmpty(String attributeName);

    /**
     *
     * @param childNodeName
     *            the name of the childNode to check
     * @return the result of the check processing
     */
    TestSolution checkChildNodeExists(String childNodeName);

    /**
     *
     * @param childNodeName
     *            the name of the childnode to check
     * @return the result of the check processing
     */
    TestSolution checkChildNodeExistsRecursively(String childNodeName);

    /**
     *
     * @return the result of the check processing
     */
    TestSolution checkContentNotEmpty();

    /**
     * 
     * @param expr
     * @return the result of the check processing using xpath
     */
    TestSolution checkEachWithXpath(String expr);

    /**
     *
     * @param blacklist
     *            the list of prevented values
     * @param whitelist
     *            the list of granted values
     * @return the result of the check processing
     */
    TestSolution checkNodeValue(Collection<String> blacklist,
            Collection<String> whitelist);

    /**
     *
     * @param blacklist
     *            the list of prevented values
     * @param whitelist
     *            the list of granted values
     * @param result
     *            the result associated with a blacklisted element
     * @param errorMessageCode
     *            the errorMessageCode to use to create the processRemark
     * @return
     */
    TestSolution checkNodeValue(
            Collection<String> blacklist,
            Collection<String> whitelist,
            TestSolution result,
            String errorMessageCode);

    /**
     *
     * @param attributeName
     *            the name of the attribute to check
     * @param blacklist
     *            the list of prevented values
     * @param whitelist
     *            the list of granted values
     * @return the result of the check processing
     */
    TestSolution checkTextContentAndAttributeValue(String attributeName,
            Collection<String> blacklist, Collection<String> whitelist);

    /**
     *
     * @param blacklist
     *            the list of prevented values
     * @param whitelist
     *            the list of granted values
     * @return the result of the check processing
     */
    TestSolution checkTextContentValue(Collection<String> blacklist,
            Collection<String> whitelist);

    /**
     *
     * @param length
     *            the length of the text content to check
     * @param defaultFailResult
     *            the default return value if the check processing fails
     * @return the restult of the check processing
     */
    TestSolution checkTextContentValueLengthLower(int length,
            TestSolution defaultFailResult);

    /**
     *
     * @return the result of the check processing
     */
    TestSolution checkTextContentValueNotEmpty();

    /**
     *
     * @param attributeName
     *            the name of the attribute to filter
     * @return the current DOMHandler instance
     */
    DOMHandler excludeNodesWithAttribute(String attributeName);

    /**
     *
     * @param childNodeNames
     *            the names of the childnodes to filter
     * @return the current DOMHandler instance
     */
    DOMHandler excludeNodesWithChildNode(ArrayList<String> childNodeNames);

    /**
     *
     * @param childNodeName
     *            the name of the childNode to filter
     * @return the current DOMHandler instance
     */
    DOMHandler excludeNodesWithChildNode(String childNodeName);

    /**
     *
     * @param attributeName
     *            the name of the attribute targeted
     * @return the textual values from all the attributes found
     */
    List<String> getAttributeValues(String attributeName);

    /**
     *
     * @return the page of the ssp used
     */
    public WebResource getPage();

    /**
     *
     * @return the remarks
     */
    Collection<ProcessRemark> getRemarkList();

    /**
     *
     * @return the elements currently selected
     */
    List<Node> getSelectedElementList();

    /**
     *
     * @return the SSP
     */
    SSP getSSP();

    /**
     *
     * @return the textual values from all currently selected elements
     */
    List<String> getTextContentValues();

    /**
     *
     * @return <tt>true</tt> if there are no elements selected
     */
    boolean isSelectedElementsEmpty();

    /**
     *
     * @param attributeName
     *            the name of the attribute to filter
     * @return the current DOMHandler instance
     */
    DOMHandler keepNodesWithAttribute(String attributeName);

    /**
     *
     * @param attributeName
     *            the name of the attribute to filter
     * @param values
     *            the values of the attribute to filter
     * @return the current DOMHandler instance
     */
    DOMHandler keepNodesWithAttributeValueEquals(String attributeName,
            Collection<String> values);

    /**
     *
     * @param attributeName
     *            the name of the attribute to filter
     * @return the current DOMHandler instance
     */
    DOMHandler keepNodesWithAttributeValueNonEmpty(String attributeName);

    /**
     *
     * @param attributeName
     *            the name of the attribute to be filteterd
     * @param values
     *            the values of the attribute to filter
     * @return the current DOMHandler instance
     */
    DOMHandler keepNodesWithAttributeValueStartingWith(String attributeName,
            Collection<String> values);

    /**
     *
     * @param attributeName
     *            the name of the attribute to filter
     * @param value
     *            the value of the attribute to filter
     * @return the current DOMHandler instance
     */
    DOMHandler keepNodesWithAttributeValueStartingWith(String attributeName,
            String value);

    /**
     *
     * @param childNodeName
     *            the name of the attribute to filter
     * @return the current DOMHandler instance
     */
    DOMHandler keepNodesWithChildNode(String childNodeName);

    /**
     *
     * @param childNodeNames
     *            the names of the childnodes to filter
     * @return the current DOMHandler instance
     */
    DOMHandler keepNodesWithoutChildNode(Collection<String> childNodeNames);

    /**
     *
     * @param childNodeName
     *            the name of the childnode to filter
     * @return the current DOMHandler instance
     */
    DOMHandler keepNodesWithoutChildNode(String childNodeName);

    /**
     *
     * @param attributeName
     *            the name of the atribute to select
     * @return the current DOMHandler instance
     */
    DOMHandler selectAttributeByName(String attributeName);

    /**
     *
     * @param childNodeNames
     *            the names of the childNodes to select
     * @return the current DOMHandler instance
     */
    DOMHandler selectChildNodes(Collection<String> childNodeNames);

    /**
     *
     * @param childNodeName
     *            the name of the childNode to select
     * @return the current DOMHandler instance
     */
    DOMHandler selectChildNodes(String childNodeName);

    /**
     *
     * @param childNodeNames
     *            the names of the childnodes to select recursively
     * @return the current DOMHandler instance
     */
    DOMHandler selectChildNodesRecursively(Collection<String> childNodeNames);

    /**
     *
     * @param childNodeName
     *            the name of the childnode to select recursively
     * @return the current DOMHandler instance
     */
    DOMHandler selectChildNodesRecursively(String childNodeName);

    /**
     *
     * @param nodeNames
     *            the names of the nodes to select
     * @return the current DOMHandler instance
     */
    DOMHandler selectDocumentNodes(Collection<String> nodeNames);

    /**
     *
     * @param nodeName
     *            the name of the nodeto select in all the document
     * @return the current DOMHandler instance
     */
    DOMHandler selectDocumentNodes(String nodeName);

    /**
     *
     * @param attributeName
     *            the name of the attribute to check
     * @return the current DOMHandler
     */
    DOMHandler selectDocumentNodesWithAttribute(String attributeName);

    /**
     * http://www.ibm.com/developerworks/library/x-javaxpathapi.html
     *
     * @param expr
     * @return
     */
    DOMHandler xPathSelectNodeSet(String expr);

    /**
     *
     * @param selectedElementList
     *            the selected element list to set
     */
    void setSelectedElementList(List<Node> selectedElementList);

    /**
     *
     * @param ssp
     *            the SSP to set
     */
    void setSSP(SSP ssp);

    /**
     * Add a source code remark
     * @param processResult
     * @param node
     * @param messageCode
     * @param attributeName
     */
    public void addSourceCodeRemark(TestSolution processResult, Node node,
            String messageCode, String attributeName);

    /**
     * This method checks whether an attribute only contains non alphanumeric
     * characters
     * @param attribute
     * @param workingElement
     * @param currentTestSolution
     * @param remarkMessage
     * @return
     */
    public TestSolution checkAttributeOnlyContainsNonAlphanumericCharacters(
            Node attribute,
            Node workingElement,
            TestSolution testSolution,
            String remarkMessage);

    /**
     * This method checks whether an attribute only contains non alphanumeric
     * characters
     * @param attributeContent
     * @param workingElement
     * @param currentTestSolution
     * @param remarkMessage
     * @return
     */
    public TestSolution checkAttributeOnlyContainsNonAlphanumericCharacters(
            String attributeContent,
            Node workingElement,
            TestSolution testSolution,
            String remarkMessage);

    /**
     * This method return the number of selected elements
     * @return
     */
    public int getSelectedElementNumber();

    /**
     *
     * @param processRemarkService
     */
    public void setProcessRemarkService(ProcessRemarkService processRemarkService);

    /**
     *
     * @return the message code
     */
    public String getMessageCode();

    /**
     *
     * @param messageCode
     */
    public void setMessageCode(String messageCode);

}