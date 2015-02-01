/*
 * #%L
 * DukeScript Game Engine - a library from the "DukeScript GameEngine" project.
 * Visit http://dukescript.com for support and commercial license.
 * %%
 * Copyright (C) 2015 Eppleton IT Consulting
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */
package com.dukescript.api.gameenegine.event;

import java.util.EventObject;

/**
 *
 * @author antonepple
 */
public class Event extends EventObject{
    private final Type type;
    public static Type ANY = new Type("Event", null);

    public Event(Object source, Type type) {
        super(source);
        this.type = type;
    }

    public Type getType() {
        return type;
    }
    
    public static class Type<T extends Event>{
        private final String name;
        private final Type superType;

        public Type(String name, Type superType) {
            this.name = name;
            this.superType = superType;
        }

        public String getName() {
            return name;
        }

        public Type getSuperType() {
            return superType;
        }
       
        
        
    }
    
}
