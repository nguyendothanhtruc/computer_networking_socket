package Socket.Server.GUI;

import javax.swing.*;
import java.io.OutputStream;
import java.io.PrintStream;

class OutputJText extends OutputStream {
    private final JTextArea source;

    public OutputJText(JTextArea source) {
        if (source == null)
            throw new IllegalArgumentException("System.out.println is null");

        this.source = source;
    }

    @Override
    public void write(byte[] buffer, int offset, int length) {
        final String text = new String(buffer, offset, length);
        SwingUtilities.invokeLater(() -> source.append(text));
    }

    @Override
    public void write(int b) {
        write(new byte[]{(byte) b}, 0, 1);
    }

    public void convertJText(JTextArea textArea) {

        OutputJText out = new OutputJText(textArea);
        System.setOut(new PrintStream(out));
    }
}