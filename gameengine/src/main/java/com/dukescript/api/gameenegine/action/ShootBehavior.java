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

import com.dukescript.api.gameengine.Sprite;
import com.dukescript.api.gameenegine.collision.Collision;
import com.dukescript.api.gameenegine.collision.CollisionHandler;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author antonepple
 */
public class ShootBehavior extends SpriteBehavior {
    Collection<CollisionHandler> listeners;

    public ShootBehavior(CollisionHandler listener) {
        this.listeners = new ArrayList<CollisionHandler>();
        listeners.add(listener);
    }
     
    @Override
    public boolean perform(Sprite sprite) {
        if (sprite.getY() <= 0) {
            sprite.getParent().removeSprite(sprite);
            return false;
        }
        Collection<Collision> collisions = sprite.getParent().checkCollisions(sprite);
        for (Collision collision : collisions) {
            for (CollisionHandler handler : listeners) {
                handler.handleCollision(collision);
            }
        }
        return true;
    }
    
    
}
