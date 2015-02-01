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
package com.dukescript.api.gameenegine.action;

import com.dukescript.api.gameengine.Renderer;

/**
 *
 * @author antonepple
 */
public class ActionFactory {

    /**
     * Helper Method to create a simple MoveAction. 
     * @param anim the Renderer
     * @param name a name
     * @param velocityX the speed in x direction while the action is executed 
     * @param velocityY the speed in y direction while the action is executed 
     * @param x2 the X speed after the action is finished
     * @param y2 the Y speed after the action is finished
     * @return the action
     */
    public static SpriteAction createMoveAction(Renderer anim, String name, double velocityX, double velocityY, double x2, double y2) {
        return new MoveAction(velocityX, velocityY, x2, y2, anim, name);
    }
    
    
}
