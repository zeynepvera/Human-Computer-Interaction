
package com.mycompany.human_computer;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;


public class HelloWorld {

    public static void main(String[] args) throws IOException {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            Screen screen = new TerminalScreen(terminal);
            screen.startScreen();

            
            //textgraphics nesnesi oluşturduk2, putstring ile metin eklemek için
            TextGraphics textGraphics = screen.newTextGraphics();
            textGraphics.setForegroundColor(TextColor.ANSI.YELLOW_BRIGHT);
            textGraphics.putString(10, 10, "HELLO WORLD");
            
            screen.refresh();
            
            

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
