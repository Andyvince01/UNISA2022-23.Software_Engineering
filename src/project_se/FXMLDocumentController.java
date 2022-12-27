package project_se;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import project_se.Command.ChangeColorCommand;
import project_se.Command.CopyCommand;
import project_se.Command.DeleteCommand;
import project_se.Command.FlipHorizontalCommand;
import project_se.Command.FlipVerticalCommand;
import project_se.Command.LoadCommand;
import project_se.Command.NewPaintCommand;
import project_se.Command.PasteCommand;
import project_se.Command.ResizeCommand;
import project_se.Command.RotateCommand;
import project_se.Command.SaveCommand;
import project_se.Command.ToBackCommand;
import project_se.Command.ToFrontCommand;

/**
 *
 * @author Group16 (Martina Iannaccone, Andrea Vincenzo Ricciardi, Giovanni Rolando)
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField angleField;

    @FXML
    private TextField angleFieldMenu;

    @FXML
    private ColorPicker colorPickerFill;

    @FXML
    private ColorPicker colorPickerOutline;

    @FXML
    private MenuItem ellipseButton;

    @FXML
    private MenuItem flipHorizontalButton;

    @FXML
    private MenuItem flipVerticalButton;

    @FXML
    private CheckBox gridCheck;

    @FXML
    private Button lessSizeCharacter;

    @FXML
    private MenuItem lineButton;

    @FXML
    private Button loadFile;

    @FXML
    private MenuItem menuBringTop;

    @FXML
    private ColorPicker menuColorPickerFill;

    @FXML
    private ColorPicker menuColorPickerOutline;

    @FXML
    private MenuItem menuCopy;

    @FXML
    private MenuItem menuCut;

    @FXML
    private MenuItem menuDelete;

    @FXML
    private MenuItem menuPaste;

    @FXML
    private MenuItem menuSendBack;

    @FXML
    private Button newFile;

    @FXML
    private Button plusSizeCharacter;

    @FXML
    private MenuItem rectangleButton;

    @FXML
    private Button resizeButton;

    @FXML
    private Button saveFile;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Label sizeCharacter;

    @FXML
    private Slider sliderGrid;

    @FXML
    private Slider sliderZoom;

    @FXML
    private TextField textField;

    @FXML
    private Button undoButton;

    @FXML
    private Button zoomOut;

    @FXML
    private MenuItem textButton;
    
    @FXML
    private TextField angField;

    @FXML
    private MenuItem polygonButton;

    @FXML
    private ContextMenu contextMenu;

    @FXML
    private TextField resizeMenu;

    @FXML
    private TextField heightResize;

    @FXML
    private TextField widthResize;

    @FXML
    private VBox vboxResize;
   
    @FXML 
    private MenuButton menuShapes;
    
    private AbstractShape currentSelection;
    private ShapeInterface selectedShape;
    private CopyCommand copyShape;
    private PasteCommand pasteShape;
    private List<Double> points = new ArrayList<Double>(10);
    private Group circle = new Group();
    private CareTaker cTaker = new CareTaker();
    
    double clickX, clickY, oldX, oldY, oldScaleX, oldScaleY, clickXPaste, clickYPaste, oldWidth, oldHeight;
    DoubleProperty w, h;
    boolean flag = true;
    SimpleBooleanProperty selectedBool = new SimpleBooleanProperty(false);
    
    
    /** 
     * @param url
     * @param rb
     * Initialize all the variables used and set their values, as well as some bindings.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        GridandZoom gz = new GridandZoom(anchorPane, sliderGrid, sliderZoom, gridCheck);
        cTaker.save(this);

        /*Slider Zoom*/
        oldScaleX = anchorPane.getScaleX();
        oldScaleY = anchorPane.getScaleY();
        oldWidth = anchorPane.getMinWidth();
        oldHeight = anchorPane.getMinHeight();
        sliderZoom.valueProperty().addListener((v, o, n) ->{
            if(n.doubleValue() != 2){
                anchorPane.setScaleX(oldScaleX*n.doubleValue()/2);
                anchorPane.setScaleY(oldScaleY*n.doubleValue()/2);
            }else{
                anchorPane.setScaleX(oldScaleX);
                anchorPane.setScaleY(oldScaleY);                 
            }
        });
        /*Slider Grid*/
        sliderGrid.valueProperty().addListener((v, o, n) ->{
            gz.updateGrid();
        });
        gridCheck.selectedProperty().addListener((v, o, n) -> {
            sliderGrid.setDisable(!n.booleanValue());
            gz.updateGrid();
        });

        gridCheck.setSelected(true);
        menuPaste.setDisable(true);
        copyShape = new CopyCommand(anchorPane);
        pasteShape = new PasteCommand(anchorPane, cTaker, this);
        textButton.disableProperty().bind(textField.textProperty().isEmpty());
        contextMenu.setOpacity(0);
        menuColorPickerFill.setValue(colorPickerFill.getValue());
        menuColorPickerOutline.setValue(colorPickerOutline.getValue());

        vboxResize.setVisible(false);
        resizeButton.setOnMouseClicked(eh ->{
            vboxResize.setVisible(flag);
            flag = !flag;
        });
        
        heightResize.setText(String.valueOf(anchorPane.getPrefHeight()));
        widthResize.setText(String.valueOf(anchorPane.getPrefWidth()));
        
        heightResize.textProperty().addListener((v, o, n) ->{
            anchorPane.setMinHeight(Double.valueOf(n));
        });
        widthResize.textProperty().addListener((v, o, n) ->{
            anchorPane.setMinWidth(Double.valueOf(n));
        });

        plusSizeCharacter.setOnMouseClicked(eh -> {
            int size = Integer.parseInt(sizeCharacter.getText()) + 1;
            sizeCharacter.setText(String.valueOf(size));
        });

        lessSizeCharacter.setOnMouseClicked(eh -> {
            int size = Integer.parseInt(sizeCharacter.getText()) - 1;
            sizeCharacter.setText(String.valueOf(size));
        });
        
        lessSizeCharacter.disableProperty().bind(sizeCharacter.textProperty().isEqualTo("1"));

        flipHorizontalButton.setDisable(true);
        flipVerticalButton.setDisable(true);

        angleField.textProperty().addListener((v, o, n) -> {
            if(n.isEmpty() || n.equals("-"));               
            else{
                if(Double.parseDouble(n) < -360)
                    angleField.setText("-360");
                else if ((Double.parseDouble(n) > 360))
                    angleField.setText("360");
            }        
        });

        angleFieldMenu.textProperty().addListener((v, o, n) -> {
            if(n.isEmpty() || n.equals("-"));               
            else{
                if(Double.parseDouble(n) < -360)
                    angleFieldMenu.setText("-360");
                else if ((Double.parseDouble(n) > 360))
                    angleFieldMenu.setText("360");
            }        
        });

        undoButton.setDisable(true);
        
        AnchorPane.setTopAnchor(scrollPane, 0.0);
        AnchorPane.setBottomAnchor(scrollPane, 0.0);
        AnchorPane.setLeftAnchor(scrollPane, 0.0);
        AnchorPane.setRightAnchor(scrollPane, 0.0);

    }    
    
    /** 
     * @param event
     * Calls the function to create a "line" type shape and set all its parameters: color, size, angle of rotation
     */
    @FXML
    private void createNewLine(ActionEvent event) {
        currentSelection = new LineCreator();
        currentSelection.creationOfShape(colorPickerOutline.getValue(), colorPickerFill.getValue(), Double.parseDouble(angleField.getText()), null, Integer.parseInt(sizeCharacter.getText())/2, 80, 80); 
    }
   
   /** 
    * @param e
    * Calls the function to create a "rectangle" type shape and set all its parameters: color, size, angle of rotation
    */
   @FXML
    private void createNewRectangle(ActionEvent e) {
        currentSelection = new RectangleCreator();
        currentSelection.creationOfShape(colorPickerOutline.getValue(), colorPickerFill.getValue(), Double.parseDouble(angleField.getText()), null, Integer.parseInt(sizeCharacter.getText())/2, 100,  50);
    }
      
    /** 
     * @param event
     * Calls the function to create an "ellipse" type shape and set all its parameters: color, size, angle of rotation
     */
    @FXML
    private void createNewEllipse(ActionEvent event) {
        currentSelection = new EllipseCreator();
        currentSelection.creationOfShape(colorPickerOutline.getValue(), colorPickerFill.getValue(), Double.parseDouble(angleField.getText()), null, Integer.parseInt(sizeCharacter.getText())/2, 100, 50);
    }

    /** 
     * @param event
     * Calls the function to create a "generic polygon" type shape and set all its parameters: color, size, angle of rotation
     */
    @FXML
    private void createNewPolygon(ActionEvent event){
        currentSelection = new PolygonCreator();
        currentSelection.creationOfShape(colorPickerOutline.getValue(), colorPickerFill.getValue(), Double.parseDouble(angleField.getText()), null, Integer.parseInt(sizeCharacter.getText())/3, 1, 1);
    }

    /** 
     * @param event
     * Calls the function to create a "text" type shape and set all its parameters: color, size, angle of rotation
     */
    @FXML
    private void createText(ActionEvent event){

        currentSelection = new TextCreator();
        currentSelection.creationOfShape(colorPickerOutline.getValue(), colorPickerFill.getValue(), Double.parseDouble(angleField.getText()), textField.getText(), Integer.parseInt(sizeCharacter.getText()), 1, 1);

    }

    /** 
     * @param event
     * Calls the function to change the fill color of the shape and passes it as a parameter 
     * the selected shape converting it to the "node" type
     */
    @FXML
    private void changeColorFill(ActionEvent event) {
        cTaker.save(this);
        ChangeColorCommand col = new ChangeColorCommand(anchorPane, menuColorPickerFill.getValue(), true);
        col.exeCommand((Node)selectedShape);
        selectedShape = null;
    }

    /** 
     * @param event
     * Calls the function to change the color of the outline of the shape and passes it as a parameter 
     * the selected shape converting it to the "node" type
     */
    @FXML
    private void changeColorOutline(ActionEvent event) {
        cTaker.save(this);
        ChangeColorCommand col = new ChangeColorCommand(anchorPane, menuColorPickerOutline.getValue(), false);
        col.exeCommand((Node)selectedShape);
        selectedShape = null;      
    }
    
    /** 
     * @param event
     * Call the function to copy the selected shape and finally delete it from the drawing sheet by calling the function to delete it
     */
    @FXML
    private void menuCutShape(ActionEvent event) {
        cTaker.save(this);
        copyShape.exeCommand((Node)selectedShape);
        DeleteCommand del = new DeleteCommand(anchorPane);
        del.exeCommand((Node)selectedShape);
        menuPaste.setDisable(false);
        selectedShape = null;
    }
    
    /** 
     * @param event
     * Call the function to copy the selected shape
     */
    @FXML
    private void menuCopyShape(ActionEvent event) {
        copyShape.exeCommand((Node)selectedShape);
        menuPaste.setDisable(false);
        selectedShape = null;
        
    }
    
    /** 
     * @param event
     * Takes the previously copied shape, calls the function to "paste" it on the drawing pad 
     * and assigns it all the properties of the selected shape
     */
    @FXML
    private void menuPasteShape(ActionEvent event) {
        cTaker.save(this);
        Node n = (Node) copyShape.getShapeCopy();
        pasteShape.exeCommand(n, clickX, clickY);
        n.setOnMouseClicked(e -> {
            selectedShape = (ShapeInterface) n;
            if(e.getButton() == MouseButton.SECONDARY){
                contextMenu.setOpacity(1);
                menuColorPickerFill.setValue((Color)selectedShape.getColorFill());
                menuColorPickerOutline.setValue((Color)selectedShape.getColorStroke());
                angleFieldMenu.setText(String.valueOf(selectedShape.getAngle()));
                resizeMenu.setText((selectedShape).getWidthShape()+"x"+(selectedShape.getHeigthShape()));
            }
        });
        copyShape.setShapeCopy((ShapeInterface) n); 
        menuPaste.setDisable(true);
    }
    
    /** 
     * @param event
     * Call the function to delete the selected shape
     */
    @FXML
    private void menuDeleteShape(ActionEvent event) {
        cTaker.save(this);
        DeleteCommand del = new DeleteCommand(anchorPane);
        del.exeCommand((Node)selectedShape);
        selectedShape = null;        
    }
    
    /** 
     * @param event
     * Call the function to create a new file by cleaning up the drawing pad
     */
    @FXML
    private void newFile(ActionEvent event) {
        cTaker.save(this);
        NewPaintCommand newfile = new NewPaintCommand(anchorPane);
        newfile.exeCommand(null);     
        points.clear();   
    }

    /** 
     * @param event
     * Call the function to save the newly created file
     */
    @FXML
    private void saveFile(ActionEvent event) {
        SaveCommand savedPaint = new SaveCommand(anchorPane);
        savedPaint.exeCommand(null);     
    }

    /** 
     * @param event
     * Call the function to load a file created earlier and saved on the computer
     */
    @FXML
    private void loadFile(ActionEvent event) {
        cTaker.save(this);
        LoadCommand load = new LoadCommand(anchorPane, cTaker, this);
        load.exeCommand(null);    

        for(Node n: anchorPane.getChildren()){
            n.setOnMouseClicked(e -> {
                selectedShape = (ShapeInterface) n;
                if(e.getButton() == MouseButton.SECONDARY){
                    contextMenu.setOpacity(1);
                    menuColorPickerFill.setValue((Color)selectedShape.getColorFill());
                    menuColorPickerOutline.setValue((Color)selectedShape.getColorStroke());
                    angleFieldMenu.setText(String.valueOf(selectedShape.getAngle()));
                    resizeMenu.setText((selectedShape).getWidthShape()+"x"+(selectedShape.getHeigthShape()));
                }
            });
        }
    }

    /** 
     * @param event
     * @throws InterruptedException
     * Call the function to place the selected shape on the drawing pad and set all the parameters
     */
    @FXML
    private void drawingSelected(MouseEvent event) throws InterruptedException {
       
        clickX = event.getX();
        clickY = event.getY();
        if(event.getButton() == MouseButton.PRIMARY){
            if(currentSelection != null){
                currentSelection.creationOfShape(currentSelection.getShape().getColorStroke(), currentSelection.getShape().getColorFill(), currentSelection.getShape().getAngle(), currentSelection.getShape().getString(), currentSelection.getShape().getCount(), currentSelection.getShape().getWidthShape(), currentSelection.getShape().getHeigthShape());
                Double[] dpoints = new Double[points.size()];
                dpoints = points.toArray(dpoints);
                
                if(currentSelection.getClass().getName() == "project_se.PolygonCreator"){
                    while(event.getClickCount() != 2){
                        Circle c = new Circle(clickX, clickY, 3, Color.RED); //Points' creation
                        circle.getChildren().add(c);
                        anchorPane.getChildren().remove(circle);
                        anchorPane.getChildren().add(circle);
                        points.add(clickX);
                        points.add(clickY);
                        while(clickX == event.getX() && clickY == event.getY())
                            points.wait();
                    }
                    currentSelection.getShape().draw(dpoints);    
                    anchorPane.getChildren().remove(circle);    
                    circle.getChildren().clear();       
                }
                else if(currentSelection.getClass().getName() == "project_se.LineCreator"){
                    while(points.size() < 4){
                        Circle c = new Circle(clickX, clickY, 3, Color.RED); //Points' creation
                        circle.getChildren().add(c);
                        anchorPane.getChildren().remove(circle);
                        anchorPane.getChildren().add(circle);
                        points.add(clickX);
                        points.add(clickY);
                        while(clickX == event.getX() && clickY == event.getY())
                            points.wait();
                    }
                    currentSelection.getShape().draw(dpoints);    
                    anchorPane.getChildren().remove(circle);    
                    circle.getChildren().clear();   
                }     
                else{
                    circle.getChildren().clear();
                    clickX = event.getX();
                    clickY = event.getY();
                    points.add(0, clickX);
                    points.add(1, clickY);
                    currentSelection.getShape().draw(clickX, clickY);
                }
                Node n = (Node)currentSelection.getShape();
                cTaker.save(this);
                anchorPane.getChildren().add(n);

                n.setOnMouseClicked(e -> {
                    selectedShape = (ShapeInterface) n;
                    if(e.getButton() == MouseButton.SECONDARY){
                        contextMenu.setOpacity(1);
                        menuColorPickerFill.setValue((Color)selectedShape.getColorFill());
                        menuColorPickerOutline.setValue((Color)selectedShape.getColorStroke());
                        angleFieldMenu.setText(String.valueOf(selectedShape.getAngle()));
                        resizeMenu.setText((selectedShape).getWidthShape()+"x"+(selectedShape.getHeigthShape()));
                    }
                    flipVerticalButton.setDisable(false);
                    flipHorizontalButton.setDisable(false);
                });
                DragMod d = new DragMod((Node) currentSelection.getShape(), anchorPane, cTaker, this);
                d.makeDraggable();

                textField.clear();
                currentSelection = null;
                points.clear();
                selectedShape = null;
            }
        }
    }

    
    /** 
     * @param event
     * Call the function to bring the selected shape to the foreground
     */
    @FXML
    private void menuBringToTop(ActionEvent event) {
        cTaker.save(this);
        ToFrontCommand tfCommand = new ToFrontCommand(anchorPane);
        tfCommand.exeCommand((Node)selectedShape);
        selectedShape = null;
        
    }

    
    /** 
     * @param event
     * Call the function to put the selected shape in the background
     */
    @FXML
    private void menuSendToBack(ActionEvent event) {
        cTaker.save(this);
        ToBackCommand tbCommand = new ToBackCommand(anchorPane);
        tbCommand.exeCommand((Node)selectedShape);
        selectedShape = null;
    }

    
    /** 
     * @param event
     * Call the function to change the rotation angle of the selected shape
     */
    @FXML
    private void changeAngle(ActionEvent event) {
        cTaker.save(this);
        RotateCommand rotCommand = new RotateCommand(anchorPane, Double.parseDouble(angleFieldMenu.getText()));
        rotCommand.exeCommand((Node)selectedShape);
        selectedShape = null;
    }

    
    /** 
     * @param event
     * Call the function to change the size of the selected shape
     */
    @FXML
    private void changeSize(ActionEvent event){
        cTaker.save(this);
        String[] wh = resizeMenu.getText().split("x");
        ResizeCommand resCommand = new ResizeCommand(anchorPane);
        resCommand.exeCommand((Node)selectedShape, Double.parseDouble(wh[0]), Double.parseDouble(wh[1]));
        selectedShape = null;
    }

    
    /** 
     * @param event
     * Call the function to flip vertically the selected shape
     */
    @FXML
    private void flipVertical(ActionEvent event) {
        cTaker.save(this);
        FlipVerticalCommand flipCommand = new FlipVerticalCommand(anchorPane);
        flipCommand.exeCommand((Node) selectedShape);
        selectedShape = null;
    }

    
    /** 
     * @param event
     * Call the function to flip horizontally of the selected shape
     */
    @FXML
    private void flipHorizontal(ActionEvent event) {
        cTaker.save(this);
        FlipHorizontalCommand flipCommand = new FlipHorizontalCommand(anchorPane);
        flipCommand.exeCommand((Node) selectedShape);
        selectedShape = null;
    }

    /**
     * @return Memento
     */
    public Memento save(){
        undoButton.setDisable(false);
        ObservableList<Node> shapes = FXCollections.observableArrayList();
        for(Node n: anchorPane.getChildren()){
            ShapeInterface temp = ((ShapeInterface)n).getAcopy(((ShapeInterface)n));
            shapes.add((Node) temp);
        }
        return new Memento(shapes);
    }

    /**
     * @param apMem
     * Revert to the previous state.
     */
    public void revert(Memento memento){
        anchorPane.getChildren().clear();
        for(Node node : memento.getShapes()){
            anchorPane.getChildren().add(node);
            DragMod d = new DragMod(node, anchorPane, cTaker, this);
            d.makeDraggable();
            node.setOnMouseClicked(e -> {
                selectedShape = (ShapeInterface) node;
                if(e.getButton() == MouseButton.SECONDARY){
                    contextMenu.setOpacity(1);
                    menuColorPickerFill.setValue((Color)selectedShape.getColorFill());
                    menuColorPickerOutline.setValue((Color)selectedShape.getColorStroke());
                    angleFieldMenu.setText(String.valueOf(selectedShape.getAngle()));
                    resizeMenu.setText((selectedShape).getWidthShape()+"x"+(selectedShape.getHeigthShape()));
                }
            });
        }
    }

    /**
     * 
     * @param event
     * Undo operation
     */
    @FXML
    void undoAction(ActionEvent event) {
        cTaker.revert(this, undoButton);
    }

    // Static Nested Class Memento
    static class Memento {
        ObservableList<Node> shapes = FXCollections.observableArrayList();
        
        /**
         * 
         * @param observableList
         * It inits the nested static class Memento.
         */
        public Memento(ObservableList<Node> observableList){
            this.shapes.clear();
            this.shapes = observableList;
        }

        /**
         * 
         * @return an obserbableList of nodes.
         */
        private ObservableList<Node> getShapes(){
            return shapes;
        }
    }
}
   
