package com.jia.push.constants;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSortedSet;

/**
 * Created by user on 2017/3/15.
 */
public class Constants {
    public static final ImmutableSortedSet<String> citySets =  ImmutableSortedSet.of(
     "全国", "上海", "深圳", "北京", "广州", "武汉", "成都", "重庆", "天津", "衡水", "杭州", "苏州", "南京",
     "长沙", "西安", "郑州", "无锡", "宁波", "常州", "青岛", "龙岩", "沈阳", "济南", "东莞", "石家庄", "南昌",
     "佛山", "长春", "福州", "合肥", "太仓", "昆明", "大连", "海南", "南宁", "珠海", "哈尔滨", "惠州", "厦门",
     "南通", "徐州", "太原", "贵阳", "昆山", "中山", "唐山", "三亚", "扬州", "赣州", "廊坊", "盐城", "温州", "泉州",
     "保定", "烟台", "芜湖", "嘉兴", "江门", "潍坊", "兰州", "连云港", "呼和浩特", "汕头", "德阳", "洛阳", "乌鲁木齐",
     "金华", "淮安", "南安", "绍兴", "郴州", "延边", "秦皇岛", "清远", "宜昌", "泰州", "镇江", "临沂", "威海", "桂林",
     "合川", "新乡", "吉林", "漳州", "柳州", "绵阳", "湛江", "茂名", "驻马店", "济宁", "九江", "衡阳", "淄博", "顺德",
     "邯郸", "临汾", "肇庆", "襄阳", "台州", "宿迁", "咸宁", "湖州", "广元", "沧州", "张家口", "娄底", "包头", "银川",
     "邢台", "梅州", "蚌埠", "聊城", "荆州", "鞍山", "南充", "迁安", "莆田", "阜阳", "信阳", "常德", "吉安", "肥城",
     "株洲", "北海", "泰安", "商丘", "玉林", "西宁", "咸阳", "开封", "岳阳", "孝感", "滁州", "黄冈", "六安", "河源",
     "舟山", "大理", "韶关", "景德镇", "宿州", "阳江", "遵义", "大同", "衢州", "揭阳", "菏泽",
     "承德", "南阳", "马鞍山", "安阳", "黄石", "晋中", "启东", "安庆", "铜仁", "宜春", "广安",
     "齐齐哈尔", "上饶", "乐山", "荆门", "常熟", "葫芦岛", "日照",
     "大庆", "东营", "宁德", "富阳", "湘潭", "达州", "德州", "泸州", "许昌", "牡丹江", "陇南", "自贡", "新沂",
     "贵港", "周口", "抚顺", "宝鸡", "淮南", "四平", "眉山", "遂宁", "焦作", "宜宾", "濮阳",
     "永州", "邵阳", "锦州", "十堰", "丽水", "长治", "平顶山", "运城", "汉中", "漯河", "内江", "鄂尔多斯", "渭南",
     "宣城", "益阳", "营口", "曲靖", "海门", "江阴", "怀化", "资阳", "肇东", "抚州", "三门峡",
     "汕尾", "滨州", "安康", "榆林", "佳木斯", "黄山", "鄂州", "亳州", "枣庄",
     "赤峰", "张家港", "潮州", "新建", "淮北", "巴中", "丽江", "盘锦", "南平", "丹东", "凉山", "恩施", "天水", "兴化", "晋城", "三明",
            "福清", "海宁", "宝应", "辽阳", "毕节", "萍乡", "阜新", "吕梁", "随州", "新郑", "西双版纳", "梧州", "新余", "澳门",
            "邳州", "池州", "铜陵", "忻州", "仙桃", "延安", "云浮", "如皋", "桐乡", "温岭", "张家界", "上虞", "安顺", "靖江", "本溪",
            "丰县", "朝阳", "巢湖", "石狮", "青州", "台山", "黔东南", "防城港", "通辽", "余姚", "临海", "万州", "钦州", "黔南", "莱阳",
            "绥化", "肥西", "铁岭", "开平", "诸暨", "长乐", "中牟", "惠东", "庆阳", "六盘水", "江都", "河池", "阳泉", "平湖", "武威",
            "睢宁", "滕州", "鹤壁", "东港", "玉溪", "湘西", "海安", "贺州", "临安", "邹平", "通化", "昭通", "攀枝花", "百色", "即墨",
            "雅安", "来宾", "安宁", "如东", "松原", "泰兴", "双鸭山", "白银", "宜兴", "朔州", "东台", "鸡西", "高邮", "楚雄", "象山",
            "黔西南", "鹰潭", "定西", "沭阳", "红河", "句容", "拉萨", "白城", "长寿", "永川", "甘孜", "慈溪", "仪征", "莱芜", "呼伦贝尔",
            "吴江", "铜川", "定州", "龙海", "荥阳", "寿光", "商洛", "平凉", "张掖", "保山", "伊犁", "白山", "巴彦淖尔", "普洱", "涪陵",
            "喀什", "乌兰察布", "济阳", "江津", "霸州", "安溪", "桐庐", "天门", "巴州", "万宁", "潜江", "黑河", "彭州", "高碑店", "昌吉",
            "辛集", "吴忠", "綦江", "阿克苏", "未传", "连江", "沛县", "长兴", "伊春", "高密", "肥东", "鹤岗", "酒泉", "中卫", "崇左",
            "惠安", "辽源", "龙口", "邛崃", "庐江", "德宏", "克拉玛依", "文山", "昌邑", "金堂", "石河子", "长葛", "安丘", "邹城", "东方",
            "德清", "宁乡", "平度", "新密", "商河", "玉环", "禹州", "甘南", "恩平", "固原", "儋州", "莱州", "阳春", "兴安盟", "铜梁",
            "都江堰", "溧阳", "巩义", "浏阳", "章丘", "简阳", "七台河", "当涂", "遵化", "淳安", "济源", "桐城", "临沧", "瓦房店", "蓬莱",
            "石嘴山", "登封", "三河", "玉田", "汝州", "金昌", "招远", "永春", "安达", "海东", "宁海", "乌海", "锡林郭勒盟", "偃师", "建德",
            "进贤", "平潭", "昌乐", "瑞金", "临朐", "黔江", "鹤山", "阿拉善盟", "嘉峪关", "新泰", "临夏", "南川", "莱西", "霍邱", "德惠",
            "金坛", "榆树", "宾县", "博罗", "当阳", "广饶", "胶州", "哈密", "阿坝州", "庄河", "普兰店", "宜都", "农安", "伊川", "丰都",
            "日喀则", "滦县", "鄢陵", "任丘", "耒阳", "姜堰", "永登", "凤城", "宜阳", "阜宁", "新民", "邓州", "榆中", "博尔塔拉", "辽中",
            "奉化", "海阳", "东海", "义乌", "峨眉山", "汝阳", "新安", "宾阳", "迪庆", "兰考", "湘乡", "枝江", "醴陵", "大兴安岭", "海西",
            "新津", "临猗", "崇州", "昌黎", "高淳", "蓝田", "长丰", "璧山", "和田", "胶南", "孟津", "固镇", "晋州", "武安", "怀远", "吐鲁番",
            "大足", "公主岭", "玉山", "普宁", "巴彦", "克孜勒苏", "潼南", "文安", "镇海", "五家渠", "乐亭", "横县", "临清", "五常", "昌都",
            "海盐", "清镇", "罗源", "赵县", "新乐", "大邑", "黄南", "尚志", "平山", "攸县", "长清", "海北", "闽清", "长岛", "五河", "怒江",
            "肇州", "户县", "蓟州", "海林", "永泰", "滦南", "康平", "无极", "泉港", "周至", "永城", "林芝", "钟祥", "开阳", "海拉尔", "福安",
            "栖霞", "肇源", "宜良", "京山", "永康", "丰城", "汉南", "嵩县", "海城", "枣阳", "高陵", "洛宁", "迁西", "凯里", "深州", "修文",
            "未来", "平阴", "龙门", "果洛", "望城", "库尔勒", "常宁", "繁昌", "栾川", "蓟县", "金湖", "元氏", "奎屯", "青龙", "法库", "泉山",
            "那曲", "怀仁", "宜城", "清徐", "永安", "神农架", "依兰", "邕宁", "锡林浩特", "老河口", "德化", "靖安", "玉树", "舞钢", "铜山"
    );

