package project_se.Command;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.stage.FileChooser;
import project_se.ShapeInterface;

public class SaveCommand implements CommandInterface{

    private AnchorPane anchorPane;

    /**
     * 
     * @param anchorPane
     * It inits the SaveCommand class.
     */
    public SaveCommand(AnchorPane anchorPane){
        this.anchorPane = anchorPane;
    }
    
    /** 
     * @param node
     * Saves the children of the anchor pane with them properties in a text file
     */
    @Override
    public void exeCommand(Node node) {       
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png"));
        File file = fileChooser.showSaveDialog(null);
        if(file.getName().endsWith(".txt")){
            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
                for(Node n: anchorPane.getChildren())
                    out.print(((ShapeInterface)n).toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(file.getName().endsWith(".png")){
            try {
                Background bOld = anchorPane.getBackground();
                BackgroundFill bf = new BackgroundFill(null, null, null);
                Background bNew = new Background(bf, bf);
                anchorPane.setBackground(bNew);
                WritableImage image = anchorPane.snapshot(new SnapshotParameters(), null);
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
                anchorPane.setBackground(bOld);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /** 
     * @param node
     * @param x
     * @param y
     */
    @Override
    public void exeCommand(Node node, double x, double y) {
        // TODO Auto-generated method stub
        
    }
}
