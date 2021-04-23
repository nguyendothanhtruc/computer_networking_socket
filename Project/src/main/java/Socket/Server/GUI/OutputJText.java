package Socket.Server.GUI;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

class OutputJText extends OutputStream {
    private final JTextArea source;

    public OutputJText(JTextArea source) {
        if (source == null)
            throw new IllegalArgumentException("Sout is null");

        this.source = source;
    }

    @Override
    public void write(byte[] buffer, int offset, int length) throws IOException {
        final String text = new String(buffer, offset, length);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                source.append(text);
            }
        });
    }

    @Override
    public void write(int b) throws IOException {
        write(new byte[]{(byte) b}, 0, 1);
    }

    public void convertJText(JTextArea textArea) throws Exception {

        OutputJText out = new OutputJText(textArea);
        System.setOut(new PrintStream(out));
    }
}