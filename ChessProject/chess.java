package ChessProject;


import java.util.ArrayList;
import java.util.LinkedList;


import java.util.Iterator;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class chess extends Application {
     static LinkedList<Piece> ps=new LinkedList<>();
     public static Piece selectedPiece=null;
     Piece brook=new Piece(0, 0, false, "rook", ps);
        Piece bkinght=new Piece(1, 0, false, "knight", ps);
        Piece bbishop=new Piece(2, 0, false, "bishop", ps);
        Piece bqueen=new Piece(3, 0, false, "queen", ps);
        Piece bking=new Piece(4, 0, false, "king", ps);
        Piece bbishop2=new Piece(5, 0, false, "bishop", ps);
        Piece bkight2=new Piece(6, 0, false, "knight", ps);
        Piece brook2=new Piece(7, 0, false, "rook", ps);
        Piece bpawn1=new Piece(1, 1, false, "pawn", ps);
        Piece bpawn2=new Piece(2, 1, false, "pawn", ps);
        Piece bpawn3=new Piece(3, 1, false, "pawn", ps);
        Piece bpawn4=new Piece(4, 1, false, "pawn", ps);
        Piece bpawn5=new Piece(5, 1, false, "pawn", ps);
        Piece bpawn6=new Piece(6, 1, false, "pawn", ps);
        Piece bpawn7=new Piece(7, 1, false, "pawn", ps);
        Piece bpawn8=new Piece(0, 1, false, "pawn", ps);
        
        Piece wrook=new Piece(0, 7, true, "rook", ps);
        Piece wkinght=new Piece(1, 7, true, "knight", ps);
        Piece wbishop=new Piece(2, 7, true, "bishop", ps);
        Piece wqueen=new Piece(3, 7, true, "queen", ps);
        Piece wking=new Piece(4, 7, true, "king", ps);
        Piece wbishop2=new Piece(5, 7, true, "bishop", ps);
        Piece wkight2=new Piece(6, 7, true, "knight", ps);
        Piece wrook2=new Piece(7, 7, true, "rook", ps);
        Piece wpawn1=new Piece(1, 6, true, "pawn", ps);
        Piece wpawn2=new Piece(2, 6, true, "pawn", ps);
        Piece wpawn3=new Piece(3, 6, true, "pawn", ps);
        Piece wpawn4=new Piece(4, 6, true, "pawn", ps);
        Piece wpawn5=new Piece(5, 6, true, "pawn", ps);
        Piece wpawn6=new Piece(6, 6, true, "pawn", ps);
        Piece wpawn7=new Piece(7, 6, true, "pawn", ps);
        Piece wpawn8=new Piece(0, 6, true, "pawn", ps);
        Image imgs[]=new Image[12];
        ImageView imgsv[]=new ImageView[12];
        ArrayList<ImageView> imageView = new ArrayList<ImageView>(ps.size());
             
    @Override
    public void start(Stage primaryStage) {
        
        //System.out.println(ps.size() + "size "+imageView.size());
        imgs[0] = new Image(getClass().getResourceAsStream("pieces/black-bishop.png"));
        imgs[1] = new Image(getClass().getResourceAsStream("pieces/black-king.png"));
        imgs[2] =  new Image(getClass().getResourceAsStream("pieces/black-knight.png"));
        imgs[3] = new Image(getClass().getResourceAsStream("pieces/black-pawn.png"));
        imgs[4] = new Image(getClass().getResourceAsStream("pieces/black-queen.png"));
        imgs[5] =new Image(getClass().getResourceAsStream("pieces/black-rook.png"));
        ///////////////////////////////////////////////////////////////////////////////////
        imgs[6] = new Image(getClass().getResourceAsStream("pieces/white-bishop.png"));
        imgs[7] = new Image(getClass().getResourceAsStream("pieces/white-king.png"));
        imgs[8] = new Image(getClass().getResourceAsStream("pieces/white-knight.png"));
        imgs[9] = new Image(getClass().getResourceAsStream("pieces/white-pawn.png"));
        imgs[10] = new Image(getClass().getResourceAsStream("pieces/white-queen.png"));
        imgs[11] = new Image(getClass().getResourceAsStream("pieces/white-rook.png"));
        int k = 0;
        for(Image i:imgs)
        {
            
           
            ImageView v = new ImageView(i);
            imgsv[k] = v;
            
            
            //System.out.println((imgsv[k] == null  ) ? true:false );
            k++;
        }
        Pane root = new Pane();

        // Rectangle bigRect = new Rectangle(0, 0, 400, 400);
        // bigRect.setFill(Color.BLACK);
        // root.getChildren().add(bigRect);

        boolean white=true;
                for(int y= 0;y<8;y++){
                   
            for(int x= 0;x<8;x++){
                Rectangle smallRect = new Rectangle(x*50, y*50, 50, 50);
                if(white){
                     smallRect = new Rectangle(x*50, y*50, 50, 50);
                   smallRect.setFill(Color.WHITE);
                }else{
                     smallRect = new Rectangle(x*50, y*50, 50, 50);
                      smallRect.setFill(Color.BLUE);
                    
                }
                root.getChildren().add(smallRect);
           white=!white;
            }
            white=!white;
            }
        // for (int i = 0; i <8; i ++) {
        //     for (int j = 0; j <8; j ++) {
        //         Rectangle smallRect = new Rectangle(i, j, 50, 50);
        //         smallRect.setFill(Color.WHITE);
        //         root.getChildren().add(smallRect);
        //     }
        // }

        // for (int i = 150; i <= 450; i += 100) {
        //     for (int j = 150; j <= 450; j += 100) {
        //         Rectangle smallRect = new Rectangle(i, j, 50, 50);
        //         smallRect.setFill(Color.WHITE);
        //         root.getChildren().add(smallRect);
        //     }
        // }
        int i = 0;
        for(Piece p: ps){
            int ind=0;
            if(p.name.equalsIgnoreCase("king")){
                ind=1;
            }
            if(p.name.equalsIgnoreCase("queen")){
                ind=4;
            }
            if(p.name.equalsIgnoreCase("bishop")){
                ind=0;
            }
            if(p.name.equalsIgnoreCase("knight")){
                ind=2;
            }
            if(p.name.equalsIgnoreCase("rook")){
                ind=5;
            }
            if(p.name.equalsIgnoreCase("pawn")){
                ind=3;
            }
            if(p.isWhite){
                ind+=6;
            }
           // g.drawImage(imgs[ind], p.xp*64, p.yp*64, this);
           //System.out.println("index :" + ind + " "+((imgsv[ind] == null) ? true : false));
            
           imageView.add(i,new ImageView(imgs[ind])) ;
           imageView.get(i).setFitWidth(50); 
           imageView.get(i).setFitHeight(50); 
           imageView.get(i).setX(p.xp * 50 ); 
           imageView.get(i).setY(p.yp * 50 ); 
           root.getChildren().add(imageView.get(i));
           i++;
        
        }
        
        Scene scene = new Scene(root, 400, 400, Color.LIGHTGRAY);
        
        
        root.setOnMousePressed(event -> {
           //System.out.print((int)event.getX()+ (int)event.getY());
            selectedPiece = getPiece((int)event.getX(), (int)event.getY());
            


            //System.out.println("x : "+selectedPiece.xp+" y :"+selectedPiece.yp);
           // root.
           // root.getChildren().add(selectedPiece);


        });
        
        root.setOnMouseReleased(event -> {
            int j = ps.indexOf(selectedPiece);
            if (selectedPiece != null ) {
                imageView.get(j).setX((int) (event.getX() / 50) * 50);
                imageView.get(j).setY((int) (event.getY() / 50) * 50);
                int x_save = selectedPiece.xp;
                int y_save = selectedPiece.yp;
                selectedPiece.move((int) (event.getX() / 50), (int) (event.getY() / 50));
        
                Iterator<Piece> iterator = ps.iterator();
                while (iterator.hasNext()) {
                    Piece e = iterator.next();
                    if (e.xp == selectedPiece.xp && e.yp == selectedPiece.yp && e != selectedPiece && e.isWhite != selectedPiece.isWhite) {
                        int aux = ps.indexOf(e);
                        if (aux >= 0) {
                            root.getChildren().remove(imageView.get(aux));
                            imageView.remove(aux);
                            iterator.remove(); 
                        }
                    }
                    else if(e.xp == selectedPiece.xp && e.yp == selectedPiece.yp && e != selectedPiece && e.isWhite == selectedPiece.isWhite)
                    {
                            imageView.get(j).setX(x_save * 50);
                            imageView.get(j).setY(y_save * 50);
                            selectedPiece.move(x_save, y_save); 
                    }
                    
                }
            }
        });
        
         root.setOnMouseDragged(event -> {
            int j = ps.indexOf(selectedPiece) ;
            
            if (selectedPiece != null && j >= 0) {
                imageView.get(j).setX((int) (event.getX() - 32 ));
                imageView.get(j).setY((int) (event.getY() - 32 ));
                
                
                 
                 //selectedPiece.xp= (int) (event.getX() - 32);
                // selectedPiece.yp = (int) (event.getY() - 32);
                
                 //root.getChildren().add(imageView[ps.indexOf(selectedPiece)]);
                
             }
         });
       
        



        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("pieces/icon.png")));
        primaryStage.setTitle("chess");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static Piece getPiece(int x,int y){
        int xp=x/50;
        int yp=y/50;
        for(Piece p: ps){
            if(p.xp==xp&&p.yp==yp){
                return p;
            }
        }
        return null;
    }
    

    public static void main(String[] args) {
        launch(args);
    }
}

