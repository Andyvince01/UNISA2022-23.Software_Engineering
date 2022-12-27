package project_se.Command;

import javafx.scene.Node;

public interface CommandInterface {
    public void exeCommand(Node node);
    public void exeCommand(Node node, double x, double y);
}
