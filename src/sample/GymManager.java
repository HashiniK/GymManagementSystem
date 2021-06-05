package sample;

import java.net.UnknownHostException;

public interface GymManager {
        void add(String option) throws UnknownHostException;
        void delete() throws UnknownHostException;
        void printConsole() throws UnknownHostException;
        void write();
        void open();
        void quit();
}
