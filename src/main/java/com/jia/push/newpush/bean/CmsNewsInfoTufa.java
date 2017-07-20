package com.jia.push.newpush.bean;

import java.util.List;

/**
 * Created by user on 2017/3/20.
 */
public class CmsNewsInfoTufa {

    /**
     * total : 2
     * resulteState : SUCCESS
     * stateInfo : 数据请求成功！
     * result : [{"id":350,"cityName":"全国","yywId":201600121,"sort":0,"isColorRed":"0","normalColumnData":{"title":"多家银行首套房贷利率最低9折 2月房贷数据回落","imagePath":"http://img.soufun.com/news/2017_03/13/home/1489389810133_000.jpg","url":"http://www.fang.com/news/2017-03-13/24642631.htm"},"customColumnData":{"customColumn3":"装修","customColumn2":"全国","customColumn1":"是"},"createTime":"2017-03-13 15:23:58","creatorEmail":"huyuanchao@fang.com","lastUpdateTime":"2017-03-13 16:56:24","lastEditorEmail":"lianghuan.bj@fang.com","effectiveTime":"2017-03-13 15:23:45","isDeleted":0,"combinedTitle":""},{"id":349,"cityName":"全国","yywId":201600121,"sort":0,"isColorRed":"0","normalColumnData":{"title":"房贷月供利息或被纳入个税改革专项扣除 有成功经验可循","imagePath":"http://img.soufun.com/news/2017_03/13/home/1489389642434_000.jpg","url":"http://www.fang.com/news/2017-03-13/24640836.htm"},"customColumnData":{"customColumn2":"上海 北京 天津 河北石家庄 山西太原 内蒙古呼和浩特 辽宁沈阳 大连 吉林长春 黑龙江哈尔滨 江苏南京 浙江杭州 宁波 安徽合肥 福建福州 厦门 江西南昌 山东济南 青岛 河南郑州 湖北武汉 湖南长沙 广东 广州 深圳 广西 南宁 海南海口 重庆 四川成都 贵州贵阳 云南昆明 陕西西安 甘肃兰州 青海西宁 宁夏银川 新疆 乌鲁木齐 河北 唐山 秦皇岛 内蒙古包头 辽宁丹东 锦州 吉林 牡丹江 江苏无锡 扬州 徐州 浙江温州 金华 安徽 蚌埠 安庆 福建泉州 江西九江 赣州 山东烟台 济宁 河南洛阳 平顶山 湖北宜昌 襄樊 湖南岳阳 常德 广东 惠州 湛江 韶关 广西桂林 北海 海南三亚 重庆泸州 南充 贵州遵义 云南大理","customColumn1":"否"},"createTime":"2017-03-13 15:22:46","creatorEmail":"huyuanchao@fang.com","lastUpdateTime":"2017-03-13 15:22:46","lastEditorEmail":"huyuanchao@fang.com","effectiveTime":"2017-03-13 15:21:07","isDeleted":0,"combinedTitle":""}]
     */

    private int total;
    private String resulteState;
    private String stateInfo;
    /**
     * id : 350
     * cityName : 全国
     * yywId : 201600121
     * sort : 0
     * isColorRed : 0
     * normalColumnData : {"title":"多家银行首套房贷利率最低9折 2月房贷数据回落","imagePath":"http://img.soufun.com/news/2017_03/13/home/1489389810133_000.jpg","url":"http://www.fang.com/news/2017-03-13/24642631.htm"}
     * customColumnData : {"customColumn3":"装修","customColumn2":"全国","customColumn1":"是"}
     * createTime : 2017-03-13 15:23:58
     * creatorEmail : huyuanchao@fang.com
     * lastUpdateTime : 2017-03-13 16:56:24
     * lastEditorEmail : lianghuan.bj@fang.com
     * effectiveTime : 2017-03-13 15:23:45
     * isDeleted : 0
     * combinedTitle :
     */

    private List<ResultBean> result;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getResulteState() {
        return resulteState;
    }

    public void setResulteState(String resulteState) {
        this.resulteState = resulteState;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private int id;
        private String cityName;
        private int yywId;
        private int sort;
        private String isColorRed;
        /**
         * title : 多家银行首套房贷利率最低9折 2月房贷数据回落
         * imagePath : http://img.soufun.com/news/2017_03/13/home/1489389810133_000.jpg
         * url : http://www.fang.com/news/2017-03-13/24642631.htm
         */

        private NormalColumnDataBean normalColumnData;
        /**
         * customColumn3 : 装修
         * customColumn2 : 全国
         * customColumn1 : 是
         */

        private CustomColumnDataBean customColumnData;
        private String createTime;
        private String creatorEmail;
        private String lastUpdateTime;
        private String lastEditorEmail;
        private String effectiveTime;
        private int isDeleted;
        private String combinedTitle;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public int getYywId() {
            return yywId;
        }

        public void setYywId(int yywId) {
            this.yywId = yywId;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getIsColorRed() {
            return isColorRed;
        }

        public void setIsColorRed(String isColorRed) {
            this.isColorRed = isColorRed;
        }

        public NormalColumnDataBean getNormalColumnData() {
            return normalColumnData;
        }

        public void setNormalColumnData(NormalColumnDataBean normalColumnData) {
            this.normalColumnData = normalColumnData;
        }

        public CustomColumnDataBean getCustomColumnData() {
            return customColumnData;
        }

        public void setCustomColumnData(CustomColumnDataBean customColumnData) {
            this.customColumnData = customColumnData;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getCreatorEmail() {
            return creatorEmail;
        }

        public void setCreatorEmail(String creatorEmail) {
            this.creatorEmail = creatorEmail;
        }

        public String getLastUpdateTime() {
            return lastUpdateTime;
        }

        public void setLastUpdateTime(String lastUpdateTime) {
            this.lastUpdateTime = lastUpdateTime;
        }

        public String getLastEditorEmail() {
            return lastEditorEmail;
        }

        public void setLastEditorEmail(String lastEditorEmail) {
            this.lastEditorEmail = lastEditorEmail;
        }

        public String getEffectiveTime() {
            return effectiveTime;
        }

        public void setEffectiveTime(String effectiveTime) {
            this.effectiveTime = effectiveTime;
        }

        public int getIsDeleted() {
            return isDeleted;
        }

        public void setIsDeleted(int isDeleted) {
            this.isDeleted = isDeleted;
        }

        public String getCombinedTitle() {
            return combinedTitle;
        }

        public void setCombinedTitle(String combinedTitle) {
            this.combinedTitle = combinedTitle;
        }

        public static class NormalColumnDataBean {
            private String title;
            private String imagePath;
            private String url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImagePath() {
                return imagePath;
            }

            public void setImagePath(String imagePath) {
                this.imagePath = imagePath;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class CustomColumnDataBean {
            private String customColumn3;
            private String customColumn2;
            private String customColumn1;

            public String getCustomColumn3() {
                return customColumn3;
            }

            public void setCustomColumn3(String customColumn3) {
                this.customColumn3 = customColumn3;
            }

            public String getCustomColumn2() {
                return customColumn2;
            }

            public void setCustomColumn2(String customColumn2) {
                this.customColumn2 = customColumn2;
            }

            public String getCustomColumn1() {
                return customColumn1;
            }

            public void setCustomColumn1(String customColumn1) {
                this.customColumn1 = customColumn1;
            }
        }
    }
}
