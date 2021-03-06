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

import java.util.ServiceLoader;
import net.java.html.BrwsrCtx;
import net.java.html.boot.BrowserBuilder;

public final class Main {

    public static BrwsrCtx brwsrctx;

    private Main() {
    }

    public static void main(String... args) throws Exception {
        BrowserBuilder.newBrowser().
                loadPage("pages/index.html").
                loadClass(Main.class).
                invoke("onPageLoad", args).
                showAndWait();
        System.exit(0);
    }

    /**
     * Called when the page is ready.
     */
    public static void onPageLoad() throws Exception {
        GameView gameView = new GameView(1024, 800);
        ServiceLoader<Level> load = ServiceLoader.load(Level.class);
        for (Level level : load) {
            gameView.addLevel(level);
        }
        gameView.getCurrentLevel().start();
    }

// @JavaScriptBody(args = {}, body = "ko.bindingHandlers['keyPress'] = {\n"
//            + "    init: function (element, valueAccessor, allBindingsAccessor, viewModel) {\n"
////            + "        alert('initializing keyevents on '+element);\n"
//            + "        var allBindings = allBindingsAccessor();\n"
//            + "        element.onkeypress=function (event) {\n"
////            + "             alert('received event');\n"
//            + "            allBindings['keyPress'].call(viewModel,null, event);\n"
//            + "            return false;\n"
//            + "        };\n"
//            + "    }\n"
//            + "};")
//    public static native void registerKeyEvents();
//    
//    @Function 
//    public static void onKeyDown(Data model, int keyCode){
//        running.dispatchEvent(new KeyEvent(running, KeyEvent.KEY_PRESSED, KeyCode.getKeyCode(keyCode)));
//    }
}
