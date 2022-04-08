package lab6;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    int canvasWidth = 400, canvasHeight = 400;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    int stoneSize = 20;
    int rows, cols;
    int player=0;
    //boolean [][] adj; //pentru a vedea ce intersectii sunt legate intre ele
    int precX, precY; //pentru a retine pozitia mutarii anterioara
    int precR, precC; //pentru linia si coloana precedenta
    boolean[][] checkedNodes;
    SimpleGraph<String, DefaultEdge> graph;

    BufferedImage image; //the offscreen image
    Graphics2D offscreen; //the offscreen graphics

    public DrawingPanel(MainFrame frame)  {
        this.frame = frame;
        createOffscreenImage();
        init(frame.configPanel.getRows(), frame.configPanel.getCols());
    }

    private void createOffscreenImage() {
        image = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        offscreen = image.createGraphics();
        offscreen.setColor(Color.WHITE); //fill the image with white
        offscreen.fillRect(0, 0, canvasWidth, canvasHeight);
       // paintSticks();
        // paintComponent(offscreen);
        // paintGrid(offscreen);
    }

    final void init(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
      //  adj=new boolean[rows+1][cols+1];
        checkedNodes=new boolean[rows+1][cols+1];
        for(int i=0;i<=rows;i++) {
            for (int j = 0; j <= cols; j++) {
               // this.adj[i][j] = false;
                this.checkedNodes[i][j]=false;
            }
        }
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        graph=createGraf();
        paintGrid(offscreen);
        paintSticks();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                isWinner();
                if(isNode(e.getX(),e.getY()) && isAdjacent(e.getX(),e.getY())) {
                    drawStone(e.getX(), e.getY());
                    repaint();
                  //  isWinner();
                }
               // isWinner();
            }
        });

    }

    private void drawStone(int x, int y) {
        if(player%2==0) {
            offscreen.setColor(Color.RED);
            offscreen.fillOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
        }
        else {
            offscreen.setColor(Color.BLUE);
            offscreen.fillOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
        }
            player++;
    }

    private void paintGrid(Graphics2D offscreen) {
        offscreen.setColor(Color.LIGHT_GRAY);
        //horizontal lines
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            offscreen.drawLine(x1, y1, x2, y2);
        }
        //vertical lines
        for (int col = 0; col < cols; col++) {
            int x1 = padX + col * cellWidth;
            int y1 = padY;
            int x2 = x1;
            int y2 = padY + boardHeight;
            offscreen.drawLine(x1, y1, x2, y2);
        }
        //intersections
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                offscreen.setColor(Color.LIGHT_GRAY);
                offscreen.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
    }

    public boolean isNode(int x1,int y1){
        for (int row = 0; row <= rows; row++) {
            for (int col = 0; col <= cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
               if(x1<=x+stoneSize/2 && x1>= x-stoneSize/2 && y1<=y+stoneSize/2 && y1>=y-stoneSize/2
                   && !checkedNodes[row+1][col+1]){
                       // && adj[row+1][col+1] && !checkedNodes[row+1][col+1]) {
                   if (graph.containsEdge("v"+precR+precC,"v"+row+col) || player==0){
                 //  || graph.containsEdge("v"+row+col,"v"+precR+precC) || player==0) {
                       precR = row;
                       precC = col;
                       checkedNodes[row + 1][col + 1] = true;
                      // checkedNodes[row][col]=true;
                       return true;
                   }
               }
            }
        }
        return false;
    } //verifica daca intersectia e nod

    public boolean isAdjacent(int x1, int y1){
        if(player==0) {
            this.precX=x1;
            this.precY=y1;
            return true;
        }//daca e prima alegere

        if(x1<precX+cellHeight+stoneSize/2 && x1>precX-cellHeight-stoneSize/2){
            if(y1<precY+cellWidth+stoneSize/2 && y1> precY-cellWidth-stoneSize/2){
                    this.precX = x1;
                    this.precY = y1;

                    return true;
            }
        }
        return false;
    }//verifica daca este adiacent cu alegerea precedenta

    public void isWinner(){

        if ((graph.containsEdge("v"+precR+precC,"v"+(precR++)+(precC++))
        &&  precR<rows && precC<cols && checkedNodes[precR+1][precC+1]==true)
               || !graph.containsEdge("v"+precR+precC,"v"+(precR++)+(precC++))
                        ||  precR>=rows || precC>=cols){

            if((graph.containsEdge("v"+precR+precC,"v"+(precR--)+(precC--))
                            &&  precR>0 && precC>0 && checkedNodes[precR-1][precC-1]==true)
            ||!graph.containsEdge("v"+precR+precC,"v"+(precR--)+(precC--))
                    ||  precR==0 || precC==0) {

                if((graph.containsEdge("v"+precR+precC,"v"+(precR++)+precC)
                                &&  precR<rows  && checkedNodes[precR+1][precC]==true)
                        ||!graph.containsEdge("v"+precR+precC,"v"+(precR++)+precC)
                                ||  precR>=rows) {

                    if((graph.containsEdge("v"+precR+precC,"v"+precR+(precC++))
                                    && precC<cols && checkedNodes[precR][precC+1]==true)
                            || !graph.containsEdge("v"+precR+precC,"v"+precR+(precC++))
                                    || precC>=cols) {

                        if((graph.containsEdge("v"+precR+precC,"v"+(precR--)+precC)
                                        &&  precR>0  && checkedNodes[precR-1][precC]==true)
                                ||!graph.containsEdge("v"+precR+precC,"v"+(precR--)+precC)
                                        ||  precR==0) {

                            if ((graph.containsEdge("v"+precR+precC,"v"+precR+(precC--))
                                            && precC>0 && checkedNodes[precR][precC+1]==true)
                            ||!graph.containsEdge("v"+precR+precC,"v"+precR+(precC--))
                                    || precC==0) {
                                if (player % 2 == 0)
                                    System.out.println("Primul jucator a castigat");
                                else
                                    System.out.println("Al doilea jucator a castigat");
                            }
                        }
                    }
                }
            }
        }

    }
    @Override
    public void update(Graphics g) {
    } //No need for update

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
       // paintGrid(offscreen);
        //paintSticks();
    }
    public void paintSticks() {
       Stroke stroke = new BasicStroke(4f);

         for (int i=0;i<rows*cols+rows*cols/2; i++) {
             int r = (int) (Math.random() * rows);
             int c = (int) (Math.random() * cols);
             int verticalLine = (int) (Math.random() * 2);  // 0==linie orizontala si 1== linie verticala

             offscreen.setColor(Color.BLACK);
             offscreen.setStroke(stroke);
             if (verticalLine == 1 && r<rows-1) {
                 int x = padX + c * cellWidth;
                 int y = padY + r * cellHeight;
                 int x1 = padX + (c) * cellWidth;
                 int y1 = padY + (r + 1) * cellHeight;
               //  this.adj[r+1][c+1]=true;
                // this.adj[r+2][c+1]=true;

                 int r2=r+1;
                 graph.addEdge("v"+r+c,"v" + r2+ c);

                 offscreen.drawLine(x, y, x1, y1);
             } else if(c<cols-1) {
                 int x = padX + c * cellWidth;
                 int y = padY + r * cellHeight;
                 int x1 = padX + (c + 1) * cellWidth;
                 int y1 = padY + (r) * cellHeight;
                 //this.adj[r+1][c+1]=true;
                 //this.adj[r+1][c+2]=true;

                 int c2=c+1;
                 graph.addEdge("v"+r+c,"v" + r+ c2);


                 offscreen.drawLine(x, y, x1, y1);
             }
         }
    }

    public SimpleGraph<String, DefaultEdge> createGraf() {
        SimpleGraph<String, DefaultEdge> g = new SimpleGraph<>(DefaultEdge.class);

        for (int i = 0; i <= rows; i++) {
            for(int j=0;j<=cols; j++) {
                g.addVertex("v" + i + j);
            }
        }

        return g;
    }

    public void saveImg() throws IOException {
        File file=new File("joc.png");
        ImageIO.write(image,"png",file);
    }
}
