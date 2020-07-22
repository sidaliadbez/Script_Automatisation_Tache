package base;

import com.google.gson.*;
import com.sun.jna.platform.win32.Netapi32Util;
import netscape.javascript.JSObject;
import okhttp3.*;
import org.apache.commons.exec.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import retrofit2.http.PATCH;

import javax.sound.sampled.*;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BaseTests {
    private WebDriver driver ;
    public  void setUp (ArrayList<String> num){
        System.setProperty("webdriver.opera.driver","resources/operadriver.exe") ;
        driver =new OperaDriver();
        driver.get("http://stage.workbench.apptek.com.s3-website-us-east-1.amazonaws.com/#/auth?return=%2Fauth%3Freturn%3D%252Fauth%253Freturn%253D%25252Fauth%25253Freturn%25253D%2525252Fprograms");

        WebElement email =driver.findElement(By.id("mat-input-0")) ;
        email.sendKeys("shemsou.adbez@gmail.com");
        WebElement mdp =driver.findElement(By.id("mat-input-1")) ;
        mdp.sendKeys("123Shems");
        WebElement button =driver.findElement(By.cssSelector("#mat-tab-content-0-0 button")) ;
        button.click();
        /*try {
            TimeUnit.SECONDS.sleep((long) 5.0);
            button.click();button.click();button.click();

            System.out.println("1111111");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        try{
            TimeUnit.SECONDS.sleep((long) 5.0);
            WebElement NAME =driver.findElement(By.id("mat-input-9")) ;
            NAME.sendKeys("109_Alg_Work_CH1.m4a");
        } catch (Exception e) {
            e.printStackTrace();
        }


        Integer selectcpt = 1 ;
        Integer optioncpt = 5 ;
        try{
            TimeUnit.SECONDS.sleep((long) 35.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0 ; i<num.size();i++){
            WebElement EDIT =driver.findElement(By.id(num.get(i))) ;
            System.out.println("######## segment NUM:"+i+1+"#########");
            EDIT.click();
            EDIT.click();
            WebElement trans =driver.findElement(By.xpath("//tr[@id='"+num.get(i)+"']//div[@class='segmentTranscription']//span[@id='"+num.get(i)+"']")) ;
            switch (trans.getText()){
                case "/":{
                    WebElement select1 =driver.findElement(By.id("mat-select-"+(selectcpt.toString()))) ;
                    select1.click();
                    System.out.println("-- selector NUM:"+selectcpt+"--");
                    selectcpt++ ;
                    int opt2 = optioncpt+1 ;
                    WebElement option1 =driver.findElement(By.id("mat-option-"+opt2)) ;
                    option1.click();
                    System.out.println("  -- Option NUM:"+opt2);
                    optioncpt= optioncpt+2 ;




                    WebElement select2 =driver.findElement(By.id("mat-select-"+selectcpt.toString())) ;
                    select2.click();
                    System.out.println("-- selector NUM:"+selectcpt+"--");
                    selectcpt++;
                    int opt = optioncpt+4 ;
                    WebElement option2 =driver.findElement(By.id("mat-option-"+opt));
                    option2.click();
                    System.out.println("  -- Option NUM:"+opt);
                    optioncpt= optioncpt+5 ;



                    trans.click();
                    trans.clear();
                    trans.sendKeys("[no-speech]");
                    break;

                }
                case "":{
                    WebElement select1 =driver.findElement(By.id("mat-select-"+selectcpt)) ;
                    select1.click();
                    System.out.println("-- selector NUM:"+selectcpt+"--");
                    selectcpt++ ;
                    int opt2 = optioncpt ;
                    WebElement option1 =driver.findElement(By.id("mat-option-"+opt2)) ;
                    option1.click();
                    System.out.println("  -- Option NUM:"+opt2);
                    optioncpt= optioncpt+2 ;




                    WebElement select2 =driver.findElement(By.id("mat-select-"+selectcpt.toString())) ;
                    select2.click();
                    System.out.println("-- selector NUM:"+selectcpt+"--");
                    selectcpt++;

                    WebElement option2 =driver.findElement(By.id("mat-option-"+optioncpt));
                    option2.click();
                    System.out.println("  -- Option NUM:"+optioncpt);
                    optioncpt= optioncpt+5 ;



                    break;

                }
                case "///":{
                    WebElement select1 =driver.findElement(By.id("mat-select-"+(selectcpt.toString()))) ;
                    select1.click();
                    System.out.println("-- selector NUM:"+selectcpt+"--");
                    selectcpt++ ;
                    int opt2 = optioncpt +1;
                    WebElement option1 =driver.findElement(By.id("mat-option-"+opt2)) ;
                    option1.click();
                    System.out.println("  -- Option NUM:"+opt2);
                    optioncpt= optioncpt+2 ;



                    WebElement select2 =driver.findElement(By.id("mat-select-"+selectcpt.toString())) ;
                    select2.click();
                    System.out.println("-- selector NUM:"+selectcpt+"--");
                    selectcpt++;
                    int opt = optioncpt+4 ;
                    WebElement option2 =driver.findElement(By.id("mat-option-"+opt));
                    option2.click();
                    System.out.println("  -- Option NUM:"+opt2);
                    optioncpt= optioncpt+5 ;


                    trans.click();
                    trans.clear();
                    trans.sendKeys("[noise]");
                    break;
                }
                default:{
                    selectcpt= selectcpt+2 ;
                    optioncpt= optioncpt+7;
                }
            }




        }

    }

    public static void main(String args[]) throws IOException, UnsupportedAudioFileException {

//        RequestBody requestBody = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM)
//                .addFormDataPart("transcription", "hello sidali ")
//                .build();
//
//        Request request = new Request.Builder()
//                .url("https://api-workbench.apptek.com/api/Programs/749854/Segments/")
//                .addHeader("Cookie", "WbApiCookie=CfDJ8O7IbQzvnBZNguANVZjp_v4fzvJeFvGpmhlYPsUJfF9fb_yIk8u9zfSHBk-pyfCm8ZiGnyuHhAESQIZSl359G_FAXA515nFhbmk8wlng_2cmQEYhRjdC0QR5ZYjYDcibzt2OKRkNM4gKnCrsWaxQRsdqCb7Rk0Tf27x52FELqi2T0_YV6yVcrqPBQxgNoYifrU-vvDOuqbF-DeQua1SBG4Ik4Cupy9rKHOLzhvECs62Qz9LScShr3_UJy2xpZvbKahmLIfAmj-uQyxJXPSDHezOTP7yd_OULEsziUvHjd_pjBzYJ-PtfuY1zbWAfWIaOYxV7KrUf_ik3N_Vf7s1TzONcAnRMS9IuNc18keokEOOh5QsF7BhPNhGGDsk3haHJMkY-qjRF62Oyq5riGviDyyua2JvtfaBprLuQjodwhQiYQbc_9uuWsjv-MiIY4WQmt1WeamKJp3G08KxNIExXJxiTefuogQsNEinbq-unbbatABIjC0Vfls4kVx4ksE0GveQ-cB_O3b0C10fMLRrmD4GCU6QH3UUhHCLDeFL3wxzPFKlKa_dk8WC_Ru7D8RQolqh8iCXLm-D8I286Lc9j7K3t-nSYI-rFi8ZePSpFZJ_zBRBED6NnCWlHFNQCzg1TmoPR9k79gIuZ-nOaVqucUvHEu_e36fS3LQsj3ZTk_Of-o98T4sK0zb0h609mHhhxtI1kbuLD_42vnukQigYU3UQ5B_dX_NsE1DdNJm8ByQgKSvNiI1fZi0w_FAld6Mad3wfeBoO-52woIGaQstlfu24Jqj1A6Sgj3lC7lgpy965LsfQHEI-Xdm02HTruOKvdRTI1xcf5IxfvepRGQgyIO_dTfPJJSWVg9BO9tCZBW0fS")
//                .post(requestBody)
//                .build();

//        File file = new File("C:\\Users\\Slash\\Desktop\\75db0dc8-bf93-4185-acb0-492ac8ffac2d-ASR.wav");
//        WaveFile wave= new WaveFile(file);
//        wave.play();
//
//        for (int i = 1 ; i < wave.getData().length; i++){
//            int amplitudeExample = wave.getSampleInt(i);
//            System.out.println(i+" : "+amplitudeExample);
//        }



       OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api-workbench.apptek.com/api/Programs/749861/Segments/")
                .method("GET", null)
                .addHeader("Cookie", "WbApiCookie=CfDJ8DZCzl-4oAVHhr3RSmcGD519-5zfIJVP1w59DqgczqOMVNUWymUql5RJj2RYMn95q1lVFlS_SU137233Mm2gvS8CM1KNZmrj5nNfcFzoEdq1Ibxw6rfzhMfZBhZ-EVj1DSDJZG398pQtND9dfrVRCxbgfla84ZEgACIUC2L_3gRCFTB0npxPjnt8FJFhzONECtuRgD6xU9CIto_TIgd5t-_5cl5s4QnHONRfVKAQ0bcq3u3wOYjSJt9bQ5aOf9ilTNh_j3GREdbatkQMDrvK9XeU7igWQyKPgPnOJoE2hQr8LleswQaYETlAmKqV_IElefk3h7xAiBheaR_VahRif2Rs69mNb8VTRWKpJzELpEvJx84LX2dPLLMwINoRjk7iAlsQUl-9K4zfWJHlJff4wq0JlZDfCZuYlqc1IIKX93w6FeD-E4j16j-LiEifIdK2jw8FVMW2p_rJxej5yeBh8MuDnqCOmCZbRprsjiWTI6jvhjUIUOR7GTfevAkYNaI8Anx0W_ddzWyKUOqKg6UbVTjpSl2Y-AW64Zlimj-ohnk5Fdo3Kn88HO8GwCUFQwfeeuflnoTiFGvjKihFWoHS87AhpiRXes_fhbnQVlOZHwPYfO5Aozj4lY-fIYcNoyK6M8BaBclK0XWD3qR54WM_AePGu1gis43V9omefun6817Ma-hXFmZH0Vyb7Eq9110Hu74O1SDA27rlqDrSWmRrtgFIilqU2BDwf22aClJbB7TiF8ujK_ah1VjyTedAsCKxJVUoj5jGNDnML4UiLIw9CfUsAQgkkLsSiWp69DcZ2q3-XrsAhT_xDmg7O-Y9yHGCqedoa0oE2qn_vjPJbk-nNj6hrGSo6f-MhMP94fCzSPQs")
                .build() ;   Response response = client.newCall(request).execute() ;

        Pattern pattern = Pattern.compile("\"id\": (.*?),", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response.body().string());
        ArrayList<String> arrOfStr= new ArrayList<String>();

        while (matcher.find()) {
            if (!matcher.group(1).equals("2716575") && !matcher.group(1).equals("2716577") && !matcher.group(1).equals("null")){
                arrOfStr.add(matcher.group(1));
            }

        }
        System.out.println("/////:"+ arrOfStr.size());



       BaseTests test = new BaseTests();
        test.setUp(arrOfStr);



    }


}

class WaveFile {
    public final int NOT_SPECIFIED = AudioSystem.NOT_SPECIFIED; // -1
    public final int INT_SIZE = 4;


    public byte[] getData() {
        return data;
    }

    private int sampleSize = NOT_SPECIFIED;
    private long framesCount = NOT_SPECIFIED;
    private int sampleRate = NOT_SPECIFIED;
    private int channelsNum;
    private byte[] data;      // wav bytes
    private AudioInputStream ais;
    private AudioFormat af;

    private Clip clip;
    private boolean canPlay;

    public WaveFile(File file) throws UnsupportedAudioFileException, IOException {
        if (!file.exists()) {
            throw new FileNotFoundException(file.getAbsolutePath());
        }

        ais = AudioSystem.getAudioInputStream(file);

        af = ais.getFormat();

        framesCount = ais.getFrameLength();

        sampleRate = (int) af.getSampleRate();

        sampleSize = af.getSampleSizeInBits() / 8;

        channelsNum = af.getChannels();

        long dataLength = framesCount * af.getSampleSizeInBits() * af.getChannels() / 8;

        data = new byte[(int) dataLength];
        ais.read(data);

        AudioInputStream aisForPlay = AudioSystem.getAudioInputStream(file);
        try {
            clip = AudioSystem.getClip();
            clip.open(aisForPlay);
            clip.setFramePosition(0);
            canPlay = true;
        } catch (LineUnavailableException e) {
            canPlay = false;
            System.out.println("I can play only 8bit and 16bit music.");
        }
    }

    public boolean isCanPlay() {
        return canPlay;
    }

    public void play() {
        clip.start();
    }

    public void stop() {
        clip.stop();
    }

    public AudioFormat getAudioFormat() {
        return af;
    }

    public int getSampleSize() {
        return sampleSize;
    }

    public double getDurationTime() {
        return getFramesCount() / getAudioFormat().getFrameRate();
    }

    public long getFramesCount() {
        return framesCount;
    }


    /**
     * Returns sample (amplitude value). Note that in case of stereo samples
     * go one after another. I.e. 0 - first sample of left channel, 1 - first
     * sample of the right channel, 2 - second sample of the left channel, 3 -
     * second sample of the rigth channel, etc.
     */
    public int getSampleInt(int sampleNumber) {

        if (sampleNumber < 0 || sampleNumber >= data.length / sampleSize) {
            throw new IllegalArgumentException(
                    "sample number can't be < 0 or >= data.length/"
                            + sampleSize);
        }

        byte[] sampleBytes = new byte[4]; //4byte = int

        for (int i = 0; i < sampleSize; i++) {
            sampleBytes[i] = data[sampleNumber * sampleSize * channelsNum + i];
        }

        int sample = ByteBuffer.wrap(sampleBytes)
                .order(ByteOrder.LITTLE_ENDIAN).getInt();
        return sample;
    }

    public int getSampleRate() {
        return sampleRate;
    }

    public Clip getClip() {
        return clip;
    }

}

