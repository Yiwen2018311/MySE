package se02;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class my02 {
    public static void main(String[] args) throws IOException {
        //��ȡ�����ļ���yq_in.txt
    	File infile=new File("C:\\Users\\admin\\Desktop\\yq_in.txt");
    	FileInputStream fis=new FileInputStream(infile);
    	InputStreamReader isr=new InputStreamReader(fis,"GBK");
        BufferedReader reader=new BufferedReader(isr);
        List<String> list=new ArrayList();
        String line=null;
        while((line=reader.readLine())!=null){
        	//��Ŀ���ļ���ÿһ�����δ���List
            list.add(line);
        }
        reader.close();
        //д���ļ���myout.txt
        File outfile=new File("C:\\Users\\admin\\Desktop\\myout.txt");
        FileOutputStream fos=new FileOutputStream(outfile);
        OutputStreamWriter osw=new OutputStreamWriter(fos);
        BufferedWriter bw =new BufferedWriter(osw);
        String pro2=null;
        boolean first=true;
        //����ȡ��List�д�ŵ��ַ���
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
            if(!myline.contains("����ȷ����")){
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