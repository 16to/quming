# 1.名字模块

## 2.1取名

#### 接口路径

POST	/name/actions/generate

#### 请求

```json
{
	"firstName":"姓",//必传
    "birth":"出生时间",//必传
    "sex":0,//必传，0-女，1-男
    "selectParam":{
        //筛选条件支持多个
        "length":[2,3,4],//长度
        "elements":["metal","wood"],//metal-金，wood-木，water-水，fire-火,earth-土
        "sources":["shijing","chuci"]//shijing-诗经，chuci-楚辞，lunyu-论语，tangshi-唐诗，songci-宋词
    }
}
```



#### 响应

```json
{
	"code":0,
	"message":"成功",
    "data":[
        {
            //整个名字和单个字的结构区分开
            "id":"名字唯一标识",
            "firstName":{
                "word":"姓",
                "oldword":"繁体",
                "strokes":10,//笔画
                "pinyin":"拼音",
                "explanation":"字典释义",
                "element":{//五行
                    "type":"类型",
                    "name":"名称",
                    "explanation":"解释"
                }
            },
            "length":2,
            "zodiac":"生肖",
            "constellation":"星座",
            "source":"出处",
            "lastName":[
                {
                    "word":"字",
                    "oldword":"繁体",
                    "strokes":10,//笔画
                    "pinyin":"拼音",
                    "explanation":"字典释义",
                    "element":{//五行
                        "type":"类型",
                        "name":"名称",
                        "explanation":"解释"
                    }
                },
                {……}
            ] 
        },
        {……}
    ]
}
```

## 2.2名字详情

#### 接口路径

GET	/name/detail

#### 请求

id=12345

#### 响应

```json
{
	"code":0,
	"message":"成功",
    "data":{
        //整个名字和单个字的结构区分开
        "id":"名字唯一标识",
        "firstName":{
                "word":"姓",
                "oldword":"繁体",
                "strokes":10,//笔画
                "pinyin":"拼音",
                "explanation":"字典释义",
                "element":{//五行
                    "type":"类型",
                    "name":"名称",
                    "explanation":"解释"
                }
            },
        "length":2,
        "source":"出处",
        "celebrities":["名人1","名人2"],
        "zodiac":{//生肖
            "type":"类型",//Rat,OX,Tiger,Rabbit,Dragon,Snake,Horse,Sheep,Monkey,Rooster,Dog,Pig
            "name":"名称",//鼠,牛,虎,兔,龙,蛇,马,羊,猴,鸡,狗,猪
            "explanation":"解释"
        },
        "constellation":{//星座
            "type":"类型",//Aries,Gemini,Leo,Libra,Sagittarius,Aquarius,Taurus,Cancer,Virgo,Scorpio,Capricorn,Pisces
            "name":"名称",//白羊座,双子座,狮子座,天秤座,射手座,水瓶座,金牛座,巨蟹座,处女座,天蝎座,摩羯座,双鱼座
            "explanation":"解释"
        },
        "same":{//同名
            "total":15000,//总数
            "male":90,//男性比例
            "female":10//女性比例
        },
        "lastName":[
            {
                "word":"字",
                "oldword":"繁体",
                "strokes":10,//笔画
                "pinyin":"拼音",
                "explanation":"字典释义",
                "element":{//五行
                    "type":"类型",
                    "name":"名称",
                    "explanation":"解释"
                }
            },
            {……}
        ] 
    }
}
```



## 2.2收藏

#### 接口路径

POST	/name/actions/collect

#### 请求

```json
{
	"userId":"12345",
	"nameId":"12345"
}
```

#### 响应

```json
{
	"code":0,
    "message":"成功",
    "data":null
}
```

## 2.3取消收藏

#### 接口路径

POST	/name/actions/collect/cancer

#### 请求

```json
{
	"userId":"12345",
	"nameId":"12345"
}
```

#### 响应

```json
{
	"code":0,
    "message":"成功",
    "data":null
}
```

## 2.4查询收藏列表

GET	/name/collections/list

#### 请求

userId=12345

#### 响应

```json
{
	"code":0,
    "message":"成功",
    "data":同2.1取名接口返回data数据结构
}
```

