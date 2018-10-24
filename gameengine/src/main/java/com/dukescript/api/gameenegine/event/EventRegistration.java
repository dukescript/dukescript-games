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

import net.java.html.js.JavaScriptBody;

/**
 *
 * @author antonepple
 */
public class EventRegistration {

    @JavaScriptBody(args = {}, javacall = true, body
            = "var game = document.getElementById('game-canvas');\n"
            + "game.addEventListener('touchstart',function (event) {"
            + "   event.preventDefault();\n"
            + "   var touches = event.touches;\n"
            + "   var result = []; "
            + "   var rect = game.getBoundingClientRect();"
            + "   for (var i = 0, l = touches.length; i < l; ++i) {\n"
            + "       result [i*2] = rect.left + touches[i].clientX;\n"
            + "       result[(i*2)+1] = rect.top + touches[i].clientY;"
            + "   }\n"
            + "  if(result.length>0) {@com.dukescript.api.gameengine.GameView::touchStarted([Ljava/lang/Object;)(result);}\n"
            + "});"
            + "game.addEventListener('touchmove',function (event) {\n"
            + "   event.preventDefault();\n"
            + "   var touches = event.touches;\n"
            + "   var result = []; "
            + "   var rect = game.getBoundingClientRect();"
            + "   for (var i = 0, l = touches.length; i < l; ++i) {\n"
            + "       result [i*2] = rect.left + touches[i].clientX;\n"
            + "       result[(i*2)+1] = rect.top + touches[i].clientY;"
            + "   }\n"
            + "console.log(result);\n"
            + "  if(result.length>0) {@com.dukescript.api.gameengine.GameView::touchMove([Ljava/lang/Object;)(result);}\n"
            + "});"
            + "game.addEventListener('touchend',function (event) {\n"
            + "   var touches = event.touches;\n"
            + "   var result = []; "
            + "   var rect = game.getBoundingClientRect();"
            + "   for (var i = 0, l = touches.length; i < l; ++i) {\n"
            + "       result [i*2] = rect.left + touches[i].clientX;\n"
            + "       result[(i*2)+1] = rect.top + touches[i].clientY;"
            + "   }\n"
            + "  if(result.length>0) {@com.dukescript.api.gameengine.GameView::touchEnd([Ljava/lang/Object;)(result);}\n"
            + "});"
            + "game.addEventListener('touchcancel',function (event) {\n"
            + "   event.preventDefault();\n"
            + "   var touches = event.touches;\n"
            + "   var result = []; "
            + "   var rect = game.getBoundingClientRect();"
            + "   for (var i = 0, l = touches.length; i < l; ++i) {\n"
            + "       result [i*2] = rect.left + touches[i].clientX;\n"
            + "       result[(i*2)+1] = rect.top + touches[i].clientY;"
            + "   }\n"
            + "  if(result.length>0) {@com.dukescript.api.gameengine.GameView::touchCancel([Ljava/lang/Object;)(result);}\n"
            + "});"
    )
    public static native void registerTouch();

    @JavaScriptBody(args = {}, javacall = true, body
            = "var game = document.getElementById('game-canvas');\n"
            + "game.addEventListener('mousedown', function (event) {\n"
            + "   event.preventDefault();\n"
            + "    var rect = game.getBoundingClientRect();"
            + "    var realX = event.clientX - rect.left;"
            + "    var realY = event.clientY -rect.top;"
            + "    @com.dukescript.api.gameengine.GameView::mouseDown(II)(realX, realY);"
            + "});\n"
            + "game.addEventListener('click',function (event) {\n"
            + "   event.preventDefault();\n"
            + "  var rect = game.getBoundingClientRect();"
            + "  var realX = event.clientX - rect.left;"
            + "  var realY = event.clientY -rect.top;"
            + "  @com.dukescript.api.gameengine.GameView::mouseClick(II)(realX, realY);"
            + "});\n"
            + "game.addEventListener('mouseup',function (event) {\n"
            + "   event.preventDefault();\n"
            + "  var rect = game.getBoundingClientRect();"
            + "  var realX = event.clientX - rect.left;"
            + "  var realY = event.clientY -rect.top;"
            + "  @com.dukescript.api.gameengine.GameView::mouseUp(II)(realX, realY);"
            + "});\n"
    )
    public static native void registerMouseBinding();

    @JavaScriptBody(args = {}, javacall = true, body
            = "var game = document.getElementById('game-canvas');\n"
            + "game.addEventListener('keypress', function (event) {\n"
            + "   event.preventDefault();\n"
            + "  @com.dukescript.api.gameengine.GameView::keyPress(I)(event.keyCode);"
            + "});\n"
            + "game.addEventListener('keyup', function (event) {\n"
            + "   event.preventDefault();\n"
            + "  @com.dukescript.api.gameengine.GameView::keyUp(I)(event.keyCode);"
            + "});\n"
            + "game.addEventListener('keydown', function (event) {\n"
            + "   event.preventDefault();\n"
            + "  @com.dukescript.api.gameengine.GameView::keyDown(I)(event.keyCode);"
            + "});\n"
    )
    public static native void registerKeyEvents();
}
