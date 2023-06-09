package com.example.teste_email;

import java.util.HashMap;

public class ContentTypes {

    static final HashMap<String, String> types = new HashMap<>();

    static {
        types.put("aac", "audio/aac");
        types.put("abw", "application/x-abiword");
        types.put("arc", "application/x-freearc");
        types.put("avif", "image/avif");
        types.put("avi", "video/x-msvideo");
        types.put("azw", "application/vnd.amazon.ebook");
        types.put("bin", "application/octet-stream");
        types.put("bmp", "image/bmp");
        types.put("bz", "application/x-bzip");
        types.put("bz2", "application/x-bzip2");
        types.put("cda", "application/x-cdf");
        types.put("csh", "application/x-csh");
        types.put("css", "text/css");
        types.put("csv", "text/csv");
        types.put("doc", "application/msword");
        types.put("docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        types.put("eot", "application/vnd.ms-fontobject");
        types.put("epub", "application/epub+zip");
        types.put("gz", "application/gzip");
        types.put("gif", "image/gif");
        types.put("htm", "text/html");
        types.put("html", "text/html");
        types.put("ico", "image/vnd.microsoft.icon");
        types.put("ics", "text/calendar");
        types.put("jar", "application/java-archive");
        types.put("jpeg", "image/jpeg");
        types.put("jpg", "image/jpeg");
        types.put("js", "text/javascript");
        types.put("json", "application/json");
        types.put("jsonld", "application/ld+json");
        types.put("mid", "audio/midi");
        types.put("midi", "audio/midi");
        types.put("mjs", "text/javascript");
        types.put("mp3", "audio/mpeg");
        types.put("mp4", "video/mp4");
        types.put("mpeg", "video/mpeg");
        types.put("mpkg", "application/vnd.apple.installer+xml");
        types.put("odp", "application/vnd.oasis.opendocument.presentation");
        types.put("ods", "application/vnd.oasis.opendocument.spreadsheet");
        types.put("odt", "application/vnd.oasis.opendocument.text");
        types.put("oga", "audio/ogg");
        types.put("ogv", "video/ogg");
        types.put("ogx", "application/ogg");
        types.put("opus", "audio/opus");
        types.put("otf", "font/otf");
        types.put("png", "image/png");
        types.put("pdf", "application/pdf");
        types.put("php", "application/x-httpd-php");
        types.put("ppt", "application/vnd.ms-powerpoint");
        types.put("pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation");
        types.put("rar", "application/vnd.rar");
        types.put("rtf", "application/rtf");
        types.put("sh", "application/x-sh");
        types.put("svg", "image/svg+xml");
        types.put("swf", "application/x-shockwave-flash");
        types.put("tar", "application/x-tar");
        types.put("tif", "image/tiff");
        types.put("tiff", "image/tiff");
        types.put("ts", "video/mp2t");
        types.put("ttf", "font/ttf");
        types.put("txt", "text/plain");
        types.put("vsd", "application/vnd.visio");
        types.put("wav", "audio/wav");
        types.put("weba", "audio/webm");
        types.put("webm", "video/webm");
        types.put("webp", "image/webp");
        types.put("woff", "font/woff");
        types.put("woff2", "font/woff2");
        types.put("xhtml", "application/xhtml+xml");
        types.put("xls", "application/vnd.ms-excel");
        types.put("xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        types.put("xml", "application/xml");
        types.put("xul", "application/vnd.mozilla.xul+xml");
        types.put("zip", "application/zip");
        types.put("7z", "application/x-7z-compressed");
    }

    private ContentTypes() {
    }

    public static String getContentType(String fileExtension){
        return types.get(fileExtension);
    }
}