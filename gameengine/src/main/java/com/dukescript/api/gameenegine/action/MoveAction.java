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
import com.dukescript.api.gameengine.Sprite;

/**
 *
 * @author antonepple
 */
public class MoveAction extends SpriteAction {

    double velocityX;
    double velocityY;
    double endX;
    double endY;

    public MoveAction(double velocityX, double velocityY, double endX, double endY, Renderer animation, String name) {
        super(animation, name);
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.endX = endX;
        this.endY = endY;
    }

    @Override
    public void started(Sprite sprite) {
        if (velocityX != 0) {
            sprite.setVelocityX(velocityX);
        }
        if (velocityY != 0) {
            sprite.setVelocityY(velocityY);
        }

    }

    @Override
    public void finished(Sprite sprite) {
        if (velocityX != 0) {
            sprite.setVelocityX(endX);
        }
        if (velocityY != 0) {
            sprite.setVelocityY(endY);
        }

    }
}
