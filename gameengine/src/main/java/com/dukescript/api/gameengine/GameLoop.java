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

import net.java.html.js.JavaScriptBody;
import net.java.html.js.JavaScriptResource;

/**
 *
 * @author antonepple
 */
@JavaScriptResource(value = "GameLoop.js")
public class GameLoop {

    private final Handler handler;

    public GameLoop(Handler handler) {
        this.handler = handler;
    }

    public void start() {
        startAnimation(handler);
    }

    public void stop() {

    }

    @JavaScriptBody(args = {"handler"}, javacall = true,
            body = "Game_Singleton.prototype.mainLoop = function () {\n"
            + "    var date = new Date();\n"
            + "var time = date.getTime();"
            + "    handler.@com.dukescript.api.gameengine.Handler::pulse(J)(time);\n"
            + "requestAnimationFrame(Game.mainLoop);\n"
            + "console.log('running')"
                    + "};"
            + "Game.start();")
    public static native void startAnimation(Handler handler);
}
