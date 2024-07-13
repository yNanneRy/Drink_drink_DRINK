import java.io.File;
import javax.sound.sampled.*;

public class Sons {

    Clip efeito2;
    Clip efeito3;
    Clip tema;
    Clip jogoFinalizado;
    Clip efeitoSorteio;
    Clip efeitoSuspense;
    
    public void Efeito2() {
        String dir = System.getProperty("user.dir");
        File lol = new File(dir + "/Sons/Efeito2.wav");
        try {
            efeito2 = AudioSystem.getClip();
            efeito2.open(AudioSystem.getAudioInputStream(lol));
            efeito2.start();
        } catch (Exception e) {
            System.out.print(System.getProperty("user.dir"));
            e.printStackTrace();
        }
    }

    public void Efeito3() {
        String dir = System.getProperty("user.dir");
        File lol = new File(dir + "/Sons/Efeito3.wav");
        try {
            efeito3 = AudioSystem.getClip();
            efeito3.open(AudioSystem.getAudioInputStream(lol));
            efeito3.start();
        } catch (Exception e) {
            System.out.print(System.getProperty("user.dir"));
            e.printStackTrace();
        }
    }
    
    public void EfeitoSuspense() {
        String dir = System.getProperty("user.dir");
        File lol = new File(dir + "/Sons/EfeitoSuspense.wav");
        try {
            efeitoSuspense = AudioSystem.getClip();
            efeitoSuspense.open(AudioSystem.getAudioInputStream(lol));
            efeitoSuspense.start();
        } catch (Exception e) {
            System.out.print(System.getProperty("user.dir"));
            e.printStackTrace();
        }
    }

    public void Tema() {
        String dir = System.getProperty("user.dir");
        File lol = new File(dir + "/Sons/falha.wav");
        try {
            tema = AudioSystem.getClip();
            tema.open(AudioSystem.getAudioInputStream(lol));
            tema.start();
            tema.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.out.print(System.getProperty("user.dir"));
            e.printStackTrace();
        }
    }

    public void efeitoSorteio1(){
        String dir = System.getProperty("user.dir");
        File lol = new File(dir + "/Sons/efeitosuspenseprim.wav");
        try {
            efeitoSorteio = AudioSystem.getClip();
            efeitoSorteio.open(AudioSystem.getAudioInputStream(lol));
            efeitoSorteio.start();
        } catch (Exception e) {
            System.out.print(System.getProperty("user.dir"));
            e.printStackTrace();
        }
    }
    
    public void efeitoSorteio2(){
        String dir = System.getProperty("user.dir");
        File lol = new File(dir + "/Sons/efeitosuspenseseg.wav");
        try {
            efeitoSorteio = AudioSystem.getClip();
            efeitoSorteio.open(AudioSystem.getAudioInputStream(lol));
            efeitoSorteio.start();
        } catch (Exception e) {
            System.out.print(System.getProperty("user.dir"));
            e.printStackTrace();
        }
    }
    
    public void efeitoSorteio3(){
        String dir = System.getProperty("user.dir");
        File lol = new File(dir + "/Sons/efeitosuspenseterc.wav");
        try {
            efeitoSorteio = AudioSystem.getClip();
            efeitoSorteio.open(AudioSystem.getAudioInputStream(lol));
            efeitoSorteio.start();
        } catch (Exception e) {
            System.out.print(System.getProperty("user.dir"));
            e.printStackTrace();
        }
    }
    
    public void efeitoSorteio4(){
        String dir = System.getProperty("user.dir");
        File lol = new File(dir + "/Sons/efeitosuspensequa.wav");
        try {
            efeitoSorteio = AudioSystem.getClip();
            efeitoSorteio.open(AudioSystem.getAudioInputStream(lol));
            efeitoSorteio.start();
        } catch (Exception e) {
            System.out.print(System.getProperty("user.dir"));
            e.printStackTrace();
        }
    }
    
    public void efeitoSorteio5(){
        String dir = System.getProperty("user.dir");
        File lol = new File(dir + "/Sons/efeitosuspensequin.wav");
        try {
            efeitoSorteio = AudioSystem.getClip();
            efeitoSorteio.open(AudioSystem.getAudioInputStream(lol));
            efeitoSorteio.start();
        } catch (Exception e) {
            System.out.print(System.getProperty("user.dir"));
            e.printStackTrace();
        }
    }
    
    public void efeitoSorteio6(){
        String dir = System.getProperty("user.dir");
        File lol = new File(dir + "/Sons/efeitosuspensesex.wav");
        try {
            efeitoSorteio = AudioSystem.getClip();
            efeitoSorteio.open(AudioSystem.getAudioInputStream(lol));
            efeitoSorteio.start();
        } catch (Exception e) {
            System.out.print(System.getProperty("user.dir"));
            e.printStackTrace();
        }
    }
    
