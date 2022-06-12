package one.service;

import one.bean.User;
import org.slf4j.Logger;

import javax.swing.*;
import java.io.IOException;

public interface Service {
    User login(Logger logger, String uFT, String pFT, JFrame jf) throws IOException;

    void regist(String uField, String pField);
}
