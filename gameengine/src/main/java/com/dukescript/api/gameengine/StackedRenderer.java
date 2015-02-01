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
package com.dukescript.api.gameengine;

import com.dukescript.api.canvas.GraphicsContext2D;
import java.util.ArrayList;
import java.util.List;

/**
 * A Renderer that allows you to stack renderers on top of each others. 
 * This creates a mini-Layer system. The benefit is that you can easily add more 
 * than one renderer to a sprite at the same time, e.g. to decorate a sprite.
 * @author antonepple
 */
public class StackedRenderer implements Renderer {

    List<Renderer> renderers = new ArrayList<Renderer>();

    public StackedRenderer(Renderer ... stack) {
        for (Renderer renderer : stack) {
            this.renderers.add(renderer);
        }
    }

    
    
    @Override
    public boolean prepare(Sprite sprite, long time) {
        boolean dirty = false;
        for (Renderer renderer : renderers) {
            renderer.prepare(sprite, time);
        }
        return dirty;
    }

    @Override
    public void render(Sprite sprite, GraphicsContext2D context, float alpha, long time) {
        for (Renderer renderer : renderers) {
            renderer.render(sprite, context, alpha, time);
        }
    }

    public void removeRenderer(Renderer renderer){
        renderers.remove(renderer);
    }
    
    public final void addRenderer(int position, Renderer renderer) {
        renderers.add(position, renderer);
    }

    public final void addRenderer(Renderer renderer) {
        renderers.add(renderer);
    }
}
