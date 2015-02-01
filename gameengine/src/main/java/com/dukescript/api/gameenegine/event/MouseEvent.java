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
public class MouseEvent extends Event{
      /**
     * Common supertype for all mouse event types.
     */
    public static final Event.Type<MouseEvent> ANY =
            new Event.Type<MouseEvent>("MOUSE", Event.ANY);

    public static final Event.Type<MouseEvent> MOUSE_PRESSED =
            new Event.Type<MouseEvent>("MOUSE_PRESSED",ANY);

    public static final Event.Type<MouseEvent> MOUSE_RELEASED =
            new Event.Type<MouseEvent>( "MOUSE_RELEASED",ANY);

    public static final Event.Type<MouseEvent> MOUSE_CLICKED =
            new Event.Type<MouseEvent>("MOUSE_CLICKED",ANY);

    public static final Event.Type<MouseEvent> MOUSE_ENTERED_TARGET =
            new Event.Type<MouseEvent>("MOUSE_ENTERED_TARGET",ANY);

    public static final Event.Type<MouseEvent> MOUSE_ENTERED =
            new Event.Type<MouseEvent>( "MOUSE_ENTERED",ANY);

    public static final Event.Type<MouseEvent> MOUSE_EXITED_TARGET =
            new Event.Type<MouseEvent>( "MOUSE_EXITED_TARGET",ANY);

    public static final Event.Type<MouseEvent> MOUSE_EXITED =
            new Event.Type<MouseEvent>( "MOUSE_EXITED",ANY);

    public static final Event.Type<MouseEvent> MOUSE_MOVED =
            new Event.Type<MouseEvent>("MOUSE_MOVED",ANY);

    public static final Event.Type<MouseEvent> MOUSE_DRAGGED =
            new Event.Type<MouseEvent>("MOUSE_DRAGGED",ANY);

    private double x;
    private double y;
    
    public MouseEvent(Object source, Event.Type<? extends MouseEvent> type , double x, double y) {
        super(source, type );
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    
}
