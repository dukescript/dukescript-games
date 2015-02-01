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
public class SpriteAction {

    private final Renderer animation;
   
    public SpriteAction(Renderer animation, String name) {
        this.animation = animation == null? Sprite.NO_ANIMATION:animation;    
    }

    public Renderer getAnimation() {
        return animation;
    }

    
    public void started( Sprite sprite ){
        // by default do nothing
    }

    public void finished( Sprite aThis ) {
        // by default do nothing
    }
   
}
