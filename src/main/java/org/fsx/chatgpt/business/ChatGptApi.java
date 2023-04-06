package org.fsx.chatgpt.business;

import java.io.IOException;

public interface ChatGptApi {

    String getAnswer(String ask) throws IOException;
}