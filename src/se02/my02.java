package se02;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class my02 {
    public static void main(String[] args) throws IOException {
        //读取数据文件：yq_in.txt
    	File infile=new File("C:\\Users\\admin\\Desktop\\yq_in.txt");
    	FileInputStream fis=new FileInputStream(infile);
    	InputStreamReader isr=new InputStreamReader(fis,"GBK");
        BufferedReader reader=new BufferedReader(isr);
        List<String> list=new ArrayList();
        String line=null;
        while((line=reader.readLine())!=null){
        	//将目标文件的每一行依次存入List
            list.add(line);
        }
        reader.close();
        //写入文件：myout.txt
        File outfile=new File("C:\\Users\\admin\\Desktop\\myout.txt");
        FileOutputStream fos=new FileOutputStream(outfile);
        OutputStreamWriter osw=new OutputStreamWriter(fos);
        BufferedWriter bw =new BufferedWriter(osw);
        String pro2=null;
        boolean first=true;
        //依次取出List中存放的字符串
        for(int i=0;i<list.size();i++){
            String myline=list.get(i);
            String pro1=myline.substring(0,3);
            if(!pro1.equals(pro2)){
                if(!first){
                	bw.write("\n");
                }
                bw.write(pro1);
                bw.write("\n");
            }
            if(!myline.contains("待明确地区")){
                String str=myline.substring(4,myline.length());
                bw.write(str);
                bw.write("\n");
            }
            pro2=pro1;
            first=false;
        }
        bw.close();
    }
}