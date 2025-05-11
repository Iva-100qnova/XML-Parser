package bg.tu_varna.sit.b1.f23621718.contracts.menu;

import bg.tu_varna.sit.b1.f23621718.contracts.io_handlers.*;

public interface BaseMenu {
    void exit();
    void startMenu();
    IOHandler getIOHandler();
}
