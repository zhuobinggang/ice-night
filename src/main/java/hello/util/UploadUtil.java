package hello.util;

/**
 * Created by Administrator on 2017/1/19.
 */
public class UploadUtil {
    public static String getWebInf(){
        try{

            String path =
                    Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath();

            if(System.getProperty("os.name").startsWith("Windows")) {
                //windows 系统
                path = path.substring(1);
            }

            return path.substring(0, path.length() - 9);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String getStaticRoot(){
        String path = getWebInf();
        return path+"/static";
    }

//    public static void main(String[] args) {
//        System.out.println(UploadUtil.getStaticImgRoot());
//    }
}