    public static final ImmutableMap<String,String> ROLE_DUIZHAO =
            new ImmutableMap.Builder<String, String>().
                    put("新房", "N_BUY").
                    put("二手房买房", "E_BUY").
                    put("二手房卖房", "E_SALE").
                    put("家居","H_BUY").
                    put("装修","H_BUY").
                    put("租房房东","R_SALE").
                    put("租房房客","R_BUY").build();
    public static final Integer PAGE_SIZE = 2000;
    public static final String TOKEN_SEPERATOR=",";

    public static final String CITYS_SEPERATOR=",";
    public static final String SQL_SINGLE_QUOTATION ="'";
    public static final String CITYS_FROMHTTP_SEPERATOR="\\||\\s+";
    public static final String SQL_TEMPLATE_TAG_PATTERN_WITHNAME=":\\w+";
    public static final String SQL_TEMPLATE_TAG=":";
    public static final char SQL_TAG_PATTERN='?';
    public static final Integer RECENT_THREE_DAYS_SLEEP_MINUTS = 10;
    public static final String CACHE_HEADER_NEWSINFO = "6e18936235e50d018472dc1ad5671fb6";
    public static final Integer CACHE_HOURS_NEWSINFO = 24*30;
    public static final String CACHE_KEY_FORMAT_NEWSINFO = "%s_%s";


/*
    public static final Integer  PAYLOAD_DESC_TUFA_ZhiShi =      0x0000001;
    public static final Integer  PAYLOAD_DESC_TUFA_ZiXun =       0x0000010;
    public static final Integer  PAYLOAD_DESC_DINGSHI_ZhiShi =   0x0000100;
    public static final Integer  PAYLOAD_DESC_DINGSHI_ZiXun =    0x0001000;
*/

