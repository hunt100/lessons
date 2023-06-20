package org.example.home7.structural;

public interface Constants {
    interface Commands {

        String EXIT_CMD = "ext";
        String HISTORY_CMD = "hst";

    }

    interface Message {

        String WELCOME = "Write operation (+,*,/), or exit command (ext), or history command (hst):";
        String ERROR = "Something bad happen. Check logs";

        String FIRST_OPERAND = "Input first complex number:";
        String SECOND_OPERAND = "Input second complex number:";
        String RESULT_MESSAGE = "The result is:";
    }
}
