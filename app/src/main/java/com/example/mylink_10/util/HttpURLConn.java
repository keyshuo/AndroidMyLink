package com.example.mylink_10.util;

public class HttpURLConn {
    //            HttpURLConnection connection;
//            BufferedReader reader = null;
//            try {
//                //获取HttpURLConnection实例：这时候我们需要new出一个对象，然后传入百度的网络地址，调用openConnect（）方法
////                    URL url = new URL("https://www.baidu.com/");
//                connection = (HttpURLConnection) url.openConnection();
//                //  new URL("http://www.baidu.com").openConnection();
//                //需要从服务器获取数据get，提交数据给服务器post
//                connection.setRequestMethod(method);
//                //设置连接超时、读取超时的毫秒数
//                connection.setConnectTimeout(5000);
//                connection.setReadTimeout(5000);
//                if ("POST".equals(method)) {
//                    //待POST的数据
//                    String d = "";
//                    if (mGson == null) {
//                        mGson = new GsonBuilder().disableHtmlEscaping().create();
//                    }
//                    try {
//                        d = mGson.toJson(data);
//                    } catch (Exception e) {
//                        Log.getStackTraceString(e);
//                    }
//                    //允许输出
//                    connection.setDoOutput(true);
//                    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//                    OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
//                    osw.write(d);
//                    osw.flush();
//                    osw.close();
//                }
//                //获取服务器返回的输入流
//                InputStream inputStream = connection.getInputStream();
//                //对获取的输入流进行读取
//                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//                reader = new BufferedReader(inputStreamReader);
//
////                response = new StringBuilder();
//
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    response.append(line);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                //已经获取到了数据，我们需要关闭连接,close()是用来释放连接所占用的资源
//                if (reader != null) {
//                    try {
//                        reader.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
}
