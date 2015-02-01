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

/**
 * Implement this to add timed Behaviors to Sprites. Behaviors range from AI for
 * seeking an enemy, attacking to Animation, etc. Behaviors are a bit like
 * Keyframes. They are called at certain intervals set by the
 * {@link SpriteBehavior#setEvaluationInterval(long)} method. At each game pulse
 * the Sprite will check it's Behaviours and invoke the ones where the
 * EvaluationInterval is exceeded. So be aware that the resolution is limited by
 * the Framerate.
 *
 * Behaviors are intended to be stateless and reusable.
 *
 * @author antonepple
 */
public abstract class SpriteBehavior extends Behavior {

    /**
     * implement this to add your custom behavior.
     *
     * @param sprite
     * @return false if the behaviour is finished
     */
    public boolean perform(Sprite sprite) {
        return true;
    }

}
