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

import java.util.Collections;
import java.util.List;

/**
 *
 * @author antonepple
 */
public final class TouchEvent extends Event {

//    private final int eventGroupId;
    private final List<Touch> touches;

    public static final Event.Type<TouchEvent> ANY
            = new Event.Type<TouchEvent>("TOUCH", Event.ANY);

    public static final Event.Type<TouchEvent> TOUCH_STARTED
            = new Event.Type<TouchEvent>("TOUCH_STARTED", ANY);

    public static final Event.Type<TouchEvent> TOUCH_MOVED
            = new Event.Type<TouchEvent>("TOUCH_MOVED", ANY);

    public static final Event.Type<TouchEvent> TOUCH_END
            = new Event.Type<TouchEvent>("TOUCH_END", ANY);

    public TouchEvent(Object source, Event.Type<TouchEvent> eventType,
          List<Touch> touches//, int eventGroupId
    ) {
        super(source, eventType);
        this.touches = touches != null ? Collections.unmodifiableList(touches) : null;
//        this.eventGroupId = eventGroupId;
    }

//    public int getNumTouches() {
//        return touches.size();
//    }
    @Override
    public Event.Type<TouchEvent> getType() {
        return (Event.Type<TouchEvent>) super.getType();
    }

//    public final int getEventGroupId() {
//        return eventGroupId;
//    }

    public Touch getPrimaryTouch() {
        return touches.get(0);
    }

    public List<Touch> getAllTouches() {
        return touches;
    }
    
    public static class Touch {

        double x, y;

        public Touch(double x, double y) {
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

}
