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

/**
 *
 * @author antonepple
 */
public class KeyEvent extends Event{

    public static final Event.Type<KeyEvent> ANY =
            new Event.Type<KeyEvent>("KEY", Event.ANY);

    public static final Event.Type<KeyEvent> KEY_PRESSED =
            new Event.Type<KeyEvent>("KEY_PRESSED",ANY);

    public static final Event.Type<KeyEvent> KEY_RELEASED =
            new Event.Type<KeyEvent>( "KEY_RELEASED",ANY);

    public static final Event.Type<KeyEvent> KEY_TYPED =
            new Event.Type<KeyEvent>("KEY_TYPED",ANY);

    
    private final KeyCode keyCode;
    public KeyEvent(Object source, Type type, KeyCode keyCode) {
        super(source, type);
        this.keyCode = keyCode;
    }

    public KeyCode getKeyCode() {
        return keyCode;
    }

    
     
   
    
}
