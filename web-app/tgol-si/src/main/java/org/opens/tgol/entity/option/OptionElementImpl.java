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
package org.opens.tgol.entity.option;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jkowalczyk
 */
@Entity
@Table(name = "TGSI_OPTION_ELEMENT")
@XmlRootElement
public class OptionElementImpl implements OptionElement, Serializable {

    private static final long serialVersionUID = 866337625495716065L;
    
    @Id
    @GeneratedValue
    @Column(name = "Id_Option_Element")
    private Long id;

    @Column(name = "Cd_Option_Element")
    private String code;

    @Column(name = "Description")
    private String description;

    @Column(name = "Is_Restriction")
    private boolean isRestriction;
    
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean isRestriction() {
        return isRestriction;
    }

    @Override
    public void setIsRestriction(boolean isRestriction) {
        this.isRestriction = isRestriction;
    }
    
}