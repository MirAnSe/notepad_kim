import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.print.Printable;
import java.awt.print.PageFormat;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Color;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class printDocument implements Printable {

    private PrinterJob job;
    private Image imageHero;

    printDocument(){
        System.out.println("Print Any doc.");

        File fileNameHero = new File("src/HeroV2.png");

        try{
            imageHero = ImageIO.read(fileNameHero);
        }catch (IOException e) {
            System.out.println("Error load image file");
        }

        job = PrinterJob.getPrinterJob();
        job.setPrintable(this);

        System.out.println("End action doc.");

    }

    private void doAction(){
        System.out.println("Start to print");

        boolean ok = job.printDialog();
        if (ok){
            try{
                job.print();
            }catch (PrinterException ex){

            }
        }
    }


    public void startPrint(){
        printDocument ob = new printDocument();

        ob.doAction();
    }

    public int print (Graphics g, PageFormat pf, int page){
        //return 0;
        if (page > 0){
            return NO_SUCH_PAGE;
        }
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        g2d.drawString("Этот мир ЗАХВАЧЕН!!!",100,100);
        g2d.drawImage(imageHero,150,150, null);

        g2d.setColor(Color.red);
        g2d.drawRect(150,150,20,20);

        return PAGE_EXISTS;

    }

}