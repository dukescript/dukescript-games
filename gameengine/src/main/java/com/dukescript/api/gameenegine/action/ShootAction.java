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
import com.dukescript.api.gameengine.SpriteProvider;
import com.dukescript.api.gameenegine.collision.CollisionHandler;
import net.java.html.sound.AudioClip;

/**
 *
 * @author antonepple
 */
public class ShootAction extends SpriteAction {

    private final SpriteProvider spriteProvider;
    private final AudioClip sound;
    private final CollisionHandler collisionHandler;

    public ShootAction(Renderer animation, String name, SpriteProvider provider, CollisionHandler collisionHandler, AudioClip sound) {
        super(animation, name);
        this.sound = sound;
        this.spriteProvider = provider;
        this.collisionHandler = collisionHandler;
    }

    @Override
    public void started(Sprite sprite) {
        if (sound != null) {
            sound.play();
        }
        Sprite bullet = spriteProvider.getSprite(sprite.getParent(), sprite.getX(), sprite.getY());
        bullet.setVelocityY(-10);
        ShootBehavior behavior = new ShootBehavior(collisionHandler);
        behavior.setEvaluationInterval(20000000);
        bullet.addBehaviour(behavior);
    }
}
