import org.deeplearning4j.models.word2vec.Word2Vec;
import org.openkoreantext.processor.OpenKoreanTextProcessorJava;
import org.openkoreantext.processor.tokenizer.KoreanTokenizer;
import scala.collection.Seq;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class twtAnalyzer {

    public static String path ="K:\\twitterData\\";

    public static List tokenExecute(String words)
    {
        List result = new ArrayList();
        Seq<KoreanTokenizer.KoreanToken> tokens = OpenKoreanTextProcessorJava.tokenize(words);
        result = OpenKoreanTextProcessorJava.tokensToJavaStringList(tokens);
        return result;
    }


    public static void main(String[] args) throws IOException {

        //negative의 파일 목록을 받아온다.

        FileReader fr = null;
        BufferedReader br = null;
        StringTokenizer stoken = null;
        String s = null;
        List tokenWords = null;
        File dirFile = new File(path+"positive\\");
        File []fileList = dirFile.listFiles();
        Word2Vec vec = null;


        try {

            for (File tempFile : fileList)
                if (tempFile.isFile()) {
                    String tempPath = tempFile.getParent();
                    String tempFileName = tempFile.getName();
                    String targetFilepath = tempPath + "\\" + tempFileName;
                    System.out.println("Path : " + targetFilepath);
                    fr = new FileReader(targetFilepath);
                    br = new BufferedReader(fr);

                    while ((s = br.readLine()) != null) {

                        stoken = new StringTokenizer(s, "|");
                        while (stoken.hasMoreTokens()) {
                            String num = stoken.nextToken();
                            String label = stoken.nextToken();
                            String time = stoken.nextToken();
                            String id = stoken.nextToken();
                            String textData = stoken.nextToken();
                            System.out.println("textData"+textData);
                            tokenWords = tokenExecute(textData);
                        }
                    }
                }
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        //positive의 파일 목록을 받아온다.



        //파일을 순회 하면서 데이터를 넣는다.


    }

}


/* 참조 코드

String path="C:\";
File dirFile=new File(path);
File []fileList=dirFile.listFiles();
for(File tempFile : fileList) {
  if(tempFile.isFile()) {
    String tempPath=tempFile.getParent();
    String tempFileName=tempFile.getName();
    System.out.println("Path="+tempPath);
    System.out.println("FileName="+tempFileName);
  */




