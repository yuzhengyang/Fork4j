package com.yuzhyn.azylee.core.ios.files;

public enum FileTypeEnum {

    /**
     * 图片文件类型
     */
    IMAGE("IMAGE", "图片文件",
            new String[]{"BMP", "JPG", "JPEG", "PNG", "TIFF", "GIF", "PCX", "TGA", "EXIF", "FPX", "SVG", "PSD", "CDR", "PCD", "DXF", "UFO", "EPS", "AI", "RAW", "WMF"}),

    /**
     * 音频文件类型
     */
    MUSIC("MUSIC", "音频文件",
            new String[]{"MP3", "WMA", "WAV", "MOD", "RA", "CD", "MD", "ASF", "AAC", "VQF", "APE", "MID", "OGG", "M4A", "VQF"}),

    /**
     * 视频文件类型
     */
    VIDEO("VIDEO", "视频文件",
            new String[]{"MP4", "AVI", "MOV", "WMV", "ASF", "NAVI", "3GP", "MKV", "F4V", "RMVB", "WEBM"}),

    /**
     * 文档文件类型
     */
    DOC("DOC", "文档文件",
            new String[]{"TXT", "DOC", "DOCX", "XLS", "HTM", "HTML", "JSP", "RTF", "WPD", "PDF", "PPT"}),

    UNKNOWN("UNKNOWN", "未知文件", new String[]{""});


    //region 构造函数、属性及get、set方法

    /**
     * 构造函数
     *
     * @param type
     * @param desc
     * @param exts
     */
    FileTypeEnum(String type, String desc, String[] exts) {
        this.type = type;
        this.desc = desc;
        this.exts = exts;
    }

    /**
     * 类型
     */
    private String type;
    /**
     * 描述
     */
    private String desc;
    /**
     * 扩展名
     */
    private String[] exts;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String[] getExts() {
        return exts;
    }

    public void setExts(String[] exts) {
        this.exts = exts;
    }
    //endregion
}
