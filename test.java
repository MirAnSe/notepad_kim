/*import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Canvas extends JPanel{
    private Model model;
    private int widthWindows;
    private Image imageHero;
    private Image imageWall;
    private Image imageHeroDawn, imageHeroUp, imageHeroLeft, imageHeroRight, imageBox,imageLogo;

    private Controller controller;

    private Reset reset;
    //private int sleep = 10;

    Canvas(Model model,Controller controller, int widthWindows){
        this.model=model;
        this.controller=controller;
        reset = model.getMyButton();
        //this.widthWindows=widthWindows;

        File fileNameHero = new File("src/image/HeroV2.png");
        File fileNameHeroDawn = new File("src/image/HeroDown.png");
        File fileNameHeroUp = new File("src/image/HeroUp.png");
        File fileNameHeroLeft = new File("src/image/HeroLeft.png");
        File fileNameHeroRight = new File("src/image/HeroRight.png");
        File fileNameWall = new File("src/image/Wall.png");
        File fileNameLogo = new File("src/image/logo.png");
        File filenameBox = new File("src/image/Box.png");
        setBackground(Color.white);
        setOpaque(true);

        try{
            imageHero = ImageIO.read(fileNameHero);
            imageHeroDawn = ImageIO.read(fileNameHeroDawn);
            imageHeroUp = ImageIO.read(fileNameHeroUp);
            imageHeroLeft = ImageIO.read(fileNameHeroLeft);
            imageHeroRight = ImageIO.read(fileNameHeroRight);
            imageWall = ImageIO.read(fileNameWall);
            imageBox = ImageIO.read(filenameBox);
            imageLogo = ImageIO.read(fileNameLogo);
        }catch (IOException e) {
            System.out.println("Error load image file");
        }

        this.widthWindows=widthWindows-imageLogo.getWidth(null);
    }

    public int getLogoHeight(){
        return imageLogo.getWidth(null);
    }
    //System.out.println(imageLogo.getWidth(null));

    public void paint(Graphics pen){
        super.paint(pen);
        //draw

        boolean win = true;
        int start=5;
        int x = start;
        int y = 71;
        int width = 50;
        int height = 50;
        int offset = 0;

        pen.drawImage(imageLogo,widthWindows,0,null);

        for (int i=0;i<model.desktop.length;i++){
            for(int j=0;j<model.desktop[i].length;j++){
                if (model.desktop[i][j] == 1 || model.desktop[i][j] == 6){
                    if(model.desktop[i][j] == 6){
                        pen.setColor(Color.yellow);
                        pen.fillRect(x,y,width,height);
                        win = false;
                    }

                    switch (controller.direction){
                        case 0:
                            pen.drawImage(imageHero,x,y,null);
                            break;
                        case 1:
                            pen.drawImage(imageHeroUp,x,y,null);
                            break;
                        case 2:
                            pen.drawImage(imageHeroRight,x,y,null);
                            break;
                        case 3:
                            pen.drawImage(imageHeroDawn,x,y,null);
                            break;
                        case 4:
                            pen.drawImage(imageHeroLeft,x,y,null);
                            break;
                        case 5:
                            pen.drawImage(imageHero,x,y,null);
                            break;
                    }

                }else if(model.desktop[i][j]==2){
                    pen.setColor(Color.red);
                    pen.fillRect(x,y,width,height);
                    pen.setColor(Color.black);
                    pen.drawRect(x,y,width,height);
                    pen.drawImage(imageWall,x,y,null);
                }else if (model.desktop[i][j]==3){
                    pen.drawImage(imageBox,x,y,null);
                }else if(model.desktop[i][j]==4){
                    pen.setColor(Color.yellow);
                    pen.fillRect(x,y,width,height);
                    win = false;
                }else if(model.desktop[i][j]==5){
                    pen.setColor(Color.yellow);
                    pen.fillRect(x,y,width,height);
                    pen.drawImage(imageBox,x,y,null);
                }
                x=x+width+offset;
            }
            x=start;
            y=y+height+offset;
        }

        if (win){
            model.nextLvl();

            //pen.setFont(new Font ("console", Font.PLAIN,30));
            //pen.setColor(Color.red);
            //pen.drawString("You WON!!!",200,50);
            //model.stopProgramm=false;
            //System.out.println(win);
        }

    }
}
*/