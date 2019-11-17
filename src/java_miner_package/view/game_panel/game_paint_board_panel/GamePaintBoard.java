package java_miner_package.view.game_panel.game_paint_board_panel;

import java_miner_package.controller.GameController;
import java_miner_package.controller.input_control.InputTypeControl;
import java_miner_package.controller.input_control.KeyBoardControl;
import java_miner_package.model.Cell;
import java_miner_package.view.MainWindow;

import javax.swing.*;
import java.awt.*;

public class GamePaintBoard extends JPanel {
    private final int paintBoardWidth;
    private final int paintBoardHeight;
    private int fieldWidth;
    private int fieldHeight;
    private DrawingCell[][] paintBoardField;
    private CurrentDrawingCell currentDrawingCell;
    private InputTypeControl controlType;

    public GamePaintBoard(MainWindow mainWindow, InputTypeControl controlType) {
        this.paintBoardWidth = 700;
        this.paintBoardHeight = 700;
        this.setSize(this.paintBoardWidth, this.paintBoardHeight);
        this.fieldWidth = mainWindow.getGameController().getGameParameters().getFieldWidth();
        this.fieldHeight = mainWindow.getGameController().getGameParameters().getFieldHeight();
        this.paintBoardField = new DrawingCell[fieldWidth][fieldHeight];
        this.controlType = controlType;
        this.loadPaintBoard(mainWindow.getGameModel().getMinesField());
        this.loadPaintBoardControl();
    }

    public void paint(Graphics g) { // drawing pain board
        super.paint(g);
        this.requestFocus();
        for(int x = 0; x < this.fieldWidth; x++) {
            for(int y = 0; y < this.fieldHeight; y++) {
                this.paintBoardField[x][y].paintDrawingCell(g, this.getDrawingCellWidth(), this.getDrawingCellHeight());
            }
        }
        this.currentDrawingCell.paintCurrentDrawingCell(g, this.getDrawingCellWidth(), this.getDrawingCellHeight());
    }

    public DrawingCell[][] getPaintBoardField() {
        return paintBoardField;
    }

    private int getDrawingCellWidth() {
        return  this.paintBoardWidth / this.fieldWidth;
    }

    private int getDrawingCellHeight() {
        return  this.paintBoardHeight / this.fieldHeight;
    }

    private void loadPaintBoard(Cell[][] minesField) {
        for(int x = 0; x < this.fieldWidth; x++) {
            for(int y = 0; y < this.fieldHeight; y++) {
                this.paintBoardField[x][y] = new DrawingCell(minesField[x][y], getDrawingCellWidth(), getDrawingCellHeight());
            }
        }
    }

    private void loadPaintBoardControl() {
        this.currentDrawingCell = new CurrentDrawingCell(fieldWidth / 2, fieldHeight / 2, fieldWidth, fieldHeight, this.getDrawingCellWidth(), this.getDrawingCellHeight());
        this.controlType.setCurrentCell(this.currentDrawingCell);
        this.controlType.addControlToGamePaintBoard(this);
    }
}