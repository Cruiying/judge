package com.hqz.hzuoj.common.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class FilesUtils {

    private final static Pattern pattern = Pattern.compile(".*fileName=(.*)");

    /**
     * 文件下载
     *
     * @param httpUrl 下载的url
     * @return
     */
    public static FileMetaInfoDTO downLoadFromUrl(String httpUrl) throws IOException {
        File file = null;

        FileMetaInfoDTO fileMetaInfoDTO = null;
        try {
            // 统一资源
            URL url = new URL(httpUrl);
            // 连接类的父类，抽象类
            URLConnection urlConnection = url.openConnection();
            // http的连接类
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
            // 设定请求的方法，默认是GET
            httpURLConnection.setRequestMethod("GET");
            // 设置字符编码
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            urlConnection.setConnectTimeout(500000);
            // 打开到此 URL 引用的资源的通信链接（如果尚未建立这样的连接）。
            httpURLConnection.connect();

            String suffix  = getSuffix(httpUrl);
            if (StringUtils.isEmpty(suffix)) {
                suffix = ".tmp";
            }
            file = File.createTempFile("httpdonwFile", suffix);
            BufferedInputStream bin = new BufferedInputStream(httpURLConnection.getInputStream());

            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            FileOutputStream out = new FileOutputStream(file);
            int size = 0;
            int len = 0;
            byte[] buf = new byte[1024];
            while ((size = bin.read(buf)) != -1) {
                len += size;
                out.write(buf, 0, size);
            }
            bin.close();
            out.close();
            String fileName = tryGetFileName(urlConnection);
            fileMetaInfoDTO = new FileMetaInfoDTO(fileName, file);
        } catch (MalformedURLException e) {
            log.error("downLoad file eror url = {} ", httpUrl, e);
        } catch (IOException e) {
            log.error("downLoad file eror url = {} ", httpUrl, e);
        } finally {
            return fileMetaInfoDTO;
        }
    }

    private static String tryGetFileName(URLConnection conn) {

        String contentDisposition = null;
        try {
            String disposition = conn.getHeaderField("content-Disposition");
            if (!StringUtils.isEmpty(disposition)) {
                contentDisposition = URLDecoder.decode(disposition, "UTF-8");
                Matcher matcher = pattern.matcher(contentDisposition);
                return matcher.group(1);
            } else {
                String path = conn.getURL().getPath();
                Integer start = path.lastIndexOf('/') + 1;
                String fileName = path.substring(start);
                return URLDecoder.decode(fileName, "UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            log.error("文件名解析失败 url = {}", conn.getURL(), e);
        } catch (Exception e) {
            log.error("文件名解析失败 url = {}", conn.getURL(), e);
        }
        return null;
    }

    /**
     * 从输入流中获取字节数组
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

    public static String getSuffix(String path) {
        String suffix = StringUtils.substringAfterLast(path, ".");
        suffix = StringUtils.substringBeforeLast(suffix, "?");
        suffix = StringUtils.substringBeforeLast(suffix, "@");
        return "." + suffix;
    }

    @Data
    public static class FileMetaInfoDTO  {
        String fileName;
        File file;

        public FileMetaInfoDTO(String fileName, File file) {
            this.fileName = fileName;
            this.file = file;
        }

        public FileMetaInfoDTO() {
        }
    }
}