    public  enum   PLAYLOAD_DESC{
            PAYLOAD_DESC_TUFA_ZhiShi, PAYLOAD_DESC_TUFA_ZiXun, PAYLOAD_DESC_DINGSHI_ZhiShi, PAYLOAD_DESC_DINGSHI_ZiXun,
            PAYLOAD_DESC_TUFA_JIAJU,PAYLOAD_DESC_TUFA_WENDA;
    }

    public static final String DINGSHI_YYW_ID = "201600141";
                public static final String TUFA_YYW_ID = "201600142";
    public static final String DINGSHI_NEWS_URL =  "http://cms.light.test.fang.com/cms/yywPublish/queryYywData.do?id="+DINGSHI_YYW_ID+"&city=全国&currentPage=1&pageSize=1000&";
    public static final String JISHI_NEWS_URL =    "http://cms.light.test.fang.com/cms/yywPublish/queryYywData.do?id="+TUFA_YYW_ID+"&city=全国&currentPage=1&pageSize=1000&";
    public static final String JIAJU_YYW_ID= "201600210";
    public static final String WENDA_YYW_ID="201600209";
    public static final String JIAJU_YYW_URL =  "http://cms.light.test.fang.com/cms/yywPublish/queryYywData.do?id="+JIAJU_YYW_ID+"&city=全国&currentPage=1&pageSize=1000&";
    public static final String WENDA_YYW_URL =    "http://cms.light.test.fang.com/cms/yywPublish/queryYywData.do?id="+WENDA_YYW_ID+"&city=全国&currentPage=1&pageSize=1000&";



}