    public void efeitoSorteio7(){
        String dir = System.getProperty("user.dir");
        File lol = new File(dir + "/Sons/efeitosuspenseset.wav");
        try {
            efeitoSorteio = AudioSystem.getClip();
            efeitoSorteio.open(AudioSystem.getAudioInputStream(lol));
            efeitoSorteio.start();
        } catch (Exception e) {
            System.out.print(System.getProperty("user.dir"));
            e.printStackTrace();
        }
    }
    
    public void efeitoSorteio8(){
        String dir = System.getProperty("user.dir");
        File lol = new File(dir + "/Sons/efeitosuspenseoit.wav");
        try {
            efeitoSorteio = AudioSystem.getClip();
            efeitoSorteio.open(AudioSystem.getAudioInputStream(lol));
            efeitoSorteio.start();
        } catch (Exception e) {
            System.out.print(System.getProperty("user.dir"));
            e.printStackTrace();
        }
    }
    
    public void efeitoSorteio9(){
        String dir = System.getProperty("user.dir");
        File lol = new File(dir + "/Sons/efeitosuspensenon.wav");
        try {
            efeitoSorteio = AudioSystem.getClip();
            efeitoSorteio.open(AudioSystem.getAudioInputStream(lol));
            efeitoSorteio.start();
        } catch (Exception e) {
            System.out.print(System.getProperty("user.dir"));
            e.printStackTrace();
        }
    }
    
    public void efeitoSorteio10(){
        String dir = System.getProperty("user.dir");
        File lol = new File(dir + "/Sons/efeitosuspensedec.wav");
        try {
            efeitoSorteio = AudioSystem.getClip();
            efeitoSorteio.open(AudioSystem.getAudioInputStream(lol));
            efeitoSorteio.start();
        } catch (Exception e) {
            System.out.print(System.getProperty("user.dir"));
            e.printStackTrace();
        }
    }
    
    public void efeitoSorteio11(){
        String dir = System.getProperty("user.dir");
        File lol = new File(dir + "/Sons/efeitosuspensedec11.wav");
        try {
            efeitoSorteio = AudioSystem.getClip();
            efeitoSorteio.open(AudioSystem.getAudioInputStream(lol));
            efeitoSorteio.start();
        } catch (Exception e) {
            System.out.print(System.getProperty("user.dir"));
            e.printStackTrace();
        }
    }
    
    public void efeitoSorteio12(){
        String dir = System.getProperty("user.dir");
        File lol = new File(dir + "/Sons/efeitosuspensedec2.wav");
        try {
            efeitoSorteio = AudioSystem.getClip();
            efeitoSorteio.open(AudioSystem.getAudioInputStream(lol));
            efeitoSorteio.start();
        } catch (Exception e) {
            System.out.print(System.getProperty("user.dir"));
            e.printStackTrace();
        }
    }
    
    public void efeitoSorteio(int sorteio){
        switch(sorteio){
            case 0:
                efeitoSorteio1();
                break;
            case 1:
                efeitoSorteio2();
                break;
            case 2:
                efeitoSorteio3();
                break;
            case 3:
                efeitoSorteio4();
                break;
            case 4:
                efeitoSorteio5();
                break;
            case 5:
                efeitoSorteio6();
                break;
            case 6:
                efeitoSorteio7();
                break;
            case 7:
                efeitoSorteio8();
                break;
            case 8:
                efeitoSorteio9();
                break;
            case 9:
                efeitoSorteio10();
                break;
            case 10:
                efeitoSorteio11();
                break;
            case 11:
                efeitoSorteio12();
                break;
        }
    }
    public void pararEfeito2() {
        try {
            efeito2.stop();
        } catch (Exception e) {
            System.out.print(System.getProperty("user.dir"));
            e.printStackTrace();
        }
    }
    
    public void pararEfeito3() {
        try {
            efeito3.stop();
        } catch (Exception e) {
            System.out.print(System.getProperty("user.dir"));
            e.printStackTrace();
        }
    }

    public void pausarTema() {
        try {
            tema.wait();
        } catch (Exception e) {
            System.out.print(System.getProperty("user.dir"));
            e.printStackTrace();
        }
    }
    
    public void jogoFinalizado() {
        String dir = System.getProperty("user.dir");
        File lol = new File(dir + "/Sons/JogoFinalizado.wav");
        try {
            jogoFinalizado = AudioSystem.getClip();
            jogoFinalizado.open(AudioSystem.getAudioInputStream(lol));
            jogoFinalizado.start();
        } catch (Exception e) {
            System.out.print(System.getProperty("user.dir"));
            e.printStackTrace();
        }
    }
}